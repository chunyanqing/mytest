package day04;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie中保存中文问题演示:
 */
public class CookieChinese extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,  HttpServletResponse response)
			throws ServletException,  IOException 
	{

		request.setCharacterEncoding("UTF-8");
		
		String name = "李艳";
		name = URLEncoder.encode(name);
		Cookie cookie = new Cookie("userpass", name);
		cookie.setMaxAge(60*60);
		
		// 硬编码
		// cookie.setPath("/servlet_demo/");
	    // 灵活编码
		cookie.setPath(request.getContextPath() + "/"); 
		response.addCookie(cookie);	
		response.getWriter().println("success");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
