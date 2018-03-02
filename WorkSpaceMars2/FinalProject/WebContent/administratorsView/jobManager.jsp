<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
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
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>公司主页</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-color:#F0F8FF">
	<!-- HTML HERE -->
	<!-- HTML HERE -->
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#AddNewJob" data-toggle="tab">添加新岗位</a></li>
    <li><a href="#DeleteJob" data-toggle="tab">删除已有岗位</a></li>
    <li><a href="#UpdateJob" data-toggle="tab">修改已有岗位</a></li>
    <li><a href="#QueryJobInform" data-toggle="tab">查询岗位信息</a></li>
    <li><a href="#QueryJobEmpInform" data-toggle="tab">查询岗位所属员工信息</a></li>
</ul>

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->