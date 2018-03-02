<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/tn_css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language=JavaScript src="js/script.js"></script>
<SCRIPT type="text/javascript">
var showMsg='<%=request.getAttribute("showAlert")%>';
		if(showMsg!="null"&&showMsg!=""){
		alert(showMsg);
	
		}
</SCRIPT>
<body >

当前位置:员工信息中心
<br>
<form action="EmployeeActon.do?method=listEmployees"  method="post">
 <table  width="100%" align="center" >
<tr>
<td align="center" >
<span style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">员工信息查询
<span id="hidden">[已隐藏]</span>
<span id="show" style="display:none">[已显示]</span>
</span></td>
</tr>
</table>
<table  align="center" style="display:none" id="showselect"  class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
<tr> 
<td align="right"> 员工编号：</td>
<td><input name="em_number" type="text"  /></td>


<td align="right">姓    名：</td>
<td><input name="em_name" type="text"  /></td>
</tr>
<tr >
<td align="right">部门编号：</td>
<td><input name="dept_number" type="text" /></td>


<td align="right">岗位编号：</td>
<td><input name="job_number" type="text" /></td>
</tr>
<tr>
<td></td>
<td align="right"> <input name="OK" type="submit"  class="button" value="查询"/></td>
<td><input name="reset" type="reset"  class="button" value="重新填写" /> </td><td></td>
</tr>
</table>
</form>
<p/>

  
<logic:empty name="EmployeeActionForm" property="list">
<tr>
	<td  colspan="6"><div align="center">
	<font color="red">无查询结果！</font></div>
	</td>
</tr>	
</logic:empty>
				
<logic:notEmpty name="EmployeeActionForm" property="list">
<table width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box">
	<tr class="title" >
				    <td width="75">员工编号</td>
				    <td width="97">姓名</td>
				    <td width="121">部门名称</td>
				    <td width="120">岗位名称</td>
				    <td width="121">联系电话</td>
				    <td width="121">电子邮件</td>
					<td width="121">&nbsp;</td>
  </tr>
					<logic:iterate id="em" name="EmployeeActionForm" property="list">
					<input type="hidden" name="em" value="${EmployeeActionForm.employee.id} ">
						<tr>
							<td >
								<bean:write name="em" property="em_number" />
							</td>
							<td >
								<bean:write name="em" property="em_name" />
							</td>
							<td >
								<bean:write name="em" property="dept_name" />
							</td>
							<td >
								<bean:write name="em" property="job_name" />
							</td>
							<td >
								<bean:write name="em" property="em_phone" />
							</td>
							<td >
								<bean:write name="em" property="em_mail" />
							</td>
							<td >
								<html:link page="/EmployeeActon.do?method=editEmployee" paramId="id" paramName="em" paramProperty="id">修改</html:link>
							</td>
						</tr>
					</logic:iterate>
					</table>
				</logic:notEmpty>


<table>
	<tr>
		<td height=13 colspan="6"  align="center">&nbsp; <br>&nbsp;
		</td>
	</tr><tr><td valign="top"><br></td><td valign="top"><br></td><td valign="top"><br></td><td valign="top"><br></td><td valign="top"><br></td><td valign="top"><br></td></tr>
</table>


</body>
</html>








