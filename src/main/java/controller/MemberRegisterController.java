package controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.exception.MemberDuplicateException;
import clubactivity.exception.MemberInsertException;
import clubactivity.service.MemberRegisterService;
import clubactivity.vo.MemberRegisterRequest;

@Controller
@RequestMapping("/signup")
public class MemberRegisterController {

	private MemberRegisterService memberRegisterService;

	@Autowired
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	public MemberRegisterController() {
		super();
	}

	@RequestMapping("/step1")
	public String signStep1(MemberRegisterRequest memberRegisterRequest) {
		return "register/signupForm";
	}

	@GetMapping("/step2")
	public String signupStep2Get() {
		return "redirect:/register/signupForm";
	}

	@PostMapping("/step2")
	public String signStep2(@Valid MemberRegisterRequest memberRegisterRequest, Errors errors,
			HttpServletRequest request) throws Exception {
		if (!memberRegisterRequest.isPasswordEqualToCheckPassword()) {
			errors.rejectValue("checkPassword", "password.notMatch");
		}
		if (errors.hasErrors()) {
			return "register/signupForm";
		}

		try {
			memberRegisterService.memberRegister(memberRegisterRequest);
			
			return "register/signupSucess";
		} catch (MemberInsertException e) {
			e.printStackTrace();
			errors.reject("failed.register");
			return "register/signupForm";
		} catch (MemberDuplicateException e) {
			e.printStackTrace();
			errors.rejectValue("memberId", "memberId.duplicate");
			return "register/signupForm";
		} catch (Exception e) {
			e.printStackTrace();
			return "register/signupForm";
		}

	}

}
