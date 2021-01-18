package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.MessageListService;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/profile")
public class MessageListController {

	@Autowired
	private MessageListService messageListService;
	
	@GetMapping("/messageList/{memberNumber}")
	public String messageList(@PathVariable("memberNumber") int memberNumber, Model model){
		List<Messagecommand> messagecommands = messageListService.findListByMemberNumber(memberNumber);
		
		model.addAttribute("messagecommands", messagecommands);
		
		return "profile/messageList";
	}
}
