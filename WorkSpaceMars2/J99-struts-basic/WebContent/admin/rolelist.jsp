<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>后台管理首页</title>
</head>
<body>
	<h1>RoleList</h1>
	<table>
		<thead>
			<th>编号</th>
			<th>名称</th>
			<th>操作</th>
		</thead>
		<tbody>
		<c:if test="${empty requestScope.lrs }">
			<tr>
				<td colspan="3">没有角色数据</td>
			</tr>
		</c:if>
		<c:if test="${not empty lrs }">
			<c:forEach items="${lrs }" var="r">
				<tr>
					<td>${r.roleid }</td>
					<td>${r.nm }</td>
					<td><a href="roleedit.jsp">编辑</a><a>删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
		</tbody>
		<tfoot>
			<a href="roleadd.jsp">添加</a>
		</tfoot>
	</table>
</body>
</html>