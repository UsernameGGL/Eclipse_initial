<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic"  uri="http://struts.apache.org/tags-logic" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	      <base href="<%=basePath%>">
	      <link rel="stylesheet" type="text/css" href="css/tn_css.css" />
	      <script language=JavaScript src="js/script.js"></script>
	      <title>岗位调动管理</title>
	</head>
	<body>
		<p>当前位置:<html:link action="job.do?method=getJobByID" target="lower_right" >岗位基本信息</html:link>&gt;&gt;岗位员工查询</p>
			
				<logic:empty name="EmployeeActionForm" property="list">
					<tr>
					<td><div align="center">
						<font color="red">无查询结果！</font></div>
					</td>
				</tr>
				</logic:empty>
				<logic:notEmpty name="EmployeeActionForm" property="list">
				<table  id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" width="100%">
				<tr class="title">					
					<td align="center">员工号</td>
					<td align="center">姓名</td>			
					<td align="center">电话</td>
				</tr>
					<logic:iterate id="em" name="EmployeeActionForm" property="list">
						<tr><td align="center">
						   <bean:write name="em" property="em_number" />
						</td>
						<td align="center">
						   <bean:write name="em" property="em_name" />
						</td>
						<td align="center">
							<bean:write name="em" property="em_phone" />
						</td></tr>
					</logic:iterate>
					</table>
				</logic:notEmpty>				
			
	</body>
</html>