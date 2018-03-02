<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"  %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
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
<title>部门查询</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>

<script language="javascript" type="text/javascript">		
		function addPrompt() {
			document.deptlist.action="dept.do?method=addPrompt";
			document.deptlist.submit();
		}
		
		function listAllEmpl(deptno){
		document.deptlist.action="dept.do?method=listAllDeptEmpl&deptno="+deptno;
		document.deptlist.submit();
		}
</script>

</head>

<body>
<p>当前位置:部门基本信息</p>

<form method="post" action="dept.do?method=listDept" name="deptlist">
<table align="center" cellspacing="0">

	<tr>
		<td align="center"><span style="cursor: hand"
			onClick="dispTab('showselect', 'show', 'hidden', openitem)";>部门信息查询<span
			id="hidden">[已隐藏]</span> <span id="show" style="display: none">[已显示]</span>
		</span></td>
	</tr>
</table>
<table align="center" id="showselect" style="display: none"
	class='TableQueryClass' borderColorDark="#F3FBF0"
		borderColorLight="#999999" cellSpacing=0 cellPadding=0 border=1 >
	<tr>
		<td align="center" >部门编号: <input type="text" name="dept_number"><br></td>

		<td align="center" >部门名称: <input type="text" name="dept_name"><br></td>
	
		<td align="center">部门类型:<select name="dept_type">
		    <option value="0">不限</option>
            <logic:iterate name="dept_typeList" id="code">
                   <option value="<bean:write name="code" property="id"/>">
                   <bean:write name="code" property="code_value"/></option>
              </logic:iterate>
             
             </select></td> 
		
	</tr>
	<tr>
	<tr>
		 <td colspan=3 class="DataTitle">&nbsp;</td>
	</tr>
	
	<tr>
		<td align="center"  colspan=3> <input type="submit" id="query" value="查询" class="button">
		 <input type="reset" value="重新填写" class="button"></td>
	</tr>
</table>
<p>
<logic:empty name="deptList">
				<tr>
					<td><div align="center">
						<font color="red">无查询结果！</font></div>
					</td>
				</tr>
</logic:empty>				
<logic:notEmpty name="deptList">
	<table width="100%" id="DetailScrollTable"  borderColorDark="#F3FBF0"
		borderColorLight="#999999" border=1 cellPadding="0" cellspacing="0" frame="box" align="center" >

	<tr class="SrollDataHead">
		<td>
		<div align="center">部门编号</div>
		</td>
		<td>
		<div align="center">部门名称</div>
		</td>
		<td>
		<div align="center">部门类型</div>
		</td>
		<td>
		<div align="center">电话</div>
		</td>
		<td>
		<div align="center">传真</div>
		</td>
		<td>
		<div align="center">上级部门</div>
		</td>
		<td>
		<div align="center">描述</div>
		</td>
		<td>
		<div align="center">成立日期</div>
		</td>
		<td>
		<div align="center">员工</div>
		</td>
		<td>
		<div align="center">删除</div>
		</td>
	</tr>

	<logic:iterate id="dept" name="deptList">
		<input type="hidden" name="id" value="<bean:write name="dept" property="id"/>"/>
	<tr>
		<td>
		<div align="center"><bean:write name="dept" property="dept_number" /></div>
		</td>
		<td>
		<div align="center"><html:link action="dept.do?method=getDeptById" paramName="dept" paramId="id" paramProperty="id" >
	                         <bean:write name="dept" property="dept_name" />
	                       </html:link>
        </div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_value" /></div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_tel" /></div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_fax" /></div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_superName" /></div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_desc" /></div>
		</td>
		<td>
		<div align="center"><bean:write name="dept" property="dept_setDate" /></div>
		</td>
		<td>
		<div align="center"><html:link action="dept.do?method=listAllDeptEmpl" paramId="dept_number" paramName="dept" paramProperty="dept_number">员工</html:link></div>
		</td>
		<td>
		<div align="center"><html:link action="dept.do?method=delDept" paramId="dept_number" paramName="dept" paramProperty="dept_number">删除</html:link>
</div>
		</td>
	</tr>
	</logic:iterate>	
</table>
</logic:notEmpty>
<br>
<input type="button" value="增加" class="button" onClick="addPrompt()"/>
</form>
<script type="text/javascript">
var showMsg='<%=request.getAttribute("showAlert")%>';
		if(showMsg!="null"&&showMsg!=""){
		alert(showMsg);
		document.all.query.click();
		}
</script>
</body>
</html>
