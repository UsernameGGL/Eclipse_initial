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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建角色对象</title>
</head>
<body>
	<form action="addrole.action" method="post">
		角色ID  ：<input type="text" name="rid"/></br>
		角色名称：<input type="text" name="rnm"/></br>
		<input type="submit"value="添加" />
	</form>
</body>
</html>