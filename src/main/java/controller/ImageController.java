package controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import clubactivity.exception.ImageUpdateException;
import clubactivity.exception.ImageUploadException;
import clubactivity.service.ChangeProfileService;
import clubactivity.service.ImageListService;
import clubactivity.service.ImageUploadService;
import clubactivity.vo.Image;
import clubactivity.vo.ImageUploadRequest;

@Controller
@RequestMapping("/edit")
public class ImageController {

	@Autowired
	private ImageUploadService imageUploadService;

	@Autowired
	private ImageListService imageListService;

	@Autowired
	private ChangeProfileService changeProfileService;

	@GetMapping("/uploadImage/{memberNumber}")
	public String selectImage(@PathVariable("memberNumber") int memberNumber, Model model) throws Exception {
		try {
			List<Image> imageList = imageListService.selectImageList(memberNumber);
			model.addAttribute("imageList", imageList);
			model.addAttribute("uploadImage", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "profile/info";
	}

	@PostMapping("/uploadImage")
	public String upload(@RequestParam("memberNumber") int memberNumber,
			@RequestParam(value = "select", required = false) String btnSelect, RedirectAttributes redirect,
			MultipartHttpServletRequest request) throws Exception {

		if (btnSelect != null) {
			redirect.addFlashAttribute("select", true);
			return "redirect:/edit/uploadImage/" + memberNumber;
		}

		try {
			List<MultipartFile> file = request.getFiles("file");
			String rootPath = request.getSession().getServletContext().getRealPath("/upload");

			String savedName;
			for (MultipartFile mf : file) {
				savedName = uploadFile(mf.getOriginalFilename(), mf.getBytes(), rootPath);

				ImageUploadRequest imageUploadRequest = new ImageUploadRequest(memberNumber, savedName);
				imageUploadService.insertImage(imageUploadRequest);
			}
			return "redirect:/edit/uploadImage/" + memberNumber;
		} catch (ImageUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "profile/info";
	}

	@PostMapping("/updateImage/{memberNumber}")
	public String updateImage(@PathVariable("memberNumber") int memberNumber,
			@RequestParam(value = "radio", required = false) String imagePath, HttpSession session) throws Exception {

		try {
			int imageNumber = imageListService.getImageNumber(imagePath);
			Image image = new Image(memberNumber, imagePath, imageNumber);
			
			changeProfileService.updateImage(image, session);
		} catch (ImageUpdateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/profile";
	}

	private String uploadFile(String originalName, byte[] fileData, String rootPath) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rndName = sdf.format(new java.util.Date()) + System.currentTimeMillis();
		String savedName = rndName + "." + originalName.substring(originalName.lastIndexOf(".") + 1);
		File target = new File(rootPath, savedName);
		FileCopyUtils.copy(fileData, target);

		return savedName;
	}
}
