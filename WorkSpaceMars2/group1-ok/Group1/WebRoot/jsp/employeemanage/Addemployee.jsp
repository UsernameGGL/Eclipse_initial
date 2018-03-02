<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/tn_css.css" />

</head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var showMsg='<%=request.getAttribute("showAlert")%>';
		if(showMsg!="null"&&showMsg!=""){
		alert(showMsg);
	
		}

function fun(){
style="visibility: none;" 
　　document.getElementById("yy").style.visibility="hidden";//隐藏 
}
function fun1(){
style="visibility: none;" 
　　document.getElementById("yy").style.visibility="visible";//显示 
}

function qun(){
style="visibility: none;" 
　　document.getElementById("qq").style.visibility="hidden";//隐藏 
}
function qun1(){
style="visibility: none;" 
　　document.getElementById("qq").style.visibility="visible";//显示 
}

<!-- 限制 -->
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

<body onload="fun(),qun()">
当前位置：员工信息
<form action="EmployeeActon.do?method=addEmployees" method="post" name="form">
<p>注：标有*的必填</p>
<center>

<table width="100%" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
<tr>
<td align="right" ><font color=red>*</font>员工编号</td>
<td align="left"> <input type="text" name="em_number" maxlength=5></td>
<td align="right"><font color=red>*</font>姓名 </td>
<td align="left"><input type="text" name="em_name"></td>
<td align="right"><font color=red>*</font>性别</td>
<td align="left"> <select name="sex">
      <logic:iterate name="sexList" id="s">
      <option value="<bean:write name="s" property="id"/>"> <bean:write name="s" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>
<!--  <td align="right">*   性别</td><td><select  name="sex"> <option value="n" selected>1:男</option><option value="v">2:女</option></select></td>-->
</tr>

<tr><td align="right" ><font color=red>*</font> 出生日期 </td><td align="left"><input type="text" name="em_birth" id="d11" onClick="WdatePicker()" ></td>
<td align="right"><font color=red>*</font>身份证号 </td>
<td align="left"><input type="text" name="em_id"></td>
<td align="right" colspan="2">&nbsp;</td>

</tr>

<tr>
<td align="right"><font color=red>*</font>入职日期 </td>
<td align="left"><input type="text" name="em_indate" id="d11" onClick="WdatePicker()"></td>
<td align="right"><font color=red>*</font>参加工作时间</td><td align="left"><input type="text" name="em_worktime" id="d11" onClick="WdatePicker()"></td>
<td align="right"><font color=red>*</font>用工形式</td>
<td align="left"> <select name="em_format">
      <logic:iterate name="em_formatList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>

<!-- <td><select  name="em_format"> <option value="zs" selected>1:正式员工</option><option value="ls">2:临时员工</option></select></td>-->

</tr>

<tr>
<td align="right"><font color=red>*</font>人员来源</td>
<td align="left">
<select name="em_source">
      <logic:iterate name="em_sourceList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>
<!--  <td><select  name="em_source"> <option value="xy" selected>1:校园招聘</option><option value="sh">2:社会招聘</option><option value="qt1" selected>3:其他</option></select></td>-->
<td align="right"><font color=red>*</font>政治面貌</td>
<td align="left">
<select  name="em_polity">
      <logic:iterate name="em_polityList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>
<!--   <td><select  name="em_polity"> <option value="dy" selected>1:党员</option><option value="yb" >2:预备党员</option><option value="sh">3:团员</option><option value="qt2" >4:其它</option></select></td> -->
<td align="right"><font color=red>*</font>民族</td>
<td align="left">
<select name="em_folk">
      <logic:iterate name="em_folkList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>
<!--  <td><select  name="em_folk"> <option value="hz" selected>1:汉族</option><option value="mz">2:满族</option><option value="zz1" >3:壮族</option></select></td>-->
</tr>

<tr>
<td align="right">是否为试用期</td>
<td align="left"><input type="radio" name="situation" value="0" onclick="qun1()" >是<input type="radio" name="situation" value="1"onclick="qun()"  checked>否</td>
</tr>





<tr>
<td></td>
<td align="right"><input type="button" class="button"  value="显示更多信息" onClick="fun1()"></td>
<td align="left"><input type="button" value="隐藏更多信息" class="button" onClick="fun()"></td> 
<td align="right"><input type="button"  class="button" value="  确认提交 " onclick="xz()" ></td>
<td align="left"><input type="reset" value="  重新填写  " class="button"></td>
</tr>



</table>

<div id="qq" class="border"   width="100%">
<td align="right">试用期开始日期：</td>
<td><input type="text" name="prob_start" id="d4311" class="Wdate"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"></td>
<td align="right">试用期结束日期：</td>
<td><input type="text" name="prob_end" id="d4312" class="Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})"></td>
</div>



<div id="yy">
<table    width="100%" class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 align="center">
<tr>
<td align="right">籍贯 </td>
<td  align="left"><input type="text" name="em_birthplace"></td>
<td align="right">联系电话 </td><td  align="left"><input type="text" name="em_phone"></td>
<td align="right">电子邮件 </td><td  align="left"><input type="text" name="em_mail"></td>
</tr>

<tr>
<td align="right">身高 </td>
<td  align="left"><input type="text" name="em_stature"></td>
 <td align="right"> 血型</td>
 <td  align="left"> 
 <select name="em_blood">
      <logic:iterate name="em_bloodList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
     </td>
 <!--  <td><select  name="em_blood"> <option value="a" selected>1:A型</option><option value="b">2:B型</option><option value="ab" >3:AB型</option><option value="o" >4:o型</option><option value="qita">5:其他血型</option></select></td> -->
 <td align="right">婚姻状况</td>
 <td  align="left">
 <select name="em_wedlock">
      <logic:iterate name="em_wedlockList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
     </td>
 <!--  <td><select  name="em_wedlock"> <option value="wh" selected>1:未婚</option><option value="yh" >2:已婚</option><option value="so">3:丧偶</option><option value="lh" >4:离婚</option><option value="qt4" >5:其他</option></select></td>-->
 </tr>


<tr>
<td align="right">部门名称</td>
<td  align="left"><select name="dept_number">
	   <option value="0">无</option>
	  <logic:iterate name="dept_nameList" id="dept" >
	       <option value="<bean:write name="dept" property="dept_number"/>">
	       <bean:write name="dept" property="dept_name"/></option>            
      </logic:iterate>
	   </select></td> 
<td align="right">出生地 </td><td  align="left"><input type="text" name="em_homeplace"></td> 
<td align="right">用户所在地</td><td  align="left"><input type="text" name="em_seat"></td>
</tr>

<tr>
<td align="right"> 最高学历</td>
<td  align="left">
 <select name="em_learn">
      <logic:iterate name="em_learnList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
     </select>
</td>

<!--  <td><select  name="em_learn"> <option value="gzh" selected>1:高中及以下</option><option value="dzhua">2:大专</option><option value="ben" >3:本科</option><option value="yanj" >4:研究生</option></select></td>-->
 <td align="right">最高学位</td>
<td  align="left">
<select name="em_degree">
      <logic:iterate name="em_degreeList" id="f">
      <option value="<bean:write name="f" property="id"/>"> <bean:write name="f" property="code_value"/> </option>
      </logic:iterate>
</select>
</td>
<!--  <td><select  name="em_degree"> <option value="wx" selected>1:无学位</option><option value="xshi" >2:学士</option><option value="shuangxs">3:双学士</option><option value="sshi" >4:硕士</option><option value="bshi" >5:博士</option><option value="shh" >6:博士后</option></select></td>--> 
<td align="right">毕业院校 </td><td  align="left"><input type="text" name="em_graduate"></td>
</tr>


<tr>
<td align="right">所学专业 </td>
<td  align="left"><input type="text" name="em_specialty"></td>
<td align="right">毕业日期</td><td  align="left"><input type="text" name="em_gradate" id="d11" onClick="WdatePicker()"></td>
<td align="right">岗位名称</td><td  align="left">  <select name="job_number">
					<option value="0">无</option>					
					<logic:iterate name="job_nameList" id="job">
					<option value="<bean:write name="job" property="job_number"/>">
					<bean:write name="job" property="job_name"/></option>            
					</logic:iterate>				  
				</select>
</td>
</tr>

</table>
</div>

<table>


</table>

</center>

</form>
</body>
</html>