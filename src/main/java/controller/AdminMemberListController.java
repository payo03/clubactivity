package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import clubactivity.service.MemberListService;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/admin")
public class AdminMemberListController {

	@Autowired
	private MemberListService memberListService;

	@GetMapping("/memberList")
	public String listMember(HttpSession session) {
		try {
			List<Member> memberList = memberListService.selectMemberList(session);
			session.setAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "admin/memberList";
	}

	@GetMapping("/refresh")
	public String refresh(HttpSession session) {
		session.removeAttribute("memberList");

		return "redirect:/admin/memberList";
	}

}
