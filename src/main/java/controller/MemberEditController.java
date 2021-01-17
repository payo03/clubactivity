package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.exception.MemberNotFoundException;
import clubactivity.exception.WrongIdPasswordException;
import clubactivity.service.ChangeNumberService;
import clubactivity.service.ChangePasswordService;
import clubactivity.service.LoginService;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.ChangeNumberCommand;
import clubactivity.vo.ChangePasswordCommand;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/edit")
public class MemberEditController {

	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private ChangeNumberService changeNumberService;
	
	@Autowired
	private LoginService loginService;

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
	public String passwordform(ChangePasswordCommand changePasswordCommand, HttpSession session) {
		return "edit/changePasswordForm";
	}

	@PostMapping("/changePassword")
	public String submitPassword(ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
			throws Exception {
		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		try {
			if (changePasswordCommand.getNewPassword() != "") {

				changePasswordService.changePassword(authInfo.getMemberId(), changePasswordCommand.getCurrentPassword(),
						changePasswordCommand.getNewPassword());

				return "edit/changePassword";
			}
			errors.rejectValue("newPassword", "password.null");

			return "edit/changePasswordForm";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "password.notMatch");

			return "edit/changePasswordForm";
		}
	}

	@GetMapping("/changeNumber")
	public String numberform(ChangeNumberCommand changeNumberCommand, HttpSession session) {
		return "edit/changeNumberForm";
	}
	
	@PostMapping("/changeNumber")
	public String submitNumber(ChangeNumberCommand changeNumberCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
		if (errors.hasErrors()) {
			return "edit/changeNumberForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (changeNumberCommand.getNewPhoneNumber() != "") {

			changeNumberService.changeNumber(authInfo.getMemberId(), changeNumberCommand.getNewPhoneNumber());

			return "edit/changeNumber";
		}
		errors.rejectValue("newPhoneNumber", "phoneNumber.null");

		return "edit/changeNumberForm";
	}

}