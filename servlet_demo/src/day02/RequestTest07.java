package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 浏览器请求URL：
 *     http://localhost:8080/servlet_demo/messycode.html
 *     
 * post方式请求处理中文乱码：
 *    方法2使用request.setCharacterEncoding()演示：
 *    
 * 1.使用字符串转码 
 *     String name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
 *     
 * 2.使用request.setCharacterEncoding()
 *     一定要在request.getParameter("xxx")被调用之前
 */
public class RequestTest07 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

	}

	/**
	 * post方式请求处理中文乱码
	 * 方法2使用request.setCharacterEncoding()
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 给request设置编码为UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String introduce = request.getParameter("introduce");

		// 解决中文乱码
		System.out.println(name);
		System.out.println(introduce);

	}
}