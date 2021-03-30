package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String registerForm(AdminMemberCommand adminMemberCommand, Model model) {
		memberlevelList = adminDAO.selectMemberlevel();
		
		model.addAttribute("register", true);
		model.addAttribute("memberlevelList", memberlevelList);
		
		return "admin/memberList";
	}
	
	@PostMapping("/register")
	public String register(AdminMemberCommand adminMemberCommand) throws Exception {
		adminMemberRegisterService.memberRegister(adminMemberCommand);
		
		return "redirect:/admin/refresh";
	}

	@GetMapping("/update/{memberNumber}")
	public String updateMemberForm(@PathVariable("memberNumber") int memberNumber, AdminMemberCommand adminMemberCommand, Model model) {
		memberlevelList = adminDAO.selectMemberlevel();
		
		model.addAttribute("updateMemberNumber", memberNumber);
		model.addAttribute("memberlevelList", memberlevelList);
		
		return "admin/memberList";
	}
	
	@PostMapping("/update")
	public String updateMember(AdminMemberCommand adminMemberCommand, int memberNumber) throws Exception {
		adminMemberCommand.setMemberNumber(memberNumber);
		adminMemberEditService.updateMember(adminMemberCommand);
		
		return "redirect:/admin/refresh";
	}
	
	@GetMapping("/delete/{memberNumber}")
	public String deleteMember(@PathVariable("memberNumber") int memberNumber) {
		adminDAO.deleteMember(memberNumber);
		
		return "redirect:/admin/refresh";
	}
}
