package clubactivity.service.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.vo.Member;

@Component
public class MemberListService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Transactional(rollbackFor=SQLException.class)
	public List<Member> selectMemberList() throws Exception {
		List<Member> memberList = adminDAO.selectMemberList();
		return memberList;
	}

}
