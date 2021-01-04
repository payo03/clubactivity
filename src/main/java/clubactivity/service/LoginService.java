package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberNotFoundException;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.Member;

@Component
public class LoginService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Transactional(rollbackFor=SQLException.class)
	public AuthInfo selectMemberById(String memberId, String memberPassword) throws MemberNotFoundException {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("not found");
		}
		if(!member.getMemberPassword().equals(memberPassword)) {
			throw new MemberNotFoundException("wrong password");
		}
		return new AuthInfo(member.getMemberId(), member.getMemberNumber(), member.getMemberName(), member.getMemberPhoneNumber(),
				member.getMemberRegisterDate(), member.getMemberlevel());
	}

}
