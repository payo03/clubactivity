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
public class ChangeNumberService {
	
	private MemberDAO memberDAO;

	@Autowired
	public void setMemberDao(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Transactional(rollbackFor=SQLException.class)
	public void changeNumber(String memberId, String newNumber) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDAO.selectMemberById(memberId);
		if(member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}
		
		member.changeNumber(newNumber);
		memberDAO.updateNumber(member);
	}

}
