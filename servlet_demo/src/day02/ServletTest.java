package day02;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * http://localhost:8080/servlet_demo/servlet
 *
 */
public class ServletTest implements Servlet
{
	/**
	 * 执行时机: 当Servlet实例被创建的时候调用,做初始化工作,仅被调用一次
	 * ServletConfig:Servlet的配置对象,初始化的时候可以进行配置
	 */
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("servlet组件被创建了");
	}

	/**
	 * 执行时机: 当一个请求来请求当前的Servlet的时候被调用
	 * 处理当前Servlet的业务逻辑并且把响应返回给浏览器
	 */
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("servlet响应请求!");
		response.getOutputStream().write("<font color = 'red'>helloServlet</font>".getBytes());
	}
	
	/**
	 * 执行时机:是Servlet的实例对象被销毁的时候调用
	 * 做一些收尾或清理的工作(重要)
	 */
	public void destroy()
    {
		System.out.println("servlet组件被销毁了");
	}
	
	/**
	 * 获得ServletConfig的配置对象
	 */
	public ServletConfig getServletConfig() {
		return null;
	}

	/**
	 * 获得当前Servlet的一些属性信息(了解,不重要)
	 */
	public String getServletInfo() {
		return null;
	}

}
