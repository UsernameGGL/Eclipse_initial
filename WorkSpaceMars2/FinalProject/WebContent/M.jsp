<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kms.po.WorkInfo"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	WorkInfo worker=(WorkInfo)request.getAttribute("worker");
	session.setAttribute("worker", worker);
	//pageContext.setAttribute("s", s);
	//pageContext.setAttribute("worker", worker);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
		location="/FinalProject/workerview.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="work/worker_list.action">员工信息</a>
<a href="work/worker_salList.action">薪资</a>

<a href="probation/probation_list.action">实习生</a>
<a href="probation/apply_applist.action">申请</a>
<a href="index.html">${worker.wid }</a>
<a href="workerview.jsp">进入2</a>

</body>

</html>
