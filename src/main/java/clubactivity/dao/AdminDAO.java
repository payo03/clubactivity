package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.AdminMemberRegisterCommand;
import clubactivity.vo.Member;
import clubactivity.vo.Memberlevel;

@Mapper
@Component
public interface AdminDAO {
	
	List<Member> selectMemberList();

	List<Memberlevel> selectMemberlevel();
	
	int selectById(@Param("memberId") String memberId);

	int insertMember(@Param("adminMemberRegisterCommand") AdminMemberRegisterCommand adminMemberRegisterCommand);

}
