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
<title>listpersons</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${ls }" var="l">
			<tr>
				<td>${l.pid }</td>
				<td>${l.pnm }</td>
				<td>${l.pwd }</td>
				<td>${l.bdate }</td>
				<td>${l.rid }</td>
				<td>${l.mgid }</td>
				<td>${l.icon }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>