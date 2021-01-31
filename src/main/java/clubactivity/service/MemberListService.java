package clubactivity.service;

import java.sql.SQLException;
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
public class MemberListService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	private static List<Member> memberList;

	@Transactional(rollbackFor = SQLException.class)
	public List<Member> selectMemberList(HttpSession session) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		if (authInfo.getMemberlevel().getMemberLevelCode() == 1) {
			memberList = adminDAO.selectMemberList();
		} else {
			memberList = memberDAO.selectMemberList(authInfo.getMemberNumber());
		}
		return memberList;
	}

}
