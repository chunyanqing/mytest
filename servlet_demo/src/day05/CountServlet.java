package day05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 使用session实现在线人数统计
 * 
 * http://localhost:8080/servlet_demo/servlet/CountServlet
 * 每刷新一次浏览器中的地址栏
 *    在线人数会加1
 *
 */
public class CountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 从请求中获取HttpSession
		HttpSession session = request.getSession();
		
		// 从HttpSession中获取在线人数count
		Object objCount = session.getAttribute("count");
		Integer count = (Integer) objCount;
		
	    // 如果是第一人访问(session中还没有数据)则要处理
		if(count == null)
		{
			count = 1;
		}else
		{
			count++;
		}
		
		// 把count结果存入session
		session.setAttribute("count", count);
		
		// 转发到/day05/count.jsp
		request.getRequestDispatcher("/day05/count.jsp").forward(request, response);
	}
}
