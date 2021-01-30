package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.dao.MemberDAO;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.LoginRequest;

@Controller
public class LogoutController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping("/logout")
	public String logout(LoginRequest loginRequest, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		memberDAO.updateOffline(authInfo.getMemberNumber());
		
		session.invalidate();
		return "redirect:/home";
	}
}
