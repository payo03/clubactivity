package clubactivity.vo;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlertScript {

	public static boolean write(String message, String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("location.href='" + request.getContextPath() + "/" + path + "';");
		out.println("</script>");
		out.flush();
		
		return false;
	}
}
