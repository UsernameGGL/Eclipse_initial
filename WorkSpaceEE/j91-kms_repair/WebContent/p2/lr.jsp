<%@page import="com.kms2.pojo.Role"%>
<%@page import="java.util.*"%>
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
<title>Insert title here</title>
</head>
<body>
	 
	<%
		
		//从request对象中读取List<Role>
		List<Role> lrs = null;
		Object o = request.getAttribute("lrs");
		if (o != null) {
			lrs = (List<Role>) o;
		}
	%>
	<table border="2">
		<tr>
			<th>角色编号</th>
			<th>角色名称</th>
		</tr>
		<%
			for (int i = 0; i < lrs.size(); i++) {
				Role r = lrs.get(i);//读取List集合元素
		%>
		<tr>
			<td><%=r.getRid()%></td>
			<td><%=r.getRnm()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>