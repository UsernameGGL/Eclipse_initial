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

<body >
<form action="DomiAction.do?method=zcha"  method="post">
<div id="container">
<div id="content">
<div id="content1">
当前位置:在职人员查询
<div align="right"><html:link action="DomiAction.do?method=gologin">查询（离职）人员信息</html:link></div>
   <table  width="100%" align="center">
  <tr>
    <td align="center" >
	<span  style="cursor:hand" onClick="dispTab2('showselect2','show2','hidden2',openitem)">员工信息查询 
		<span id="hidden2">[已隐藏]</span>
		<span  id="show2"   style="display:none">[已显示]</span>
	</span></td>
  </tr>
  <table  align="center" id="showselect2" style="display:none" align="center" style="display:none" id="showselect"  class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
  <tr class="title"><td colspan="4">员工信息查询</td></tr>
 	<tr>
	<td align="right">部门编号：</td>
	<td><input type="text" name="dept_number"></td>
	<td align="center">部门名称：</td>
	<td><input name="dept_name" type="text"></td>
 	</tr>
	
	<tr>
	<td align="right">用工形式：</td>
	<td>
	<select name="em_format" >
	  <option value="">不限</option>
      <logic:iterate name="emList" id="s">
      <option value="<bean:write name="s" property="id"/>"> <bean:write name="s" property="code_value"/> </option>
      </logic:iterate>
     </select>
   <!--<select><option >1.不限</option><option>2.正式</option><option>3.试用</option></select> -->
	</td>
	<td align="center">员工编号：</td>
	<td><input type="text" name="em_number"></td>
	</tr>
	<tr>
	<td  colspan="4" align="center"><input type="submit" class="button" value="查询" >
	             <input type="reset" class="button" value="重新填写" >
	</td>
	</tr>
  </table>
    </table>
    </div>
  </div>
</div>
<p>

<logic:empty name="DomiForm" property="elist">
<p>
<tr>
	<td  colspan="6"><div align="center">
	<font color="red">无查询结果！</font></div>
	</td>
</tr>	
</logic:empty>
				
<logic:notEmpty name="DomiForm" property="elist">
<table width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box">
	<tr >
	  <td ><div align="left">员工编号</div></td>
		<td align="center">员工姓名</td>
		<td align="center">部门名称</td>
		<td align="center">岗位名称</td>
		<td align="center">电话</td>
		<td align="center">离职</td>
	</tr>
					<logic:iterate id="em" name="DomiForm" property="elist">
					<input type="hidden" name="id" value="<bean:write name="em" property="id"/>">
					<input type="hidden" name="id" value="<bean:write name="em" property="em_number"/>">
					<input type="hidden" name="id" value="<bean:write name="em" property="dept_number"/>">
					<input type="hidden" name="id" value="<bean:write name="em" property="dept_name"/>">
					<input type="hidden" name="id" value="<bean:write name="em" property="em_name"/>">
						<tr>
							<td align="center">
								<bean:write name="em" property="em_number" />
							</td>
							<td align="center">
								<bean:write name="em" property="em_name" />
							</td>
							<td align="center">
								<bean:write name="em" property="dept_name" />
							</td>
							<td align="center">
								<bean:write name="em" property="job_name" />
							</td>
							<td align="center">
								<bean:write name="em" property="em_phone" />
							</td>
							<td align="center">
								<html:link page="/DomiAction.do?method=lzc" paramId="id" paramName="em" paramProperty="id">离职</html:link>
							</td>
						</tr>
					</logic:iterate>
					</table>
				</logic:notEmpty>

</form>
</body>
</html>