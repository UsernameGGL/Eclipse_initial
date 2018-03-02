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
      <script type="text/javascript">
      function addJob(){
        if (document.getElementById("job_number").value==""||document.getElementById("job_number").value=="0" ) {
			alert("岗位编号不能为空 或 0");
			document.getElementById("job_number").focus();
			return;
		 }
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
      <title>新增岗位</title>
   </head>
   <body topmargin="0">
      
          当前位置:
         <html:link action="job.do?method=getJobByID">岗位基本信息</html:link> &gt;&gt;
             新增岗位
         <p>注:标有*的必填</p>
        <html:form action="job.do?method=addJob" method="post" styleId="jobForm">   
         <table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
	        <tr>
		       <td align="center" colspan="4">新增岗位</td>
	        </tr>
	        <tr>
	           <td align="right"><font color=red>*</font>岗位编号：</td>	   
	           <td align="left"><input type="text" name="job_number" id="job_number"></td>
               <td align="right"><font color=red>*</font>岗位名称：</td>
               <td align="left"><input type="text" name="job_name" id="job_name"></td>
	        </tr>
	        <tr>
	           <td  align="right"><font color=red>*</font>岗位类型：</td>
	           <td align="left"><select name="job_type">
		                 <logic:notEmpty name="jobForm" property="codeList">
							<logic:iterate id="jobCode" name="jobForm" property="codeList">
			                <option value="<bean:write name="jobCode" property="code_value"/>"><bean:write name="jobCode" property="code_value"/></option>
			                </logic:iterate>
			               </logic:notEmpty>
		                 </select></td>
	           <td align="right">岗位编制人数：</td>
	           <td align="left"><input type="text" name="job_max"></td>
	        </tr>	
	        <tr>
		       <td align="center" colspan="4"><input type="button" class="button" value="保存" onclick="addJob()">		       
			   
			      <input type="reset" class="button"  value=" 重新填写 ">&nbsp;<INPUT type="button" class="button"  value=" 返回 " onclick="aa()">	
			   </td>
            </tr>
         </table>
      </html:form>
   </body>
</html>

