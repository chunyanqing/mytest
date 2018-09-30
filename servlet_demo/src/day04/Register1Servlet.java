package day04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 分步注册功能(用session)：
 * 浏览器URL：
 *    http://localhost:8080/servlet_demo/day04/register1.html
 *    输入信息完成后, 点击"下一步",跳转到Register1Servlet,第二次输入信息
 *    完成后点击"完成",跳转到Register2Servlet
 *
 */
public class Register1Servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 从request中获取session对象
		HttpSession session = request.getSession();

		// 设置session的属性 , session中的属性在整次会话中(只要浏览器不关闭)都有作用
		session.setAttribute("username", username);
		session.setAttribute("password", password);

		// 服务器端跳转
		request
		    .getRequestDispatcher("/day04/register2.html")
		    .forward(request,response);
	}
}