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
      <title>岗位基本信息</title>
      
   </head>
   
  
   <script type="text/javascript">
   
	
   </script>
   <body topmargin="0" bottommargin="0">
         
         <p>当前位置:岗位基本信息</p>
         
         <html:form action="job.do?method=listJob" method="post">
         
            <table  width="100%" align="center">
            
               <tr>
                  <td align="center" >
	                 <span  style="cursor:hand" onClick="dispTab('showselect','show','hidden',openitem)">岗位信息查询
	                    <span id="hidden"  color:#0088CC>[已隐藏]</span>
	                    <span  id="show"   style="display:none" >[已显示]</span>
	                 </span>
	              </td>
               </tr>
            </table>     
	           <table  align="center" style="display:none" id="showselect" 
	                 class='TableQueryClass' borderColorDark="#F3FBF0"
		             borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
		          <tr>
	                 <td align="center">岗位编号：
	                 <input name="job_number" type="text" value=""></td>
	                 <td align="center">岗位名称：
	                 <input name="job_name" type="text"></td>
		          						              
	                 <td align="center">岗位类型：
	                 <select name="job_type">
	                 <option>不限</option>
		                 <logic:notEmpty name="jobForm" property="codeList">
							<logic:iterate id="jobCode" name="jobForm" property="codeList">
			                <option value="<bean:write name="jobCode" property="code_value"/>"><bean:write name="jobCode" property="code_value"/></option>
			                </logic:iterate>
			               </logic:notEmpty>
		                 </select></td>
	                    
	              </tr>
	           
				<tr>
				    <td colspan=3 class="DataTitle">&nbsp;</td>
			    </tr>
	              <tr>
	                 <td  colspan="3" align="center">
	                    <input type="submit" class="button" value="查询">
	                    <input type="reset" class="button"  value="重新填写"></td>
	              </tr>
	             
	             </table>
                       
         </html:form>
   
	        <logic:empty name="jobForm" property="list">
				<tr>
							<td><div align="center">
								<font color="red">无查询结果！</font></div>
							</td>
				</tr>
			</logic:empty>
				
			<logic:notEmpty name="jobForm" property="list">
			<table  width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box">
	        <tr >	  
		       <td><div align="center">岗位编号</div></td>
		       <td><div align="center">岗位名称</div></td>
		       <td><div align="center">类型</div></td>
		       <td><div align="center">岗位编制</div></td>
		       <td><div align="center">在岗人数</div></td>
		       <td><div align="center">员工</div></td>
		       <td><div align="center">删除</div></td>		
	        </tr>
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
	                       <html:link action="jobEmployeeActon.do?method=listEmployees" paramId="job_number" paramName="job" paramProperty="job_number">员工</html:link>
                        </td>
                        <td align="center">
	                       <html:link action="job.do?method=delJob" paramId="job_number" paramName="job" paramProperty="job_number">删除</html:link>
                        </td>
					</tr>
				</logic:iterate>
				</table>
			</logic:notEmpty>
								
        
                
	        <tr><html:form action="job.do?method=add">   
	            <td ><INPUT type="submit" class="button"  value="增加"></td>
	        </html:form></tr>	        
        
	      <SCRIPT type="text/javascript">
				var showMsg='<%=request.getAttribute("showAlert")%>';
						if(showMsg!="null"&&showMsg!=""){
						alert(showMsg);
						document.all.query.click();
						}
		  </SCRIPT>	  
   </body>

</html>
