package day05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 生成验证码Servlet
 * http://localhost:8080/servlet_demo/day05/code.jsp
 * 
 * 每访问一次
 * http://localhost:8080/servlet_demo/show.code
 * 验证码就会改变
 */
public class CodeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) 
		          throws ServletException, IOException 
    {
		String path = request.getServletPath();
		
		// /check.code 或者 /show.code
		System.out.println("servletpath:" + path);

		if ("/show.code".equals(path)) 
		{
			show(request, response);
		}
		
		if ("/check.code".equals(path)) 
		{
			show(request, response);
		}
	}
	
	
	protected void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// 获取请求中的参数验证码
		String code = request.getParameter("code");
		
		// 获取session中验证码的值
		String sessionCode = (String) request.getSession().getAttribute("code");
		if (code.equals(sessionCode))
		{
			System.out.println("校验成功");
		}else
		{
			System.out.println("校验失败");
		}
	}

	public void show(HttpServletRequest request, 
		HttpServletResponse response) throws IOException
	{

		// 第1步:在内存中创建画板
		// BufferedImage(int width, int height, int imageType)
		// 第一个参数是宽度
		// 第二个参数是高度
		// 第三个参数是 表示一个具有 8 位 RGB 颜色分量的图像
		BufferedImage image = new BufferedImage(60, 30,
				BufferedImage.TYPE_INT_RGB);

		// 第2步:创建画笔
		Graphics graphics = image.getGraphics();

		// 填充矩形区域
		// abstract void fillRect(int x, int y, int width, int height)
		// 参数：
		// x - 要填充矩形的 x 坐标
		// y - 要填充矩形的 y 坐标
		// width - 要填充矩形的宽度
		// height - 要填充矩形的高度
		graphics.fillRect(0, 0, 60, 60);

		Random random = new Random();

		
		// 设置画笔颜色
		// Color(int r, int g, int b) 
		// 验证码画笔颜色不写死,要随机
		// graphics.setColor(new Color(255, 255, 255));
		graphics.setColor(new Color(
				                    random.nextInt(256), 
				                    random.nextInt(256),
				                    random.nextInt(256)
				                   ));
		
		// 设置字体的样式
		// Font(String name, int style, int size) 
		// 根据指定名称、样式和 字体大小, 创建一个新 Font
		graphics.setFont( new Font("宋体",Font.BOLD + Font.ITALIC, 18) );
		
		
		// 生成随机内容(关键)
		String str = "0123456789qwertyuiopasdfghjklzxcvbnm";
		StringBuffer code = new StringBuffer();
		
		// 随机生成4位的验证码
		for (int i = 0; i < 4; i++)
		{
			code.append(str.charAt(random.nextInt(str.length())));
		}
		
		// 将生成的字符串写入到画板中
		// drawString(String str, int x, int y) 
		// 参数：
		// str - 要绘制的 string
		// x - x 坐标
		// y - y 坐标 
		graphics.drawString(code.toString(), 8, 20);
		
		
		// 将生成字符串数据同步的放入到session中,方便后面的校验
		request.getSession().setAttribute("code", code.toString());
		System.out.println("验证码:" + code.toString());
		
		OutputStream out = response.getOutputStream();
		
		// 图片压缩
		JPEGImageEncoder encode = JPEGCodec.createJPEGEncoder(out);
		encode.encode(image);
	}
	
	// 如何生成验证码测试
	public static void main(String[] args)
	{
		
		/**
		 * Random
		 * 随机生成1-9之间的随机整数
		 *    random.nextInt(9)+1
		 *    
		 * 随机生成3-7之间的随机整数
		 * 
		 *    random.nextInt(5)+3
		 * 
		 * 
		 * Math.random()
		 * 随机生成1-9之间的随机整数
		 *    (int) Math.random() * 9 + 1
		 * 
		 * 随机生成3-7之间的随机整数
		 *    Math.random()*5 + 3
		 * 
		 * 随机生成m,n的随机数
		 * Math.random()*(n - m + 1) + m
		 * 
		 * a-c
		 * Math.random()*('c'-'a' + 1) + 'a'
		 * 
		 * 0-9A-Za-z
		 * String s = "123456789"	
		 */
		// int i = new Random().nextInt()*'A';
		// int i = (int)(Math.random() * ('c'-'a' + 1) + 'a');
		// System.out.println((char)i);
		
	    /* String str = "0123456789qwertyuiopasdfghjklzxcvbnm";
		char chr = str.charAt(new Random().nextInt(str.length()));
		System.out.println(chr);*/
		
		
		// 只要是36位的字符串就可以了
		// String str = "0123456789abcdefghijklopqnmrstuvwxyz";
		String str = "0123456789wwertyuiopasdfghjklzxcvbnm";
		StringBuffer code = new StringBuffer();
		for(int i = 0; i < 4; i++)
		{
			code.append(str.charAt(new Random().nextInt(str.length())));
		}
		
		System.out.println(code.toString());
		
	}
	

}
