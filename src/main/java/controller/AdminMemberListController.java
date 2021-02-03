package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clubactivity.dao.AdminDAO;
import clubactivity.service.MemberListService;
import clubactivity.vo.AdminMemberCommand;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/admin")
public class AdminMemberListController {

	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private MemberListService memberListService;

	@GetMapping("/memberList")
	public String listMember(Model model, HttpSession session, AdminMemberCommand adminMemberCommand) {
		try {
			List<Member> memberList = memberListService.selectMemberList(session);
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "admin/memberList";
	}
	
	@GetMapping("/delete")
	public String deleteMember(@RequestParam("memberNumber") int memberNumber) {
		adminDAO.deleteMember(memberNumber);
		
		return "redirect:/admin/memberList";
	}
	
	@GetMapping("/refresh")
	public String refresh(HttpSession session) {
		session.removeAttribute("register");
		session.removeAttribute("memberlevelList");
		session.removeAttribute("updateMemberNumber");
		
		return "redirect:/admin/memberList";
	}

}
