package clubactivity.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MessageDAO;
import clubactivity.exception.MessageSendException;
import clubactivity.vo.Messagecommand;

@Component
public class MessageService {

	@Autowired
	private MessageDAO messageDAO;

	@Transactional(rollbackFor = SQLException.class)
	public Messagecommand viewMessage(int messageNumber) {
		messageDAO.updateMessage(messageNumber);
		Messagecommand messagecommand = messageDAO.selectByMessageNumber(messageNumber);

		return messagecommand;
	}

	@Transactional(rollbackFor = SQLException.class)
	public List<Messagecommand> findListByMemberNumber(int memberNumber) {
		List<Messagecommand> messagecommands = messageDAO.findListByMemberNumber(memberNumber);

		String title = null;
		for(Messagecommand messagecommand : messagecommands) {
			if(messagecommand.getTitle().length() > 18) {
				title = messagecommand.getTitle().substring(0, 15) + "...";
				messagecommand.setTitle(title);
			}
		}
		return messagecommands;
	}
	
	@Transactional(rollbackFor=SQLException.class)
	public int sendMessage(Messagecommand messagecommand) {
		
		int cnt = messageDAO.sendMessage(messagecommand);
		if (cnt == 0) {
			throw new MessageSendException("Message Send Failed");
		}
		return cnt;
	}
}
