package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.exception.MemberNotFoundException;
import clubactivity.service.LoginService;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.LoginRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginController() {
		super();
	}

	@GetMapping
	public String loginForm(LoginRequest loginRequest, @CookieValue(value = "memory", required = false) Cookie cookie,
			HttpServletRequest request, HttpSession session) {

		if (cookie != null) {
			loginRequest.setMemberId(cookie.getValue());
			loginRequest.setMemory(true);
		}
		session.setAttribute("refererPage", request.getAttribute("refererPage"));
		return "login/loginFormPage";
	}

	@PostMapping
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		if (errors.hasErrors()) {
			return "login/login";
		}

		try {
			AuthInfo authInfo = loginService.selectMemberById(loginRequest.getMemberId(),
					loginRequest.getMemberPassword());

			session.setAttribute("login", authInfo);

			Cookie memoryCookie = new Cookie("memory", loginRequest.getMemberId());
			memoryCookie.setPath("/");
			if (loginRequest.isMemory()) {
				memoryCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				memoryCookie.setMaxAge(0);
			}
			response.addCookie(memoryCookie);

			String refererPage = (String) session.getAttribute("refererPage");
			if (refererPage == null) {
				return "redirect:/";
			} else {
				return "redirect:" + refererPage;
			}

		} catch (MemberNotFoundException e) {
			errors.reject("notfound");
			e.printStackTrace();
			return "login/loginFormPage";
		} catch (Exception e) {
			e.printStackTrace();
			return "login/loginFormPage";
		}
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handleMemberNotFoundException() {
		return "errors/member/noMember";
	}
}
