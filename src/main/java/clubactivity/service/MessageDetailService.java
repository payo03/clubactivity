package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MessageDAO;
import clubactivity.vo.Messagecommand;

@Component
public class MessageDetailService {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Transactional(rollbackFor=SQLException.class)
	public Messagecommand viewMessage(int messageNumber) {
		
		Messagecommand messagecommand = messageDAO.selectByMessageNumber(messageNumber);
		messageDAO.updateMessage(messageNumber);
		
		return messagecommand; 
	}
}
