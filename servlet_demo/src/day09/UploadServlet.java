package day09;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传
 * <servlet>
	    <servlet-name>UploadServlet</servlet-name>
	    <servlet-class>day09.UploadServlet</servlet-class>
    </servlet>

    <servlet-mapping>
	    <servlet-name>UploadServlet</servlet-name>
	    <url-pattern>/servlet/UploadServlet</url-pattern>
    </servlet-mapping>
 * 
 * http://127.0.0.1:8080/servlet_demo/day09/upload.jsp
 */
// 其中urlPatterns是必选属性
// @WebServlet(name="UploadServlet",urlPatterns="/servlet/UploadServlet")
// @WebServlet(value="/servlet/UploadServlet")
public class UploadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		upload(request, response);
	}

	
	/**
	 * 文件上传方法
	 * @throws IOException 
	 */
	public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		List<FileItem> itemList = null;
		
		// 解决request乱码问题方法(1) 设置request的编码方式
		request.setCharacterEncoding("UTF-8");
		
		// 防止页面回写出现乱码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		
		// (1)创建接收文件的工厂类   用于获取DiskFileItem对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		
		// (2)创建文件解析对象    获取解析工具
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		// 解决request乱码问题方法(2) 设置解析request的编码方式
		fileUpload.setHeaderEncoding("UTF-8");
		
		// 设置单个上传文件的最大值,以字节为单位
		// 单个要上传文的上限是100KB
		fileUpload.setFileSizeMax(1024 * 100);

		// 设置多个上传文件的总和的最大值,以字节为单位
		// 设置多个要上传文件的总和上限是100 * 3 KB
		fileUpload.setSizeMax(1024 * 100 * 3);
		
		
		try 
		{
			request.setCharacterEncoding("utf-8");
			
			// (3)解析request, 获取流中所有表单提交的内容, 
			//    获得表单中的每一个文件项(包含普通文本域)每个表单标签对应一个FileItem对象
			itemList = fileUpload.parseRequest(request);
			// System.out.println("itemList大小:" + itemList.size());
			
			if (itemList != null && itemList.size() != 0)
			{
				// 遍历每一个文本项
				for (FileItem item : itemList)
				{
					// 获取原始文件名
					String originalFileName = item.getName();
					System.out.println("原始文件名:" + originalFileName);
					
					// 获取文本域名称
					String fieldName = item.getFieldName();
					System.out.println("获取文本域名称:" + fieldName);
					
					
					// 获取文件大小
					Long fileSize = item.getSize();
					System.out.println("获取文件大小:" + fileSize);
					
					
					String value = item.getString();
					System.out.println("获取值:" + value);
					
					
					// (1)获取是否是普通文本, 如果是true是普通字段,如果是false是文件字段
					boolean  isFieldForm = item.isFormField();
					
					System.out.println("fieldName:" + fieldName + ",value:" + value);
					
					// 获取文本项的内容
					String fieldContent = item.getString();
					System.out.println("文本项的内容:" + fieldContent);
					
					// 如果采用commons-fileupload组件要控制普通文本项内容的乱码就只能手动转换编码
					fieldContent = new String(fieldContent.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println("转换编码后文本项的内容:" + fieldContent);
					
					
					// (2)如果是文件file类型  才可以上传
					if (!isFieldForm)
					{
						
						// 获取原始文件名的后缀
						String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
						
                        // 发布到tomcat中的项目的根目录下的upload目录
						// 指定要上传的路径(指的是项目部署目录,而不是项目中的目录)
						// 指定要上传的目录如果是隐私文件可以放在WEB-INF下来提高安全性
						// String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
						String uploadPath = getServletContext().getRealPath("/WEB-INF/upload");
						
						// 文件同名问题(文件重命名)
						
						// 生成UUID文件名,使文件名不会重复   实际工作中会根据具体的业务需要进行设置文件名
						String uuid = UUID.randomUUID().toString();
						// 创建文件对象
						File  file = new File(uploadPath, uuid + suffix);
						
						// 把文件写入硬盘   会有Exception异常
						item.write(file);
					}
				}
			}
			
			// 回写结果
			response.getWriter().println("文件上传成功");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}catch (FileUploadException e) 
		{
			e.printStackTrace();
		} catch (Exception e) 
		{
			e.printStackTrace();
			if (e instanceof FileSizeLimitExceededException)
			{
				response.getWriter().println("单个上传文件大小超出限制!");
			}
			
			if (e instanceof SizeLimitExceededException)
			{
				response.getWriter().println("多个上传文件大小的总和超出限制!");
			}
		}
	}
}
