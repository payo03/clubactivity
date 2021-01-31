package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MessageDAO;
import clubactivity.exception.MessageSendException;
import clubactivity.vo.Messagecommand;

@Component
public class MessageSendService {
	
	@Autowired
	private MessageDAO messageDAO;

	@Transactional(rollbackFor=SQLException.class)
	public int sendMessage(Messagecommand messagecommand) {
		
		int cnt = messageDAO.sendMessage(messagecommand);
		if (cnt == 0) {
			throw new MessageSendException("Message Send Failed");
		}
		return cnt;
	}

}
