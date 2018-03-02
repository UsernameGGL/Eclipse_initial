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
<title>修改部门</title>
</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
     function deptList(){
          history.go(-1);
   } 
    function editDept(){
     if(document.getElementById("dept_number").value == "") {
			alert("部门编号不能为空！");
			document.getElementById("dept_number").focus();
			return;
		}
		if(document.getElementById("dept_name").value == "") {
			alert("部门名称不能为空！");
			document.getElementById("dept_name").focus();
			return;
		}
		if(document.getElementById("dept_tel").value == "") {
			alert("电话不能为空！");
			document.getElementById("dept_tel").focus();
			return;
		}
		if(document.getElementById("d11").value == "") {
			alert("成立日期不能为空!");
			document.getElementById("d11").focus();
			return;
		}
		with (document.getElementById("editDept")) {
			method = "post";
			submit();
		}
     }
</script>
<body>
<p>当前位置:<html:link action="dept.do?method=forwardDept">部门基本信息</html:link>&gt;&gt;修改部门</p>
<p>注：标有*的必填</p>

<form method="post" action="dept.do?method=editDept" id="editDept">
<table class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
<input type="hidden" name="id" value="<bean:write name="dept" property="id"/>"/>
  <tr>
          <td colspan="4" align="center">修改部门</td>
  </tr>
  <tr>
    <td align="right"><font color=red>*</font>部门编号:</td>
    <td align="left"><input type="text" name="dept_number" value="<bean:write name="dept" property="dept_number" />" id="dept_number"></td>
    <td align="right"><font color=red>*</font>部门名称:</td>
    <td align="left"><input type="text" name="dept_name" value="<bean:write name="dept" property="dept_name" />" id="dept_name"></td>
  </tr>
  <tr>
    <td align="right"><font color=red>*</font>部门类型:</td>
    
    <td align="left">
        <select name="dept_type" value="${dept.dept_type}">
        
         <logic:iterate name="dept_typeList" id="code">
         <logic:equal name="code" property="id" value="${dept.dept_type}"> 
                <option value="<bean:write name="code" property="id"/>" selected>
                <bean:write name="code" property="code_value"/></option>
         </logic:equal>
         <logic:notEqual name="code" property="id" value="${dept.dept_type}"> 
                <option value="<bean:write name="code" property="id"/>">
                <bean:write name="code" property="code_value"/></option>
         </logic:notEqual>
           </logic:iterate>
          </select></td>
    <td align="right"><font color=red>*</font>电话:</td>
    <td align="left"><input type="text" name="dept_tel" value="<bean:write name="dept" property="dept_tel" />" id="dept_tel"></td>
   
  </tr>
  
  <tr>
    <td align="right">传真:</td>
    <td align="left"><input type="text" name="dept_fax" value="<bean:write name="dept" property="dept_fax" />"></td>

    <td align="right">描述:</td>
    <td align="left"><input type="text" name="dept_desc" value="<bean:write name="dept" property="dept_desc" />"></td>
  </tr>
  <tr>
    <td align="right">上级部门:</td>
    <td align="left">
    <select name="dept_super" value="${dept.dept_super} ">
      <logic:iterate name="dept_superList" id="sup">
	          <logic:equal name="sup" property="dept_super" value="${dept.dept_super}"> 
		                <option value="<bean:write name="sup" property="dept_super"/>" selected>
		                <bean:write name="sup" property="dept_superName"/></option>
		      </logic:equal>
	          
	           <logic:notEqual name="sup" property="dept_super" value="${dept.dept_super}"> 
	                <option value="<bean:write name="sup" property="dept_super"/>">
	                <bean:write name="sup" property="dept_superName"/></option>
	           </logic:notEqual>    
           
                 
            </logic:iterate>
           </select></td>


    <td align="right"><font color=red>*</font>成立日期:</td>
    <td align="left"><input type="text" name="dept_setDate" value="<bean:write name="dept" property="dept_setDate"/>" id="d11" onClick="WdatePicker()"></td>
  </tr>
  <tr>
   <td align="center" colspan=4><input type="button" value="保存" class="button" onClick="editDept()">
   <input type="reset" value="重新填写" class="button" >
   <input type="button" value="返回" onClick="deptList()" class="button" ></td>
  </tr>
</table>
</form>
</body>
</html>
