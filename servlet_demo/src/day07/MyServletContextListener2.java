package day07;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 统计网站的在线人数
 * 
 */
public class MyServletContextListener2 implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent sce)
	{
        ServletContext sc =  sce.getServletContext();
        sc.setAttribute("count", 0);
	}

	public void contextDestroyed(ServletContextEvent sce)
	{

	}
}