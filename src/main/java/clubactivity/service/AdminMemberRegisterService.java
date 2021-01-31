package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.exception.MemberDuplicateException;
import clubactivity.exception.MemberInsertException;
import clubactivity.vo.AdminMemberRegisterCommand;

@Component
public class AdminMemberRegisterService {

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Transactional(rollbackFor = SQLException.class)
	public int insertMember(AdminMemberRegisterCommand adminMemberRegisterCommand) throws Exception {
		adminMemberRegisterCommand.insertLevelCode(adminMemberRegisterCommand);
		
		String password = passwordEncoder.encode("1234");
		adminMemberRegisterCommand.setMemberPassword(password);
		
		int cnt = adminDAO.insertMember(adminMemberRegisterCommand);
		if (cnt == 0) {
			throw new MemberInsertException("Insert failed");
		}
		return cnt;
	}

	@Transactional(rollbackFor = SQLException.class)
	public int selectById(String memberId) throws Exception {
		int cnt = adminDAO.selectById(memberId);
		if (cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
		return cnt;
	}

	@Transactional(rollbackFor = SQLException.class)
	public void memberRegister(AdminMemberRegisterCommand adminMemberRegisterCommand) throws Exception {
		this.selectById(adminMemberRegisterCommand.getMemberId());
		this.insertMember(adminMemberRegisterCommand);
	}
}
