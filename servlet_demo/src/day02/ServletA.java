package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 需求： 请求转发(服务器端的跳转forward)
 *   先从ServletB 跳转到ServletA,
 *   再从ServletA(/a) 跳转到success.html页面
 *   
 * 浏览器URL
 *    http://localhost:8080/servlet_demo/b
 */
public class ServletA extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
			throws ServletException, IOException 
	{

		System.out.println("ServletA 被访问");

		System.out.print("testAttr:");
		String[] attrValue = (String[]) request.getAttribute("testAttr");
		for (String val : attrValue) 
		{
			System.out.print(val + " ");
		}
		
		/**
		 * request请求转发(服务器端的跳转forward路径不需要写项目名)
		 * 服务器端的页面跳转,地址不变
		 * (从"hello"(hello是一个Servlet)
		 * 转发到"success.html"(success.html是一个页面))
		 */
		request.getRequestDispatcher("/success.html")
				.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}
