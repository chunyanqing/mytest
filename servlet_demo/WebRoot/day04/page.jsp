<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	     <!-- 
	                        这里对应LoginServlet中的
	        request.setAttribute("name", userName);
	      -->
	     <%--  欢迎您: <%=request.getAttribute("name") %> --%>
                            欢迎您: <%=session.getAttribute("name") %>
	</body>
</html>