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

<title>试用期员工表</title>

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
	<table class="table table-striped table-hover">
		<caption>试用期员工表</caption>
		<thead>
			<th>员工编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>民族</th>
			<th>身份证号</th>
			<th>联系电话</th>
			<th>学历 </th>
			<th>户籍</th>
			<th>使用开始时间</th>
			<th>试用结束时间</th>
			<th>岗位</th>
			<th>部门</th>
		</thead>
		<tbody>
			<c:if test="${empty pl}">
				<tr>
					<td colspan="13">没有试用期信息</td>
				</tr>
			</c:if>
			<c:if test="${not empty pl}">
				<c:forEach items="${pl }" var="p">
					<tr>
						<td>${p.pid }</td>
						<td>${p.pnm }</td>
						<td>${p.psex }</td>
						<td>${p.page }</td>
						<td>${p.pna }</td>
						<td>${p.piid }</td>
						<td>${p.ptel }</td>
						<td>${p.pedu }</td>
						<td>${p.ploc }</td>
						<td>${p.pst }</td>
						<td>${p.pend }</td>
						<td>${p.ppos }</td>
						<td>${p.pdept }</td>
						<td><a  id="${p.pid }"  onclick="acceptToCom(this)" 
						style="cursor:pointer">接受</a>
						<a  id="${p.pid }"  onclick="delay(this)" 
						style="cursor:pointer">延长</a>
						<a  id="${p.pid }"  onclick="reject(this)"
						style="cursor:pointer">拒绝</a>
							<%-- <a href="position_update.action?position.pid=${p.pid }&position.pnm=${p.pnm }&position.pnum=${p.pnum }">保存</a> --%>
						</td>
							
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	</body>



	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<script type="text/javascript">
/**
 * 此函数供确认接受入职申请用，当点击接受按钮时，弹出提示框，当管理员点击确定后，就将此人的数据写入正式员工信息表中，并删除此人在入职申请表中的记录
 */
	function acceptToCom(label){
		var flag=confirm("确定升级此人为正式员工？");
		if(flag)location="../probation/probation_positive.action?pid="+label.id;
	}
/**
 * 此函数供延长试用期用，当点击延长试用期按钮时，弹出prompt框，提示管理员输入新的截止日期，点击确定后，将新的信息写入数据库
 */
 	function delay(label){
		var delayDay=prompt("请填入要增加的月数","");
		while(isNaN(delayDay)){
			alert("请输入整数");
			delayDay=prompt("请填入要增加的月数");
		}
		if(delayDay)location="../probation/probation_delay.action?pid="+label.id+"&delayDay="+delayDay;
	}

	function reject(label){
		var flag=confirm("确定拒绝此人进入公司？");
		if(flag)location="../probation/probation_reject.action?pid="+label.id;
	}
</script>
</html>
	<!-- Include all compiled plugins (below), or include individual files as needed -->