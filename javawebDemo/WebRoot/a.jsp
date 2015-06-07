<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <%
  out.print(request.getParameter("username"));
  %>
  ${param.username}
  ${username}
  </body>
</html>
