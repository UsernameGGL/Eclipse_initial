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
<title>实习资格审核</title>

<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<!-- HTML HERE -->
	
	<table class="table table-striped table-hover">
	
		<caption>实习资格审核</caption>
		
		<thead>
			<tr>
				<th>    </th> 
				<th>姓名</th> 
				<th>学历</th>
				<th>申请岗位</th>
				<th>性别</th> 
				<th>年龄</th>
				<th>民族</th>
				<th>身份证号</th>
				<th>联系电话</th>
				<th>住址</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty lrs }">
				<tr><td colspan="10">查询为空</td></tr>
			</c:if>
			<c:if test="${not empty lrs }">
				<c:forEach items="${lrs}" var="b">
					<tr>
						<td>${b.rid}</td>
						<td>${b.anm}</td>
						<td>${b.aedu}</td>
						<td>${b.apos}</td>
						<td>${b.asex}</td>
						<td>${b.aage}</td>
						<td>${b.ana}</td>
						<td>${b.aid}</td>
						<td>${b.atel}</td>
						<td>${b.aloc}</td>
						<td>
						<a href="probation/apply_accept.action?rid=${b.rid }">接受</a>
						<a href="probation/apply_del.action?rid=${b.rid }">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>

	
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	
