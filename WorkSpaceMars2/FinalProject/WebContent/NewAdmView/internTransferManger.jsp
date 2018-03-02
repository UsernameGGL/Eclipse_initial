<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.kms.po.Change"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	//basePath : the  ROOT of this APP
	List<Change> list=(List<Change>)session.getAttribute("list");
	pageContext.setAttribute("list", list);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>实习生调动管理</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">

	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<div class="top">
				<div class="container">
					<span> <a href="#"><i>@</i> info@freehtml5.co</a></span>
					<span> <a href="tel://+12345678910"><i class="icon-mobile3"></i> 123 4567 8910</a></span>
				</div>
			</div>
			<!-- end:top -->
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<h1 id="fh5co-logo"><a href="index.html">Welcome</a></h1>
						<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li class="active">
								<a href="/NewAdmView/index.html">管理主页</a>
							</li>
							<!-- <li>
								<a href="portfolio.html">正式员工管理</a>
							</li> -->
							<li>
								<a style="cursor:pointer" class="fh5co-sub-ddown">员工管理</a>
								 <ul class="fh5co-sub-menu">
								 	<li><a href="../administratorsView/jobInfo_list.action">员工调动管理</a></li>
								 	<li><a href="../work/worker_list">员工信息管理</a></li>
								 	<li><a href="../report/report_download.action?downloadType=2">生成在职员工报表</a></li>
								</ul>
							</li>
							<li>
								<a style="cursor:pointer" class="fh5co-sub-ddown">实习生管理</a>
								 <ul class="fh5co-sub-menu">
								 	<li><a href="../probation/apply_applist.action">实习资格审核</a></li>
								 	<li><a href="../probation/probation_list">实习生调动管理</a></li>
								 	<li><a href="../report/report_download.action?downloadType=1">生成实习生报表</a></li>
								</ul>
							</li>
							<li>
								<a style="cursor:pointer" class="fh5co-sub-ddown">部门/岗位管理</a>
								 <ul class="fh5co-sub-menu">
								 	<li><a href="../dept/dept_listdept.action">部门管理</a></li>
								 	<li><a href="../position/position_listposition.action">岗位管理</a></li>
								</ul>
							</li>
							<li>
								<a style="cursor:pointer" class="fh5co-sub-ddown">变更记录管理</a>
								 <ul class="fh5co-sub-menu">
								 	<li><a href="../change/change_listChange.action">变更记录查询</a></li>
								 	<li><a href="/FinalProject/NewAdmView/changeReport.html">生成变更记录报表</a></li>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
				</div>
			</header>
			
		</div>
		
		
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" style="background-image: url(images/work-1.jpg);">
				<div class="desc animate-box">
	<body>
	<!-- HTML HERE -->
	<table class="table">
		<caption><h4>试用期员工表</h4></caption>
		<thead>
			<th>员工编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>民族</th>
			<th>身份证号</th>
			<th>联系电话</th>
			<th>学历 </th>
			<th>户籍</th>
			<th>使用开始时间</th>
			<th>试用结束时间</th>
			<th>岗位</th>
			<th>部门</th>
		</thead>
		<tbody>
			<c:if test="${empty pl}">
				<tr>
					<td colspan="13">没有试用期信息</td>
				</tr>
			</c:if>
			<c:if test="${not empty pl}">
				<c:forEach items="${pl }" var="p">
					<tr>
						<td><b>${p.pid }</b></td>
						<td><b>${p.pnm }</b></td>
						<td><b>${p.psex }</b></td>
						<td><b>${p.page }</b></td>
						<td><b>${p.pna }</b></td>
						<td><b>${p.piid }</b></td>
						<td><b>${p.ptel }</b></td>
						<td><b>${p.pedu }</b></td>
						<td><b>${p.ploc }</b></td>
						<td><b>${p.pst }</b></td>
						<td><b>${p.pend }</b></td>
						<td><b>${p.ppos }</b></td>
						<td><b>${p.pdept }</b></td>
						<td><b><a  id="${p.pid }"  onclick="acceptToCom(this)" 
						style="cursor:pointer">接受</a>
						<a  id="${p.pid }"  onclick="delay(this)" 
						style="cursor:pointer">延长</a>
						<a  id="${p.pid }"  onclick="reject(this)"
						style="cursor:pointer">拒绝</a>
							<%-- <a href="position_update.action?position.pid=${p.pid }&position.pnm=${p.pnm }&position.pnum=${p.pnum }">保存</a> --%>
						</b></td>
							
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	</body>


				</div>
			</div>

		</div>
		<!-- END: header -->

		 <!-- <div id="fh5co-contact" class="animate-box">

			<div class="container">
				<form action="#">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Email">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="" class="form-control" id="" cols="30" rows="7" placeholder="Message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" value="Send Message" class="btn btn-primary">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>  -->
		
		
		
		
		
	 <div id="fh5co-services">
			<div class="container">
				<div class="row">
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-browser"></i></span>
									<h3>Web Development</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-mobile"></i></span>
									<h3>Mobile Apps</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-tools"></i></span>
									<h3>UX Design</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-video"></i></span>
									<h3>Video Editing</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-search"></i></span>
									<h3>SEO Ranking</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="icon-cloud"></i></span>
									<h3>Cloud Based Apps</h3>
									<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
								</div>
							</div>
						</div>
			</div>
		</div> 
		<!-- fh5co-work-section -->
		<!-- <div id="fh5co-start-project-section">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center animate-box">
						<h2>Start a Project</h2>
						<a href="#" class="btn btn-primary">Get in Touch</a>
					</div>
				</div>
			</div>
		</div>
		START a project

		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<p>Copyright 2016 Free Html5 <a href="#">Render</a>. All Rights Reserved. <br>More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> / Demo Images: <a href="#">Unsplash</a></p>
						</div>
						<div class="col-md-6">
							<ul class="footer-menu">
								<li><a href="#">Home</a></li>
								<li><a href="#">Portfolio</a></li>
								<li><a href="#">Services</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	

	</div>
	END fh5co-page

	</div> -->
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->

	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>
	<script type="text/javascript">
/**
 * 此函数供确认接受入职申请用，当点击接受按钮时，弹出提示框，当管理员点击确定后，就将此人的数据写入正式员工信息表中，并删除此人在入职申请表中的记录
 */
	function acceptToCom(label){
		var flag=confirm("确定升级此人为正式员工？");
		if(flag)location="../probation/probation_positive.action?pid="+label.id;
	}
/**
 * 此函数供延长试用期用，当点击延长试用期按钮时，弹出prompt框，提示管理员输入新的截止日期，点击确定后，将新的信息写入数据库
 */
 	function delay(label){
		var delayDay=prompt("请填入要增加的月数","");
		while(isNaN(delayDay)){
			alert("请输入整数");
			delayDay=prompt("请填入要增加的月数");
		}
		if(delayDay)location="../probation/probation_delay.action?pid="+label.id+"&delayDay="+delayDay;
	}

	function reject(label){
		var flag=confirm("确定拒绝此人进入公司？");
		if(flag)location="../probation/probation_reject.action?pid="+label.id;
	}
</script>

	</body>
</html>
