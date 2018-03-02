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
<script type="text/javascript">
/**
 * 利用Ajax技术检测运行情况，进行局部刷新
 */
 //获取请求
var myRequest=getXMLHttpRequest();
function getXMLHttpRequest(){
	return new XMLHttpRequest();
}
//从数据库查询出一个人的信息
function deleteAjax(label,keyValue){
	var url="worker/worker_findone.action?worker.workerNo="+keyValue;
	myRequest.open("GET",url,true);
	myRequest.onreadystatechange=responseAjax;
	myLabel=label;
	myRequest.send(null);
}
//当查询成功后，进行页面局部刷新
function responseAjax(){
	if(myRequest.readyState==4){
		alert(typeof myLabel);
		var id=myLabel.name;
		document.getElementById(id+"_1").innerHTML=${worker.deptNo};
		document.getElementById(id+"_2").innerHTML=${worker.jobNo};
	}
}
var myLabel="";
var oldDeptNo=0;
var oldJobNo=0;
var activeSum=0;
/**
 * 此函数供编辑操作用，当点击编辑按钮时，将对应员工信息行的部门编号和岗位编号处的html标签改为
 * input标签使其可写
 */
	function writeEnable(label){
	/**
	 * activeSum代表正在编辑行的数目，如果它大于0(大于0的值一般是1)，则表示有一行编辑未完成，
	 * 提示用户将那一行的操作结束后再进行下一次编辑操作，既防止了页面出错也改善了用户体验
	 */
		if(activeSum>0){
			alert("请提交或取消您的编辑后再进行下一次编辑");
		}
		else{
			oldDeptNo=document.getElementById(label.id+"_1").innerHTML;
			oldJobNo=document.getElementById(label.id+"_2").innerHTML;
			document.getElementById(label.id+"_1").innerHTML="<input value=\""+ oldDeptNo+"\" />";
			document.getElementById(label.id+"_2").innerHTML="<input value=\""+ oldJobNo+"\" />";
			myLabel=label;
			activeSum=1;
		}
	}
/**
 * 此函数供取消编辑操作用，当点击正在编辑行的取消编辑操作按钮时，对应员工信息行的部门编号和
 * 岗位编号处的html标签还原，并恢复编辑前的值，无需访问数据库
 */
	function cancel(label){
	//此处判断活动行是否大于0(为1)和点击取消编辑所在行和活动行是否为同一行，若成立，才允许取消操作进行
		if(activeSum>0&&myLabel.id==label.name){
			document.getElementById(label.name+"_1").innerHTML=oldDeptNo;
			document.getElementById(label.name+"_2").innerHTML=oldJobNo;
			//初始化供判断的值
			oldDeptNo=0;
			oldJobNo=0;
			activeSum=0;
			myLabel="";
		}
	}
</script>
<title>员工信息</title>

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
	<table class="table table-striped">
		<caption>员工信息列表</caption>
		<thead>
			<th>员工编号</th>
			<th>部门编号</th>
			<th>岗位编号</th>
		</thead>
		<tbody>
			<c:if test="${ empty  requestScope.lrs}">
				<tr>
					<td colspan="3">没有员工数据</td>
				</tr>
			</c:if>
			<c:if test="${ not  empty  requestScope.lrs}">
				<c:forEach items="${  requestScope.lrs }" var="w">
					<tr>
						<td>${w.workerNo }</td>
						<td id="id_${w.workerNo }_1">${w.deptNo }</td>
						<td id="id_${w.workerNo }_2">${w.jobNo }</td>
						<td><a id="id_${w.workerNo }"  onclick="writeEnable(this)" 
						style="cursor:pointer">编辑</a>
						<td><a name="id_${w.workerNo }"  onclick="cancel(this)"
						style="cursor:pointer">取消编辑</a>
							<a href="worker_update.action?worker.workerNo=${w.workerNo }&worker.deptNo=${w.deptNo }&worker.jobNo=${w.jobNo }">保存</a>
							<a href="worker_delete.action?worker.workerNo=${w.workerNo }">删除</a></td>
							
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<a href=" roleadd.jsp">添加</a>
		</tfoot>
	</table>


	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->