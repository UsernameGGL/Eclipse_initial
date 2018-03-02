<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"  %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/tn_css.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工部门调转</title>
</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
     function emplList(){
          history.go(-1);
 } 
      function changeDept(){
        if(document.getElementById("dept_chReason").value == "") {
			alert("调转原因不能为空！");
			document.getElementById("dept_chReason").focus();
			return;
		}
		if(document.getElementById("d11").value =="") {
			alert("调转日期不能为空！");
			document.getElementById("d11").focus();
			return;
		}
		
		with (document.getElementById("deptChangeForm")) {
			method = "post";
			submit();
		}
     }
</script>
  <body>

  <p>当前位置:部门调动管理&gt;&gt;<html:link action="deptchange.do?method=forwardEmplList">员工信息查询</html:link>;&gt;&gt;确认员工部门</p>
  <p>注：标有*的必填</p>
<form action="deptchange.do?method=addDeptChange" method="post" id="deptChangeForm">
  <table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
  <input type="hidden" name="id" value="<bean:write name="emp" property="id"/>"/>
  <input type="hidden" name="dept_number" value="<bean:write name="emp" property="dept_number"/>"/>
  <tr>
            <td colspan="4" align="center" >员工部门信息</td>
  </tr>
  
  <tr>
		    <td align="right">员工编号:</td>
		    <td align="left"><input type="text" name="em_number" value="<bean:write name="emp" property="em_number" />" readonly></td>
		    <td align="right">员工姓名:</td>
		    <td align="left"><input type="text" name="em_name" value="<bean:write name="emp" property="em_name" />" readonly></td>
  </tr>
  <tr>
		    <td align="right"><font color=red>*</font>调转后的部门:</td>
		    <td align="left">
		       <select name="dept_after" value="${emp.dept_number}">
		        <logic:iterate name="dept_nameList" id="deptChange">
		        <logic:equal name="deptChange" property="dept_number" value="${emp.dept_number}">
		           <option value="<bean:write name="deptChange" property="dept_number"/>" selected>
		            <bean:write name="deptChange" property="dept_name"/>
		           </option>
		        </logic:equal>
		        <logic:notEqual name="deptChange" property="dept_number" value="${emp.dept_number}">
		           <option value="<bean:write name="deptChange" property="dept_number"/>">
		            <bean:write name="deptChange" property="dept_name"/>
		           </option>
		      </logic:notEqual>
		        </logic:iterate>
		        </select>
		      </td>
    <td align="right"><font color=red>*</font>调转原因:</td>
    <td align="left"><input type="text" name="dept_chReason" id="dept_chReason"></td>
   
  </tr>
  <tr>
    <td align="right"><font color=red>*</font>调转类型:</td>
    <td align="left">
    <select name="dept_chType">
       <logic:iterate id="code" name="dept_chTypeList">
       <option value="<bean:write name="code" property="id"/>"><bean:write name="code" property="code_value"/></option>
       </logic:iterate></select></td>
    <td align="right"><font color=red>*</font>调动日期:</td>
    <td align="left"><input type="text" name="dept_chDate" id="d11" onClick="WdatePicker()"></td>
  </tr>
  <tr> 
    <td align="right">备注:</td>
      <td align="left"><textarea type="textarea" rows="2" cols="20" name="dept_chExtra" value=""></textarea></td>
      <td align="right" colspan="2">&nbsp;</td>
     </tr>
  
  <tr>
             <td align="center" colspan="4">
		            <input type="button" value="保存" onClick="changeDept()">
		            <input type="reset" value="重新填写">
		            <input type="button" value="返回" onclick="emplList()">
		      </td>
   
  </tr>
    </table>
   </form>
    
 </body>
</html>
