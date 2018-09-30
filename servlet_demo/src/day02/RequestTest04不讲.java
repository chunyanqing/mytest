package day02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器请求路径:
 * http://localhost:8080/servlet_demo/method.html
 * 
 */
public class RequestTest04不讲 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, 
		HttpServletResponse response)
			throws IOException, ServletException
	{

		String method = request.getMethod();
		System.out.println("请求方式:" + method);

		// 获取所有的请求参数和对应的参数值
		Map<String, String[]> paramsMap = request.getParameterMap();
		Set<String> keys = paramsMap.keySet();
		for (String k : keys) 
		{
			System.out
					.println(k + "------" + Arrays.toString(paramsMap.get(k)));
		}
	}

}
