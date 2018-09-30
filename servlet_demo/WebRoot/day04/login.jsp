<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录</title>
	</head>
	<body>
	   <!-- 注意:这里写form标签中的action属性的值:一定要写绝对路径 -->
	   <!-- 注意:form表单的method提交方式一定要是post -->
	   <form action="<%=request.getContextPath() %>/servlet/login" method="post">
	       <!-- 
	                            这里的"userName"值一定要和LoginServlet中的
	         String userName = request.getParameter("userName")
	                           对应
	       -->
	       <input name="userName"/>
	       <input type="submit">
	   </form>
	    
	</body>
</html>