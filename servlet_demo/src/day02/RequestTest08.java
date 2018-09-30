package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 浏览器请求URL：
 *    http://localhost:8080/servlet_demo/messycode2.html
 *     
 * 处理GET请求参数乱码的3种方式代码演示：
 * 
 *    get方式请求处理中文乱码方案1:	
 *       String name = request.getParameter("name");
 *       name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
 *    
 *
 */
public class RequestTest08 extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;

	/**
	 *  get方式请求处理中文乱码方案1:	
	 *  String name = request.getParameter("name");
	 *  name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在get方式请求中request.setCharacterEncoding("UTF-8");不起作用
		String name = request.getParameter("name");

		//  中文乱码解决方案1
	    name = new String(name.getBytes("ISO-8859-1"),"UTF-8");

		// 解决中文乱码
		System.out.println(name);

	}
}