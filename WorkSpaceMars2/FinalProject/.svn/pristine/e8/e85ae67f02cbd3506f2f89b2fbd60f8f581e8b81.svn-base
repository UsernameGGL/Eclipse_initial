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
<body style="background-color:#FFE4E1" >
	<!-- HTML HERE -->
	<!-- HTML HERE -->
<ul id="myTab" class="nav nav-tabs" style="background-color:#FFC1C1">
    <li class="active">
        <a href="#DepartmentManager" data-toggle="tab">
        	<i class="fa fa-user-md"> 部门经理</i></a></li>
    <li><a href="#SeniorStaff" data-toggle="tab">
    		<i class="fa fa-user">高级职工</i></a></li>
    
     <li><a href="#NormalWorker" data-toggle="tab">
     		<i class="fa fa-group">普通职工</i></a></li>
</ul>
<div id="myTabContent" class="tab-content" style="font-size:20px">
    <div class="tab-pane fade in active" id="DepartmentManager">
        <p>部门经理是协调部门内和企业内的资源调配的管理人员,主要职责是为部门的整体业绩负责.</p>
        <p>部门经理必须要处理好以下五种关系：</p>
        <ol>
    		<li>管理者和被管理者的关系。</li>
   			<li>分内工作与额外工作的关系。</li>
    		<li>批评与鼓励的关系。</li>
    		<li>付出与回报的关系。</li>
    		<li>成效与成长的关系。</li>
		</ol>
   
    </div>
    <div class="tab-pane fade" id="SeniorStaff">
        <p>高级管理人员是指公司的经理、副经理、财务负责人、上市公司董事会秘书和公司章程规定的其他人员。</p>
        <p>由于高级管理人员对于公司的经营管理和业绩效益负有重要的责任，公司法对他们的任职资格有较为严格的限制性条件。根据公司法的规定，有下列情形之一的，不得担任公司的董事、监事、高级管理人员:</p>
        <ol>
    		<li>无民事行为能力或者限制民事行为能力;</li>
   			<li>因犯有贪污、贿赂、侵占财产、挪用财产罪或者破坏社会经济秩序罪，被判处刑罚，执行期满未逾5年，或者因犯罪被剥夺政治权利，执行期满未逾5年;</li>
    		<li>担任破产清算的公司、企业的董事或者厂长、经理，并对该公司、企业的破产负有个人责任的，自该公司、企业破产清算完结之日起未逾3年;</li>
    		<li>担任因违法被吊销营业执照、责令关闭的公司、企业的法定代表人，并负有个人责任的，自该公司、企业被吊销营业执照之日起未逾3年;</li>
    		<li>个人所负数额较大的债务到期未清偿。</li>
		</ol>
    </div>
   
    <div class="tab-pane fade" id="NormalWorker">
		<p>职责：</p>
		<ol>
			<li>以提高客户需求为根本;坚持以客户为关注焦点。</li>
			<li>加强学习，努力提高技术水平和业务素质。</li>
			<li>踏实肯干，端正态度。</li>
			<li>协同工作。</li>
			
		</ol>
    </div>
    </div>
	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->