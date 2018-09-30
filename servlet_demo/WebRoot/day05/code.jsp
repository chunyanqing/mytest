<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
	
	<script type="text/javascript">
		function changeImage()
		{
	        // 每访问一次
            // http://localhost:8080/servlet_demo/show.code 验证码就会改变
		    // 会有问题:因为请求一样  在请求中加id
		    // document.getElementById("image").src = "${pageContext.request.contextPath}/show.code"; 
		    // $("#image").prop("src","${pageContext.request.contextPath}/show.code");
		    // new Date().getTime() 保证id的值不唯一
			$("#image").prop("src","${pageContext.request.contextPath}/show.code?id=" + new Date().getTime());
		}
	</script>
  </head>
  
  <body>
  	<h1>验证码校验</h1>
    <hr/>
    <form action="${pageContext.request.contextPath}/check.code" method="post">
    	用户名:<input type="text" name="username"/><br/>
    	密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"/><br/>
    	
    	<!-- javascript:void(0)  仅仅表示一个死链接  -->
    	<a href="javaScript:;" onclick="changeImage()">
    		<img id="image" alt="图片加载失败" src="${pageContext.request.contextPath}/show.code" ><br/>
    	</a>
    	验证码:<input type="text" name="code" />
    	<input type="submit" value="登录">
    </form>
    
  </body>
</html>
