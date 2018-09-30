<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" 
	                     + request.getServerName() + ":" 
	                     + request.getServerPort() + path + "/";
%>

<!DOCTYPEHTMLPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<!--
		        表达式会在"真身"中输出  out.println(basePath) 
	                    只能出现常量,变量以及返回值的方法调用,不能出现分号
	                    即在out.println()的合法参数都可以
		-->
		<base href="<%=basePath%>">
		
		<title>EL表达式演示</title>
	</head>
	
	<body>
		<h1>EL表达式运算</h1>
		<hr>
		
		2+3=${2+3}
		<br>
		
		2+3=\${2+3}
		<br>
		
		2+3=/${2+3}
		<br>
		
		<label>常量输出:</label> ${10}
		<br>
		
		<label>四则运算:</label> ${10+2}, ${10-2}, ${10*2}, ${10/2}, ${10.2/2}
		<br>
		
		<label>等于:</label> ${10 == 10}, ${10 eq 10}, ${ "liyan" == "liyan" }
		<br>
		
		<label>不等于:</label> ${10 != 3}
		<br>
		
		<label>取余数:</label> ${10 mod 3}, ${10 % 3}
		<br>
		
		<label>三目运算符:</label>${1 > 7 ? "great" : "less"}
		<br>
		
		<label>小于:</label> ${3 < 4}, ${3 lt 4}
		<br>
		
		<label>大于:</label> ${8 > 4}, ${8 gt 4}
		<br>
		
		<label>小于等于:</label> ${3 <= 4}, ${3 le 4}
		<br>
		
		<label>大于等于:</label> ${8 >= 4}, ${8 ge 4}
		<br>
		
		<label>逻辑与:</label> ${true && true}, ${true and true}
		<br>
		
		<label>逻辑或:</label> ${true || false}, ${true or false} 
		<br>
		
		<label>逻辑非:</label> ${!true}, ${not true}
		<br>
		
		<label>判空:</label> ${empty ""}
		<br>
		
		<label>非判空断:</label> ${empty not ""}
		
		<hr/>
		<h1>el表达式可以用于获取作用域对象中的值</h1>
		<h2>${requestScope.req}</h2>
		<h2>${sessionScope.sess}</h2>
		<h2>${applicationScope.app}</h2>
		
		<h1>el表达式可以用于获取作用域对象中的值</h1>
		<h2>${req}</h2>
		<h2>${sess}</h2>
		<h2>${app}</h2>
		
		<hr/>
		<h2>
		    <!-- 获取的是request中key为req的值 -->
  			${req}
  		</h2>
  
  		<h2>
  		    <!-- 获取的是session中key为req的值 -->
  			${sessionScope.req}
  		</h2>
  		
  		<hr/>
  		<h2>
  			<%=request.getAttribute("someValue") %>
  			---${someValue }---
  		</h2>
  		
  		<h1>获取对象</h1>
  		<h2>${user }  </h2>
  		<h2>${user.id }</h2>
  		<h2>${user.name }</h2>
  		<h2>
  			user.name 并不是访问user对象的name属性,
  			而是在访问user.getName()方法
  		</h2>
  		
  		<%--
  			Attribute 是属性
  			Property  是属性的get/set
  		 --%>
  		<h2> Property 'someProp' not found on type day08.User</h2>
  		<h2>${user.someProp }</h2>
  		<h2>${user["someProp"] }</h2>
  		
  		<h2>
  			${userList} == requset.getAttribute("userList")
  		</h2>
  		
  		<h2>yyyyyy
  		    ${userList}
  			${userList[0].age}
  			${userList[1].age}
  		</h2>
  		
  		<h2>
  		    <!-- http://localhost:8080/servlet_demo/servlet/ELServlet?id=1 -->
  			id: ${param.id }
  		</h2>
  		
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
	</body>
</html>