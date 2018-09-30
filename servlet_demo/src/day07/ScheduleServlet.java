package day07;

import java.util.Date;

/**
 * ServletContext监听器
 * 服务器启动时监听任务就启动示例:
 * 
 * 1.任务调用
 * 2.Spring容器的初始化
 *
 */
public class ScheduleServlet implements Runnable 
{

	@Override
	public void run()
	{
		// 模拟扫描任务
		while(true)
		{
			System.out.println(new Date() + "扫描任务...");
			try
			{
				Thread.sleep(5000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
