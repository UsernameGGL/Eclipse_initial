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
		<title>已调员工查询</title>
		
	</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	
	<body>
		<p>当前位置:岗位调动管理&gt;&gt;已调动岗位员工信息查询<br>
		<div align="right"><html:link action="jobChList.do?method=forwardEmplList">员工信息查询</html:link></div>
		
		 <table align="center">
			  <tr>
			    <td align="center" >
					<span style="cursor:hand" onClick="dispTab2('showselect2','show2','hidden2',openitem)">已调动岗位员工信息查询 
						<span id="hidden2">[已隐藏]</span>
						<span  id="show2" style="display:none" >[已显示]</span>
				    </span>
				</td>
			  </tr>
		  </table>
		  <html:form method="post" action="jobChList.do?method=listChEmp" styleId="jobForm">
		  <table align="center" style="display:none" id="showselect2" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
			  <tr>
				<td align="right">开始日期：</td><td><input type="text" name="job_startDate" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"></td>
			    <td align="center">结束日期：</td><td><input name="job_endDate" type="text" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"></td>
		 	  </tr>
			  <tr>
			     <td align="right">员工编号：</td><td><input type="text" name="emp_number"></td>
			     <td align="center">员工姓名：</td><td><input name="emp_name" type="text"></td>
		 	  </tr>
			  <tr>
			     <td align="right" >调动类型：</td>
			     <td>
					<select name="job_chType">
		                 <logic:notEmpty name="jobForm" property="codeList">
		                 <option value="">不限</option>
							<logic:iterate id="jobCode" name="jobForm" property="codeList">
			                <option value="<bean:write name="jobCode" property="code_value"/>"><bean:write name="jobCode" property="code_value"/></option>
			                </logic:iterate>
			               </logic:notEmpty>
		                 </select></td>    
			  </tr>
			  <tr>
		        <td colspan="4" align="center">
				        <input type="submit" value="查询" class="button" onclick="listJobCh()">
				        <input type="reset" value="重新填写" class="button">
		        </td>
		      </tr>
		  </table>
		 </html:form>
		 
		

<logic:empty name="jobChForm" property="list">
<tr>
	<td  colspan="6"><div align="center">
	<font color="red">无查询结果！</font></div>
	</td>
</tr>	

</logic:empty>	
		  <logic:notEmpty name="jobChForm" property="list">
<table id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" width="100%">
		    <tr>
			    <td align="center">员工号</td>
				<td align="center">姓名</td>
			    <td align="center">现岗位名称</td>
			    <td align="center"> 调动原因</td>
			    <td align="center">调动类型</td>
			    <td align="center">调动日期</td>
			    <td align="center">备注</td>
		  </tr>
				<logic:iterate id="job" name="jobChForm" property="list">
				
					<tr>
						<td align="center">
							<bean:write name="job" property="emp_number"/>
						</td>
						<td align="center">
						   <bean:write name="job" property="emp_name"/>
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_chName" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_chReason" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_chType" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_chDate" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_chExtra" />
                        </td>
					</tr>
				</logic:iterate>
					</table>
			</logic:notEmpty>
	
	</body>
</html>