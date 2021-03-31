package clubactivity.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.AdminDAO;
import clubactivity.exception.MemberUpdateException;
import clubactivity.vo.AdminMemberCommand;
import clubactivity.vo.Memberlevel;

@Component
public class AdminMemberEditService {

	@Autowired
	AdminDAO adminDAO;

	@Transactional(rollbackFor = SQLException.class)
	public int updateMember(AdminMemberCommand adminMemberCommand) {
		adminMemberCommand.insertLevelCode(adminMemberCommand);

		int cnt = adminDAO.updateMember(adminMemberCommand);
		if (cnt != 1) {
			throw new MemberUpdateException("Update Error");
		}
		return cnt;
	}

	@Transactional(rollbackFor = SQLException.class)
	public List<Memberlevel> selectMemberlevel() {
		List<Memberlevel> memberlevelList = adminDAO.selectMemberlevel();
		
		return memberlevelList;
	}

}
