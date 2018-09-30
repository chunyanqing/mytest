package day01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一个Servlet程序HelloWorld的开发步骤
 * 1.HelloWorld extends HttpServlet
 * 2.重写HttpServlet类中的service方法
 * 3.在WebRoot/WEB-INF/web.xml中配置servlet(HelloWorld)
 * 4.web.xml中Servlet配置完成后如何通过浏览器如何访问该servlet
 *    http://localhost:8080/项目名(webapps目录下的文件夹的名字)/path
 */
public class HelloWorld extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<font color=red>Hello</font>");
	}
}
