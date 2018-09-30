package day03;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://127.0.0.1:8080/servlet_demo/servlet/ServletConfigTest
 * 
 * <servlet>
		<servlet-name>ServletConfigTest</servlet-name>
		<servlet-class>day03.ServletConfigTest</servlet-class>
		<init-param>
		    <param-name>username</param-name>
		    <param-value>123456</param-value>
		</init-param>
		<init-param>
		    <param-name>password</param-name>
		    <param-value>111111</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletConfigTest</servlet-name>
		<url-pattern>/servlet/ServletConfigTest</url-pattern>
	</servlet-mapping>
	
	
 * ServletConfig演示:
 */
@WebServlet(urlPatterns="/servlet/ServletConfigTest",initParams={@WebInitParam(name="username",value="123456"), @WebInitParam(name="password",value="111111")})
public class ServletConfigTest extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init(ServletConfig config) throws ServletException {
		
		
		// (1)从Servlet中获得初始化的参数值
		String userName = config.getInitParameter("username");
		System.out.println("userName:" + userName);
		
		System.out.println("-------------------------");

		// (2)获得所有的参数名
		Enumeration emuns = config.getInitParameterNames();
		while (emuns.hasMoreElements()) {
			String name = (String)emuns.nextElement();
			String value = config.getInitParameter(name);
			System.out.println("name:" + value);
		}
	}
}
