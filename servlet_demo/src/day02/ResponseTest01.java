package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse API演示:
 * 浏览器请求URL：
 *    http://localhost:8080/servlet_demo/hello
 */
public class ResponseTest01 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * response中方法测试
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 解决response响应的中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		/*
		// 3秒后跳转到注册页面1.html
		response.getWriter().print("3秒后跳转到注册页面1.html");
		response.setHeader("reFresh","3;URL=/servlet_demo/1.html");
		*/
		
		// 设置服务器响应的状态码
		// response.setStatus(404);
		// response.setStatus(404,"页面找不到");
		// response.sendError(404);
		// response.sendError(500, "后台错误");
		
		/*
		// 向页面输出内容
		response.getWriter().print("<h1>success</h1>");
		response.getWriter().print("<h1>成功</h1>");
		*/

		/*
		  forward和redirect的区别: 
		  forward是服务器端的跳转,地址栏不发生变化 
		  redirect是客户端的跳转,地址栏发生变化
		  
		      重定向,又叫客户端的跳转,显著特征是地址栏发生变化
		      在浏览器输入http://localhost:8080/servlet_demo/hello
		      重定向到http://localhost:8080/servlet_demo/1.html
		 */
		// response.sendRedirect("/servlet_demo/1.html");
		// 从http://localhost:8080/servlet_demo/hello重定向到
		// http://www.baidu.com  重定向可以跨域
		response.sendRedirect("http://www.baidu.com");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
