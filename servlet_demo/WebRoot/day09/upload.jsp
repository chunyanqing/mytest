<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文件上传</title>
</head>

<body>
		<!-- 上传文件:
	                                 表单要求:
	                 1. enctype="multipart/form-data"
	                 2. 表单中需要有file类型的input
	                 3. 表单的提交方式一定要是POST!!!
	
	           Servlet要求:   
	                 1. 不能使用request.getParameter("xxx");要使用request.getInputStream()
	                 2. 要依赖于其他jar包  commons-fileupload.jar(核心jar包)和commons-io(辅助包)     
	    -->
		<form action ="${pageContext.request.contextPath}/servlet/UploadServlet" method="post" enctype="multipart/form-data"> 
	                 用户名:<input type = "text" name="username" /> <br/>
			密&nbsp;&nbsp;&nbsp;码: <input type = "password" name="password" />  <br/>
			头&nbsp;&nbsp;&nbsp;像: <input type = "file" name="pic"/><br/>
			<input type = "submit" value="提交" name="upload"/>
		</form>
	</body>
</html>
