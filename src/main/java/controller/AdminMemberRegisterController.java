package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.dao.AdminDAO;
import clubactivity.service.AdminMemberRegisterService;
import clubactivity.vo.AdminMemberRegisterCommand;
import clubactivity.vo.Memberlevel;

@Controller
@RequestMapping("/admin")
public class AdminMemberRegisterController {
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	private AdminMemberRegisterService adminMemberRegisterService;
	
	private static List<Memberlevel> memberlevelList;
	
	@GetMapping("/register")
	public String registerForm(AdminMemberRegisterCommand adminMemberRegisterCommand, HttpSession session) {
		memberlevelList = adminDAO.selectMemberlevel();
		
		session.setAttribute("register", true);
		session.setAttribute("memberlevelList", memberlevelList);
		return "redirect:/admin/memberList";
	}
	
	@PostMapping("/register")
	public String register(AdminMemberRegisterCommand adminMemberRegisterCommand) throws Exception {
		adminMemberRegisterService.memberRegister(adminMemberRegisterCommand);
		
		return "redirect:/admin/refresh";
	}

}
