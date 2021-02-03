package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clubactivity.dao.MemberDAO;
import clubactivity.service.MessageSendService;
import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/admin")
public class AdminMessageSendController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MessageSendService messageSendService;
	
	@PostMapping("/messageForm")
	public String messageForm(@RequestParam("memberNumber") int memberNumber, Model model, Messagecommand messagecommand) {
		Member member = memberDAO.selectMemberByMemberNumber(memberNumber);
		
		model.addAttribute("member", member);
		return "admin/messageForm";
	}
	
	@PostMapping("messageSend")
	public String messageSend(Messagecommand messagecommand) {
		messageSendService.sendMessage(messagecommand);
		
		return "redirect:/admin/memberList";
	}
}
