package day09;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 文件上传
 * http://127.0.0.1:8080/servlet_demo/day09/upload.jsp
 * 
 * @WebServlet(urlPatterns="/upload2")  其中urlPatterns是必选属性
 * @WebServlet(value="/upload2")        其中value是必选属性
 */
@WebServlet("/servlet/UploadServlet")
@MultipartConfig
public class UploadServlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/**
		 * 文件上传方法
		 */
		// 说明输入的请求信息采用UTF-8编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// Servlet3.0中新引入的方法，用来处理multipart/form-data类型编码的表单
		// 这里需要和表单的input标签中type是file标签中name值相同
		Part part = request.getPart("pic");
		
		// 获取HTTP头信息headerInfo=(form-data; name="file" filename="文件名")
		String headerInfo = part.getHeader("content-disposition");
		// 从HTTP头信息中获取文件名fileName=(文件名)
		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		fileName = uuid+suffix;
		// 获得存储上传文件的文件夹路径
		String fileSavingFolder = this.getServletContext().getRealPath("/upload");
		
		// 获得存储上传文件的完整路径(文件夹路径+文件名)
		// 文件夹位置固定,文件夹采用与上传文件的原始名字相同
		String fileSavingPath = fileSavingFolder + File.separator + fileName;
		
		// 如果存储上传文件的文件夹不存在,则创建文件夹
		File f = new File(fileSavingFolder + File.separator);
		if (!f.exists())
		{
			f.mkdirs();
		}
		
		// 将上传的文件内容写入服务器文件中
		part.write(fileSavingPath);
		
		// 输出上传成功信息
		out.println("文件上传成功！");

	}
}
