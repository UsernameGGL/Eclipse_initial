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
	<form action="reg.servlet" method="post">
		登录名：<input type="text" name="name"  /></br>
		密码：<input type="password" name="pwd" /></br>
		确认密码：<input type="password" name="pwd1" /></br>
		年龄：<input type="number" name="age" /></br>
		注册日期：<input type="date" name="date" /></br>
		<input type="submit" value="注册">
	</form>
</body>
</html>