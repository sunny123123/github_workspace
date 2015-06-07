<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.sunny.entity.UserInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--<jsp:useBean id="user" scope="request" class="com.sunny.entity.UserInfo"></jsp:useBean>
--%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <table><%--
  <jsp:getProperty propert`y="userId" name="user"></jsp:getProperty>
  --%><c:set value="${requestScope.USER1}" var="user"></c:set>
  ${user.userName }
  <br>
    <c:forEach items="${requestScope.USERS}" var="user">
    	<tr>
    		<td>${user[0]}</td>
    		<td>${user[1]}</td>
    		<td>${user[2]}</td>
    	</tr>
    </c:forEach>
   </table>
  </body>
</html>
