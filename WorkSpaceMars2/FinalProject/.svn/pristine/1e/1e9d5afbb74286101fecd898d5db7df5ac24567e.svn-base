<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	//basePath : the  ROOT of this APP
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- do NOT move Pre 3 metas tag -->
<title>薪资管理</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js 

"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js 

"></script>
    <![endif]-->

    
</head>
<body>
	<!-- HTML HERE -->
	
	<table class="table table-striped">
	
		<caption>员工薪资列表</caption>
		
		<thead>
			<tr>
				<th>员工编号</th>
				<th>姓名</th> 
				<th>年龄</th>
				<th>岗位</th>
				<th>部门</th> 
				<th>薪金</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty salList }">
				<tr><td colspan="3">无信息</td></tr>
			</c:if>
			<c:if test="${not empty salList }">
				<c:forEach items="${salList}" var="b">
					<tr>
						<td>${b.jid}</td>
						<td>${b.jnm}</td>
						<td>${b.jage}</td>
						<td>${b.jposi}</td>
						<td>${b.jdept}</td>
						<td>${b.jsal}</td>
						<td><%-- ?wid=${b.wid}&wnm=${b.wnm}&wsex=${b.wsex}&wna=${b.wna}&wiid=${b.wiid}&wtel=${b.wtel}&wedu=${b.wtel}&wloc=${b.wloc} --%>
						<a href="work/worker_salupdate.action?wid=${b.jid}">修改</a>
						</td><%-- ?wid=${b.wid --%>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</head>
<body>

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	
