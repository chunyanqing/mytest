package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器请求URL：
 *     http://localhost:8080/servlet_demo/messycode.html
 *     
 * post方式请求处理中文乱码：方法1使用字符串转码演示：
 * 1.使用字符串转码
 *     String name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
 * 2.使用request.setCharacterEncoding()
 *     一定要在request.getParameter("xxx")被调用之前
 */
public class RequestTest06 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException
	{

	}


	/**
	 * post方式请求处理中文乱码:方法1使用字符串转码
	 */
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
		    throws ServletException, IOException 
    {
		String name = request.getParameter("name");
		String introduce = request.getParameter("introduce");
		
		// 会出现中文乱码
		System.out.println(name);
		System.out.println(introduce);
		
		// 解决POST请求时的中文乱码问题  使用字符串转码
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		introduce = new String(introduce.getBytes("ISO-8859-1"),"UTF-8");
		
		// 中文不会出现乱码
		System.out.println(name);
		System.out.println(introduce);
	}
}