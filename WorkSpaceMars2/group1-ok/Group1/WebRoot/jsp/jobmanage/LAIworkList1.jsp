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
      <link rel="stylesheet" type="text/css" href="css/tn_css.css" />
      <script language=JavaScript src="js/script.js"></script>
      <title>岗位基本信息</title>
   </head>
<script type="text/javascript">
function aa(){
 history.go(-1);
}
</script>
   
   <body topmargin="0" bottommargin="0">   
         <p align="center">岗位基本信息查询结果</p>
         <table width="100%" cellspacing="0" class="border">
	        <tr >	  
		       <td><div align="center">岗位编号</div></td>
		       <td><div align="center">岗位名称</div></td>
		       <td><div align="center">类型</div></td>
		       <td><div align="center">岗位编制</div></td>
		       <td><div align="center">在岗人数</div></td>
		       <td><div align="center">员工</div></td>
		       <td><div align="center">删除</div></td>		
	        </tr>
			<logic:empty name="jobForm" property="list">
				<tr>
					<td>
						<font color="red"></font>
					</td>
				</tr>	
			</logic:empty>
				
			<logic:notEmpty name="jobForm" property="list">
				<logic:iterate id="job" name="jobForm" property="list">
					<tr>
						<td align="center">
							<bean:write name="job" property="job_number"/>
						</td>
						<td align="center">
						   <html:link action="job.do?method=job" paramName="job" paramId="job_number" paramProperty="job_number" >
	                         <bean:write name="job" property="job_name" />
	                       </html:link>
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_type" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_max" />
                        </td>
                        <td align="center">
	                       <bean:write name="job" property="job_man" />
                        </td>
                        <td align="center">
	                       <html:link page="emp.do?method=editPrompt" paramId="job_number" paramName="job" paramProperty="job_number">员工</html:link>
                        </td>
                        <td align="center">
	                       <html:link action="job.do?method=delJob" paramId="job_number" paramName="job" paramProperty="job_number">删除</html:link>
                        </td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
		</table>
         <table>
	        <tr>
	           <td ><INPUT type="button" class="button"  value="返回" onClick="aa();"></td>
	        </tr>
         </table>
   </body>
</html>