package day04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 7天免登录演示
 * http://localhost:8080/servlet_demo/day04/userLogin.jsp
 * 勾选7天免登录
 * 再次输入
 *    http://localhost:8080/servlet_demo/day04/userLogin.jsp
 * 可以直接登录成功
 * 
 * 如果换成本机ip地址
 * http://192.168.0.101:8080/servlet_demo/day04/userLogin.jsp
 * 则不能自动登录
 * 
 */
public class UserLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
	    HttpSession session = request.getSession();
		
		// request.setAttribute("name", userName);
		// 把userName放入session,不放在request中了
		session.setAttribute("name", userName);
	
		
		if ("admin".equals(userName) && "admin".equals(password))
		{
			// 如果用户在页面上没有勾选"7天免登陆",那么取一个不存在的参数 一定是null
			if (request.getParameter("remember") != null)
			{
				Cookie nameCookie = new Cookie("username", userName);
				Cookie passwordCookie = new Cookie("pwd", password);
				
				// 单位:分钟   设置cookie的存活时间:7天
				nameCookie.setMaxAge(7 * 24 * 60 * 60);
				passwordCookie.setMaxAge(7 * 24 * 60 * 60);
				
				// 将这2个cookie放入到response对象中
				response.addCookie(nameCookie);
				response.addCookie(passwordCookie);
			}
			
			// 登录成功, 则重定向到success.jsp页面
			response.sendRedirect(request.getContextPath() + "/day04/userSuccess.jsp");
			return;
		}
		
		request.setAttribute("errMsg", "用户名密码错误");
		
		// 登陆失败, 则转发到userLogin.jsp页面
		request.getRequestDispatcher("/day04/userLogin.jsp").forward(request, response);
	}
	
}
