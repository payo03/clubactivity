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
import clubactivity.service.ChangePasswordService;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.ChangePasswordCommand;


@Controller
@RequestMapping("/edit")
public class EditController {

	private ChangePasswordService changePasswordService;

	@Autowired
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@GetMapping
	public String form(ChangePasswordCommand changePasswordCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (authInfo == null) {
			return "redirect:/login/loginFormPage";
		}
		return "edit/changePasswordForm";
	}

	@PostMapping
	public String submit(ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
			throws MemberNotFoundException {
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

}