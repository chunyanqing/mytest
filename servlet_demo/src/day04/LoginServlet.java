package day04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 浏览器URL:
 *    http://localhost:8080/servlet_demo/servlet/login.jsp
 *
 */
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
    {
		
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		
		// request.setAttribute("name", userName);
		// 把userName放入session,不放在request中了
		session.setAttribute("name", userName);
		
		
		// 转发进入success.jsp页面
		// 转发对于浏览器而言是一次请求
		request.getRequestDispatcher("/day04/success.jsp")
		       .forward(request, response);
	}
	
	

}
