package day07;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContext监听器
 * 服务器启动时监听任务就启动示例:
 * 
 * 1.任务调用
 * 2.Spring容器的初始化
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener
{

	Thread t = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// 当ServletContext(application)被销毁的时候,容器会自动的调用该方法
		System.out.println("ServletContext 被销毁...");
		
		// 销毁线程
		t.stop();
	}

	/**
	 * ServeltContext 
	 *   被创建时调用(服务器启动时 ServletContext对象就被创建了)
	 * ServletContextEvent
	 *   事件源,可以获得到ServletContext对象
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		// 当ServletContext(application)被创建的时候,容器会自动的调用该方法
		System.out.println("ServletContext 被创建...");
		
		// 启动定时任务(单线程)
		t = new Thread(new ScheduleServlet());
		
		// 启动线程
		t.start();
	}

}
