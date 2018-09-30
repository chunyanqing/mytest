package day04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用cookie进行分布用户注册演示
 * 
 * http://localhost:8080/servlet_demo/day04/register1.jsp
 *
 */
public class Register1ServletCook extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
			throws ServletException,  IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名：" + username);
		System.out.println("密码：" + password);
		
		// 创建Cookie对象
		Cookie cookie = new Cookie("userpass", username+", "+password);

		// 把Cookie写入浏览器
		response.addCookie(cookie);
		
		// 服务器端跳转
		request.getRequestDispatcher("/day04/register2.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
