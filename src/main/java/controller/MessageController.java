package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import clubactivity.service.LoginService;
import clubactivity.service.MemberService;
import clubactivity.service.MessageService;
import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/profile")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/message/{memberNumber}")
	public String messageList(@PathVariable("memberNumber") int memberNumber, HttpSession session) {
		List<Messagecommand> messagecommands = messageService.findListByMemberNumber(memberNumber);
		int messageLength = loginService.getMessageLength(messagecommands);
		
		if (messageLength != 0) {
			session.setAttribute("messageLength", messageLength);
		} else {
			session.removeAttribute("messageLength");
		}
		session.setAttribute("messagecommands", messagecommands);
		
		return "profile/message";
	}
	
	
	@GetMapping("/messageDetail/{messageNumber}")
	public String detail(@PathVariable("messageNumber") int messageNumber, RedirectAttributes redirect) {
		Messagecommand messagecommand = messageService.viewMessage(messageNumber);
		
		redirect.addFlashAttribute("messagecommand", messagecommand);

		return "redirect:/profile/message/" + messagecommand.getMemberNumber();
	}
	
	@GetMapping("/messageForm/{memberNumber}")
	public String messageForm(@PathVariable("memberNumber") int memberNumber, Messagecommand messagecommand, Model model) {
		Member member = memberService.selectMember(memberNumber);
		
		model.addAttribute("member", member);
		return "profile/messageForm";
	}
	
	@PostMapping("messageSend")
	public String messageSend(Messagecommand messagecommand) {
		messageService.sendMessage(messagecommand);
		
		return "redirect:/profile/refresh";
	}
}
