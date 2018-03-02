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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" /> 
<title>JS实现倒计时(时、分，秒)</title> 
<script language="javascript" type="text/javascript"> 
var interval = 1000; 
var nowTime=new Date();
var endTime=new Date(nowTime.getTime()+5000);
function ShowCountDown(endTime) 
{ 
var now = new Date(); 
var endDate = endTime; 
var leftTime=endDate.getTime()-now.getTime(); 
var leftsecond = parseInt(leftTime/1000); 

document.getElementById("divdown1").innerHTML = leftsecond+"秒"; 
} 
window.setInterval(function(){ShowCountDown(endTime);}, interval); 
</script> 
</head> 
<body> 
<div id="divdown1"></div> 
</body> 
</html> 
