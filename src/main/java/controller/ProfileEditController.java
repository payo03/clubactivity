package controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.exception.MemberNotFoundException;
import clubactivity.service.ChangeProfileService;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.ChangeNumberCommand;
import clubactivity.vo.ChangeWebsiteCommand;

@Controller
@RequestMapping("/edit")
public class ProfileEditController {

	@Autowired
	private ChangeProfileService changeProfileService;

	@GetMapping("/updatePhoneNumber")
	public String numberform(Model model, ChangeNumberCommand changeNumberCommand) {
		model.addAttribute("updatePhoneNumber", true);
		
		return "profile/info";
	}

	@PostMapping("/updatePhoneNumber")
	public String submitNumber(ChangeNumberCommand changeNumberCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (errors.hasErrors()) {
			return "profile/info";
		}
		if (changeNumberCommand.getMemberPhoneNumber() != "") {
			changeProfileService.changeProfile(changeNumberCommand, changeNumberCommand.getMemberNumber());

			authInfo.setMemberPhoneNumber(changeNumberCommand.getMemberPhoneNumber());
			return "profile/info";
		}

		return "profile/info";
	}

	@GetMapping("/updateWebsite")
	public String websiteForm(Model model, ChangeWebsiteCommand changeWebsiteCommand) {
		model.addAttribute("updateWebsite", true);
		
		return "profile/info";
	}

	@PostMapping("/updateWebsite")
	public String submitWebsite(ChangeWebsiteCommand changeWebsiteCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (errors.hasErrors()) {
			return "profile/info";
		}
		if (changeWebsiteCommand.getMemberWebsite() != "") {
			changeProfileService.changeProfile(changeWebsiteCommand, changeWebsiteCommand.getMemberNumber());

			authInfo.setMemberWebsite(changeWebsiteCommand.getMemberWebsite());
			return "profile/info";
		}

		return "profile/info";
	}

	@GetMapping("/status")
	public String controlStatus(HttpSession session) {
		changeProfileService.changeStatus(session);
		
		return "redirect:/profile";
	}

}