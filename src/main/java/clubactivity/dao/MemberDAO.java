package clubactivity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Member;
import clubactivity.vo.MemberRegisterRequest;

@Mapper
@Component
public interface MemberDAO {

	Member selectMemberById(@Param("memberId") String memberId);

	int insertMember(MemberRegisterRequest memberRegisterRequest);

	int selectById(String memberId);

	int updateAuthStatus(String memberId);

	int updatePassword(Member member);

	void updateNumber(Member member);
	
}
