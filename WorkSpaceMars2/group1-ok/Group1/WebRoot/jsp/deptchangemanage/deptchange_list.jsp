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
<title>已调动员工信息查询</title>
</head>

<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<body>
当前位置:部门调动管理&gt;&gt;已调动部门员工信息查询<br>
<div align="right"><html:link action="deptchange.do?method=forwardEmplList">员工信息</html:link></div>
<form method="post" action="deptchange.do?method=listDeptChange" id="deptChangedForm">
 <table align="center">
  <tr>
    <td align="center" >
	<span style="cursor:hand" onClick="dispTab2('showselect2','show2','hidden2',openitem)">已调动部门员工信息查询 
		<span id="hidden2">[已隐藏]</span>
		<span  id="show2" style="display:none" >[已显示]</span>
	</span></td>
  </tr>
  </table>

  <table align="center" style="display:none" id="showselect2" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
  <tr>
			<td align="right">开始日期：</td><td><input type="text" name="dept_startDate" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"></td>
			<td align="center">结束日期：</td><td><input name="dept_endDate" type="text" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"></td>
 </tr>
 <tr>
			<td align="right">员工编号：</td><td><input type="text" name="em_number"></td>
			<td align="center">员工姓名：</td><td><input name="em_name" type="text"></td>
 </tr>
 <tr>
	        <td align="right" >调动类型：</td>
	        <td>
				  <select name="dept_chType">
				         <option value="0">不限</option>
				         <logic:iterate id="code" name="dept_chTypeList">
				         <option value="<bean:write name="code" property="id"/>">
				         <bean:write name="code" property="code_value"/></option>   
				      </logic:iterate>
			            
				   </select></td>    
 </tr>
	<tr>
    <td align="center" colspan="4">
        <input type="submit" value="查询" id="click" onClick="listDeptChanged()">
        <input type="reset" value="重新填写">
    </td>
  </tr>
  </table>
  <p>
<logic:empty name="deptChangeList">
				<tr>
					<td>
					<div align="center"><font color="red">无查询结果！</font></div>
					</td>
				</tr>
</logic:empty>	
<logic:notEmpty name="deptChangeList">
   <table id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border="1" cellPadding="0" cellspacing="0" frame="box" width="100%" align="center">
  <tr>
    <td width="6%" align="center">员工号</td>
	<td width="10%" align="center">姓名</td>
	<td width="13%" align="center">原部门名称</td>
    <td width="13%" align="center">新部门名称</td>
    <td width="14%" align="center">调动原因</td>
    <td width="13%" align="center">调动类型</td>
    <td width="9%" align="center">调动日期</td>
    <td width="9%" align="center">备注</td>
  </tr>
   <logic:iterate id="deptChange" name="deptChangeList">
  <tr>
    <td align="center"><bean:write name="deptChange" property="em_number"/></td>
	<td align="center"><bean:write name="deptChange" property="em_name"/></td>
	<td align="center"><bean:write name="deptChange" property="dept_oldName"/></td>
    <td align="center"><bean:write name="deptChange" property="dept_newName"/></td>   
    <td align="center"><bean:write name="deptChange" property="dept_chReason"/></td>
    <td align="center"><bean:write name="deptChange" property="dept_chValue"/></td>
    <td align="center"><bean:write name="deptChange" property="dept_chDate"/></td>
    <td align="center"><bean:write name="deptChange" property="dept_chExtra"/></td>
  </tr>
 </logic:iterate>
</table>
</logic:notEmpty>
</form>
<SCRIPT type="text/javascript">
        var showMsg='<%=request.getAttribute("showAlert")%>';
		if(showMsg!="null"&&showMsg!=""){
		alert(showMsg);
		document.all.click.click();
		}
</SCRIPT>
</body>
</html>
