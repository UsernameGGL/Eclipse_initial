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
<script type="text/javascript">
		location="/FinalProject/newPage/jump.html";
</script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- do NOT move Pre 3 metas tag -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>正在跳转</title>

 

</head>

<body  background="../img/tree.jpeg" style="background-size:100%">
<p style="font-family:Times New Roman;color:white;font-size:30px;" align="center" ><br/><br/><br/><br/>您已申请成功<br/>请耐心等待我们的通知<br/>
<span id="totalSecond">5</span>

<script language="javascript" type="text/javascript">
    var second = document.getElementById('totalSecond').textContent;
    if (navigator.appName.indexOf("Explorer") > -1)
    {
        second = document.getElementById('totalSecond').innerText;
    } else
    {
        second = document.getElementById('totalSecond').textContent;
    } 


    setInterval("redirect()", 1000);
    function redirect()
    {
        if (second < 0)
        {
            location.href = '/FinalProject/index.html';
        } else
        {
            if (navigator.appName.indexOf("Explorer") > -1)
            {
             document.getElementById('totalSecond').innerText = second--;
            } else
            {
                document.getElementById('totalSecond').textContent = second--;
            }
        }
    }
</script>
  秒后跳至主页...</p>
</body>
</html>