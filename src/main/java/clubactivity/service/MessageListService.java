package clubactivity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clubactivity.dao.MessageDAO;
import clubactivity.vo.Messagecommand;

@Component
public class MessageListService {
	
	@Autowired
	private MessageDAO messageDAO;

	public List<Messagecommand> findListByMemberNumber(int memberNumber) {
		List<Messagecommand> messagecommands = messageDAO.findListByMemberNumber(memberNumber);
		
		return messagecommands;
	}

}
