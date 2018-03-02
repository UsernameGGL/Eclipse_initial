<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/tn_css.css" />
<title>Insert title here</title>
</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function xz()
{
   
if(document.form.em_number.value=="")
  {
  alert("员工编号不能为空！");
  document.form.em_number.focus();
  return ;
  }
  
if(document.form.em_name.value=="")
  {
  alert("姓名不能为空！");
  document.form.em_name.focus();
  return ;
  }
  
if(document.form.em_birth.value=="")
  {
  alert("生日不能为空！");
  document.form.em_birth.focus();
  return ;
  }
  
if(document.form.em_indate.value=="")
  {
  alert("入职日期不能为空！");
  document.form.em_indate.focus();
  return ;
  }
  
if(document.form.em_worktime.value=="")
  {
  alert("参加工作时间不能为空！");
  document.form.em_worktime.focus();
  return ;
  }  
  
if(document.form.em_id.value=="")
  {
  alert("身份证不能为空！");
  document.form.em_id.focus();
  return ;
  } 
  
 with (document.form) 
 {
  method = "post";
  submit();
 }
}
</script>

<body>
<p>当前位置:信息修改</p>
<form action="EmployeeActon.do?method=saveEmployees" method="post" name="form">
<p>注：标有*的必填</p>
<table   width="100%" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
<tr>
<input type="hidden" name="id" value="${EmployeeActionForm.employee.id}">
<td align="right" ><font color=red>*</font>员工编号</td>
<input type="hidden" name="em_number" value="${EmployeeActionForm.employee.em_number}">
<td> ${EmployeeActionForm.employee.em_number}</td>
<td align="right"><font color=red>*</font>姓名 </td><td><input type="text" name="em_name" value="${EmployeeActionForm.employee.em_name}"></td>
<td align="right"><font color=red>*</font>性别</td>
<td> <select name="sex" value="${EmployeeActionForm.employee.sex}">
      <logic:iterate name="sexList" id="s">
        <logic:equal name="s" property="id" value="${EmployeeActionForm.employee.sex}">
      <option value="<bean:write name="s" property="id"/>" selected> <bean:write name="s" property="code_value"/> </option>
        </logic:equal>
        
         <logic:notEqual name="s" property="id" value="${EmployeeActionForm.employee.sex}">
      <option value="<bean:write name="s" property="id"/>"> <bean:write name="s" property="code_value"/> </option>
        </logic:notEqual>
      </logic:iterate>
     </select>
</td>
<!--  <td align="right">*   性别</td><td><select  name="sex"> <option value="n" selected>1:男</option><option value="v">2:女</option></select></td>-->

</tr>

<tr>
<td align="right"><font color=red>*</font>出生日期 </td>
<td><input type="text" name="em_birth" value="${EmployeeActionForm.employee.em_birth}" id="d11" onClick="WdatePicker()"></td>
<td align="right"><font color=red>*</font>身份证号 </td>
<td><input type="text" name="em_id" value="${EmployeeActionForm.employee.em_id}"></td><td align="right"></td><td><br></td>
</tr>

<tr>
<td align="right"><font color=red>*</font>入职日期 </td>
<td><input type="text" name="em_indate" value="${EmployeeActionForm.employee.em_indate}" id="d11" onClick="WdatePicker()"></td>
<td align="right"><font color=red>*</font>参加工作时间</td><td><input type="text" name="em_worktime" value="${EmployeeActionForm.employee.em_worktime}" id="d11" onClick="WdatePicker()"></td>
<td align="right"><font color=red>*</font>用工形式</td>
<td> <select name="em_format" value="${EmployeeActionForm.employee.em_format}">
      <logic:iterate name="em_formatList" id="f">
      	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_format}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_format}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>

      </logic:iterate>
     </select>
</td>

<!-- <td><select  name="em_format"> <option value="zs" selected>1:正式员工</option><option value="ls">2:临时员工</option></select></td>-->

</tr>

<tr>
<td align="right"><font color=red>*</font>人员来源</td>
<td>
<select name="em_source" value="${EmployeeActionForm.employee.em_source}">
      <logic:iterate name="em_sourceList" id="f">
      	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_source}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_source}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
</td>
<!--  <td><select  name="em_source"> <option value="xy" selected>1:校园招聘</option><option value="sh">2:社会招聘</option><option value="qt1" selected>3:其他</option></select></td>-->
<td align="right"><font color=red>*</font>政治面貌</td>
<td>
<select name="em_polity" value="${EmployeeActionForm.employee.em_polity}">
      <logic:iterate name="em_polityList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_polity}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_polity}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
</td>
<!--   <td><select  name="em_polity"> <option value="dy" selected>1:党员</option><option value="yb" >2:预备党员</option><option value="sh">3:团员</option><option value="qt2" >4:其它</option></select></td> -->

<td align="right"><font color=red>*</font>民族</td>
<td>
<select name="em_folk" value="${EmployeeActionForm.employee.em_folk}">
      <logic:iterate name="em_folkList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_folk}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_folk}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
</td>
<!--  <td><select  name="em_folk"> <option value="hz" selected>1:汉族</option><option value="mz">2:满族</option><option value="zz1" >3:壮族</option></select></td>-->

</tr>


<tr><td align="right">籍贯 </td>
<td><input type="text" name="em_birthplace" value="${EmployeeActionForm.employee.em_birthplace}"></td>
<td align="right">联系电话 </td><td><input type="text" name="em_phone" value="${EmployeeActionForm.employee.em_phone}"></td>
<td align="right">电子邮件 </td><td><input type="text" name="em_mail" value="${EmployeeActionForm.employee.em_mail}"></td>
</tr>

<tr><td align="right">身高 </td>
<td><input type="text" name="em_stature" value="${EmployeeActionForm.employee.em_stature}"></td>
 <td align="right"> 血型</td>
 <td>
 <select name="em_blood" value="${EmployeeActionForm.employee.em_blood}">
      <logic:iterate name="em_bloodList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_blood}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_blood}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
     </td>
 <!--  <td><select  name="em_blood"> <option value="a" selected>1:A型</option><option value="b">2:B型</option><option value="ab" >3:AB型</option><option value="o" >4:o型</option><option value="qita">5:其他血型</option></select></td> -->
 <td align="right">婚姻状况</td>
 <td>
 <select name="em_wedlock" value="${EmployeeActionForm.employee.em_wedlock}">
      <logic:iterate name="em_wedlockList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_wedlock}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_wedlock}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
     </td>
 <!--  <td><select  name="em_wedlock"> <option value="wh" selected>1:未婚</option><option value="yh" >2:已婚</option><option value="so">3:丧偶</option><option value="lh" >4:离婚</option><option value="qt4" >5:其他</option></select></td>-->
 
 </tr>


<tr>
<td align="right">部门名称:</td><td>${EmployeeActionForm.employee.dept_name}</td>
<td align="right">岗位名称:</td><td>${EmployeeActionForm.employee.job_name}</td>
<td align="right">用户所在地</td><td><input type="text" name="em_seat" value="${EmployeeActionForm.employee.em_seat}"></td>
</tr>

<tr>
<td align="right"> 最高学历</td>
<td>
 <select name="em_learn" value="${EmployeeActionForm.employee.em_learn}">
      <logic:iterate name="em_learnList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_learn}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_learn}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
</td>

<!--  <td><select  name="em_learn"> <option value="gzh" selected>1:高中及以下</option><option value="dzhua">2:大专</option><option value="ben" >3:本科</option><option value="yanj" >4:研究生</option></select></td>-->
 
 <td align="right">最高学位</td>
 <td>
 <select name="em_degree" value="${EmployeeActionForm.employee.em_degree}">
      <logic:iterate name="em_degreeList" id="f">
	<logic:equal name="f" property="id" value="${EmployeeActionForm.employee.em_degree}">
      		<option value="<bean:write name="f" property="id"/>" selected> <bean:write name="f" property="code_value"/> </option>
      	</logic:equal>
      	
      	<logic:notEqual name="f" property="id" value="${EmployeeActionForm.employee.em_degree}">
      		<option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      	</logic:notEqual>
      </logic:iterate>
     </select>
</td>
<!--  <td><select  name="em_degree"> <option value="wx" selected>1:无学位</option><option value="xshi" >2:学士</option><option value="shuangxs">3:双学士</option><option value="sshi" >4:硕士</option><option value="bshi" >5:博士</option><option value="shh" >6:博士后</option></select></td>--> 

<td align="right">毕业院校 </td>
<td><input type="text" name="em_graduate" value="${EmployeeActionForm.employee.em_graduate}"></td>
</tr>


<tr>
<td align="right">所学专业 </td>
<td><input type="text" name="em_specialty" value="${EmployeeActionForm.employee.em_specialty}"></td>
<td align="right">毕业日期</td><td><input type="text" name="em_gradate" value="${EmployeeActionForm.employee.em_gradate}" id="d11" onClick="WdatePicker()"></td>
<td align="right">出生地</td><td><input type="text" name="em_homeplace" value="${EmployeeActionForm.employee.em_homeplace}"></td>
</tr>



<tr>
<td colspan="6" align="center"><input type="button"  class="button" value="保存更改" onclick="xz()"></td>
</tr>
<tr></tr>
</table>
</form>
</body>
</html>