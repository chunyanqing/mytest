<%@page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>JSP include动作/动态标签演示</title>
	</head>
	<body>
	    <!-- 
	        <jsp:include page="">
	                        在转码(jsp==>servlet),通过调用方法将另一个页面加载到当前页面中
		           共享request和response 
		           与RequestDispatchincude()方法的功能相同
		-->
		<jsp:include page="a.jsp?name=liyan"></jsp:include>
	</body>
</html>