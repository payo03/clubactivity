package controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.admin.MemberListService;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/admin")
public class MemberListController {

	@Autowired
	private MemberListService memberListService;

	@GetMapping("/memberList")
	public String listMember(HttpSession session, Model model) {
		try {
			List<Member> memberList = memberListService.selectMemberList();
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "/admin/memberList";
	}

}
