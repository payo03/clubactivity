package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import clubactivity.vo.AlertScript;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object authInfo = session.getAttribute("login");
			if(authInfo != null) {
				return true;
			}
		}
		return AlertScript.write("잘못된 접근입니다", "login", request, response);
	}

}
