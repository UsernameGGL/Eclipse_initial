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
<title>登陆</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">
function checkform(){
	if(sessionStorage.getItem("fail")!=null){
		alert("账号或密码错误！");
		sessionStorage.clear();
	}
	document.getElementById("form").onsubmit=function(){
		var accountNumber=document.getElementById("accountNumber");
		var password=document.getElementById("password");
		if(accountNumber.value[0]==undefined||password.value[0]==undefined){
			alert('账号和密码不能为空！');
			return false;
		}
		for(i in accountNumber.value){
			var ch=accountNumber.value[i];
			var letter=/^[a-zA-Z]+$/;
			if((!letter.test(ch)&&isNaN(ch)&&ch!='_')||ch==' '){
				alert('账号只能包括字母、数字和下划线');
				return false;
			}
		}
		for(j in password.value){
			var ch=password.value[j];
			var letter=/^[a-zA-Z]+$/;
			if((!letter.test(ch)&&isNaN(ch)&&ch!='_')||ch==' '){
				alert('密码只能包括字母、数字和下划线');
				return false;
			}
		}
		sessionStorage.setItem("success_1", "success_1");
		return true;
	}
}

window.onload=checkform;


</script>
</head>
<body>
<!-- HTML HERE -->
<!-- <img alt="top" src="F:\学习资料\大二下\小学期\工程\成果\myself\top.png" height="50" width="100%"> -->
<div style="padding: 100px 50px 10px;">
	<img alt="没有什么能够阻挡，你对自由的向往" src="../img/loginPic.gif" class="img-rounded" 
	width="60%" height="39%" align="left" style="padding: 0px 0px 0px 0px;">
	 
		<br><br><br>
    	<form class="bs-example bs-example-form" role="form" style="padding: 100px 100px 10px 0px;"  id="form" action="../administratorsView/login.action" method="post" > 
        	<div class="input-group" style="width:30%;">
            <!-- <span class="input-group-addon"></span> -->
            <input type="text" class="form-control" placeholder="请输入账号" size="100" id="accountNumber" name="accountNumber">
        	</div>
        	<br>
        	<div class="input-group" style="padding: 0px 0px 20px;width:30%;">
            <!-- <span class="input-group-addon"></span> -->
            <input type="password" class="form-control" placeholder="请输入密码" id="password" name="password"> 
        	</div>  
        	<div class="input-group" style="width:30%;">
           <!--  <span class="input-group-addon"></span> -->
            <input type="submit" class="btn btn-primary btn-lg btn-block"  value="登录" /> 
        	</div> 
    	</form>
    
    
</div>
<!-- END HTML -->
</body>
</html>