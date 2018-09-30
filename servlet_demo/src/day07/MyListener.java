package day07;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器示例代码
 *   ServletRequestListener(用的最多)
 *   HttpSessionListener
 *   ServletContextListener
 *
 */
public class MyListener implements ServletRequestListener , HttpSessionListener, ServletContextListener
{
	/**
	 * 在浏览器中随便输入一个url
	 *   如:
	 *      http://localhost:8080/servlet_demo/index.jsp
	 * 在控制台中可以看到
	 *    当ServletRequest(request)被创建的时候,容器会自动的调用该方法
	 *    当ServletRequest(request)被销毁的时候,容器会自动的调用该方法
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0)
	{
		// 当ServletRequest(request)被创建的时候, 容器会自动的调用该方法
		System.out.println("当ServletRequest(request)被创建的时候,容器会自动的调用该方法");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) 
	{
		// 当ServletRequest(request)被销毁的时候, 容器会自动的调用该方法
		System.out.println("当ServletRequest(request)被销毁的时候,容器会自动的调用该方法");
	}

	/**
	 * 在浏览器中随便输入一个url
	 *   如:
	 *      http://localhost:8080/servlet_demo/index.jsp
	 * 在控制台中可以看到
	 *     当HttpSession被创建的时候,容器会自动的调用该方法
	 * 5秒钟后在控制台中可以看到
	 *     当HttpSession被销毁的时候,容器会自动的调用该方法
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		// 当HttpSession被创建的时候,容器会自动的调用该方法
		HttpSession session = event.getSession();
		
		/**
		 * 设置session的超时时间  单位:秒
		 * 当到达指定的时间,seesion并不是立即销毁
		 * 而是设置为不可用(invalidate)
		 * 在合适的时间 真正的销毁session
		 * 但是在invalidate到销毁这段时间内如果再次发送请求
		 * 容器会重新创建新的session
		 */
		// 5秒
		session.setMaxInactiveInterval(5);
		System.out.println("当HttpSession被创建的时候,容器会自动的调用该方法");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) 
	{
		// 当HttpSession被销毁的时候,容器会自动的调用该方法
		System.out.println("当HttpSession被销毁的时候,容器会自动的调用该方法");
	}

	/**
	 * 启动服务会出现
	 *    当ServletContext(application)被创建的时候,容器会自动的调用该方法
	 * 在Servers中Stop Server
	 *    当ServletContext(application)被销毁的时候,容器会自动的调用该方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		// 当ServletContext(application)被创建的时候,容器会自动的调用该方法
		System.out.println("当ServletContext(application)被创建的时候,容器会自动的调用该方法");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// 当ServletContext(application)被销毁的时候,容器会自动的调用该方法
		System.out.println("当ServletContext(application)被销毁的时候,容器会自动的调用该方法");
	}

}
