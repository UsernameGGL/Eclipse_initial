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
<title>申请信息</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
function checkform(){
	document.getElementById("form").onsubmit=function(){
		if($("#name").val()==""||$("#phone").val()==""||$("#job").val()==""||$("#job option:selected").val()=='请选择您要申请的岗位*'||$('#identify').val()==""){
			alert('带*为必填选项');
			return false;
		}
		if($("#identify").val().length<18){
			alert('身份证号至少为18位，请重新输入');
			return false;
		}
		var info=$("#name").val()+$('#age').val()+$("#phone").val()+$("#job").val()+$('#identify').val()+$('#户籍').val();
		
		var flag=info.indexOf('@')>=0||info.indexOf('!')>=0||info.indexOf('#')>=0||info.indexOf('$')>=0||info.indexOf('%')>=0||info.indexOf('^')>=0||info.indexOf('&')>=0||info.indexOf('*')>=0||info.indexOf('(')>=0||info.indexOf(')')>=0||info.indexOf('<')>=0||info.indexOf('>')>=0||info.indexOf('/')>=0||info.indexOf('\\')>=0;
		
		if(flag){
			alert('请输入正确的信息');
			return false
		}
		return true;
	}
}
window.onload=checkform;
</script>









</head>
<style type="text/css">
	body{
	background-image:url(../img/applyPic.jpg);
	
	}
</style>
<body>
 <form class="form-horizontal" id="form" role="form" action="../probation/apply_add.action" method="post" >
 <div class="form-group" style="padding: 40px 180px 10px;">
    <label for="名字" class="col-sm-2 control-label"><span class="glyphicon glyphicon-user"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="name" placeholder="请输入您的姓名*" name="anm"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="年龄" class="col-sm-2 control-label"><span class="glyphicon glyphicon-heart"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="age" placeholder="请输入您的年龄"name="aage"></div></div>
  <div class="form-group"style="padding: 5px 180px 10px;">
    <label for="性别" class="col-sm-2 control-label"><span class="glyphicon glyphicon-star"></span></label>
    <div class="col-sm-10"><input type="radio" name="asex" id="sex" value="男" checked>男&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="radio" name="asex" id="sex" value="女" >女</div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="身份证号" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-flash"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="identify" placeholder="请输入您的身份证号*"name="aid"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="联系电话" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-phone-alt"></span></label>
    <div class="col-sm-10"><input type="number" class="form-control" id="phone" placeholder="请输入您的联系电话*"name="atel"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
    <label for="户籍" class="col-sm-2 control-label"><span class="glyphicon glyphicon-home"></span></label>
    <div class="col-sm-10"><input type="text" class="form-control" id="户籍" placeholder="请输入您的户籍信息"name="aloc"></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
  <label for="民族" class="col-sm-2 control-label"><span class="glyphicon glyphicon-flag"></span></label>
<div class="col-sm-10"><select class="form-control"name="ana"><option>请选择您的民族</option>
<option>汉族</option><option>回族</option><option>其他</option></select></div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
  <label for="学历" class="col-sm-2 control-label"><span class="glyphicon glyphicon-wrench"></span></label>
  <div class="col-sm-10"><input type="radio" name="aedu" id="学历" value="本科" checked>本科&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="aedu" id="学历" value="大专" >大专&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="radio" name="aedu" id="学历" value="硕士研究生" >硕士研究生&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="aedu" id="学历" value="博士研究生" >博士研究生</div></div>
<div class="form-group"style="padding: 5px 180px 10px;">
  <label for="申请岗位" class="col-sm-2 control-label"> <span class="glyphicon glyphicon-briefcase"></span></label>
  <div class="col-sm-10"><select class="form-control" name="apos" id="job"><option>请选择您要申请的岗位*</option><option>部门经理</option><option>高级职工</option><option>普通职工</option></select></div></div>
  <div class="form-group" ><div class="col-sm-offset-2 col-sm-10" style="padding-left:450px;" ><button type="submit" class="btn btn-default">申请</button></div></div>
</form>
</body>
<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
