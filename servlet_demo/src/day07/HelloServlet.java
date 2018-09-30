package day07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义过滤器
 *  1.写过滤器就是写一个类  implelments javax.servlet.Filter
 *  2.在web.xml中配置Filter
 */
public class HelloServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException
	{
        System.out.println("do HelloServlet get method ...");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
	}

}
