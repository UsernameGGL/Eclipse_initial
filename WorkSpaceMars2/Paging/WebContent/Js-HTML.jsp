<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.po.Dept"%>
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
	Dept[] dept=new Dept[100];
	for(int i=0;i<100;i++){
		dept[i]=new Dept();
		dept[i].setDid(i);
		dept[i].setDnm("hhh");
		dept[i].setDnum(i+1);
	}
	pageContext.setAttribute("dept", dept);
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
	
</body>
<script src="myJs/Paging.js"></script>
<script type="text/javascript">
	//display("dept");
	var a='<table id="table" class="table table-striped table-hover">';
		
		a+='<caption>hhhhhhhh呵呵哈哈哈</caption>';
		
		a+='<thead>';
			a+='<tr>';
				a+='<th>编号</th>';
				a+='<th>名字</th>';
				a+='<th>不知道啥</th>';
			a+='</tr>';
		a+='</thead>';
		a+='<tbody>';
				a+='<c:forEach items="${dept}" var="d">';
					a+='<tr id="tr_${d.did}" style="display:none">';
						a+='<td>${d.did }</td>';
						a+='<td>${d.dnm }</td>';
						a+='<td>${d.dnum }</td>';
					a+='</tr>';
				a+='</c:forEach>';
		a+='</tbody>';
	a+='</table>';
	body.innerHTML=a;	
	paging('${lenb}',10);
</script>
</html>
