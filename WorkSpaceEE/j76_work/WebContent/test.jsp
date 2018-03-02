<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="8kb" 
	pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getXMLHttpRequest(){
		return new XMLHttpRequest();
	}
	function responseAjax(){
		if(myRequest.readyState==4){
			alert("success");
		}
	}
	var myRequest=getXMLHttpRequest();
	function callAjax(){
		var url="person/person_list.action";
		myRequest.open("GET",url,true);
		myRequest.onreadystatechange=responseAjax;
		myRequest.send(null);
	}
</script>
</head>
<body>
	<input type = "submit" value = "登陆" onclick="callAjax()"/>
</body>
</html>