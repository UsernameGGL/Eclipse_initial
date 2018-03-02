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
<html lang="zh-CN"font-family="Comic Sans MS ">
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
</head>
<style>

ul{
	/*background-color:#FFC1C1;*/
	filter:alpha(opacity=50);
	/*background: #FFC1C1;*/
}
li {
    border: solid 2px white;
    border-bottom-width: 0px
}
</style>

	<!-- HTML HERE -->
<body background="F:\学习资料\大二下\小学期\工程\成果\myself\legend\legend\img\prettyPhoto\default\sprite_y.png" style="background-size:100%">
<ul class="nav nav-pills nav-stacked"   >
  <li ><a href="companyIntroduction.jsp" target="lower_right">公司简介</a></li>
  <li><a href="deptIntroduction.jsp" target="lower_right">部门简介</a></li>
  <li><a href="jobIntroduction.jsp" target="lower_right">岗位简介</a></li>
  <li style="border-bottom-width: 2px">
  	<a href="jobApply.jsp" target="lower_right">求职申请</a></li>
</ul>
</body >

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->