package day07;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器
 * 
 * 应用场景： 统计网站在线人数
 *    http://localhost:8080/servlet_demo/day07/login.jsp
 *    http://localhost:8080/servlet_demo/day07/logout.jsp
 * 
 *
 */
public class MySessionListener implements HttpSessionListener
{
	/**
	 * 上线
	 */
	public void sessionCreated(HttpSessionEvent evt) 
	{
        System.out.println("session被创建");
        countPerson(evt.getSession().getServletContext(),true);
	}

	/**
	 * 下线
	 */
	public void sessionDestroyed(HttpSessionEvent evt) {
		 System.out.println("session被销毁");
		 countPerson(evt.getSession().getServletContext(),false);
	}

	/**
	 * 变更在线人数
	 * @param sc
	 * @param isAdd
	 */
	public void countPerson(ServletContext sc, boolean isAdd)
	{
		// ServletContext的对象永远只有一个, 可以用来当锁, 为了防止多线程并发问题加锁
		synchronized(sc)
		{
			// 获得当前的在线人数
			Integer count = (Integer)sc.getAttribute("count");
			if (isAdd)
			{
				// ++count先++再赋值
				sc.setAttribute("count", ++count);
			}else{
				sc.setAttribute("count", --count);
			}
		}
	}
}
