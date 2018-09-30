package day02;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器请求路径:
 * http://localhost:8080/servlet_demo/dynamicform.html
 * 
 */
public class RequestTest05 extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	/**
	 * getParameterNames用户获得表单中的文本域的所有name,适合动态表单
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 获得表单中所有文本域的name
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
        	// 获得每个文本域的name
        	String paramName = paramNames.nextElement();
        	// 根据文本域的name来获取值
        	String[] paraValues = request.getParameterValues(paramName);
        	// 输出文本域的name
        	System.out.print(paramName + ":");
        	// 输出相应文本域的值
        	for(String paraVal: paraValues)
        	{
        		System.out.print(paraVal + " ");
        	}
        	System.out.println();
        }
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
