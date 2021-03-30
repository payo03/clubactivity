package clubactivity.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberNotFoundException;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Component
public class LoginService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional(rollbackFor=SQLException.class)
	public AuthInfo selectMemberById(String memberId, String memberPassword) throws MemberNotFoundException {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("not found");
		}
		// param1 : 사용자 입력값, param2 : 암호화된 값
		if(!bCryptPasswordEncoder.matches(memberPassword, member.getMemberPassword())) {
			throw new MemberNotFoundException("wrong password");
		}
		memberDAO.updateOnline(member.getMemberNumber());
		member.getMemberonline().setMemberStatus(true);
		
		return new AuthInfo(member.getMemberId(), member.getMemberNumber(), member.getMemberName(), member.getMemberPhoneNumber(),
				member.getMemberRegisterDate(), member.getMemberlevel(), member.getMemberWebsite(), member.getMemberonline(), member.getImage(), member.getMessagecommand());
	}

	@Transactional(rollbackFor=SQLException.class)
	public int getMessageLength(List<Messagecommand> messagecommands) {
		int messageLength = 0;
		
		for (Messagecommand messagecommand : messagecommands) {
			if (!messagecommand.isRead())
				messageLength++;
		}
		return messageLength;
	}

}
