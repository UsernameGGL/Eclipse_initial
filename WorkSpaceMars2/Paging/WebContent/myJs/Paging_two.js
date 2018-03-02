	var length;
	var array=document.getElementById("tr_");
	function paging(len,terms,pattern){//terms作为display的参数传入
		length=len;//将len传递给length，让其在substitution中使用，防止内存溢出
		//var len=100;//拿到数据长度，数据长度作为参数传入的话，就不需这一步
		var pageNumber=0;//为按钮分配其点击所显示的页面的页面号，作为substitution函数的参数传入
		while(len>0){//一页terms行，根据数据长度确定一共有多少页，一共有多少个按钮
			len=len-terms;
			var newButton=document.createElement("button");//创建新按钮
			newButton.setAttribute("onclick","substitution("+pageNumber+","+terms+")");//为其分配onclick事件，并将页号传入作为参数
			newButton.innerHTML=++pageNumber;//按钮内容为页号
			newButton.className="btn btn-info btn-lg";//分配class，使其按照bootstrap形式显示
			table.appendChild(newButton);//将按钮添加入页面
		}
		
		
		//默认显示前terms行数据
		for(var j=0;j<terms;j++){
			/*var str="tr_"+j;
			var tr=document.getElementById(str);*/
			array[j].style.display=pattern;
		}
		
	}
	
	//分页函数
	var nowPage=0;//记录当前页面，0表示第1页
	function substitution(choice,terms){
		var nowDis=nowPage*terms;//在页面上显示的第一行的id号等于页号乘terms
		var nextDis=choice*terms;//将要显示的第一行的id号等于页号乘terms
		for(var i=0;i<terms&&nowDis<length;i++){//循环terms次，将正在显示的terms行的状态改为不显示
			//var str_now="tr_"+(nowDis++);
			array[nowDis+i].style.display="none";
		}
		for(var i=0;i<terms&&nextDis<length;i++){
			var str_next="tr_"+(nextDis++);
			array[nowDis+i].style.display="table-row";
		}
		nowPage=choice;//刷新当前页面号
	}
	
	
	
	function display(str){
		var a='<table id="table" class="table table-striped table-hover">';
		
		a+='<caption>hhhhhhhh呵呵哈哈哈</caption>';
		
		a+='<thead>';
			a+='<tr>';
				a+='<th>编号</th>';
				a+='<th>名字</th>';
				a+='<th>不知道啥</th>';
			a+='</tr>';
		a+='</thead>';
		a+='<tbody>';
				a+='<c:forEach items="${'+str+'}" var="d">';
					a+='<tr id="tr_${d.did}" style="display:none">';
						a+='<td>${d.did }</td>';
						a+='<td>${d.dnm }</td>';
						a+='<td>${d.dnum }</td>';
					a+='</tr>';
				a+='</c:forEach>';
		a+='</tbody>';
	a+='</table>';
	body.innerHTML=a;	
	}