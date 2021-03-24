package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import clubactivity.vo.AlertScript;
import clubactivity.vo.AuthInfo;

public class AdminCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		if (authInfo.getMemberlevel().getMemberLevelCode()!=1) {
			return AlertScript.write("권한이 없습니다", "home", request, response);
		}

		return true;
	}

}
