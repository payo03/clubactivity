package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import clubactivity.exception.ImageDeleteException;
import clubactivity.exception.ImageUpdateException;
import clubactivity.exception.ImageUploadException;
import clubactivity.service.ChangeProfileService;
import clubactivity.service.ImageService;
import clubactivity.service.ImageUploadService;
import clubactivity.vo.Image;
import clubactivity.vo.ImageUploadRequest;

@Controller
@RequestMapping("/edit")
public class ImageController {

	@Autowired
	private ImageUploadService imageUploadService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private ChangeProfileService changeProfileService;

	@GetMapping("/uploadImage/{memberNumber}")
	public String selectImage(@PathVariable("memberNumber") int memberNumber, Model model) throws Exception {
		try {
			List<Image> imageList = imageService.selectImageList(memberNumber);
			model.addAttribute("imageList", imageList);
			model.addAttribute("uploadImage", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "profile/info";
	}

	@PostMapping("/uploadImage")
	public String upload(@RequestParam("memberNumber") int memberNumber,
			@RequestParam(value = "select", required = false) String btnSelect,
			@RequestParam(value = "delete", required = false) String btnDelete, RedirectAttributes redirect,
			MultipartHttpServletRequest request) throws Exception {

		if (btnSelect != null) {
			redirect.addFlashAttribute("modifyImage", true);
			return "redirect:/edit/uploadImage/" + memberNumber;
		}
		if (btnDelete != null) {
			redirect.addFlashAttribute("modifyImage", false);
			return "redirect:/edit/uploadImage/" + memberNumber;
		}

		try {
			List<MultipartFile> file = request.getFiles("file");
			String rootPath = request.getSession().getServletContext().getRealPath("/upload");

			String savedName;
			for (MultipartFile mf : file) {
				savedName = ImageUploadRequest.uploadFile(mf.getOriginalFilename(), mf.getBytes(), rootPath);

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
	public String updateImage(@PathVariable("memberNumber") int memberNumber, @RequestParam("radio") String imagePath,
			HttpSession session) throws Exception {

		try {
			int imageNumber = imageService.getImageNumber(imagePath);
			Image image = new Image(memberNumber, imagePath, imageNumber);

			changeProfileService.updateImage(image, session);
		} catch (ImageUpdateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/profile";
	}

	@PostMapping("/deleteImage/{memberNumber}")
	public String deleteImage(@PathVariable("memberNumber") int memberNumber,
			@RequestParam("checkbox") String[] imagePath, HttpSession session, HttpServletRequest request)
			throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/upload");
		try {
			for (int i = 0; i < imagePath.length; i++) {
				imageService.deleteImage(imagePath[i]);
				File file = new File(rootPath + "/" + imagePath[i]);
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		insertDefaultImage(memberNumber, session);
		return "redirect:/profile";
	}

	private void insertDefaultImage(int memberNumber, HttpSession session) {
		try {
			imageService.checkImageNumber(memberNumber);
		} catch (ImageDeleteException e) {
			Image image = new Image(memberNumber, "user-medium.png", 0);
			changeProfileService.updateImage(image, session);
		}
	}
}
