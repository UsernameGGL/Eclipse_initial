//记录当前被选中的复选框的个数
var CheckedNum = 0;
/*
 * 选中所有的复选框，checkallbox是提供选择所有复选框的复选框，checksbox是要选中的复选框数组。
 */
function checkAll(checkallbox,checksbox){
	var length = checksbox == undefined ? 0 : checksbox.length == undefined ? 1 : checksbox.length;
	if ( length > 1 ){
	  for( i = 0 ; i < length ; i ++ ){
		  checksbox[i].checked = checkallbox.checked;
	  }
	}                
	else{
	  if ( length == 1 ) checksbox.checked = checkallbox.checked;
	}  

	if ( checkallbox.checked ) CheckedNum = length;
	else CheckedNum = 0;
}

/*
 * 选中所有的复选框，checkallbox是提供选择所有复选框的复选框，checksbox是要选中的复选框数组。
 */
function checkAllEnabled(checkallbox,checksbox){
	var length = checksbox == undefined ? 0 : checksbox.length == undefined ? 1 : checksbox.length;
	if ( length > 1 )
	  for( i = 0 ; i < length ; i ++ ){
		  if (checksbox[i].disabled == false)
				checksbox[i].checked = checkallbox.checked;
	  }
	else
	  if ( length == 1 ) checksbox.checked = checkallbox.checked;

	if ( checkallbox.checked ) CheckedNum = length;
	else CheckedNum = 0;
}

/*
 * 选中一个复选框obj,checkallbox是提供选中所有复选框功能的复选框，obj所在的复选框数组
 */
function checkA(checkallbox,checksbox,obj){
	var length = checksbox == undefined ? 0 : checksbox.length == undefined ? 1 : checksbox.length;

	if ( obj.checked )  CheckedNum ++;
	else  CheckedNum --;

	if ( CheckedNum == length ) checkallbox.checked = true;
	else checkallbox.checked = false;
}

/*
 *  检查checksbox是否有复选框被选中，如果checksbox没定义则显示noDefineHint并返回1,如果没选中则显示noSelectHint并返回2。
 *  如果有则返回0。
 */
function checkSelectByHint(checksbox,noDefineHint,noSelectHint){
	var result = checkSelect(checksbox)
	if( result == 1)
	  alert(noDefineHint);
	else if( result ==2 )
	  alert(noSelectHint);

	return result;
}

/*
 *  检查checksbox是否有复选框被选中，如果checksbox没定义则返回1,如果没选中则并返回2。
 *  如果有则返回0。
 */
function checkSelect(checksbox){
	if( checksbox == undefined || checksbox==null )
		return 1;
	if( checksbox.length == undefined ){
		if( checksbox.checked )
			return 0;
		else
			return 2;
	}else{
		var i;
		for(i=0;i<checksbox.length;i++)
		   if( checksbox[i].checked )
			  return 0;
		return 2;
	}
}
//true 表示处于显示状态
var billHeadDisp = true;
var billDetailDisp = false;
var openitem=false;
var d=true;
var b=true;
/*
tabID 要控制的表格的id名称
flag 当前要控制表格的显示状态
*/
function dispTab(tabID,tabID2,tabID3,flag)
{
  var tabObj = document.getElementById(tabID);
  var tabObj2 = document.getElementById(tabID2);
  var tabObj3 = document.getElementById(tabID3);

  if(flag){
    tabObj.style.display = "none";
    tabObj2.style.display = "none";
    tabObj3.style.display="inline";

  }else{
    tabObj.style.display = "inline";
    tabObj2.style.display = "inline";
    tabObj3.style.display="none";
  }
  //改变状态
  switch(tabID)
  {
    case "showselect":
	  openitem = !openitem;
	   
	case "showfeedbackdetai":
	  billDetailDisp = !billDetailDisp;
	  case "showstudentm":
	  b=!b;	
	  case "showteacherm":
	  d=!d;	
  }
}
function dispTab2(tabID,tabID2,tabID3,flag)
{
  var tabObj = document.getElementById(tabID);
  var tabObj2 = document.getElementById(tabID2);
  var tabObj3 = document.getElementById(tabID3);

  if(flag){
    tabObj.style.display = "none";
    tabObj2.style.display = "none";
    tabObj3.style.display="inline";

  }else{
    tabObj.style.display = "inline";
    tabObj2.style.display = "inline";
    tabObj3.style.display="none";
  }
  //改变状态
  switch(tabID)
  {
    case "showselect2":
	  openitem = !openitem;
	case "showfeedbackdetai":
	  billDetailDisp = !billDetailDisp;
	  case "showstudentm":
	  b=!b;	
	  case "showteacherm":
	  d=!d;	
  }
}
	function confirmDel(){
		confirm("确认删除该项目?")
	}
	function addTraining(){
		url="addTraining.html"
		window.location.assign(url);
	}
	function go_back(){
		url="../index.html"
		window.location.assign(url);
	}
	
	function confirmDelSelected(){
		checkSelectByHint(form1.customerIDs,"复选框未定义","请选择要删除的项目记录");
	}
	function queryTraining()
	
	{ url="queryTraining.html"
		window.location.assign(url);
	
	}
	function delTraining(){
		var flag = false;
		for (var i = 0; i < document.getElementsByName("customerIDs").length; i++) {
			if (document.getElementsByName("customerIDs")[i].checked) {
				flag = true;
			}		
		}
		if (!flag) {
			alert("请选择需要删除的培养方案！");
			return;
		}
		if(flag){
		   confirm("确认删除该培养方案?")
		
		}

	}
	
