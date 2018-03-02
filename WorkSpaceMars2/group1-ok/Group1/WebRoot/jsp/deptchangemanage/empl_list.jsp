<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"  %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/tn_css.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工定位查询</title>

</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
<body>
当前位置:部门调动管理&gt;&gt;员工信息查询<br>
<div align="right"><html:link action="deptchange.do?method=forwardDeptChange">已调动部门员工信息</html:link></div>
  
<form method="post" action="deptchange.do?method=listEmpl">
<table align="center" cellspacing="0">
  <tr>
    <td align="center" >
	<span style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">员工信息查询 
		<span id="hidden">[已隐藏]</span>
		<span  id="show" style="display:none" >[已显示]</span>
	</span></td>
  </tr>
  </table>
  <table align="center" style="display:none" id="showselect" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
    <tr>
	<td align="center">员工编号:<input type="text" name="em_number"></td>
	
	<td align="center">姓名：<input name="em_name" type="text"></td>
 		
	
	<td align="center">员工所在部门：
	<select name="dept_number">
	                   <option value="0">不限</option>
				  <logic:iterate name="dept_nameList" id="dept" >
				       <option value="<bean:write name="dept" property="dept_number"/>">
				       <bean:write name="dept" property="dept_name"/></option>            
			      </logic:iterate>
    
	   </select></td>     
	</tr>
   <tr>
		 <td colspan=3 class="DataTitle">&nbsp;</td>
	</tr>
	<tr>
          <td  colspan="4" align="center"><input type="submit" class="button" value="查询"">&nbsp;&nbsp;<input type="reset" value="重新填写" class="button"></td>
   </tr>
  </table>
  <p>
<logic:empty name="employeeList">
				<tr>
					<td><div align="center">
						<font color="red">无查询结果！</font></div>
					<br></td>
				</tr>
</logic:empty>	

<logic:notEmpty name="employeeList">			
<table id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" width="100%">
  <tr>
    <td width="18%" align="center">员工号</td>
    <td width="18%" align="center">姓名</td>
    <td width="22%" align="center">电话</td>
    <td width="22%" align="center">员工部门</td>
    <td width="20%" align="center">&nbsp;</td>
  </tr>
  <logic:iterate id="deptChange" name="employeeList">
  
  <input type="hidden" name="id" value="<bean:write name="deptChange" property="id"/>"/>
  <tr>
    <td align="center"><bean:write name="deptChange" property="em_number"/></td>
    <td align="center"><bean:write name="deptChange" property="em_name"/></td>
    <td align="center"><bean:write name="deptChange" property="em_phone"/></td>
    <td align="center"><bean:write name="deptChange" property="dept_name"/></td>
    <td align="center"><html:link action="deptchange.do?method=getEmplById" paramId="id" paramName="deptChange" paramProperty="id">部门调动</html:link></td>
  </tr>
 </logic:iterate> 
</table>
</logic:notEmpty>
</form>

</body>
</html>

