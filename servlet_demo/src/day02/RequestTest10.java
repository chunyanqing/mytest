package day02;

import java.io.IOException;
import java.net.URLDecoder;
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
 *   get方式请求处理中文乱码方案3:JS端设置编码,后台解码
 * 
 */
public class RequestTest10 extends HttpServlet 
{
		
	private static final long serialVersionUID = 1L;

		/**
		 * get方式请求处理中文乱码方案3:JS端设置编码,后台解码
		 */
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			System.out.println(name);
			name = URLDecoder.decode(name,"UTF-8");
			System.out.println(name);
		}
	}