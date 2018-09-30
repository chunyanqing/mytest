<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户端cookie的设置和获取</title>
  	
  	<script type="text/javascript" src="jquery.js"></script>
  	<script type="text/javascript" src="jquery.cookie.js"></script>
  	<script type="text/javascript">
  	
  		function getCookie()
  		{
  			var key = $("#key").val();
  			var cookieVal = $.cookie(key);
  			alert(cookieVal);
  		}
  		
  		function setCookie()
  		{
			var key = $("#key").val();
			var value = $("#val").val();
  			$.cookie(key,value);
  		}
  	
  	</script>
  </head>
  
  <body>
  		<input id="key"/>
  		<input id="val">
  		
  		<button onclick="getCookie()">getCookie</button>
  		<button onclick="setCookie()">setCookie</button>
  </body>
</html>
