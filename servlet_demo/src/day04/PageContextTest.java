package day04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

/**
 * 
 * http://localhost:8080/servlet_demo/servlet/PageContextTest
 * 
 * jsp内置对象pageContext演示：
 *  使用pageContext来获取其它的8个JSP内置对象(工作中不常用)给Servlet用的
 */
public class PageContextTest extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	// 重写HttpServlet抽象类中的service方法
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
    {
		// getPageContext(this, request, response, null, true, 8192, true)中参数解析
		// 参数1: Servlet
		// 参数2: ServletRequest 
		// 参数3: ServletResponse
		// 参数4: String   errorPage ==> xx.jsp ==> 当出现异常的时候,到的页面
		// 参数5: boolean  needsSession  request.getSession(false)
		// 参数6: int  out对象的缓冲区大小      8192 缓存大小  为什么jsp缓存大小默认给的是8192?(有兴趣)
		//         buffer.println("aaa");
		//         buffer.flush();
		// 参数7: boolean true：缓冲区自动刷新 
		// 获取jsp中的内置对象PageConext对象
		PageContext pageContext = JspFactory.getDefaultFactory()
				.getPageContext(this, request, response, null, true, 8192, true);
		
		
		// service方法中也有request和response
		// 一般不需要这样获取request和response
		System.out.println("获取ServletRequest:" + pageContext.getRequest());
		System.out.println("获取ServletResponse:" + pageContext.getResponse());
		
		// 获取ServletConfig方法1
		System.out.println("获取ServletConfig:" +  pageContext.getServletConfig());
		// 获取ServletConfig方法2
		getServletConfig();
		
		System.out.println("获取HttpSession:" + pageContext.getSession());
	
		// jsp内置对象page就是指this
		System.out.println((pageContext.getPage() == this));
		
		System.out.println("获取JspWriter:" + pageContext.getOut());
		
		System.out.println("获取Exception:" + pageContext.getException());
	}

}
