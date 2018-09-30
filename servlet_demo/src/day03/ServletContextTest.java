package day03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取工程中src文件夹下的/test.properties文件 
 * 读取项目更目录下的/db.properties文件
 */
public class ServletContextTest extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
			throws ServletException, IOException 
	{

	}

	@Override
	public void init(ServletConfig config) throws ServletException 
	{

		// 从ServletConfig中获取ServletContext对象
		ServletContext sc = config.getServletContext();

		// 方法1(用的多,使用类加载器的方式来读取classpath下的资源文件;
		// 这种方式不依赖于Servlet,任何类都可以获取classpath下的文件,
		// 不需要自己指定/WEB-INF/classes,直接写文件名就可以了)
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("test.properties");

		// 方法2 用的不多(利用ServletContext获取)
		// db.properties在webRoot目录下
		// 当资源文件/db.properties放在src路径下,用此方法不可行,应该用类加载器读取
		// InputStream in = sc.getResourceAsStream("/db.properties");

		Properties prop = new Properties();
		try 
		{
			if (in != null) 
			{
				prop.load(in);

				// 对应的是test.properties文件中的key
				System.out.println(prop.get("username"));
				System.out.println(prop.get("password"));
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try 
			{
				if (in != null) 
				{
					in.close();
				}
				in = null;
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
