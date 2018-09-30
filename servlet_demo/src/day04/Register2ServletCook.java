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
 */
public class Register2ServletCook extends HttpServlet 
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
		
		System.out.println("性别：" + sex);
		System.out.println("职位：" + job);

		// 从浏览器中读取当前项目中的所有Cookie
		Cookie[] cookies = request.getCookies();
		String userpassVal = null;
		// 循环遍历cookie
		for(Cookie cookie : cookies){
			// 获得cookie的名称
			String cookieName = cookie.getName();
			if ("userpass".equals(cookieName)){
				// 拿到第一步写入cookie的值
				userpassVal = cookie.getValue();
			}
		}
		
		String username = null;
		String password = null;
		if (userpassVal != null){
			String[] userpassValStr = userpassVal.split(", ");
			username = userpassValStr[0];
			password = userpassValStr[1];
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String sexText = "";
		if ("1".equals(sex)){
			sexText = "男";
		}else if ("2".equals(sex)){
			sexText = "女";
		}
		
		String jobText = "";
		if ("1".equals(job)){
			jobText = "讲师";
		}else if ("2".equals(job)){
			jobText = "教授";
		}
		
		response.getWriter().println("<h1>注册成功</h1>");
		response.getWriter().println("<hr>");
		response.getWriter().println("用户名:" + username + "<br/>");
		response.getWriter().println("密码:" + password + "<br/>"); 
		response.getWriter().println("性別:" + sexText + "<br/>");
		response.getWriter().println("职位:" + jobText + "<br/>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
