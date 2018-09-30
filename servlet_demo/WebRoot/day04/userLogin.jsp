<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面(7天免登录)</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/day04/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/day04/jquery.cookie.js"></script>
    
    
    <script type="text/javascript">
    	$(function()
    	{
    	    //  当页面加载完成时,从cookie中获取key为username的pwd的两个cookie值
    		var name = $.cookie("username");
    		var pwd = $.cookie("pwd");
    		
    		// 如果这两个cookie值存在：
    		// 将这两个值放入到form表单对应的input中
    		if (name && pwd)
    		{
    		    // 注意这里不能这样写 error!!!!!!!!!!!
    		    // $("input[name=username]").val = name;
    			$("input[name=username]").val(name);
    			$("input[name=password]").val(pwd);
    			// 将form表单通过js代码提交
    			$("form").submit();
    		}
    	});
    
    </script>
  </head>
  
  <body>
  	<!-- 表单提交到servlet -->
  	<form action="${pageContext.request.contextPath }/userLogin" method="get">
  		
  		用户名:<input type="text" name="username" />  <br/>
  		密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password" /> <br/><br/>
		
		<input type="checkbox" name="remember" />7天免登陆
		
		<input type="submit" value="登录">  
		
		<span style="color:red">
			<%-- <%=request.getAttribute("errMsg") == null ? "" : request.getAttribute("errMsg") %> --%>
			${errMsg }
		</span>	
  	</form>	
  
  </body>
</html>
