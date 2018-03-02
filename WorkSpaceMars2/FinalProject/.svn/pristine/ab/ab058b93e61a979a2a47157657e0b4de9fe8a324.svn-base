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
<title>调整信息</title>

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
 <form class="form-horizontal" id="form" role="form" action="probation/probation_accept.action" method="post" >
 <div class="form-group" style="padding: 5px 180px 10px;">
    <label for="编号" class="col-sm-2 control-label"><span class="glyphicon glyphicon-asterisk"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="rid" value="${apply.rid }" name="rid" readonly="readonly"></div></div>
  <div class="form-group" style="padding: 5px 180px 10px;">
    <label for="姓名" class="col-sm-2 control-label"><span class="glyphicon glyphicon-user"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="name" value="${apply.anm }"  name="pnm" readonly="readonly"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="性别" class="col-sm-2 control-label"><span class="glyphicon glyphicon-star"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" name="psex" id="sex" value="${apply.asex }" readonly="readonly"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="身份证号" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-search"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="identify" name="piid" value="${apply.aid }" readonly="readonly"></div> </div>
 <div class="form-group"style="padding: 5px 180px 10px;">
<label for="民族" class="col-sm-2 control-label"><span class="glyphicon glyphicon-flag"></span></label>
<div class="col-sm-10"><input type="text" class="form-control" id="ana" name="ana" value="${apply.ana }"readonly="readonly"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="联系电话" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-phone-alt"></span></label>
    <div class="col-sm-10"><input type="number" class="form-control" id="phone"name="ptel" value="${apply.atel }" readonly="readonly">
  </div></div>
  <div class="form-group"style="padding: 5px 180px 10px;">
  <label for="学历" class="col-sm-2 control-label"><span class="glyphicon glyphicon-wrench"></span></label>
  <div class="col-sm-10"><input type="text" class="form-control" name="pedu" value="${apply.aedu }" readonly="readonly" ></div></div>
      <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="住址" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-home"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="ploc" name="ploc" value="${apply.aloc }" readonly="readonly"></div> </div>
      <div class="form-group"style="padding: 5px 180px 10px;">
  <label for="申请岗位" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-briefcase"></span></label>
  <div class="col-sm-10"><input type="text" class="form-control" id="ploc" name="position"  value="${apply.apos}" readonly="readonly"></div></div>
    <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="员工编号" class="col-sm-2 control-label"><span class="glyphicon glyphicon-eye-open"></span></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="员工编号" name="pid"  value="1503030212"></div> </div>
  <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="岗位" class="col-sm-2 control-label"><span class="glyphicon glyphicon-cog"></span></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="岗位" name="ppos"  value="高级职工"></div></div>
    <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="部门" class="col-sm-2 control-label"><span class="glyphicon glyphicon-folder-open"></span></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="部门" name="pdept"  value="营销部"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="实习开始时间" class="col-sm-2 control-label"><span class="glyphicon glyphicon-play"></span></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="实习开始时间" name="pst"  value="2012-10-27"></div></div>
  <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="实习结束时间" class="col-sm-2 control-label"><span class="glyphicon glyphicon-stop"></span></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="实习结束时间" name="pend" value="2022-10-27"></div></div>
<div class="form-group" >
    <div class="col-sm-offset-2 col-sm-10" style="padding-left:300px;" >
     <input type="submit" class="btn btn-info" value="保存" />
	<a type="button" href="probation/apply_applist.action">返回</a> </div></div>
</form>
</body>
<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
