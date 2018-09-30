<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'second.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		span{
			display: inline-block;
			width: 70px;
		}
		div{
			margin-top: 10px;
		}
	</style>
  </head>
  
  <body>
  	

    <!-- 
  			1. 浏览器显示h1标签的HelloWorld
  				HelloWorld0
  				HelloWorld1
  				HelloWorld2
  				HelloWorld3
  				HelloWorld4
  				......
  				HelloWorld9999
  				
  			2. 浏览器显示  99乘法表 双重for循环
  	-->
  		 
  	<%
  	    for (int i = 0; i < 4; i++)
  	    {
  	      
  	%>  
  	        <h1>HelloWorld<%=i %></h1>
  	<%   
  	   
  	    }
  	%>	
  	 
  		
  	<hr/>
  	
  	
  	
  	<%
  	    for(int i = 1; i < 9; i++)
  	    {
  	%>
  	         <div>
  		
  	<%
  	         for(int j = 1; j <= i; j++)
  	         {
  	%>
  	              <span><%=i %>*<%=j %>=<%=i*j %></span>
  	              
  	<%
  	         }
  	%>
  	         </div>
  	
  	<%
  	    }
  	%>
  	
  	
  	<hr/>
  	<%= request.getContextPath() %>
  </body>
</html>
