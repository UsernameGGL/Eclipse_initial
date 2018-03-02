<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>变更记录表</title>

<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<!-- HTML HERE -->
	
	<table class="table table-striped table-hover">
	
		<caption>变更记录表</caption>
		
		<thead>
			<tr>
				<th>编号</th> 
				<th>员工姓名</th> 
				<th>变更操作</th>
				<th>原来部门/岗位</th>
				<th>现在部门/岗位</th> 
				<th>原薪金</th>
				<th>现薪金</th>
				<th>日期</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list }">
				<tr><td colspan="8">查询为空</td></tr>
			</c:if>
			<c:if test="${not empty list }">
				<c:forEach items="${list}" var="b">
					<tr>
						<td>${b.rid}</td>
						<td>${b.cnm}</td>
						<td>${b.cop}</td>
						<td>${b.cold}</td>
						<td>${b.cnew}</td>
						<td>${b.cosal}</td>
						<td>${b.cnsal}</td>
						<td>${b.cdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>

	
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
</html>	
