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
<script language=JavaScript src="js/script.js"></script>

<body >
<div id="container">
<div id="content">
<div id="content1">
当前位置:已离职人员查询
<div align="right"><html:link action="DomiAction.do?method=login">查询（在职）人员信息</html:link></div>
		<form action="DomiAction.do?method=lcha" method="post">
		<table  width="100%" align="center">
  <tr>
    <td align="center" >
	<span  style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">离职员工查询 
		<span id="hidden">[已隐藏]</span>
		<span  id="show"   style="display:none">[已显示]</span>
	</span></td>
  </tr>
  <table align="center" id="showselect" style="display:none" align="center" style="display:none" id="showselect"  class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
 	<tr>
				<td align="right">员工编号：</td>
				<td><input type="text" name="em_number"></td>
				<td align="center">员工姓名：</td>
				<td><input name="em_name" type="text"></td>
 	</tr>
	
    <tr>
				<td align="right">岗位名称：</td>
				<td><input type="text" name="job_name"></td>
				<td align="center">部门名称：</td>
				<td><input type="text" name="dept_name"></td>
	</tr>
	<tr>
				<td align="right">开始日期：</td>
				<td><input type="text" name="begin_date" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"></td>
				<td align="center">结束日期：</td>
				<td><input name="end_date" type="text" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"></td>
 	</tr>
 	<tr>
	<td align="right">离职类型：</td>
	<td>
	 <select name="lz_type">
	 <!--<option value="">不限</option>-->
      <logic:iterate name="typeList" id="s">
      <option value="<bean:write name="s" property="id"/>"> <bean:write name="s" property="code_value"/> </option>
      </logic:iterate>
	 
	 <!--    <option value="tn_null" selected="selected">1.不限</option>
	   <option value="tn_initiative ">2.主动辞职</option>
	   <option value="tn_dismissa">3.辞退</option>
	   <option value="tn_Retired">4.退休</option>
	   <option value="tn_Dismissed">5.开除</option>
	   <option value="tn_pass">6.试用期未通过</option> -->
	</select>
	</td>
	
 	</tr>
	
	<tr>
	<td  colspan="4" align="center"><input type="submit" class="button" value="查询" >
	    <input type="reset" class="button" value="重新填写" >
	</td>
	</tr>
  </table>
  </table>
  <p>
  
<logic:empty name="DomiForm" property="elist">
<tr>
	<td  colspan="6"><div align="center">
	<font color="red">无查询结果！</font></div>
	</td>
</tr>	
</logic:empty>
				
<logic:notEmpty name="DomiForm" property="elist">

<table width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" align="center" frame="box">
	<tr >
	  <td align="center">员工编号</td>
		<td align="center">员工姓名</td>
		<td align="center">部门名称</td>
		<td align="center">岗位名称</td>
		<td align="center">电话</td>
	</tr>
					<logic:iterate id="em" name="DomiForm" property="elist">
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
							
						</tr>
					</logic:iterate>
					</table>
				</logic:notEmpty>

  </form>
 
  </body>
  </html>