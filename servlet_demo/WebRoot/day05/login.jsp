<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <h1>用户登录</h1>
    <hr/>
    
    <form action="${pageContext.request.contextPath }/servlet/ShowLoginServlet" method="post">
    	用户名:<input type="text" name="username"/><br/>
    	密&nbsp;&nbsp;码:<input type="password" name="pwd"/><br/>
    	<input type="submit" value="登陆">
    	<span style="color:red;">${loginMsg }
    	
   	    <%-- 	
   	    <%
   			String loginMsg = (String)request.getAttribute("loginMsg");
   			if (loginMsg!=null)
   			{
   				out.print(loginMsg);
   			}
   		 %> 
   		--%>
    	</span>
    </form>
    
  </body>
</html>
