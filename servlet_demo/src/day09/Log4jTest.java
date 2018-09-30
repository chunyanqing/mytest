package day09;

import org.apache.log4j.Logger;

public class Log4jTest 
{
	// 属性  首字符小写  第二个字母大写 生成的set/get方法 首字符不会变大写
    private String uRL;
    
    public static void main(String[] args)
    {
    	Logger logger = Logger.getLogger(Log4jTest.class);
    	
    	logger.debug("日志信息.....debug");
		logger.info("日志信息.....info");
		logger.warn("日志信息.....warn");
		logger.error("日志信息.....error");
		logger.fatal("日志信息.....fatal");
		
/*		try 
		{
			System.out.println(1/0);
			
		} catch (Exception e) 
		{
//			e.printStackTrace();
			logger.error("出错了",e);
		}*/
		
		
//		new Thread()
//		{
//			public void run() 
//	        {
//				logger.error("inside a  thread.....");
//			};
//		}.start();
    }

	public String getuRL() 
	{
		return uRL;
	}

	public void setuRL(String uRL) 
	{
		this.uRL = uRL;
	}
}
