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
      <title>修改岗位</title>
   </head>
<script type="text/javascript">
function editJob(){
		if (document.getElementById("job_name").value=="" ) {
			alert("岗位名称不能为空");
			document.getElementById("job_name").focus();
			return;
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
      <html:form action="job.do?method=editJob" method="post" styleId="jobForm">当前位置:
         <html:link action="job.do?method=getJobByID">岗位基本信息</html:link>&gt;&gt;修改岗位
             <p>注:标有*的必填<p>
             
         <table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">	
           <logic:notEmpty name="jobForm" property="list">
			 <logic:iterate id="job" name="jobForm" property="list">
			 <tr>
		       <td align="center" colspan="4">修改岗位</td>
	        </tr>
	        <tr>
	           <td align="right"><font color=red>*</font>岗位编号：</td>
               <td align="left"><INPUT type="text" name="job_number" value="<bean:write name="job" property="job_number" />" readonly="readonly" id="job_number"></td>
              
               <td align="right"><font color=red>*</font>岗位名称：</td>
               <td align="left"><INPUT type="text" name="job_name" value="<bean:write name="job" property="job_name" />" id="job_name"></td>
	        </tr>
	        <tr>
	           <td align="right" ><font color=red>*</font>岗位类型：</td>
	           <td align="left">
	              <select name="job_type" value="${jobForm.job.job_type}" >	                 
						<logic:iterate id="jobCode" name="jobForm" property="codeList">
						  <logic:equal name="jobCode" property="code_value" value="${jobForm.job.job_type}">
		                <option value="<bean:write name="jobCode" property="code_value"/>" selected><bean:write name="jobCode" property="code_value"/></option>
		                  </logic:equal>
		                  <logic:notEqual name="jobCode" property="code_value" value="${jobForm.job.job_type}">
		                <option value="<bean:write name="jobCode" property="code_value"/>"><bean:write name="jobCode" property="code_value"/></option>  
		                  </logic:notEqual>
		                </logic:iterate>			         
	              </select>
	           </td>
          
	           <td align="right">岗位编制人数：</td>
	           <td align="left"><input type="text" name="job_max" value="<bean:write name="job" property="job_max" />"></td>
	        </tr>
	         </logic:iterate>
	      </logic:notEmpty>
	        <tr>
		       <td align="center" colspan="4"><input type="button" class="button"  value=" 保存 " onclick="editJob()">
			      <input type="reset" class="button"  value=" 重新填写 "><INPUT type=button class="button"  value=" 返回 " onClick="aa()">
			   </td>
                     
	        </tr>
         </table>
      </html:form>
   </body>
</html>

