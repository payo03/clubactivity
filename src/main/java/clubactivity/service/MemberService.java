package clubactivity.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.dao.MemberDAO;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.Member;

@Component
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AdminDAO adminDAO;

	@Transactional(rollbackFor = SQLException.class)
	public List<Member> selectMemberList(HttpSession session) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		List<Member> memberList = new ArrayList<Member>();
		if (authInfo.getMemberlevel().getMemberLevelCode() == 1) {
			memberList = adminDAO.selectMemberList();
		} else {
			memberList = memberDAO.selectMemberList(authInfo.getMemberNumber());
		}
		return memberList;
	}

	@Transactional(rollbackFor = SQLException.class)
	public Member selectMember(int memberNumber) {
		Member member = memberDAO.selectMemberByMemberNumber(memberNumber);

		return member;
	}

}
