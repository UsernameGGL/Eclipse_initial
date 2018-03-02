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
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- HTML HERE -->
	<table class="table table-striped">
		<caption>角色信息列表</caption>
		<thead>
			<th>编号</th>
			<th>名称</th>
			<th>操作</th>
		</thead>
		<tbody>
			<c:if test="${ empty  requestScope.lrs}">
				<tr>
					<td colspan="3">没有角色数据</td>
				</tr>
			</c:if>
			<c:if test="${ not  empty  requestScope.lrs}">
				<c:forEach items="${  requestScope.lrs }" var="r">
					<tr>
						<td>${r.roleid }</td>
						<td>${r.nm }</td>
						<td><a. href="role_findone?roleid=${r.roleid }">编辑</a.>
							<a.>删除</a.></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<a href=" roleadd.jsp">添加</a>
		</tfoot>
	</table>


	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->