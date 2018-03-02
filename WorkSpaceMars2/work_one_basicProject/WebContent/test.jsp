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
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>部门简介</title>

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

<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#PersonnelLogisticsDepartment" data-toggle="tab">
			 菜鸟教程
		</a>
	</li>
	<li><a href="#FinanceDepartment" data-toggle="tab">iOS</a></li>
	<li class="dropdown">
		<a href="#" id="myTabDrop1" class="dropdown-toggle" 
		   data-toggle="dropdown">Java 
			<b class="caret"></b>
		</a>
		<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
			<li><a href="#jmeter" tabindex="-1" data-toggle="tab">jmeter</a></li>
			<li><a href="#ejb" tabindex="-1" data-toggle="tab">ejb</a></li>
		</ul>
	</li>
</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade in active" id="PersonnelLogisticsDepartment">
		<p>后勤部直接作用于团体内部其它部门，对其它部门的正常运作具有至关重要的作用，对实现团体目标任务起间接作用。</p>
        <p>岗位职责：</p></br>
        <ol>
    		<li>执行上级的命令和指示。</li>
   			<li>全面负责行政后勤部的工作。</li>
    		<li>负责制定职责范围内的相关管理制度并督导管理执行。</li>
    		<li>负责做好与有关业务单位和酒店有关部门的沟通、协调工作。</li>
    		<li>做好员工的政治思想工作，关心员工生活。</li>
    		<li>做好副总经理安排的其它工作。</li>
		</ol>
	</div>
	<div class="tab-pane fade" id="FinanceDepartment">
		<p>主要职能是在本机构一定的整体目标下，关于资产的购置(投资)，资本的融通(筹资)和经营中现金流量(营运资金)，以及利润分配的管理。</p>
        <p>岗位职责：</p></br>
        <ol>
    		<li>利润最大化。</li>
   			<li>管理当局收益最大化。</li>
    		<li>企业财富（价值）最大化。</li>
    		<li>社会责任最大化。</li>
		</ol>
	</div>
	<div class="tab-pane fade" id="jmeter">
		<p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
	</div>
	<div class="tab-pane fade" id="ejb">
		<p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
		</p>
	</div>
</div>
</body>
</html>