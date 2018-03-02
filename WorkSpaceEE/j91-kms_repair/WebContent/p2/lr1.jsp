<%@ page language="java" import = "javax.servlet.http.HttpServlet" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户角色</title>
</head>
<body>
	<table>
		<tr>
			<th>角色编号</th><th>角色名称</th>
		</tr>
		<c:if test="${ empty requestScope.lrs }">
			<tr> <td colspan="2">没有数据</td> </tr>
		</c:if>
		<c:if test="${not empty  requestScope.lrs }">
			<c:forEach items="${requestScope.lrs  }" var="r" >
				<tr>
					<td>${r.rid }</td>
					<td>${r.rnm }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>