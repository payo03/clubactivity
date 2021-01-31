package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.MemberListService;
import clubactivity.vo.AdminMemberRegisterCommand;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/admin")
public class AdminMemberListController {

	@Autowired
	private MemberListService memberListService;

	@GetMapping("/memberList")
	public String listMember(Model model, HttpSession session, AdminMemberRegisterCommand adminMemberRegisterCommand) {
		try {
			List<Member> memberList = memberListService.selectMemberList(session);
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "admin/memberList";
	}
	
	@GetMapping("/refresh")
	public String refresh(HttpSession session) {
		session.removeAttribute("register");
		session.removeAttribute("memberlevelList");
		
		return "redirect:/admin/memberList";
	}

}
