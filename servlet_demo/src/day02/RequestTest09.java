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
 *   http://localhost:8080/servlet_demo/messycode2.html
 * 
 *  get方式请求处理中文乱码方案2:
 *    Tomcat服务器安装路径中的conf/server.xml中加 URIEncoding="UTF-8"
 *  
 *    <Connector port="8080" protocol="HTTP/1.1"   
 *       connectionTimeout="20000"
 *              redirectPort="8443" URIEncoding="UTF-8"/>
 * 
 */
public class RequestTest09 extends HttpServlet 
{
		
	private static final long serialVersionUID = 1L;

		/**
		 * get方式请求处理中文乱码方案2:
		 * Tomcat服务器安装路径中的conf/server.xml中加 URIEncoding="UTF-8"
		 */
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			System.out.println(name);
			name = URLDecoder.decode(name,"UTF-8");
			System.out.println(name);
		}
	}