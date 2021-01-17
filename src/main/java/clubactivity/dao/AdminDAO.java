package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Member;
import clubactivity.vo.Messagecommand;

@Mapper
@Component
public interface AdminDAO {
	
	List<Member> selectMemberList();

	Member findMemberByNumber(@Param("memberNumber") String memberNumber);

	int sendMessage(@Param("messagecommand") Messagecommand messagecommand);

}
