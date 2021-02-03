package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.dao.MessageDAO;
import clubactivity.exception.MemberDuplicateException;
import clubactivity.exception.MemberInsertException;
import clubactivity.exception.MessageSendException;
import clubactivity.vo.AdminMemberCommand;

@Component
public class AdminMemberRegisterService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public int insertMember(AdminMemberCommand adminMemberCommand) throws Exception {
		adminMemberCommand.insertLevelCode(adminMemberCommand);
		
		String password = passwordEncoder.encode("1234");
		adminMemberCommand.setMemberPassword(password);
		
		int cnt = adminDAO.insertMember(adminMemberCommand);
		if (cnt == 0) {
			throw new MemberInsertException("Insert failed");
		}
		return cnt;
	}

	public int selectById(String memberId) throws Exception {
		int cnt = adminDAO.selectById(memberId);
		if (cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
		return cnt;
	}
	
	public int sendWelcomeMessage(String memberId) {
		int memberNumber = messageDAO.selectMemberNumberById(memberId);
		
		int cnt = messageDAO.sendWelcomeMessage(memberNumber);
		if(cnt == 0) {
			throw new MessageSendException("Message Error");
		}
		return cnt;
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void memberRegister(AdminMemberCommand adminMemberCommand) throws Exception {
		this.selectById(adminMemberCommand.getMemberId());
		this.insertMember(adminMemberCommand);
		this.sendWelcomeMessage(adminMemberCommand.getMemberId());
	}
}
