package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.MemberService;
import clubactivity.service.MessageService;
import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/admin")
public class AdminMessageSendController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messageForm/{memberNumber}")
	public String messageForm(@PathVariable("memberNumber") int memberNumber, Messagecommand messagecommand, Model model) {
		Member member = memberService.selectMember(memberNumber);
		
		model.addAttribute("member", member);
		return "admin/messageForm";
	}
	
	@PostMapping("messageSend")
	public String messageSend(Messagecommand messagecommand) {
		messageService.sendMessage(messagecommand);
		
		return "redirect:/admin/refresh";
	}
}
