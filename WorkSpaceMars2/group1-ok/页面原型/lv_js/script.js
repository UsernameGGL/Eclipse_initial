
var CheckedNum = 0;

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


function checkA(checkallbox,checksbox,obj){
	var length = checksbox == undefined ? 0 : checksbox.length == undefined ? 1 : checksbox.length;

	if ( obj.checked )  CheckedNum ++;
	else  CheckedNum --;

	if ( CheckedNum == length ) checkallbox.checked = true;
	else checkallbox.checked = false;
}


function checkSelectByHint(checksbox,noDefineHint,noSelectHint){
	var result = checkSelect(checksbox)
	if( result == 1)
	  alert(noDefineHint);
	else if( result ==2 )
	  alert(noSelectHint);

	return result;
}


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
var billHeadDisp = true;
var billDetailDisp = false;
var openitem=false;
var d=true;
var b=true;
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
 