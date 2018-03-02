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
<title>员工信息列表</title>

<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
	<!-- HTML HERE -->
	
	<table class="table table-striped table-hover">
	
		<caption>员工信息列表</caption>
		
		<thead>
			<tr>
				<th>员工编号</th>
				<th>姓名</th> 
				<th>性别</th>
				<th>民族</th>
				<th>身份证号</th> 
				<th>联系电话</th>
				<th>学历</th>
				<th>住址</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty lrs }">
				<tr><td colspan="8">查询为空</td></tr>
			</c:if>
			<c:if test="${not empty lrs }">
				<c:forEach items="${lrs}" var="b">
					<tr>
						<td>${b.wid}</td>
						<td>${b.wnm}</td>
						<td>${b.wsex}</td>
						<td>${b.wna}</td>
						<td>${b.wiid}</td>
						<td>${b.wtel}</td>
						<td>${b.wedu}</td>
						<td>${b.wloc}</td>
						<td>
							<a href="work/worker_update.action?wid=${b.wid}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
    
</head>
<body>

	
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	
