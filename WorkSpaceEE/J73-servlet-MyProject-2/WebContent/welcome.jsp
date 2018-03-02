<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<!-- 映射标签，很重要！ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.person==null }">
		<a href="log/login.jsp">登录</a>
		<a href="log/reg.jsp">注册</a>
	</c:if>
	
	<c:if test="${sessionScope.person!=null }">
		<a href="#">${sessionScope.person.name }</a>
		<a href="log/logout.servlet">退出</a>
	</c:if>
</body>
</html>