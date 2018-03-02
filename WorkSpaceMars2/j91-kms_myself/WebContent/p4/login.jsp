<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="8kb" 
	pageEncoding="UTF-8" %>
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
	<form action = "login_2.servlet" method = "post">
		PNM<input type = text name = "pnm" value = "sa" /><br>
		PWD<input type = text name = "pwd" value = "sa" /><br>
		REM<input type = "checkbox" name = "rme" value = "1" />记住我2周<br>
		验证码：<input type = "text" name = "sid" /><img alt = "没有验证码，无法继续" 
		src = "sid.servlet" id = "sid" ><a href="javascript:reloadimg()">看不清</a><br>
		<input type = "submit" value = "登陆" /><br>
	</form>
</body>
</html>
<script>
	function reloadimg(){
		var img = document.getElementById("sid");
		img.src = "sid.servlet?abc="+Math.random();
		//alert("asdfg");
	}
</script>