package day02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器请求路径:
 * http://localhost:8080/servlet_demo/param?userId=1&name=zhangsan&x=b&x=a&x=c
 * 
 */
public class RequestTest03 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// http://localhost:8080/servlet_demo/param?userId=1&name=zhangsan&x=b&x=a&x=c
		// 获取请求参数
		String userId = request.getParameter("userId");
		System.out.println("userId:" + userId);

		String name = request.getParameter("name");
		System.out.println("name:" + name);

		// 当有多个请求参数的参数名相同的时候如果使用request.getParameter("x")则获取的是第一个x的值
		// 此时我们可以使用下面的方法 request.getParameterValues("x");
		String[] x = request.getParameterValues("x");
		// Arrays类 jdk1.8以后 没了
		System.out.println(Arrays.toString(x));

		System.out.println("-------------------------");
		
		// 获取所有请求参数的名字
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements())
		{
			System.out.println(paramNames.nextElement());
		}

		System.out.println("--------------------------");
		
		// 以Map的形式,获取所有的参数
		// 参数名作为key 参数值作为value
		Map<String, String[]> map = request.getParameterMap();
		// 遍历map
		Set<Entry<String, String[]>> entries = map.entrySet();
		Iterator<Entry<String, String[]>> iter = entries.iterator();
		while (iter.hasNext())
		{
			Entry<String, String[]> entry = iter.next();
			System.out.println(entry.getKey());
			System.out.println(Arrays.toString(entry.getValue()));
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
