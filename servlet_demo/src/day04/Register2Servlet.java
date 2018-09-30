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
public class Register2Servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			   throws ServletException,  IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String sex = request.getParameter("sex");
		String job = request.getParameter("job");
		
		// 根据来获取session
		HttpSession session = request.getSession();
		// 从session中获取用户名和密码
		String username = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
		
		// 获取session的id, session利用id和浏览器中的Cookie进行绑定, 用来区分会话
		String sessionId  = session.getId();
		System.out.println("sessionId:" + sessionId);
		
		String sexText = "";
		if ("1".equals(sex))
		{
			sexText = "男";
		}else if ("2".equals(sex))
		{
			sexText = "女";
		}
		
		String jobText = "";
		if ("1".equals(job))
		{
			jobText = "讲师";
		}else if ("2".equals(job))
		{
			jobText = "教授";
		}

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("<h1>注册成功</h1>");
		response.getWriter().println("<hr>");
		response.getWriter().println("用户名:" + username + "<br/>");
		response.getWriter().println("密码:" + password + "<br/>"); 
		response.getWriter().println("性別:" + sexText + "<br/>");
		response.getWriter().println("职位:" + jobText + "<br/>");
	}
}