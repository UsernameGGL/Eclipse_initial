<%@page import="java.util.ArrayList"%>
<%@ page language="java" import = "com.kms2.pojo.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.person == null }">
		<a href = "p3_2/login.jsp">登陆</a>	<a href = "reg.jsp">注册</a>
	</c:if>
	<c:if test="${sessionScope.person != null }">	
	${sessionScope.person.nm}
		<a href = "p3_2/logout.servlet">退出</a>
	</c:if>
</body>
</html>