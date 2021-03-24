package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clubactivity.dao.AdminDAO;
import clubactivity.service.AdminMemberEditService;
import clubactivity.service.AdminMemberRegisterService;
import clubactivity.vo.AdminMemberCommand;
import clubactivity.vo.Memberlevel;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	private AdminMemberRegisterService adminMemberRegisterService;

	@Autowired
	private AdminMemberEditService adminMemberEditService;
	
	private static List<Memberlevel> memberlevelList;
	
	@GetMapping("/register")
	public String registerForm(AdminMemberCommand adminMemberCommand, HttpSession session) {
		memberlevelList = adminDAO.selectMemberlevel();
		
		session.setAttribute("register", true);
		session.setAttribute("memberlevelList", memberlevelList);
		
		return "redirect:/admin/memberList";
	}
	
	@PostMapping("/register")
	public String register(AdminMemberCommand adminMemberCommand) throws Exception {
		adminMemberRegisterService.memberRegister(adminMemberCommand);
		
		return "redirect:/admin/refresh";
	}

	@GetMapping("/update")
	public String updateMemberForm(@RequestParam("memberNumber") int memberNumber, AdminMemberCommand adminMemberCommand, HttpSession session) {
		memberlevelList = adminDAO.selectMemberlevel();
		
		session.setAttribute("updateMemberNumber", memberNumber);
		session.setAttribute("memberlevelList", memberlevelList);
		
		return "redirect:/admin/memberList";
	}
	
	@PostMapping("/update")
	public String updateMember(AdminMemberCommand adminMemberCommand, int memberNumber) throws Exception {
		adminMemberCommand.setMemberNumber(memberNumber);
		adminMemberEditService.updateMember(adminMemberCommand);
		
		return "redirect:/admin/refresh";
	}
}
