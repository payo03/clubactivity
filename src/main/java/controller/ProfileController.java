package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.MemberService;
import clubactivity.vo.Member;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public String profile(HttpSession session) {
		try {
			List<Member> memberList = memberService.selectMemberList(session);
			session.setAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "home/main";
		}
		return "profile/info";
	}

	@GetMapping("/refresh")
	public String refresh(HttpSession session) {
		session.removeAttribute("memberList");
		session.removeAttribute("imageList");
		
		return "redirect:/profile";
	}

}
