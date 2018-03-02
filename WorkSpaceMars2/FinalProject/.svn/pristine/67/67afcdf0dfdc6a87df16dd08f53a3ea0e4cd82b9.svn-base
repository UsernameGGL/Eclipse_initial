<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	//basePath : the  ROOT of this APP
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- do NOT move Pre 3 metas tag -->

<title>部门信息表</title>

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
		<caption >部门信息表</caption>
		<thead>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门员工数</th>
		</thead>
		<tbody>
			<c:if test="${ empty  requestScope.listDept}">
				<tr>
					<td colspan="3">没有部门信息</td>
				</tr>
			</c:if>
			<c:if test="${ not  empty  requestScope.listDept}">
				<c:forEach items="${  requestScope.listDept }" var="p">
					<tr>
						<td>${p.did }</td>
						<td id="${p.did }_1">${p.dnm }</td>
						<td id="${p.did }_2">${p.dnum }</td>
						
						<td><a id="${p.did }"  onclick="writeEnable(this)" 
						style="cursor:pointer">编辑</a>
						<a name="${p.did }"  onclick="cancel(this)"
						style="cursor:pointer">取消编辑</a>
							<!-- <a name="${p.did }" onclick="keep(this)">保存</a> -->
							<!-- href="dept_update.action?did=${p.did }&dnm=${p.dnm}&dnum=${p.dnum}" -->
						<a name="${p.did }"  onclick="callAjax_del(this)"
						style="cursor:pointer">删除</a>
						<a href="dept_listperson.action?did=${p.did }">下属员工</a>
						</td>
						
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot><a onclick="add()" style="cursor:pointer">添加</a></tfoot>
	</table>

</body>
	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<script type="text/javascript">
var myLabel="";
var oldDnm=0;
var oldDnum=0;
var activeSum=0;

/**
 * 此函数供编辑操作用，当点击编辑按钮时，将对应行部门名称的html标签改为form表单使其可写并能传入后端
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
			oldDnm=document.getElementById(label.id+"_1").innerHTML;
			document.getElementById(label.id+"_1").innerHTML="<form action=\"dept_update.action\" method=\"post\">"
			+"<input type=\"hidden\" name=\"did\" value=\""+label.id+"\" /><input name=\"dnm\" value=\""+ oldDnm+"\" /><input type=\"submit\" value=\"保存\" /></form>";
			myLabel=label;
			activeSum=1;
		}
	}
/**
 * 此函数供取消编辑操作用，当点击正在编辑行的取消编辑操作按钮时，对应在职信息行的部门编号、
 * 岗位编号和薪金处的html标签还原，并恢复编辑前的值，无需访问数据库
 */
	function cancel(label){
	//此处判断活动行是否大于0(为1)和点击取消编辑所在行和活动行是否为同一行，若成立，才允许取消操作进行
		if(activeSum>0&&myLabel.id==label.name){
			document.getElementById(label.name+"_1").innerHTML=oldDnm;
			//初始化供判断的值
			oldDnm=0;
			oldDnum=0;
			activeSum=0;
			myLabel="";
		}
	}
/**
 * //保存编辑结果
	function keep(label){
		if(activeSum>0&&myLabel.id==label.name){
			var newDnm=$("#_"+label.name+"_1").val();
			var newDnum=$("#_"+label.name+"_2").val();
			//初始化供判断的值
			oldDnm=0;
			oldDnum=0;
			activeSum=0;
			myLabel="";
			location="dept_update.action?did="+label.name+"&dnm="+newDnm+"&dnum="+newDnum;
		}
	}
 */
	
	
/**
 * 进行部门删除操作
 */
	/* function del(label){
		if(activeSum>0){
			alert("请编辑完成后再进行删除操作");
		}else{
			var flag=confirm("确定删除？");
			if(flag){
				location="dept_delete.action?dept.did="+label.name;
			}
		}
	} */
	var opObject;
	function getXMLHttpRequest(){
		return new XMLHttpRequest();
	}
	function responseAjax_del(){
		if(myRequest.readyState==4&&myRequest.status==200){
			opObject.remove();
		}else if(myRequest.readyState==4&&myRequest.status!=200){
			alert("删除失败");
		}
	}
	var myRequest=getXMLHttpRequest();
	function callAjax_del(label){
		if(activeSum>0){
			alert("请编辑完成后再进行删除操作");
		}else{
			var flag=confirm("确定删除？");
			if(flag){
				if(document.getElementById(label.name+"_2").innerHTML==0){
					opObject=$('#'+label.name).parent().parent();
					 var url="dept_delete.action?dept.did="+label.name;
					myRequest.open("GET",url,true);
					myRequest.onreadystatechange=responseAjax_del;
					myRequest.send(null);
				}else{
					alert('此部门还有员工，不能删除');
				}
			}
		}
	}
/**
 * 进行部门添加操作
 */
 	function add(){
		var flag=confirm("确定添加新部门？");
		if(flag)$("tfoot").before("<td></td><td><form action=\"dept_add.action\" method=\"post\">"
				+"<input name=\"dnm\" /><input type=\"submit\" value=\"保存\" /></form></td>")
		//if(flag)$("tfoot").before("<td></td><td><input /></td><td>0</td><td><a onclick=confirm()>保存</a></td>");
	}
 	//$("tfoot").before("<td></td><td><input /></td><td>0</td><td><a href=\"dept_add.action\" style=\"cursor:pointer\">保存</a></td>");
</script>
</html>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->