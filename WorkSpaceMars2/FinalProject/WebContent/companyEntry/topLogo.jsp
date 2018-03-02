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
<title>公司主页</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<!-- js_ggl -->
<script type="text/javascript">
	function login(){
		window.parent.location="loginPage.jsp";
	}
</script>
</head>
<style>
body{
	background-size:cover;
	FONT-SIZE: 35pt;
	WIDTH: 100%; 
	COLOR: white; 
    LINE-HEIGHT: 100%;
    FONT-FAMILY: 华文行楷;
    text-align:center;
}
</style>
<body background="F:\学习资料\大二下\小学期\工程\成果\myself\legend\legend\img\top-bg.jpg" style="background-size:100%"  >
	欢迎进入公司
<div align="right"><a onclick="login()" style="cursor:pointer;">登陆</a></div>

	<!-- HTML HERE -->
</body>
	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->