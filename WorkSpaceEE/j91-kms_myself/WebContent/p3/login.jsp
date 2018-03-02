<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "login.servlet" method = "post">
		pnm : <input name = "pnm" value = "sa" /><br>
		pwd : <input name = "pwd" value = "sa" /><br>
		记住我 : <input name = "rm" value = "1" checked type = "checkbox" /><br>
		<input type = "submit" value = "登陆" /><br>
		
	</form>
</body>
</html>