package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.MemberDuplicateException;
import clubactivity.exception.MemberInsertException;
import clubactivity.vo.MemberRegisterRequest;

@Component
public class MemberRegisterService {

	@Autowired
	private MemberDAO memberDAO;

	public int insertMember(MemberRegisterRequest memberRegisterRequest) throws Exception {

		int cnt = memberDAO.insertMember(memberRegisterRequest);
		if (cnt == 0) {
			throw new MemberInsertException("Insert failed");
		}
		return cnt;
	}

	public int selectById(String memberId) throws Exception {
		int cnt = memberDAO.selectById(memberId);
		if (cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
		return cnt;
	}

	@Transactional(rollbackFor=SQLException.class)
	public void memberRegister(MemberRegisterRequest memberRegisterRequest) throws Exception {
		this.selectById(memberRegisterRequest.getMemberId());
		this.insertMember(memberRegisterRequest);
	}
}
