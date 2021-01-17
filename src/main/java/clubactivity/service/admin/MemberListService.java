package clubactivity.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clubactivity.dao.AdminDAO;
import clubactivity.vo.Member;

@Component
public class MemberListService {
	
	@Autowired
	private AdminDAO adminDAO;

	public List<Member> selectMemberList() throws Exception {
		List<Member> memberList = adminDAO.selectMemberList();
		return memberList;
	}

}
