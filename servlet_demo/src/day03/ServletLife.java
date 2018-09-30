package day03;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet生命周期
 *    ServletLife对象实例并不是由我们手动创建,而是Web容器给我们创建
 * 
 * init(ServletConfig config):
 *    默认情况当Servlet被第一次访问的时候init方法会被调用
 *    说明Servlet的实例默认情况下是第一次被访问的时候被创建(可以修改) 
 *    第二次往后都不会被调用(只被调用一次),Servlet的实例是单例的
 *    
 *    可以修改Servlet创建时机
 *			    在web.xml中, <servlet></servlet>内使用
 *			    <load-on-startup>N</load-on-startup>
 *			    N是数字
 *			    	N >= 0 的时候,Servlet都会在服务器启动的时候被创建
 *			    	数字的大小决定了多个Servlet创建的顺序
 * 
 * service(ServletRequest req, ServletResponse res):
 *    每次请求来的时候都会被调用
 *    
 * destroy()：
 *    当ServletLife对象销毁时被调用
 * 
 */
public class ServletLife implements Servlet
{
	public void init(ServletConfig servletConfig)
	    throws ServletException
	{
		System.out.println("init方法被调用----------------");
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("service方法被调用");
		response
		  .getOutputStream()
		      .write("<font color = 'red'>service方法被调用---------</font>".getBytes());
	}

	public void destroy()
	{
		System.out.println("destroy方法被调用----------------");
	}

	public ServletConfig getServletConfig() 
	{
		return null;
	}

	public String getServletInfo() 
	{
		return null;
	}

}