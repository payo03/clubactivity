package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Messagecommand;

@Mapper
@Component
public interface MessageDAO {

	List<Messagecommand> findListByMemberNumber(@Param("memberNumber") int memberNumber);

	Messagecommand selectByMessageNumber(@Param("messageNumber") int messageNumber);

	int selectMemberNumberById(@Param("memberId") String memberId);

	int sendMessage(@Param("messagecommand") Messagecommand messagecommand);

	int sendWelcomeMessage(@Param("memberNumber") int memberNumber);

	void updateMessage(@Param("messageNumber") int messageNumber);

}
