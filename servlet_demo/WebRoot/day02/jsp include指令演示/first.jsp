<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP include指令演示</title>
	</head>
	<body>
	    <%
  			int j = 1;
  	    %>
	    
	    <h1>这是包含页面first.jsp</h1>
	    <hr/>
	    
	    <!-- http://localhost:8080/servlet_demo/day02/first.jsp -->
	    <!-- file属性: 指定要包含的页面 -->
	    <%@ include file="second.jsp" %>
	</body>
</html>