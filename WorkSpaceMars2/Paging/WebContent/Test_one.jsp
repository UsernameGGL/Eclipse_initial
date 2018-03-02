<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	
	//下面几行仅作仿真用
	//真实情况下数据从后台来，不需要这几行代码
	int[] worker=new int[100];
	for(int i=0;i<100;i++){
		worker[i]=i;
	}
	pageContext.setAttribute("worker", worker);
	int len=worker.length;
	pageContext.setAttribute("lenb", len);//${}表达式中的是前面的键值
	
	
	//真实情况下k的作用可能被数据的id代替
	int k=0;
	pageContext.setAttribute("k", k);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body id="body">
	<table id="table" class="table table-striped table-hover">
	
		<caption>hhhhhhhh呵呵哈哈哈</caption>
		
		<thead>
			<tr>
				<th>编号</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${worker}" var="w">
					<!-- <tr id="tr_<%=k++ %>" style="display:none"> -->
					<tr id="tr_<%=k++ %>" style="display:none">
						<td>${w }</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</body>
<script src="myJs/Paging.js">
	//似乎用不到欸
	//将Java格式的数据存入到js格式中
	/*var worker = new Array();
	var i=0;
	<c:forEach var="w" items="${worker}">
   		worker[i++] = '${w}';
	</c:forEach>*/
	
</script>
<script type="text/javascript">
	var worker="${worker}";
	var sum=0;
	//alert(worker);
	//前端分行组件的限制：
	//1、开发者必须手动获取数据的长度，并将其作为参数传入init函数中
	//2、开发者必须为表分配id，且必须是table
	//3、开发者必须为每个tr分配id，且必须是tr_0形式，最后的数字标志其为数组的第几个
	
	//一个优点
	//当多个表在同一页面，且需要同时分页的话，分配相同的id即可做到这一点。
	paging('${lenb}',10,"table-row");
	//alert('${lenb}');
</script>
</html>
