package clubactivity.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MessageDAO;
import clubactivity.vo.Messagecommand;

@Component
public class MessageListService {
	
	@Autowired
	private MessageDAO messageDAO;

	@Transactional(rollbackFor=SQLException.class)
	public List<Messagecommand> findListByMemberNumber(int memberNumber) {
		List<Messagecommand> messagecommands = messageDAO.findListByMemberNumber(memberNumber);
		
		return messagecommands;
	}

}
