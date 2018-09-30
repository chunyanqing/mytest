package day03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletA extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServletA.service()");
		String cmd = request.getParameter("cmd");
		
		// http://localhost:8080/servlet_demo/serA不加参数不会执行请求转发或者重定向
		// http://localhost:8080/servlet_demo/serA?cmd=d
		// http://localhost:8080/servlet_demo/s/serA?cmd=d
		// 转发
		if ("d".equals(cmd))
		{
			// 相对路径 
			// request.getRequestDispatcher("serB").forward(request, response);
			
			// url 绝对路径
			// 会报: 404
			// request.getRequestDispatcher(request.getContextPath() + "/serB").forward(request, response);
			request.getRequestDispatcher("/serB").forward(request, response);
			
		}
		
		// http://localhost:8080/servlet_demo/serA?cmd=r
		// 重定向
		// 当重定向的返回码是302时,去Response Headers中找到
		// location:http://localhost:8080/servlet_demo/serB
		if ("r".equals(cmd))
		{
			// 会报: 404
			// response.sendRedirect("/serB");
			// 相对路径
			// response.sendRedirect("serB");
			// response.sendRedirect("../serB");
			// 绝对路径
			response.sendRedirect(request.getContextPath() + "/serB");
		}
					
	}
	
}
