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
	   <link rel="stylesheet" href="css/tn_css.css" type="text/css">
	   <script language=JavaScript src="js/script.js"></script>
	<title>岗位调动管理</title>
	</head>

	<body>
	     当前位置:岗位调动管理&gt;&gt;员工信息查询<br><div align="right"><html:link action="jobCh.do?method=jobChange">已调动岗位员工信息查询</html:link></div>
		<html:form action="jobChList.do?method=listEmp" method="post">
		  <table  width="100%" align="center">
		  <tr>
		    <td align="center">
			<span  style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">员工信息查询 
				<span id="hidden">[已隐藏]</span>
				<span  id="show"   style="; display:none">[已显示]</span>
			</span></td>
		  </tr>
		  </table>
		  <table align="center" style="display:none" id="showselect" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1>
		 	<tr>
				<td align="center">员工编号：<input type="text" name="em_number"></td>
				<td align="center">姓名：<input name="em_name" type="text"></td>
				<td align="center">员工所在岗位：
				<select name="job_number">
					<option value="0">不限</option>					
					<logic:iterate name="job_nameList" id="job">
					<option value="<bean:write name="job" property="job_name"/>">
					<bean:write name="job" property="job_name"/></option>            
					</logic:iterate>				  
				</select></td>
				
			</tr>	
			<tr>
		           <td colspan=3 class="DataTitle">&nbsp;</td>
	     </tr>		
			<tr>
			      <td  colspan="3" align="center"><input type="submit" class="button" value="查询"">
			          <input type="reset" value="重新填写" class="button"></td>
			</tr>
		  </table>
		</html:form>
		<logic:empty name="employeeList">
			<tr>
				<td><div align="center">
					<font color="red">无查询结果！</font></div>
				<br></td>
			</tr>
		</logic:empty>	
		<br><logic:notEmpty name="employeeList">			
		<table id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" width="100%">
		  <tr>
		    <td align="center">员工号<br></td>
		    <td align="center">姓名<br></td>
		    <td align="center">电话<br></td>
		    <td align="center">员工岗位<br></td>
		    <td align="center">&nbsp;<br></td>
		  </tr>
		<logic:iterate id="jobChange" name="employeeList">
		
		  <input type="hidden" name="id" value="<bean:write name="jobChange" property="id"/>"/>
			<tr>
			 <td align="center"><bean:write name="jobChange" property="em_number"/><br></td>
			 <td align="center"><bean:write name="jobChange" property="em_name"/><br></td>
			 <td align="center"><bean:write name="jobChange" property="em_phone"/><br></td>
			 <td align="center">&nbsp;<bean:write name="jobChange" property="job_name"/></td>
			 <td align="center"><html:link action="jobCh.do?method=editJobCh" paramId="id" paramName="jobChange" paramProperty="id">岗位调动</html:link></td>
			</tr>
		</logic:iterate> 
		</table>
</logic:notEmpty>
	
	</body>
</html>
