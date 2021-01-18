package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Member;

@Mapper
@Component
public interface AdminDAO {
	
	List<Member> selectMemberList();

	Member findMemberByNumber(@Param("memberNumber") int memberNumber);

}
