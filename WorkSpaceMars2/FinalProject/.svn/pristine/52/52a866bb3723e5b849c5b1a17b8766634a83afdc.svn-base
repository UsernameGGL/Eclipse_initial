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
<title>WorkerEdit</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

</head>


<body style="background-color:#F0F8FF">
	<form action="work/worker_edit.action" method="post" >
	
	<table border="1" style=" height:450px; width:800px" align="center">
		<tbody>
		<tr><td>员工编号</td>
			<td><input name="wid" value="${worker.wid }"size="50" /></td></tr>
		<tr><td>姓名</td>
		    <td><input name="wnm" value="${worker.wnm }"size="50" /></td></tr>
		<tr><td>性别</td>
			<td><input name="wsex" value="${worker.wsex }"size="50" /></td></tr>
		<tr><td>民族</td>
			<td><input name="wna" value="${worker.wna }"size="50" /></td></tr>
		<tr><td>身份证号</td>
			<td><input name="wiid" value="${worker.wiid }" size="50"/></td></tr>
		<tr><td>联系电话</td>
			<td><input name="wtel" value="${worker.wtel }" size="50"/></td></tr>
		<tr><td>学历</td>
			<td><input name="wedu" value="${worker.wedu }" size="50"/></td></tr>
		<tr><td>住址</td>
			<td><input name="wloc" value="${worker.wloc }" size="50"/></td></tr>
		</tbody>	
	</table>
	<div align="center">
	<input type="submit" style="width:150px;height:25px;" value="保存" />
	</div>
	</form>
</head>
<body>

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	
