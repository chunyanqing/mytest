package day05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CookieUtils;

/**
 * 实现自动登录(使用cookie实现)
 * 
 *   要实现此功能要在7天免登录的基础上(username:admin pwd:admin)
 * 
 * http://localhost:8080/servlet_demo/servlet/ShowLoginServlet
 * 
 * 再次输入
 *   http://localhost:8080/servlet_demo/servlet/ShowLoginServlet
 * 输入错误的密码则重新定位到登录页面
 * 
 * 
 * 需求:
 * ShowLoginServlet作用 判断当前Cookie中有没有对应的数据, 如果有对应的数据,则让该用户直接进入到登录后的界面
 * 如果没有对应数据,则让该用户进入登录界面 
 * 如果Cookie中数据和用户输入的用户信息(用户名 密码)不一致,则让该用户重新登录
 * 
 *
 */
public class ShowLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		// 取出Cookie中保存的用户名和密码
		String username = CookieUtils.findCookie("username", request);
		String password = CookieUtils.findCookie("pwd", request);

		// 如果username和passord中有一个值为null则直接让该用户重新登录
		if (username == null || password == null)
		{
			request.getRequestDispatcher("/day05/login.jsp").forward(request,
					response);
			return;
		}

		// 如果用户密码是否正确,如果正确则进入/welcome.jsp(登录成功界面)
		// 用户改密码
		if ("admin".equals(username) && "admin".equals(password))
		{
			// 这里转发和重定向都可以
			// request.getRequestDispatcher("/day05/welcome.jsp").forward(request,
			// response);
			// 往session中保存数据
			request.getSession().setAttribute("username", username);
			
			response.sendRedirect(request.getContextPath() + "/day05/welcome.jsp");
					
			return;
		}

		// 用户名和密码都不为空,但是用户信息已经修改过了(可能用户在3天前改过密码了)
		CookieUtils.removeCookie("username", response);
		CookieUtils.removeCookie("pwd", response);

		// 这里转发和重定向都可以
		response.sendRedirect(request.getContextPath() + "/day05/login.jsp");

	}

}
