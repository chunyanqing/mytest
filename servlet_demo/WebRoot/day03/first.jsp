<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP 脚本演示</title>
	</head>
	<body>
	     <h1>hello nice girl</h1>
	   
	     <%-- jsp语句--%>
	     <%
	         String str = "liyan";
	      %>
	      
	      <%-- jsp表达式 --%>
	      <%= "abc" %>
	      <%= str %>
	      <%= path.equals("abc") %>
	      <%= new Date() %>
	      
	      <%-- jsp声明 --%>
	      <%!
	          // private int i = 1;
	          // 报500错误  java.lang.ArithmeticException: / by zero
	          // private int i = 1 / 0;
	          int j = 2;
	       %>
	</body>
</html>