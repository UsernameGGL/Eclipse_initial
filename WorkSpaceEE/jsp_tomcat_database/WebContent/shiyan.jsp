<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<script>
	var jsonObject = {
			"param1":1,
				"param2":2
			}
	//alert(jsonObject.param1+jsonObject.param2)
	//confirm("111");
	var out = "";
	for(i in jsonObject){
		out += i+"="+jsonObject[i];
	}
	alert(jsonObject["param1"]);
	</script>
</body>
</html>