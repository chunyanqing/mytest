<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    // 声明一个字符串变量path 将当前项目的根目录复制给变量path
	String path = request.getContextPath();
	// 用来拼装当前网页的相对路径用的
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//   /servlet_demo
	System.out.println(" 获得当前的项目根目录路径: " + path);
	// http://localhost:8080/servlet_demo/
	System.out.println(basePath);
%>



<!DOCTYPEHTMLPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		
		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
			<link rel="stylesheet" type="text/css"href="styles.css">
		-->
	</head>
	
	<body>
		<form action="jspdemo01.jsp" method="post">
			row:<input type="text" name="row"/><br/> 
			col:<input type="text" name="col"><br/> 
			<input type="submit" value="print"/>
		</form>
		
		<hr>
		
		<%
			String row = request.getParameter("row");
			String col = request.getParameter("col");
	
			Integer rowInt = 1;
			Integer colInt = 1;
	
			if (row != null) 
			{
				rowInt = new Integer(row);
			}
	
			if (col != null) 
			{
				colInt = new Integer(col);
			}
		%>
		
		<table border = "1px;">
			<%
				for (int i = 1; i <= rowInt; i++)
	            {
			%>
			<tr>
				<%
					for (int j = 1; j <= colInt; j++) 
					{
				%>
				<td>
					<%
						out.print(i * j);
					%>
				</td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>