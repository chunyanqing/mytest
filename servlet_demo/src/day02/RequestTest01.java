package day02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;

/**
 * HttpServletRequest接口API演示1
 * HttpServletRequest获取请求头数据
 */
public class RequestTest01 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, 
		HttpServletResponse response) 
				throws IOException, ServletException 
	{
		response.setContentType("text/html;charset=utf-8");

		// 根据头信息的key来获得相应的值 
		String headValue = request.getHeader("Host");
		// Host:localhost:8080 
		System.out.println("Host:" + headValue);
		// 会有IOException 把headValue的值输出到浏览器
		response.getWriter().println("Host:" + headValue);
		
		System.out.println("----------------------------------------");

		// 获得所有头信息的name
		Enumeration<String> headNames = request.getHeaderNames();
		// 枚举类型的遍历
		while (headNames.hasMoreElements()) 
		{
			String name = headNames.nextElement();
			// 根据头信息的key来获得相应的值 
			System.out.println("name:" + request.getHeader(name));
			
			response.getWriter().println(
					name + ":" + request.getHeader(name) + "<br/>");
		}
		
	}
}
