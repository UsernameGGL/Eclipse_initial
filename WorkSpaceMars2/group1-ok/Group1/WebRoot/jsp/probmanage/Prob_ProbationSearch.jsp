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
  <title>试用期信息</title>
</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
     function probationList(){
          history.go(-1);
 } 
 
	function display(id,id1){
			var tar=document.getElementById(id);
			var t2=document.getElementById(id1);
			if(t2.selected){
				tar.style.display="";
			}else{
				tar.style.display="none";
			}	
		} 
	function emplRev(){
		if(document.getElementById("d11").value=="") {
			alert("处理日期不能为空！");
			document.getElementById("d11").focus();
			return;
		}
		if(document.getElementById("reviews").value=="") {
			alert("考核评语不能为空！");
			document.getElementById("reviews").focus();
			return;
		}
		with (document.getElementById("revForm")) {
			method = "post";
			submit();
		} 
	}	
	
</script> 
<body>
<p>当前位置:<html:link action="ProbationAction.do?method=forwardProbationList">试用期员工查询</html:link>&gt;&gt;试用期信息确认<p>
<p>注：标有*的必填</p>
<form action="ProbationAction.do?method=editProbation" method="post" id="revForm">

<table  class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center" >
   <input type="hidden" name="id" value="<bean:write name="employee" property="id"/>">
   <tr>
			<td align="right">员工编号：</td>
			<td align="left"><input name="em_number" type="text" value="<bean:write name="employee" property="em_number"/>" readonly/></td>
			<td align="right">姓    名：</td>
			<td align="left"><input name="em_name" type="text"  value="<bean:write name="employee" property="em_name"/>" readonly/></td>
   </tr>
  <tr>
			<td align="right">部门名称：</td>
			<td align="left"><input name="dept_name" type="text"  value="<bean:write name="employee" property="dept_name"/>" readonly/></td>
			<td align="right">岗位名称：</td>
			<td align="left"><input name="job_name" type="text"  value="<bean:write name="employee" property="job_name"/>" readonly/></td>
  </tr>

  <tr>
		   <td align="right"><font color=red>*</font>考核结果：</td>
		   <td align="left">
		   <select name="prob_results" onChange="display('td','a2')">
		                     <logic:iterate name="codeList" id="code">
		                     <logic:notEqual name="code" property="id" value="32">
		                         <option value="<bean:write name="code" property="id"/>">
		                         <bean:write name="code" property="code_value"/></option>
		                      </logic:notEqual>
		                      <logic:equal name="code" property="id" value="32">
		                         <option value="<bean:write name="code" property="id"/>"  id="a2">
		                         <bean:write name="code" property="code_value"/></option>
		                      </logic:equal>
		                      </logic:iterate>
				      </select> 
		       
		   </td>
		    <td width="430" id="td" style="display:none" align="center" colspan="2">延期到:
          <input type="text" onClick="fPopCalendar(event,this,this)" onFocus="this.select()"  name="extend_date" /></td>   
		   
  </tr>
  <tr>      
            
            <td align="right"><font color=red>*</font>处理日期：</td>
            <td align="left"><input name="prob_date" type="text" id="d11" onClick="WdatePicker()"/> </td>
			<td align="right" >备注：</td>
			<td align="left"><textarea name="prob_notes" ></textarea></td>
			
  </tr>
	<tr>
	         
	         <td align="right"><font color=red>*</font>考核评语：</td>
			<td align="left"><textarea name="prob_reviews"  id="reviews"></textarea></td>
			<td align="right" colspan="2">&nbsp;</td>
			
	</tr>
  <tr>
           <td align="center" colspan="4"><input type="button"  value="保存" onClick="emplRev()"/>
					<input name="reset" type="reset"  class="button" value="重新填写"/>
					<input type="reset" value="返回" class="button" onclick="probationList()">
		   </td>
  </tr>
</table >

</form>
  </body>
</html>
