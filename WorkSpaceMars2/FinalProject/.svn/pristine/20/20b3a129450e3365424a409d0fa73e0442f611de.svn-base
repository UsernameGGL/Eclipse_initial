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
</head>
<body style="background-color:#F0F8FF">
<style>

ul{
	filter:alpha(opacity=50);
}
li {
    border: solid 2px white;
    border-bottom-width: 0px
}
</style>
<body>
	<!-- HTML HERE -->
<ul class="nav nav-pills nav-stacked" style="color:white">
<!--   <li style="border-bottom-width: 2px"><a href="../dept/dept_listdept.action" target="lower_right">部门管理</a></li> -->
  <li><a href="../administratorsView/jobInfo_list.action" target="lower_right">正式员工管理</a></li>
  <li><a href="../work/worker_list" target="lower_right">员工信息管理</a></li>
  <li><a href="../probation/apply_applist.action" target="lower_right">实习资格审核</a></li>
  <li><a href="../probation/probation_list" target="lower_right">实习生管理</a></li>
  <li style="border-bottom-width: 2px"><a href="../dept/dept_listdept.action" target="lower_right">部门管理</a></li>
  <li><a href="../position/position_listposition.action" target="lower_right">岗位管理</a></li>
  <li><a href="../change/change_listChange.action" target="lower_right">变更记录管理</a></li>
  <li><a href="reportManager.jsp" target="lower_right">报表管理</a></li>
</ul>
</body>

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- <script type="text/javascript">
	function getXMLHttpRequest(){
		return new XMLHttpRequest();
	}

	function responseAjax(){
		if(myRequest.readyState==4){
			if(myRequest.status==200){
				location="../dept/deptList.jsp";
			}
		}
	}
	var myRequest=getXMLHttpRequest();
	function callAjax(){
		var url="../dept/dept_listdept.action";
		myRequest.open("GET",url,true);
		myRequest.onreadystatechange=responseAjax;
		myRequest.send(null);
	}
	</script>	 -->
</html>
	<!-- Include all compiled plugins (below), or include individual files as needed -->