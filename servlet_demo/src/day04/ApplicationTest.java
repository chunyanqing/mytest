package day04;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/servlet_demo/servlet/ApplicationTest
 * 
 * JSP内置对象Application
 */
public class ApplicationTest extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// Application相当于ServletContext(Servlet上下文)
		
		// ServletContext获取方式1(常用)
		// ServletContext application = getServletContext();
		
		// ServletContext获取方式2
		ServletContext application = getServletConfig().getServletContext();
		// 用application可以访问全局的初始化参数
		String parameter = application.getInitParameter("itany");
		// itany:www.itany.com
		System.out.println("itany:" + parameter);
		
		// 使用application获取跟整个应用相关的一些方法(在Servlet中)
		// 获取服务器的根目录
		String serverRealPath1 = application.getRealPath("");
		// serverRealPath1:E:\tools\apache-tomcat-7.0.20\webapps\servlet_demo
		System.out.println("serverRealPath1:" + serverRealPath1);
		
		String serverRealPath2 = application.getRealPath("/day04");
		// serverRealPath2:E:\tools\apache-tomcat-7.0.20\webapps\servlet_demo\day04
		System.out.println("serverRealPath2:" + serverRealPath2);
		
		
		// application用于绑定数据(Servlet)
		application.setAttribute("key", "value");
		/*
		Object attribute = application.getAttribute("key");
		System.out.println("attribute:" + attribute);
		application.removeAttribute("key");
		*/
		
		response.sendRedirect(request.getContextPath() + "/day04/app.jsp");
		
	}
	
	

}
