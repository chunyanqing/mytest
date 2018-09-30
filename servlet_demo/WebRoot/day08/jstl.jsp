<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="day08.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL核心库演示</title>
  </head>
  
  <body>
      <% 
        pageContext.setAttribute("userName","fuxiang");
        
        String[] strArray = {"liyan","fuxiang","fuchenxi"};
        pageContext.setAttribute("strArr",strArray);
        
        JSTLPerson p1 = new JSTLPerson();
        p1.setAge(32);
        p1.setUserName("李艳");
        JSTLPerson p2 = new JSTLPerson();
        p2.setAge(30);
        p2.setUserName("付翔");
        JSTLPerson p3 = new JSTLPerson();
        p3.setAge(4);
        p3.setUserName("付宸熙");

        List<JSTLPerson> JSTLPersonList = new ArrayList<JSTLPerson>();
        JSTLPersonList.add(p1);
        JSTLPersonList.add(p2);
        JSTLPersonList.add(p3);
        pageContext.setAttribute("pList",JSTLPersonList);
        
    %>
    <h1>JSTL核心库out</h1>
    <c:out value="${'liyan'}"></c:out><br/>
    <c:out value="${2}"></c:out><br/>
    <c:out value="${userName}"></c:out><br/>
    <c:out value="${name}" default="defaultValue"></c:out><br/>
    <c:out value="${'<font color=red>字体</font>'}" ></c:out><br/>
    <!-- 可以不讲 -->
    <c:out value="${'<font color=red>字体</font>'}" escapeXml="true"></c:out><br/>
    <c:out value="${'<font color=red>字体</font>'}" escapeXml="false"></c:out>
    
    <hr>
    <h1>JSTL核心库set</h1>
    <c:set var="userName1" value="liyan"></c:set>
    ${pageScope.userName1}<br/>
    
    <c:set var="userName1" value="fuchenxi" scope="session"></c:set>
    ${sessionScope.userName1}<br/>
    
    
    
    <hr>
    <h1>JSTL核心库if</h1>
    <c:set var="userName2" value="fuxiang"></c:set>
    <%-- test属性是一个boolean类型值或者表达式	--%>
    <c:if test="${not empty userName2}">
        <c:out value="${userName2}" />
    </c:if>
    
    <%
 		boolean b = true;
		request.setAttribute("b", b);  		
  	%>
	<%-- test属性是一个boolean类型值或者表达式  --%>
	<c:if test="${b }">
		<h1>你看得见我</h1>
	</c:if>  		
	
	<c:if test="${!b }">
		<h1>噢啦</h1>
	</c:if>
 		
	<c:if test="${1 < 5 }">
		abcd
	</c:if>

	<c:if test="${1 > 5 }">
		efgh
	</c:if>
    
    <hr>
    <h1>JSTL核心库choose</h1>
    <c:set var="scope" value="50"></c:set>
   	<%--  	
		1. <c:choose>标签   类似于Java中的 switch(xx) case 1 2
		2. 或者类似于  多重 if
	--%>
    <c:choose>
        <c:when test="${scope < 60}">
            <c:out value="${'不及格'}"/>
        </c:when>
        <c:when test="${scope >= 60 && scope <= 80}">
            <c:out value="${'及格'}"/>
        </c:when>
        <c:otherwise>
           <c:out value="${'优秀'}"/>
        </c:otherwise>
    </c:choose>
    
    <hr>
    <h1>JSTL核心库forEach</h1>
    <!-- 从1遍历到10 步长step默认为1,可不写-->
    <c:forEach begin="1" end="10" var="i">
        <c:out value="${i}"></c:out>
    </c:forEach>
    <br>
    
    <!-- 从1遍历到10 步长step为2-->
    <c:forEach begin="1" end="10" var="i" step="2">
        <c:out value="${i}"></c:out>
    </c:forEach>
    <br>
    
    <!-- 9*9正方形 -->
  	<c:forEach begin="1" end="9">
  		<c:forEach begin="1" end="9">
  			*
  		</c:forEach>
  		<br/>
  	</c:forEach>
    
    <!-- 循环
			items:待循环的值	
			i:每次循环的值
    -->
    <c:forEach items="5,4,3,2,1" var="i">
        <c:out value="${i}"></c:out><br>
    </c:forEach>
    <br>
    
    <!-- 遍历数组 -->
    <c:forEach items="${strArr}" var="str">
        <c:out value="${str}"></c:out>
    </c:forEach>
    <br>
    
    <!-- 遍历集合 整体输出-->
    <c:forEach items="${pList}" var="JSTLPerson">
        <c:out value="${JSTLPerson}"></c:out><br>
    </c:forEach>
    <br>
    
    <!-- 遍历集合 单个输出-->
    <c:forEach items="${pList}" var="JSTLPerson">
        <c:out value="${JSTLPerson.userName}"></c:out>
        <c:out value="${JSTLPerson.age}"></c:out><br>
    </c:forEach>
    <br>
    
    <% 
        Map<String, String> map = new HashMap<String, String>();
        map.put("name","liyan");
        map.put("age","32");
        map.put("job","teaching");
        pageContext.setAttribute("mp",map);
    %>
    <!-- 遍历Map-->
    <c:forEach items="${mp}" var="p">
         <c:out value="${p.key}"></c:out>:<c:out value="${p.value}"></c:out><br>
    </c:forEach>
    <br/>
    
    <!-- varStatus 属性   可以不讲-->
    <c:forEach items="${pList}" var="JSTLPerson" varStatus="status">
        <c:out value="${status.current}"></c:out>
        <c:out value="${status.index}"></c:out>
        <c:out value="${status.count}"></c:out>
        
        
        <c:if test="${status.first}">
           <c:out value="${'第一行:'}"></c:out>
        </c:if>
        <c:if test="${status.last}">
           <c:out value="${'最后一行:'}"></c:out>
        </c:if>
       <c:out value="${JSTLPerson}"></c:out><br/>
    </c:forEach>
  </body>
</html>
