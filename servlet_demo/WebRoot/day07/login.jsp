<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>登录</title>
	</head>
	
	<body>
	     <% 
	         request.getSession();
	     %>
	
	<h1>欢迎登录</h1>
	<a href="${pageContext.request.contextPath}/day07/logout.jsp">退出</a>
	<hr>
	<h1><font color="red">当前的在线人数${count}</font></h1>
	</body>
</html>