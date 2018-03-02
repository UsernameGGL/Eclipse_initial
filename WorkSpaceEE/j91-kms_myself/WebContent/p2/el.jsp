<%@page import="java.util.ArrayList"%>
<%@ page language="java" import = "com.kms2.pojo.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Role r = new Role();
	r.setRid(1);
	r.setRnm("管理员");
	request.setAttribute("role", r);
	ArrayList al = new ArrayList();
	request.setAttribute("al",al);//把它放入传值作用域中
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	基本的逻辑运算，如1==1
	判断对象是否为null	"${requestScope.name == null }"
	判断集合是否为空		"${not empty requestScope.al }"
 -->
 	<c:if test="${empty requestScope.al }">
 		查询已经结束，但是集合为空
 	</c:if>
 	<c:if test="${not empty requestScope.al }">
 		查询已经结束，集合非空
 	</c:if>
	<c:if test="${requestScope.name == null }">
		<h1>我爱北京天安门</h1>
	</c:if>
	<c:if test="${requestScope.name != null }">
		<h1>${requestScope.name }</h1>
	</c:if>
	${requestScope.role.rid}<!-- EL表达式从传值作用域中获得数据 -->
	${requestScope.role.rnm }
</body>
</html>