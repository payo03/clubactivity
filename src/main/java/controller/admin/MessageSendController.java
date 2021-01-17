package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clubactivity.service.admin.FindMemberByNumberService;
import clubactivity.service.admin.MessageSendService;
import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/admin")
public class MessageSendController {

	@Autowired
	private FindMemberByNumberService memberFindByNumberService;
	
	@Autowired
	private MessageSendService messageSendService;
	
	@PostMapping("/messageForm")
	public String messageForm(@RequestParam("memberNumber") String memberNumber, Model model, Messagecommand messagecommand) {
		Member member = memberFindByNumberService.find(memberNumber);
		
		model.addAttribute("member", member);
		return "/admin/messageForm";
	}
	
	@PostMapping("messageSend")
	public String messageSend(Messagecommand messagecommand) {
		
		messageSendService.sendMessage(messagecommand);
		
		return "redirect:/admin/memberList";
	}
}
