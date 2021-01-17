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

	int insertMember(@Param("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest);

	int selectById(@Param("memberId") String memberId);

	int updateAuthStatus(String memberId);

	void updatePassword(@Param("member") Member member);

	void updateNumber(@Param("member") Member member);
	
}
