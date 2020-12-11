package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.vo.LoginRequest;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(LoginRequest loginRequest, HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
