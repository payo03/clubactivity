package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import clubactivity.service.CreateSessionService;
import clubactivity.service.MessageDetailService;
import clubactivity.service.MessageListService;
import clubactivity.vo.Messagecommand;

@Controller
@RequestMapping("/profile")
public class MessageController {

	@Autowired
	private MessageDetailService messageDetailService;
	
	@Autowired
	private MessageListService messageListService;
	
	@Autowired
	private CreateSessionService createSessionService;

	@GetMapping("/messageDetail/{messageNumber}")
	public String detail(@PathVariable("messageNumber") int messageNumber, HttpSession session, Model model) {
		Messagecommand messagecommand = messageDetailService.viewMessage(messageNumber);
		List<Messagecommand> messagecommands = messageListService.findListByMemberNumber(messagecommand.getMemberNumber());
		
		//세션 갱신 역활(read column을 위해)
		createSessionService.createMessageSession(messagecommands, session);
		
		model.addAttribute("messagecommand", messagecommand);

		return "profile/message";
	}
	
}
