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
<title>图书列表</title>
</head>
<body>
	<table>
		<c:forEach items="${cbs }" var="b">
			<tr>
				<td>${b.isbn }</td>
				<td>${b.title }</td>
				<td>${b.price }</td>
				<td>${b.pubdate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>