package day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在WEB-INF下新建一个页面a.jsp
 *    http://localhost:8080/servlet_demo/show 
 * 
 * 
 * 在WEB-INF下新建一个目录a,在a目录下新建一个a.jsp页面
 * 在WEB-INF下的a目录下新建一个b目录,在b目录下新建一个a.jsp页面
 * 想要通过以下不同的url
 *    http://localhost:8080/servlet_demo/show/a(.jsp)
 *    http://localhost:8080/servlet_demo/show/a/a(.jsp)
 *    http://localhost:8080/servlet_demo/show/a/b/a(.jsp)
 * 访问到以上几个a.jsp页面
 *
 */
public class ShowServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException 
	{
		// http://localhost:8080/servlet_demo/show 
		// 可以访问到(servlet转发实现对)/WEB-INF/a.jsp中页面的访问   
		// 而不能通过http://localhost:8080/servlet_demo/WEB-INF/a.jsp
		// request.getRequestDispatcher("/WEB-INF/a.jsp").forward(request,reponse);
		
		// servletPath:  /show
		String servletPath = request.getServletPath();
		
		// contextPath:  /servlet_demo
		String contextPath = request.getContextPath();
		
		// uri:/servlet_demo/show
		String uri = request.getRequestURI();
		
		
		System.out.println("servletPath:  " + servletPath);
		System.out.println("contextPath:  " + contextPath);
		System.out.println("uri:" + uri);
		
		
		String path = uri.substring((servletPath + contextPath).length());
		System.out.println("path:" + path);
		
		// http://localhost:8080/servlet_demo/show/a
		// http://localhost:8080/servlet_demo/show/a/a
		// http://localhost:8080/servlet_demo/show/a/b/a
		request.getRequestDispatcher("/WEB-INF/" + path + ".jsp").forward(request,reponse);
	}
    
}
