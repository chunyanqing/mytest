<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/myTag" prefix="myTag" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<%
  		request.setAttribute("info", "Hello World");
  		request.setAttribute("num", 10);
  	 %>
    <myTag:msg num="${num }" info="${info }"/>
  </body>
</html>
