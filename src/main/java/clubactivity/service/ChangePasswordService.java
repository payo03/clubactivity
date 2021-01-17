package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberNotFoundException;
import clubactivity.exception.WrongIdPasswordException;
import clubactivity.vo.Member;

@Component
public class ChangePasswordService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(rollbackFor=SQLException.class)
	public void changePassword(String memberId, String oldPassword, String newPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if(member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}
		if (!bCryptPasswordEncoder.matches(oldPassword, member.getMemberPassword())) {
			throw new WrongIdPasswordException("password.notMatch");
		}
		
		member.changePassword(oldPassword, bCryptPasswordEncoder.encode(newPassword));
		memberDAO.updatePassword(member);
	}

}
