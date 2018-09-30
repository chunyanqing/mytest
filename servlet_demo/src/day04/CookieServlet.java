package day04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * 服务器端对象cookie的CRUD
 */
public class CookieServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
		HttpServletResponse response)
			throws ServletException, IOException 
	{
		// http://localhost:8080/servlet_demo/servlet/cookie/asdf
		String path = request.getRequestURL().toString();
		// /asdf
		path = path.substring(path.lastIndexOf("/cookie") + "/cookie".length());
		// 重启Tomcat服务,看一下path和path2的值
		System.out.println(path);
		
		// /servlet/cookie
		/*String path2 = request.getServletPath();
		System.out.println(path2);*/

	
		if ("/add".equals(path))
		{
			add(request, response);
		}
		
		if("/delete".equals(path))
		{
			delete(request, response);
		}
		
		
		if("/update".equals(path))
		{
			update(request, response);
		}
		
		if("/query".equals(path))
		{
			query(request, response);
		}
		
		if("/default".equals(path))
		{
			return;
		}
	}
	


	// 添加cookie
	// http://localhost:8080/servlet_demo/servlet/cookie/add
	public void add(HttpServletRequest request, HttpServletResponse response) {
		// cookie是键值对并且键值对都要是String类型 (注意这里的value不能是中文)
		// jsessionId=xxxx
		Cookie cookie1 = new Cookie("name","liyan");
	    
		// 设置cookie的超时时间(单位:秒)为1天
		cookie1.setMaxAge(60 * 60 * 24);
		cookie1.setPath(request.getContextPath());
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("password","123");
		cookie2.setPath(request.getContextPath());
		response.addCookie(cookie2);
	}
	

	// 查询cookie
	public void query(HttpServletRequest request, HttpServletResponse response) {
		// 服务器获取cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies)
		{
			System.out.println(c.getName() + "," + c.getValue());
		}
	}
	
	// 删除cookie
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// Servlet中没有提供删除Cookie的方法
		// cookie是由生命周期的
		// 默认浏览器关闭cookie消亡
		// 可以为cookie设置maxAge
		
		// 删除cookie ==> 添加maxAge为0 的cookie
		Cookie c = new Cookie("name","");
		// cookie的存活时间为0分钟
		c.setMaxAge(0);
		response.addCookie(c);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		Cookie c = new Cookie("name","meinv");
		response.addCookie(c);
	}


	

}
