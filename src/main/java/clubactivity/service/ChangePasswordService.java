package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberNotFoundException;
import clubactivity.exception.WrongIdPasswordException;
import clubactivity.vo.Member;

@Component
public class ChangePasswordService {
	
	private MemberDAO memberDAO;

	@Autowired
	public void setMemberDao(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Transactional(rollbackFor=SQLException.class)
	public void changePassword(String memberId, String oldPassword, String newPassword) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDAO.selectMemberById(memberId);
		if(member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}
		
		member.changePassword(oldPassword, newPassword);
		memberDAO.updatePassword(member);
	}

}
