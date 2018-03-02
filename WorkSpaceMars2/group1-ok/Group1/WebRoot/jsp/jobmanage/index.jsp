<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic"  uri="http://struts.apache.org/tags-logic" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <html:link action="job.do?method=getJobByID">岗位管理</html:link><br>
    <a href="jsp/jobmanage/LAIconfirm.jsp">岗位调动</a><br>
    <a href="jsp/jobmanage/LAIchangeList.jsp">已调动查询</a><br>
    <html:link action="jobCh.do?method=jobChange">以调动岗位员工信息查询</html:link><br>
   <html:link action="jobChList.do?method=forwardEmplList">点击岗位调动到员工信息</html:link><br>
  </body>
</html>
