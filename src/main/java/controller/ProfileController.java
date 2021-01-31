package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.MemberListService;
import clubactivity.vo.ChangeNumberCommand;
import clubactivity.vo.ChangeWebsiteCommand;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private MemberListService memberListService;

	@GetMapping
	public String profile(Model model, HttpSession session, ChangeNumberCommand changeNumberCommand,
			ChangeWebsiteCommand changeWebsiteCommand) {
		try {
			List<Member> memberList = memberListService.selectMemberList(session);
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}

		return "profile/info";
	}

	@GetMapping("/refresh")
	public String refresh(HttpSession session) {
		session.removeAttribute("updatePhoneNumber");
		session.removeAttribute("updateWebsite");
		
		return "redirect:/profile";
	}
}
