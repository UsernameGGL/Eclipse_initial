<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/tn_css.css" type="text/css">
    <title>试用期员工查询</title>
    
  </head>
  <script language=JavaScript src="js/script.js"></script>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
   
<body >
当前位置:试用期员工查询<br>
<div align="right"><html:link action="ProbationAction.do?method=forwardProbationedList">已经转正员工查询</html:link></div>


<div align="right"></div>
<br>
<form  action="ProbationAction.do?method=findProbationList" method="post" id="listProForm">
  <table  width="100%" align="center" >
  <tr>
    <td align="center" >
	<span  style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">试用期查询 
		<span id="hidden">[已隐藏]</span>
		<span  id="show" style="display:none">[已显示]</span>
	</span></td>
  </tr>
  </table>
  <table class='TableQueryClass' borderColorDark="#F3FBF0" align="center"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 style="display:none" id="showselect">
    <tr> 
		<td align="right"> 员工编号：</td><td ><input name="em_number" type="text"  /></td>
		<td align="center">姓    名：</td><td><input name="prob_name" type="text"  /></td>
   </tr>

   <tr>
		<td align="right">部门名称：</td><td><input name="Prob_branchName" type="text" /></td>
		<td align="center">岗位名称：</td><td><input name="Prob_jobName" type="text" /></td>
   </tr>

   <tr>
	   <td align="right">开始日期：</td><td><input name="prob_start" type="text" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/></td>
	   <td align="center">结束日期：</td> <td><input name="prob_end" type="text" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"/></td> 
   </tr>

  <tr>
	     <td colspan="4" align="center"><input type="submit"  class="button" value="查询" />
	         <input name="reset" type="reset"  class="button" value="重新填写"/>
	     </td>
  </tr>

</table>
<p>
  <logic:empty name="ProbationList" >
<tr>
	<td>
	     <div align="center">
			<font color="red">无查询结果！</font></div>
	</td>
</tr>	
</logic:empty>
				
<logic:notEmpty name="ProbationList">
     <table id="DetailScrollTable"  borderColorDark="#F3FBF0"

		borderColorLight="#999999" border="1" cellPadding="0" cellspacing="0" frame="box" width="100%" align="center">

    <tr>

		    <td align="center">员工编号</td>
		    <td align="center">姓名</td>
		    <td align="center">部门名称</td>
		    <td align="center">岗位名称</td>
		    <td align="center">开始日期</td>
		    <td align="center">结束日期</td>
		    <td align="center">&nbsp;</td>


    </tr>
					<logic:iterate id="prob" name="ProbationList">
						<tr>
							<td align="center">
								<bean:write name="prob" property="em_number" />
							</td>
							<td align="center">
								<bean:write name="prob" property="em_name" />
							</td>
							<td align="center">
								<bean:write name="prob" property="dept_name" />
							</td>
							<td align="center">
								<bean:write name="prob" property="job_name" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_start" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_end" />
							</td>
							<td align="center">
								<html:link page="/ProbationAction.do?method=Probationedit" paramId="id" paramName="prob" paramProperty="id">对员工评价</html:link>
							</td>
						</tr>
					</logic:iterate>
					 </table>
				</logic:notEmpty>   

</form>
</body>
</html>
