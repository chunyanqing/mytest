package day07;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * http://localhost:8080/servlet_demo/servlet/HelloServlet
 * 
 * 定义过滤器
 *  1.写过滤器就是写一个类  implelments javax.servlet.Filter
 *  2.在web.xml中配置Filter
 */
public class HelloFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	/**
	 * 注意:doFilter的参数为ServletRequest和ServletResponse
	 *     而不是HttpServletReqest和HttpServletResponse
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		 System.out.println("过滤器开始...");
		 
		 HttpServletRequest req = (HttpServletRequest) request;
		 String ip = req.getRemoteAddr();
		 System.out.println(ip + "在"+ new Date() + "发送了:" + req.getRequestURL() + "请求");
		 
	     // 让过滤器往下走,放行,如果后面还有过滤器, 
		 // 那么就执行下一个过滤器,如果是最后一个过滤器就去执行Controller
	     chain.doFilter(request, response);
	     
	     System.out.println("过滤器结束...");
	}

	// 类似于Servlet中的ServletConfig
	// 用于读取过滤的初始化参数
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
