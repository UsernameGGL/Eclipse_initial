<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诚信注册</title>
</head>
<body>
	<form action="reg.servlet" method="get">
	<table>
		<thead>
			<tr>
				<th>内容</th>
				<th>数据</th>
			</tr>
		</thead>
		<tbody>
			<!-- 必须有name属性值，form表单只收集那些填写了name属性值的信息 -->
			<tr><td>登录名<input name="pnm" type="text" /></td></tr>
			<tr><td><input type="submit" /></td></tr>
		</tbody>
	</table>
	</form>
</body>
</html>