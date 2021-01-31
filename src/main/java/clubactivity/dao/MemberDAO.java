package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Member;
import clubactivity.vo.MemberRegisterRequest;

@Mapper
@Component
public interface MemberDAO {

	Member selectMemberById(@Param("memberId") String memberId);

	Member selectMemberByMemberNumber(@Param("memberNumber") int memberNumber);

	List<Member> selectMemberList(@Param("memberNumber") int memberNumber);

	int insertMember(@Param("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest);

	int selectById(@Param("memberId") String memberId);

	int updateOnline(@Param("memberNumber") int memberNumber);

	int updateOffline(@Param("memberNumber") int memberNumber);

	void updatePassword(@Param("member") Member member);

	void updateNumber(@Param("member") Member member);

	void updateWebsite(@Param("member") Member member);

}
