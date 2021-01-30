package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberNotFoundException;
import clubactivity.exception.WrongIdPasswordException;
import clubactivity.service.ChangeProfileService;
import clubactivity.service.LoginService;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.ChangeNumberCommand;
import clubactivity.vo.ChangePasswordCommand;
import clubactivity.vo.ChangeWebsiteCommand;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/edit")
public class ProfileEditController {

	@Autowired
	private ChangeProfileService changeProfileService;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberDAO memberDAO;

	// 회원정보 수정 버튼 클릭시
	@GetMapping
	public String check(Member member) {
		return "edit/passwordConfirm";
	}

	// 비밀번호 확인 버튼 클릭시
	@PostMapping
	public String form(Member member, Errors errors, HttpSession session) throws MemberNotFoundException {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		try {
			loginService.selectMemberById(authInfo.getMemberId(), member.getMemberPassword());

			return "edit/changeForm";
		} catch (MemberNotFoundException e) {
			errors.rejectValue("memberPassword", "password.notMatch");

			return "edit/passwordConfirm";
		}
	}

	@GetMapping("/changePassword")
	public String passwordform(ChangePasswordCommand changePasswordCommand) {
		return "edit/changePasswordForm";
	}

	@PostMapping("/changePassword")
	public String submitPassword(ChangePasswordCommand changePasswordCommand, Errors errors) throws Exception {
		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}
		try {
			changeProfileService.changePassword(changePasswordCommand);

			return "edit/changePassword";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "password.notMatch");

			return "edit/changePasswordForm";
		}
	}

	@GetMapping("/updatePhoneNumber")
	public String numberform(ChangeNumberCommand changeNumberCommand, Model model) {
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
	public String websiteForm(ChangeWebsiteCommand changeWebsiteCommand, Model model) {
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
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		if(authInfo.getMemberonline().isMemberStatus()) {
			memberDAO.updateOffline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(false);
		}else {
			memberDAO.updateOnline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(true);
		}
		
		return "profile/info";
	}
}