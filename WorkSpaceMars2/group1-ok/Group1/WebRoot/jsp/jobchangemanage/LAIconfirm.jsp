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
      <title>岗位调动</title>
   </head>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	function addJobCh(){
        if(document.getElementById("d11").value=="")
		  {
		  alert("调转日期不能为空！");
		  document.getElementById("d11").focus();
		  return ;
		  }
		with (document.getElementById("jobForm")) {
			method = "post";
			submit();
		}
	 }
	
	function aa(){
		 history.go(-1);
		}
	</script>

   <body>
      <html:form action="jobChList.do?method=addJobCh" method="post" styleId="jobForm">
         <p>当前位置:岗位调动管理&gt;&gt;<html:link action="jobChList.do?method=forwardEmplList">员工信息查询</html:link>&gt;确认员工岗位</p>
         <table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
       
            <tr>
               <td colspan="4" align="center" cellpadding="0" cellspacing="0">员工岗位信息</td>
            </tr>
            <tr>
               <td align="right">员工号:</td>
               <td align="left"><input type="text" name="emp_number" value="<bean:write name="employee" property="em_number"/>" readonly></td>
               <td align="right">员工姓名:</td>
               <td align="left"><input type="text" name="emp_name" value="<bean:write name="employee" property="em_name"/>" readonly></td>
            </tr>
            <tr>
               <td align="right">调转后的岗位:</td>
               <td align="left">
                  <select name="job_chName" value="${employee.job_number}">					
					<logic:iterate name="job_nameList" id="job">
					  <logic:equal name="job" property="job_number" value="${employee.job_number}">
						<option value="<bean:write name="job" property="job_name"/>" selected>
						<bean:write name="job" property="job_name"/></option>
					  </logic:equal> 
					  <logic:notEqual name="job" property="job_number" value="${employee.job_number}">
					    <option value="<bean:write name="job" property="job_name"/>">
						<bean:write name="job" property="job_name"/></option>
					  </logic:notEqual>          
					</logic:iterate>	  
				   </select>
               </td>
               <td align="right">调转原因:</td>
               <td align="left">
                  <input type="text" name="job_chReason" value="">
               </td>  
            </tr>
            <tr>
               <td align="right">调转类型:</td>
               <td align="left">
					<select name="job_chType">
						<logic:notEmpty name="jobForm" property="codeList">
						<logic:iterate id="jobCode" name="jobForm" property="codeList">
						<option value="<bean:write name="jobCode" property="code_value"/>"><bean:write name="jobCode" property="code_value"/></option>
						</logic:iterate>
						<option value="">不限</option>
						</logic:notEmpty>
					</select>
               </td>
               <td align="right"><font color=red>*</font>调动日期:</td>
               <td align="left"><input type="text" name="job_chDate" id="d11" onClick="WdatePicker()"></td>
            </tr>
            <tr> 
               <td align="right">备注:</td>
               <td align="left"><textarea type="textarea" rows="2" cols="20" name="job_chExtra" value=""></textarea></td>
               <td align="right" colspan="2">&nbsp;</td>
            </tr>  
            <tr>
               <td align="center" colspan="4"><input type="button" value="保存" class="button" onclick="addJobCh()">
               <input type="reset" value="重新填写" class="button"> <input type="reset" value="返回" class="button" onClick="aa()"></td>
               
            </tr>
         </table>
      </html:form>
   </body>
</html>