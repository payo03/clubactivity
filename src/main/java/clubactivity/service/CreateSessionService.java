package clubactivity.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clubactivity.vo.AuthInfo;
import clubactivity.vo.LoginRequest;
import clubactivity.vo.Messagecommand;

@Component
public class CreateSessionService {

	@Autowired
	private LoginService loginService;

	public List<Messagecommand> createAuthInfoSession(LoginRequest loginRequest, HttpSession session) {

		AuthInfo authInfo = loginService.selectMemberById(loginRequest.getMemberId(), loginRequest.getMemberPassword());
		List<Messagecommand> messagecommands = authInfo.getMessagecommand();

		session.setAttribute("login", authInfo);

		return messagecommands;
	}

	public void createMessageSession(List<Messagecommand> messagecommands, HttpSession session) {
		int messageLength = 0;

		for (Messagecommand messagecommand : messagecommands) {
			if (!messagecommand.isRead())
				messageLength++;
		}
		if (messageLength > 0) {
			session.setAttribute("messageLength", messageLength);
		} else if (messageLength == 0) {
			session.removeAttribute("messageLength");
		}
		session.setAttribute("messagecommands", messagecommands);
	}
}
