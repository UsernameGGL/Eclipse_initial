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
<title>RoleList</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function getXMLHttpRequest(){
		return new XMLHttpRequest();
	}
	function responseAjax(){
		if(myRequest.readyState==4){
			window.history.go(-1);
			alert("添加人员信息成功！");
		}
	}
	var myRequest=getXMLHttpRequest();
	function callAjax(){
		var url="work/worker_list.action";
		myRequest.open("GET",url,true);
		myRequest.onreadystatechange=responseAjax;
		myRequest.send(null);
	}
</script>

</head>
<body>
	<table border="3" style="width:500px">
		<tbody>
			<tr>
				<!-- <th>名称</th> -->
				<td>
					<form action="work/worker_addRet.action">
						员工编号：<input type="text" name="wid"/></br>
						姓名：<input type="text" name="wnm"/></br>
						性别：<input type="text" name="wsex"/></br>
						民族：<input type="text" name="wna"/></br>
						身份证号：<input type="text" name="wiid"/></br>
						联系电话：<input type="text" name="wtel"/></br>
						学历：<input type="text" name="wedu"/></br>
						住址：<input type="text" name="wloc"/></br>
						<input type="submit" value="添加">
					</form>
				</td>
			</tr>
		</tbody>	
	</table>
</body>
</html>

	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	
