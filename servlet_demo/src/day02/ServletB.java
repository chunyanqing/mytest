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
public class ServletB extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
			throws ServletException, IOException 
	{
		
	    System.out.println("ServletB 被访问");
		
	    // 使用request.setAttribute来设置结果集
        request.setAttribute("testAttr", new String[]{"li","liyan"});
		
        /**
		 * request请求转发(服务器端的跳转forward路径不需要写项目名)
		 * 服务器端的页面跳转,地址不变
		 * ServletB转发到ServletA
		 */
		request.getRequestDispatcher("/a").forward(request, response);
	}

	
	@Override
	public void doPost(HttpServletRequest request, 
		HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request,response);
	}
}