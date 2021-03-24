package controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.dao.MemberDAO;
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

	@Autowired
	private MemberDAO memberDAO;

	@GetMapping("/updatePhoneNumber")
	public String numberform(HttpSession session) {
		session.setAttribute("updatePhoneNumber", true);

		return "redirect:/profile";
	}

	@PostMapping("/updatePhoneNumber")
	public String submitNumber(ChangeNumberCommand changeNumberCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (errors.hasErrors()) {
			return "redirect:/profile";
		}
		if (changeNumberCommand.getMemberPhoneNumber() != "") {
			changeProfileService.changeProfile(changeNumberCommand, changeNumberCommand.getMemberNumber());

			authInfo.setMemberPhoneNumber(changeNumberCommand.getMemberPhoneNumber());
			session.removeAttribute("updatePhoneNumber");
			return "redirect:/profile";
		}

		return "redirect:/profile";
	}

	@GetMapping("/updateWebsite")
	public String websiteForm(HttpSession session) {
		session.setAttribute("updateWebsite", true);

		return "redirect:/profile";
	}

	@PostMapping("/updateWebsite")
	public String submitWebsite(ChangeWebsiteCommand changeWebsiteCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (errors.hasErrors()) {
			return "redirect:/profile";
		}
		if (changeWebsiteCommand.getMemberWebsite() != "") {
			changeProfileService.changeProfile(changeWebsiteCommand, changeWebsiteCommand.getMemberNumber());

			authInfo.setMemberWebsite(changeWebsiteCommand.getMemberWebsite());
			session.removeAttribute("updateWebsite");
			return "redirect:/profile";
		}

		return "redirect:/profile";
	}

	@GetMapping("/status")
	public String controlStatus(HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (authInfo.getMemberonline().isMemberStatus()) {
			memberDAO.updateOffline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(false);
		} else {
			memberDAO.updateOnline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(true);
		}

		return "redirect:/profile";
	}

}