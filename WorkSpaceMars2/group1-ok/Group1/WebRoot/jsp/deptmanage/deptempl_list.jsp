<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"  %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/tn_css.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门下员工查询结果</title>
</head>
<script language=JavaScript src="../js/script.js"></script>
<body>
<p>当前位置:<html:link action="dept.do?method=forwardDept">部门基本信息</html:link>&gt;&gt;部门员工查询</p>

<logic:empty name="employeeList">
				<tr>
						<td><div align="center">
							<font color="red">无查询结果！</font></div>
						</td>
				</tr>
</logic:empty>		
<br><logic:notEmpty name="employeeList">
<table id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" width="100%">
 
  <tr class="SrollDataHead">
    <td align="center">员工编号<br></td>
    <td align="center">姓名<br></td>
    <td align="center">电话<br></td>
    
  </tr>
  <logic:iterate id="employee" name="employeeList">
  <tr>
    <td align="center"><bean:write name="employee" property="em_number"/></td>
    <td align="center"><bean:write name="employee" property="em_name"/></td>
    <td align="center"><bean:write name="employee" property="em_phone"/></td>   
  </tr>
  </logic:iterate>
</table>

</logic:notEmpty>

</body>
</html>
