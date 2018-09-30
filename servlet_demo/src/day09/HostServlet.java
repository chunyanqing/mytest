package day09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * http://localhost:8080/servlet_demo/host
 *    0:0:0:0:0:0:0:1访问了HostServlet,消耗:13毫秒
 * 
 * http://127.0.0.1:8080/servlet_demo/host
 *    127.0.0.1访问了HostServlet,消耗:10毫秒
 * 
 * 清空控制台,打印在控制台上的信息没有了
 * 有没有一种方法能永久的保存信息
 * 
 * @author liyan
 *
 */
public class HostServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 记录访问者的ip,访问时间,以及该servlet执行所消耗的时间
		String ip = request.getRemoteAddr();
		
	    long stime = System.currentTimeMillis();
		
		for(int i = 0; i < Integer.MAX_VALUE;i++)
		{
			
		}
		
		long etime = System.currentTimeMillis();
		
		long millisTime = etime - stime;
		
		String str = ip + "访问了HostServlet,消耗:" + millisTime + "毫秒";
		System.out.println(str);
		
		System.out.println("----------------------------------------------------------------");
		
		Logger logger = Logger.getLogger(HostServlet.class);
		logger.debug(str);
	}
}
