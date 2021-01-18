package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Messagecommand;

@Mapper
@Component
public interface MessageDAO {

	int sendMessage(@Param("messagecommand") Messagecommand messagecommand);

	Messagecommand selectByMessageNumber(@Param("messageNumber") int messageNumber);

	void updateMessage(@Param("messageNumber") int messageNumber);

	List<Messagecommand> findListByMemberNumber(@Param("memberNumber") int memberNumber);
	
}
