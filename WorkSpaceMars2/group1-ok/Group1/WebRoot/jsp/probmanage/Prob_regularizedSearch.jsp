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
    <title>已转正查询</title>
  </head>
<script language=JavaScript src="js/script.js"></script> 
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>

<body>
当前位置:已转正员工信息查询<br>
<div align="right"><html:link action="ProbationAction.do?method=forwardProbationList">试用期员工查询</html:link></div>

<br>
 <html:form  action="ProbationAction.do?method=findProbationedList" method="post" styleId="probedListForm">
  <table  width="100%" align="center"  >
  <tr>
    <td align="center" >
	<span  style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">已转正员工查询 
		<span id="hidden">[已隐藏]</span>
		<span  id="show" style="display:none">[已显示]</span>
	</span></td>
  </tr>
  </table>
  <table class='TableQueryClass' borderColorDark="#F3FBF0" align="center"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 id="showselect"  style="display:none" >
   <tr class="title" > 

   <tr>
				<td align="right">员工编号：</td>
				<td><input name="em_number" type="text" /></td>
				<td align="center">员工姓名：</td>
				<td><input name="em_name" type="text" /></td>
   </tr>
   <tr>
			   <td align="right">部门编号：</td>
			   <td><input name="dept_number" type="text" /></td>
			   <td align="center">部门名称：</td>
			   <td><input name="dept_name " type="text" />
   </tr>
   <tr>
			   <td align="right">开始日期：</td>
			   <td><input name="prob_startDate" type="text" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/></td>
			   <td align="center">结束日期：</td>
			   <td><input name="prob_endDate" type="text" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"/>
   </tr>


  <tr>
			    <td  colspan="4" align="center"><input  type="submit"  class="button"  value="查询" />
				    <input name="reset" type="reset"  class="button" value="重新填写"/>
		      </td>
 </tr>

</table>
<p>
   <logic:empty name="probationList" >
        <tr>
				<td  colspan="6"><div align="center">
				<font color="red">无查询结果！</font></div>
				</td>
       </tr>	
</logic:empty>
								
<logic:notEmpty name="probationList">
     <table  width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" align="center" frame="box">
	         <tr>
				    <td align="center">员工编号</td>
				    <td align="center">员工姓名</td>
				    <td align="center">部门名称</td>
				    <td align="center">岗位名称</td>
				    <td align="center">处理日期</td>
				    <td align="center">考核评语</td>
				    <td align="center">备注</td>
   
             </tr>
					<logic:iterate id="prob" name="probationList">
		     <tr>
							<td align="center">
								<bean:write name="prob" property="em_number" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_name" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_branchName" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_jobName" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_date" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_reviews" />
							</td>
							<td align="center">
								<bean:write name="prob" property="prob_notes" />
							</td>		
		    </tr>
		</logic:iterate>				
	 </table>
   </logic:notEmpty>
</html:form>

</body>
</html>
