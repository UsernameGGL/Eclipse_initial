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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function aa(){
 history.go(-1);
}
function xz()
{
   
if(document.form.lz_date.value=="")
	 {
	 alert("离职时间不能为空！");
	 document.form.lz_date.focus();
	 return;
	 }
	 
 with (document.form) 
		{
		 method = "post";
		 submit();
		}
}

</script>

<body >
<form action="DomiAction.do?method=que" method="post" name="form">
<p>
<input name="id" type="hidden" value="${DomiForm.employee.id}">
当前位置:离职信息<br><br>

<table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">

<tr>
			<td align="right">部门编号：</td>
			<td align="left">${DomiForm.employee.dept_number} </td>
			<td align="right">部门名称：</td>
			<td align="left">${DomiForm.employee.dept_name}</td>
</tr>

<tr>
			<td align="right">员工编号：</td>
			<td align="left">${DomiForm.employee.em_number}</td>
			<td align="right">员工姓名：</td>
			<td align="left">${DomiForm.employee.em_name}</td></tr>

<tr>
			<td align="right">离职日期：</td>
			<td align="left"><input name="lz_date" type="text" id="d11" onClick="WdatePicker()"/></td>
			<td align="right">离职类型：</td>
			<td align="left">
			<select name="lz_type">
			      <logic:iterate name="typeList" id="s">
			      <option value="<bean:write name="s" property="id"/>"> <bean:write name="s" property="code_value"/> </option>
			      </logic:iterate>
			     </select>
			<!--  <select name="tn_separationType" >
			 <option value="tn_initiative ">主动辞职</option>
			 <option value="tn_dismissa">1.辞退</option>
			 <option value="tn_Retired">2.退休</option>
			 <option value="tn_Dismissed">3.开除</option>
			 <option value="tn_pass">4.试用期未通过</option>
			 </select>  -->
			</td>
</tr>
			 
<tr>
			<td align="right">离职去向：</td>
			<td align="left"><input name="lz_go" type="text" />  </td>
			<td align="right">备注：</td>
			<td align="left"><textarea name="lz_extra"></textarea></td>
			</tr>
<tr>

			<td align="center" colspan="4"><input class="button" name="OK" type="button" value="确定" onclick="xz()"/>
			    <input class="button" name="重新填写" type="reset" value="重新填写"/>&nbsp;<INPUT type=button class="button"  value="返回" onClick="aa()"></td>
</tr>
<!-- <input class="button" type="button" value="返回" onClick="go_back();">  -->
</table >
</form>
</body>
</html>