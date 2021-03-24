package controller;

import java.io.File;
import java.io.IOException;
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

import clubactivity.exception.ImageUploadException;
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

	@GetMapping("/uploadImage/{memberNumber}")
	public String form(@PathVariable("memberNumber") int memberNumber, HttpSession session, Model model) {
		try {
			List<Image> imageList = imageListService.selectImageList(memberNumber);
			session.setAttribute("imageList", imageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("uploadImage", true);

		return "redirect:/profile";
	}

	@PostMapping("/uploadImage")
	public String upload(@RequestParam("memberNumber") int memberNumber, HttpSession session,
			MultipartHttpServletRequest request) throws ImageUploadException {

		try {
			List<MultipartFile> file = request.getFiles("file");
			String rootPath = request.getSession().getServletContext().getRealPath("/upload");

			String savedName;
			for (MultipartFile mf : file) {
				savedName = uploadFile(mf.getOriginalFilename(), mf.getBytes(), rootPath);

				ImageUploadRequest imageUploadRequest = new ImageUploadRequest(memberNumber, savedName);
				imageUploadService.insertImage(imageUploadRequest);
			}
			return "redirect:/edit/uploadImage/"+memberNumber;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/profile/refresh";
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
