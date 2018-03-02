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
	<h1>RoleEdit</h1>
	<!-- 必须是post请求！ -->
	<form action=" role_edit.action" method="post">
	<table border="1" style="width: 500px;">
		<tbody>
		<tr>
				<td>角色编号</td>
				<td><input name="roleid" value="${role.roleid }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>角色名稱</td>
				<td><input name="nm" value="${role.nm }" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<input type="submit" value="保存" />
			</tr>
		</tfoot>
	</table>
	</form>

</body>
</html>