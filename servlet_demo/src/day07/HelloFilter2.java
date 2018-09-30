package day07;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Filter生命周期
 * 和
 * FilterConfig API演示
 * 
 */
/*<filter>
<filter-name>HelloFilter2</filter-name>
<filter-class>day07.HelloFilter2</filter-class>

<init-param>
	<param-name>encode</param-name>
	<param-value>UTF-8</param-value>
</init-param>
<init-param>
	<param-name>paramName1</param-name>
	<param-value>paramValue1</param-value>
</init-param>

</filter>
<filter-mapping>
<filter-name>HelloFilter2</filter-name>
<url-pattern></url-pattern>
</filter-mapping>
*/
@WebFilter(filterName="HelloFilter2",urlPatterns="/*",initParams={@WebInitParam(name="encode",value="UTF-8"), @WebInitParam(name="paramName1",value="paramValue1")})
public class HelloFilter2 implements Filter {

	/**
	 * 定义当前过滤器的属性
	 */
	private String requestEncoding;

	/**
	 * 过滤器的执行方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器开始...");
		// 让过滤器往下走,放行,如果后面还有过滤器, 那么就执行下一个过滤器,如果是最后一个过滤器就去执行Controller
		chain.doFilter(request, response);
		System.out.println("过滤器结束...");
	}

	/**
	 * 当服务器启动的时候被执行,说明过滤器的实例是在服务器启动的时候被创建的
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器被创建...");

		// 根据参数名来获取过滤器初始化参数
		String encode = filterConfig.getInitParameter("encode");
		// 给当过滤器赋值
		this.requestEncoding = encode;

		// 获得过滤器参数所有初始化参数的名字(即<param-name>的值)
		Enumeration<String> enum1 = filterConfig.getInitParameterNames();
		while (enum1.hasMoreElements()) {
			String paramName = enum1.nextElement();
			String paramValue = filterConfig.getInitParameter(paramName);
			System.out.println(paramName + ":" + paramValue);
		}
	}

	/**
	 * 当服务器关闭时当前方法被执行, 实例被销毁
	 */
	public void destroy() {
		System.out.println("过滤器被销毁...");
	}

}
