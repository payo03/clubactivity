package clubactivity.service.admin;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.vo.Member;

@Component
public class FindMemberByNumberService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Transactional(rollbackFor=SQLException.class)
	public Member find(String memberNumber) {
		Member member = adminDAO.findMemberByNumber(memberNumber);
		
		return member;
	}
	
}
