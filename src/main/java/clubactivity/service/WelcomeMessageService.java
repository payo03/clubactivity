package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import clubactivity.dao.MessageDAO;

@Component
public class WelcomeMessageService {

	@Autowired
	private MessageDAO messageDAO;
	
	@Transactional(rollbackFor=SQLException.class)
	public void sendWelcomeMessage(String memberId) {
		int memberNumber = messageDAO.selectMemberNumberById(memberId);
		
		messageDAO.sendWelcomeMessage(memberNumber);
	}

}
