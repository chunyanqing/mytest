package day04;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie中保存中文问题演示:
 */
public class GetCookieServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException,  IOException {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies){
			String name = cookie.getName();
			if ("userpass".equals(name)){
				String cookieVal = cookie.getValue();
				System.out.println("解码前:"+cookieVal);
				cookieVal = URLDecoder.decode(cookieVal);
				System.out.println("解码后:"+cookieVal);
			}
		}
	}
	
}
