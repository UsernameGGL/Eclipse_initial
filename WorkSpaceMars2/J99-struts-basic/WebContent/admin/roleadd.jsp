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
	<h1>RoleAdd</h1>
	<!-- 必须是post请求！ -->
	<form action=" role_add.action" method="post">
	<table border="1" style="width: 500px;">
		<tbody>
			<tr>
				<th>名称</th>
				<td><input name="nm" value="测试" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<input type="submit" value="添加" />
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>