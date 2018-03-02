<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="reg.servlet" method="post">
		登录名：    <input type = "text" name = "onName" /></br>
		性别：       <input type = "radio" name = "gender" value = "男"  checked = "11" />男
		<input type = "radio" name = "gender" value = "女" />女</br>
		<!-- 同一name的单选按钮框互斥！ -->
		爱好：       <input type = "checkbox" name = "enjoy" value = "足球" />足球</br>
		爱好：       <input type = "checkbox" name = "enjoy" value = "篮球" />篮球</br>
		爱好：       <input type = "checkbox" name = "enjoy" value = "网球" />网球</br>
		爱好：       <input type = "checkbox" name = "enjoy" value = "董德祺" />董德祺</br>
		密码：       <input type = "password" name = "password" /></br>
		确认密码：<input type = "password" name = "defpassword"/></br>
		期望薪水：<input type = "number" name = "money" /></br>
		邮箱：       <input type = "email" name = "email" width="30"/></br>
		通信地址：<input type = "text" name = "address" width = "50" size = "50"/></br>
		邮编：       <input type = "number" name = "zipcode" size = "10" maxlength = "6"></br>
		电话号码：<input type = "tel" name="tel" /></br>
		自我描述：<textarea rows = "5" cols = "50" name = "desc">没有value属性</textarea><br>
		头像：       <input type = "file" name = "icon" /></br>
		<input type = "submit" value = "注册"/></br>
	</form>
</body>
</html>