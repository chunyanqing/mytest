package day02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * HttpServletRequest接口API演示2 
 * HttpServletRequest获取请求相关的其他方法(重要方法)
 *   String  getContentType()
 *   void    setCharacterEncoding(String code)
 *   String  getCharacterEncoding()
 *   Sting   getContextPath()
 *   String  getRemoteAddr()
 *   
 *   浏览器请求路径:
 *   http://localhost:8080/servlet_demo/req?name=zhangsan
 *   或者
 *   http://127.0.0.1:8080/servlet_demo/req?name=zhangsan
 *   其中localhost也可以换成127.0.0.1或者本机服务器IP
 */
public class RequestTest02 extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		// 设置请求编码,只对请求体有效!
		// 注意:对于GET而言,没有请求体!!!
		// 所以此方法只能对POST请求中的参数有效！
		// 获取请求编码:utf-8
		request.setCharacterEncoding("utf-8");

		// 获取请求编码,如果没有setCharacterEncoding()
		// 那么返回null,表示使用ISO-8859-1编码
		String regEncoding = request.getCharacterEncoding();
		// 获取请求协议:http
		System.out.println("获取请求编码:" + regEncoding);
		
		
		
		
		
		
		
		// 获取请求应用名 ===>上下文用来获取绝对路径的(后面讲)
		String appName = request.getContextPath();
		// 获取上下文:/servlet_demo
		System.out.println("获取上下文(获取部署到服务器上的应用名):" + appName);

		/*
		 * servletPath:返回Servlet路径
		 * 
		 * 1. /abc ==> /abc 2. /abc/def ==> /abc/def 4. *.xx ===>
		 * /abc/def/ad/ad/a.php 5. /xx/yy/* ==> /servlet/a
		 */
		String servletPath = request.getServletPath();
		// 获取到url-pattern(servlet请求名):/req
		System.out.println("获取到url-pattern(servlet请求名):" + servletPath);
		
		// 返回请求URI路径 例如(/hello/oneServlet)  相当于contextPath+servletPath
		String requestURI = request.getRequestURI();
		// 返回请求URI路径:/servlet_demo/req
		System.out.println("返回请求URI路径:" + requestURI);
		
		// 整个请求URL路径(不包括参数)
		StringBuffer requestURL = request.getRequestURL();
		// 返回请求的URL地址(不包括参数):
		// http://127.0.0.1:8080/servlet_demo/req
		System.out.println("返回请求的URL地址(不包括参数):" + requestURL);
		
		
		
		
		
		

		// 返回请求协议 例如:http
		/*String scheme = request.getScheme();
		System.out.println("获取请求协议:" + scheme);*/

		String ip = request.getRemoteAddr();
		// 获取访问者的IP地址:0:0:0:0:0:0:0:1
		// 把浏览器请求改成()   http://127.0.0.1:8080/servlet_demo/req
		// 获取访问者的IP地址:127.0.0.1
		// (或者让学生访问地址 http://服务器IP:8080/servlet_demo/req)
		System.out.println("获取访问者的IP地址:" + ip);
		
		// 获取请求类型,如果请求是GET,那么这个方法返回null;
		// 如果是POST请求,那么默认为
		// application/x-www-form-urlencoded,
		// 表示请求体内容使用了URL编码
		String contentType = request.getContentType();
		// 获取请求类型:null
		System.out.println("获取请求类型:" + contentType);


		/*int remotePort = request.getRemotePort();
		// 获取访问者的端口:50468
		System.out.println("获取访问者的端口:" + remotePort);*/
		
        /*
		String remoteHost = request.getRemoteHost();
		// 获取访问者的主机(指域名):127.0.0.1
		System.out.println("获取访问者的主机(指域名):" + remoteHost);*/

		/*// 返回服务器主机名 例如(localhost)
		String serverName = request.getServerName();
		// 获取服务器主机名 :127.0.0.1
		System.out.println("获取服务器主机名 :" + serverName);*/

		/*// 返回服务器端口号 例如(8080)
		int serverPort = request.getServerPort();
		// 获取服务器端口号:8080
		System.out.println("获取服务器端口号:" + serverPort);*/
		
		/*// 返回请求URL中的参数
		String queryString = request.getQueryString();
		// 返回请求URL中的参数:null
		// name=zhangsan
		System.out.println("返回请求URL中的参数:" + queryString);*/

		/*// 获取请求体的字节数(GET请求没有请求体,没有请求体返回-1)
		int contentLength = request.getContentLength();
		// 获取请求体的字节数:-1
		System.out.println("获取请求体的字节数:" + contentLength);*/

		

		/*// 请求方式
		String method = request.getMethod();
		// 请求方式:GET
		System.out.println("请求方式:" + method);

		// 返回当前客户端浏览器的Locale.
		// java.util.Locale表示国家和言语,这个东西在国际化中很有用
		Locale locale = request.getLocale();
		// 获取当前客户端浏览器的语言:zh_CN
		System.out.println("获取当前客户端浏览器的语言:" + locale);*/

	}

	@Override
	public void doPost(HttpServletRequest request, 
	   HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
