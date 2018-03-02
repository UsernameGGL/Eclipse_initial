<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" import = "com.kms2.pojo.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<Role> lrs = new ArrayList<Role>();
	//模拟查询结果是空的情况
	
	Role r=new Role();
	r.setRid(1);
	r.setRnm("Admin");
	//填充数据
	lrs.add(r);
	lrs.add(r);
	lrs.add(r);
	lrs.add(r);
	request.setAttribute("lrs", lrs);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <c:if test="${1==1 }">
		<h2>asfsggds</h2>
	</c:if> -->
	<table border = "2">
		<thead>
			<tr>
				<th>角色编号</th>
				<th>角色名称</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty requestScope.lrs }">
				<tr><td colspan="2">查询为空</td></tr>
			</c:if>
			<c:if test="${not empty requestScope.lrs }">
				<c:forEach items="${requestScope.lrs }" var = "role"><!-- role放pageContext里 -->
					<tr><td>${role.rid }</td><td>${role.rnm }</td></tr>
				</c:forEach>
				for(Role r:lrs){
					out.write(r.getRid())
				}
			</c:if>
		</tbody>
	</table>
</body>
</html>