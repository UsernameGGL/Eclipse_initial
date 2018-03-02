<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	//basePath : the  ROOT of this APP
%>
<%!int i=0;int k=1; %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<!-- <script type="text/javascript">
	window.onload=function(){
		document.getElementById('table').style.display='none';
	}
</script> -->
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- do NOT move Pre 3 metas tag -->

<title>在职信息</title>

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

					<p style="color:#20B2AA" >编辑岗位和部门时请输入整数!</p>
				
				
			    <p  style="color:#20B2AA">岗位：1、经理；2、初级职工；3、中级职工；4、高级职工</p>
				
				
					 <p  style="color:#20B2AA">部门：1、人事后勤部；2、财务部；3、物资管理部；4、生产制造部；5、技术开发部；6、质量管理部；7、营销部</p>
				
	<!-- HTML HERE -->
	<table class="table table-striped table-hover" id="table">
	
		<caption>在职信息表</caption>
		
		           
		<thead >
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>年龄</th>
			<th>岗位</th>
			<th>部门</th>
			<th>薪金</th>
			<th>操作</th>
		</thead>
		
		<tbody class="table table-striped">
			<c:if test="${ empty  requestScope.salList}">
				<tr>
					<td colspan="6">没有在职信息</td>
				</tr>
			</c:if>
			<c:if test="${ not  empty  requestScope.salList}">
			
				
				<c:forEach items="${  requestScope.salList }" var="j">
				<%i++;
					if(i>=10){
						k++;
						i-=10;
					}
				%>
					<tr class="<%=k%>">
					<td>${j.jid }</td>
					<td>${j.jnm }</td>
					<td>${j.jage }</td>
					<td id="${j.jid }_1">${j.pnm }</td>
					<td id="${j.jid }_2">${j.dnm }</td>
					<td id="${j.jid }_3">${j.jsal }</td>
					<td><a id="${j.jid }"  onclick="writeEnable(this)" 
					style="cursor:pointer">编辑</a>
					<a name="${j.jid }"  onclick="cancel(this)"
					style="cursor:pointer">取消编辑</a>
					<a name="${j.jid }" style="cursor:pointer" onclick="keep(this)">保存</a>
					<a name="${j.jid}" onclick="del(this)" style="cursor:pointer">辞退</a>
					</td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</tbody>
		<tfoot><a href="jobInfo_add.action"></a></tfoot>
	</table>
	
</body>
	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<script type="text/javascript">
var myLabel="";
var oldJpid=0;
var oldJdid=0;
var oldJsal=0;
var activeSum=0;
var position=['部门经理','初级职工','中级职工','高级职工']; 
var dept=['人事后勤部','财务部','物资管理部','生产制造部','技术开发部','质量管理部','营销部'];
/**
 * 此函数供编辑操作用，当点击编辑按钮时，将对应在职信息行的部门编号、岗位编号和薪金处的html标签改为
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
			oldJpid=document.getElementById(label.id+"_1").innerHTML;
			oldJdid=document.getElementById(label.id+"_2").innerHTML;
			oldJsal=document.getElementById(label.id+"_3").innerHTML;
			document.getElementById(label.id+"_1").innerHTML="<input id=\"_"+label.id+"_1\" value=\""+ (position.indexOf(oldJpid)+1)+"\" />";
			document.getElementById(label.id+"_2").innerHTML="<input id=\"_"+label.id+"_2\" value=\""+(dept.indexOf(oldJdid)+1) +"\" />";
			document.getElementById(label.id+"_3").innerHTML="<input id=\"_"+label.id+"_3\" value=\""+ oldJsal+"\" />";
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
			document.getElementById(label.name+"_1").innerHTML=oldJpid;
			document.getElementById(label.name+"_2").innerHTML=oldJdid;
			document.getElementById(label.name+"_3").innerHTML=oldJsal;
			//初始化供判断的值
			oldJpid=0;
			oldJdid=0;
			oldJsal=0;
			activeSum=0;
			myLabel="";
		}
	}
	
	//保存编辑结果
	function keep(label){
		if(activeSum>0&&myLabel.id==label.name){
			var newJpid=$("#_"+label.name+"_1").val();
			var newJdid=$("#_"+label.name+"_2").val();
			var newJsal=$("#_"+label.name+"_3").val();
			//初始化供判断的值
			
			if(isNaN(newJpid)||isNaN(newJdid)||isNaN(newJsal)||newJpid<1||newJpid>4||newJdid<1||newJdid>7||newJsal<0)
				alert("请输入正确的整数");
			else {
				location="../administratorsView/jobInfo_update.action?jid="+label.name+"&jpid="+newJpid+"&jdid="+newJdid+"&jsal="+newJsal;
				oldJpid=0;
				oldJdid=0;
				oldJsal=0;
				activeSum=0;
				myLabel="";
			}
		}
	}
	 function del(label){
		if(activeSum>0){
			alert("请编辑完成后再进行删除操作");
		}else{
			var flag=confirm("确定删除？");
			if(flag){
				location="../administratorsView/jobInfo_quit.action?jid="+label.name;
			}
		}
	} 
	
	/* function del(label){
		if(activeSum>0){
			alert("请编辑完成后再进行删除操作");
		}else{
		var flag=confirm("确定开除此员工？");
		if(flag)location="worker_del.action?wid="+label.name;
		}
	} */
	
</script>
</html>



	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->