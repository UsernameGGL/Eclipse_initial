    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kms.po.WorkInfo"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	//String s=(String)session.getAttribute("s");
	//pageContext.setAttribute("s", s);
	WorkInfo worker=(WorkInfo)session.getAttribute("worker");
	pageContext.setAttribute("worker", worker);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE HTML>
    <html lang="en">
    <head>
    <meta charset="utf-8">
    <title>Company Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Styles -->
    <link href="css-css/bootstrap.css" rel="stylesheet">
    <link href="css-css/style.css" rel="stylesheet">
    <link rel='stylesheet' id='prettyphoto-css'  href="css-css/prettyPhoto.css" type='text/css' media='all'>
    <link href="css-css/fontello.css" type="text/css" rel="stylesheet">
    <!--[if lt IE 7]>
            <link href="css/fontello-ie7.css" type="text/css" rel="stylesheet">  
        <![endif]-->
    <!-- Google Web fonts -->
    <link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <style>
    body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
    }
    </style>
    <link href="css-css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- JQuery -->
    <script type="text/javascript" src="js-js/jquery.js"></script>
    <!-- Load ScrollTo -->
    <script type="text/javascript" src="js-js/jquery.scrollTo-1.4.2-min.js"></script>
    <!-- Load LocalScroll -->
    <script type="text/javascript" src="js-js/jquery.localscroll-1.2.7-min.js"></script>
    <!-- prettyPhoto Initialization -->
    <script type="text/javascript" charset="utf-8">
    var a=sessionStorage.getItem("a");
    pageContext.setAttribute("a",a);
          $(document).ready(function(){
            $("a[rel^='prettyPhoto']").prettyPhoto();
          });
    	function apply(){
    		window.location="companyEntry/information.jsp";
    	}   
    	
    	
    	function checkform(){
    		if(sessionStorage.getItem("fail")!=null){
    			alert("账号或密码错误！");
    			sessionStorage.clear();
    		}
    		document.getElementById("form").onsubmit=function(){
    			var accountNumber=document.getElementById("accountNumber");
    			var password=document.getElementById("password");
    			if(accountNumber.value[0]==undefined||password.value[0]==undefined){
    				alert('账号和密码不能为空！');
    				return false;
    			}
    			for(i in accountNumber.value){
    				var ch=accountNumber.value[i];
    				var letter=/^[a-zA-Z]+$/;
    				if((!letter.test(ch)&&isNaN(ch)&&ch!='_')||ch==' '){
    					alert('账号只能包括字母、数字和下划线');
    					return false;
    				}
    			}
    			for(j in password.value){
    				var ch=password.value[j];
    				var letter=/^[a-zA-Z]+$/;
    				if((!letter.test(ch)&&isNaN(ch)&&ch!='_')||ch==' '){
    					alert('密码只能包括字母、数字和下划线');
    					return false;
    				}
    			}
    			return true;
    		}
    	}

    	window.onload=checkform;
    </script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <!--******************** NAVBAR ********************-->
    <div class="navbar-wrapper">
      <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
          <div class="container">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
            <h1 class="brand"><a href="#top">Hello</a></h1>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <nav class="pull-right nav-collapse collapse">
              <ul id="menu-main" class="nav">
                <li><a title="公司简介" href="#portfolio">公司简介</a></li>
                <li><a title="部门简介" href="#services">部门简介</a></li>
                <li><a title="岗位简介" href="#news">岗位简介</a></li>
                <li><a title="求职申请" href="#team">求职申请</a></li>
                <li><a title="Login" href="#contact">个人信息</a></li>
              </ul>
            </nav>
          </div>
          <!-- /.container -->
        </div>
        <!-- /.navbar-inner -->
      </div>
      <!-- /.navbar -->
    </div>
    <!-- /.navbar-wrapper -->
    <div id="top"></div>
    <!-- ******************** HeaderWrap ********************-->
    <div id="headerwrap">
      <header class="clearfix">
        <h1><span>Hello!</span> Welcome to XX company.</h1>
        <div class="container">
          <div class="row">
            <div class="span12">
              <h2>Sign up to make an appointment whenever you need.</h2>
              <input type="text" name="your-email" placeholder="you@yourmail.com" class="cform-text" size="40" title="your email">
              <input type="submit" value="Notify me" class="cform-submit">
            </div>
          </div>
          <div class="row">
            <div class="span12">
              <ul class="icon">
                <li><a href="#" target="_blank"><i class="icon-pinterest-circled"></i></a></li>
                <li><a href="#" target="_blank"><i class="icon-facebook-circled"></i></a></li>
                <li><a href="#" target="_blank"><i class="icon-twitter-circled"></i></a></li>
                <li><a href="#" target="_blank"><i class="icon-gplus-circled"></i></a></li>
                <li><a href="#" target="_blank"><i class="icon-skype-circled"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </header>
    </div>
    <!--******************** Feature ********************-->
    <div class="scrollblock">
      <section id="feature">
        <div class="container">
          <div class="row">
            <div class="span12">
              <article>
                <p>We work to make web a beautiful place.</p>
                <p>We craft beautiful designs and convert them into</p>
                <p>fully functional and user-friendy web app.</p>
              </article>
            </div>
            <!-- ./span12 -->
          </div>
          <!-- .row -->
        </div>
        <!-- ./container -->
      </section>
    </div>
    <hr>
    <!--******************** Portfolio Section ********************-->
    <section id="portfolio" class="single-page scrollblock">
      <div class="container">
        <div class="align"><i class="icon-desktop-circled"></i></div>
        <h1 id="folio-headline">公司简介.</h1>
        <div class="row">
          <div class="span4">
            <div class="mask2"> <a href="img/portfolio-01.jpg" rel="prettyPhoto"><img src="img/portfolio-01.jpg" alt=""></a> </div>
            <div class="inside">
              <hgroup>
                <h2>公司历史</h2>
              </hgroup>
              <div class="entry-content">
                <p>xx网站策划股份有限公司成立于xx年，注册资金800万，是一家专业的网站策划公司。</p>
                <a class="more-link" href="#">view project</a> </div>
            </div>
            <!-- /.inside -->
          </div>
          <!-- /.span4 -->
          <div class="span4">
            <div class="mask2"> <a href="img/portfolio-02.jpg" rel="prettyPhoto"><img src="img/portfolio-02.jpg" alt=""></a> </div>
            <div class="inside">
              <hgroup>
                <h2>业务范围</h2>
              </hgroup>
              <div class="entry-content">
                <p>公司主要服务于中小企业，提供网站策划，网站设计制作建设，网络推广营销于一体的专业服务。公司以“专注网站，用心服务”为核心价值，希望通过我们的专业水平和不懈努力，重塑中小企业网络形象，为企业产品推广，文化建设传播提供服务指导。</p>
                <a class="more-link" href="#">view project</a> </div>
            </div>
            <!-- /.inside -->
          </div>
          <!-- /.span4 -->
          <div class="span4">
            <div class="mask2"> <a href="img/portfolio-03.jpg" rel="prettyPhoto"><img src="img/portfolio-03.jpg" alt=""></a> </div>
            <div class="inside">
              <hgroup>
                <h2>发展目标</h2>
              </hgroup>
              <div class="entry-content">
                <p>三年来，xx网站策划一直秉承以用户需求为重心，在专注本地市场开拓的同时，为超过一百家中小企业提供网站策划服务，优质、用心的服务赢得了众多企业的信赖和好评，逐渐树立起公司良好品牌。</p>
                <a class="more-link" href="#">view project</a> </div>
            </div>
            <!-- /.inside -->
          </div>
          <!-- /.span4 -->
        </div>
        <!-- /.row -->
        
        
      <!-- /.container -->
    </section>
    <hr>
    <!--******************** Services Section ********************-->
    <section id="services" class="single-page scrollblock">
      <div class="container">
        <div class="align"><i class="icon-cog-circled"></i></div>
        <h1>部门简介</h1>
        <!-- Four columns -->
    
          <div >
          <div class="row">
            <div class="align span3"> <i class="icon-desktop sev_icon"></i> 
            <h2>人事后  勤 部</h2>
            </div>
            <div class="span9">
            <p>后勤部直接作用于团体内部其它部门，对其它部门的正常运作具有至关重要的作用，对实现团体目标任务起间接作用。
           		 岗位职责：执行上级的命令和指示；全面负责行政后勤部的工作。；负责制定职责范围内的相关管理制度并督导管理执行；
           		 负责做好与有关业务单位和酒店有关部门的沟通、协调工作；做好员工的政治思想工作，关心员工生活；做好副总经理安排的其它工作。
            </p>
            </div>
          </div>
          <!-- /.span3 -->
          <div >
          <div class="row">
            <div class="align span3"> <i class="icon-vector sev_icon"></i> 
            <h2>财   务   部</h2>
          </div>
          <div class="span9">
            <p>主要职能是在本机构一定的整体目标下，关于资产的购置(投资)，资本的融通(筹资)和经营中现金流量(营运资金)，以及利润分配的管理。
                              岗位职责：利润最大化；管理当局收益最大化；企业财富（价值）最大化；社会责任最大化。</p>
          </div>
          </div>
          <!-- /.span3 -->
          <div >
          <div class="row">
            <div class="align span3"> <i class="icon-basket sev_icon"></i>
            <h2>物  资  管  理  部</h2>
            </div>
            <div class="span9">
            <p>目的作用：可作为供应部开展工作的规范依据;可作为公司领导考核供应部工作业绩的衡量依据;可作为供应部人员工作中相互监督与协作配合的依据;
             	工作职责：采购计划的编制;物资供应;采购物资的入库与结算;供货单位的质量审核;负责企业外委托加工的出入库业务;
             	与企业内各部门加强沟通配合，处理好生产经营过程中发生的各物流管理需求协调平衡的事项和突发问题;完成公司领导交办的其他工作任务</p>
          </div>
          </div>
          <!-- /.span3 -->
          <div >
          <div class="row">
            <div class="align span3"> <i class="icon-mobile-1 sev_icon"></i> 
            <h2>生  产  制  造  部</h2>
            </div>
            <div class="span9">
            <p>负责对各种设备事故、工伤、伤亡事故、急性中毒事故以及环境污染事故的调查处理，并制订改进措施计划;
                        根据销售部要货计划、车间生产能力及总经理意见，负责组织安排编制公司年度、月度生产计划;
			负责组织制订物料消耗定额和各种生产技术经济指标;
			按照公司年度、月度生产计划的要求组织车间贯彻施实，及时掌握生产作业进度;
			负责对各种设备事故、工伤、伤亡事故、急性中毒事故以及环境污染事故的调查处理，并制订改进措施计划</p>
          </div>
          </div>
          <!-- /.span3 -->
          <div >
          <<div class="row">
            <div class="align span3"> <i class="icon-mobile-1 sev_icon"></i> 
            <h2>技  术  开  发  部</h2>
            </div>
            <div class="span9">
            <p>负责公司的新产品开发、产品改良及公司技术标准的制定和管理工作,确保公司产品开发满足市场需求.管理权限:行使公司技术引进、新产品开发研究、新技术推广应用、技术标准制定、技术指导与监督、协调、管理的权利，并承担执行公司规程及工作
                               组织公司内部质量管理体系的策划、实施、监督和评审工作。
        	负责产品认证的组织、协调工作。
        	按照技术文件编制检验标准和检验规范；组织实施对原材料、外协件、外购件、自制件的检验，以及对产品工序、成品的检验，并出具检测报告。
            </p>
          </div>
          </div>
          <!-- /.span3 -->
          <div class="row">
            <div class="align span3"> <i class="icon-mobile-1 sev_icon"></i>
            <h2>质  量  管  理  部</h2>
            </div >
            <div class="span9">
            <p>组织公司内部对不合格品的评审，针对质量问题组织制订纠正、预防和改进措施，并追踪验证。
        	负责质量记录的统筹管理，定期进行质量分析和考核。
        	负责全公司产品的质量检验工作。
        	负责计量管理工作，完成计量仪器的定期检定并做好检定记录和标识。
         	负责检验测量和试验设备的控制，确保产品质量满足规定的要求。
        	参加对供方的评审，参加用户反馈意见的分析和处理。
        	负责外发合格证（铁科院、四方所）的申领、保管和发放。
        	完成公司交办的临时任务。
        	</p>
        	</div>
          </div>
          <!-- /.span3 -->
          <div >
          <div class="row">
            <div class="align span3"> <i class="icon-mobile-1 sev_icon"></i> 
            <h2>营销部</h2>
            </div>
            <div class="span9">
            <p>营销部是一个企业的经济命脉,营销部业绩的好坏直接影响到企业的收入.一般来说,营销部负责人的要求比较高,要有较好的沟通能力。
           	 职责:负责市场调查工作。
        	负责市场企划工作。
        	负责编制和组织实施年度营销计划。
        	负责具体销售合同（定单）的评审与组织实施。
        	负责客户管理和信用风险管理。
        	负责售后服务管理。
        	负责营销收入和销售费用的管理。
        	负责品牌建设。
        	负责营销人员队伍建设。
        	参与企业年度工作报告的编制，负责向财务部提供相应资料。
        	参与制定科技发展战略，负责向技术中心提供国、内外音视频产品市场状况及趋势分析报告。
        	负责上级领导交办的其他事项。</p>
          </div>
          </div>
          
          <!-- /.span3 -->
        </div>
        <!-- /.row -->
      
      <!-- /.container -->
    </section>
    <hr>
    <!--******************** Testimonials Section ********************-->
    <section id="testimonials" class="single-page hidden-phone">
      <div class="container">
        <div class="row">
          <div class="blockquote-wrapper">
            <blockquote class="mega">
              <div class="span4">
                <p class="cite">John Doe &amp; Sons:</p>
              </div>
              <div class="span8">
                <p class="alignright">"We highly appreciate the enthusiasm and creative talent of the people at Legend!"</p>
              </div>
            </blockquote>
          </div>
          <!-- /.blockquote-wrapper -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container -->
    </section>
    <hr>
    <!--******************** News Section ********************-->
    <section id="news" class="single-page scrollblock">
      <div class="container">
        <div class="align"><i class="icon-pencil-circled"></i></div>
        <h1>岗位简介</h1>
        <!-- Three columns -->
        <div class="row">
          <article class="span4 post"> <img class="img-news" src="img/blog_img-01.jpg" alt="">
            <div class="inside">
              <p class="post-date"><i class="icon-calendar"></i> March 17, 2013</p>
              <h2>部门经理</h2>
              <div class="entry-content">
                <p>部门经理是协调部门内和企业内的资源调配的管理人员,主要职责是为部门的整体业绩负责.
               		 部门经理必须要处理好以下五种关系：管理者和被管理者的关系;分内工作与额外工作的关系;批评与鼓励的关系。
               		 付出与回报的关系;成效与成长的关系;<br/><br/><br/><br/><br/><br/></p>
                <a href="#" class="more-link">read more</a> </div>
            </div>
            <!-- /.inside -->
          </article>
          <!-- /.span4 -->
          <article class="span4 post"> <img class="img-news" src="img/blog_img-02.jpg" alt="">
            <div class="inside">
              <p class="post-date">February 28, 2013</p>
              <h2>高级职工</h2>
              <div class="entry-content">
                <p> 高级管理人员是指公司的经理、副经理、财务负责人、上市公司董事会秘书和公司章程规定的其他人员.
		                根据公司法的规定，有下列情形之一的，不得担任公司的董事、监事、高级管理人员:
		                无民事行为能力或者限制民事行为能力;
		   		因犯有贪污、贿赂、侵占财产、挪用财产罪或者破坏社会经济秩序罪，被判处刑罚，执行期满未逾5年，或者因犯罪被剥夺政治权利，执行期满未逾5年;
		    	</p>
                <a href="#" class="more-link">read more</a> </div>
            </div>
            <!-- /.inside -->
          </article>
          <!-- /.span4 -->
          <article class="span4 post"> <img class="img-news" src="img/blog_img-03.jpg" alt="">
            <div class="inside">
              <p class="post-date">February 06, 2013</p>
              <h2>普通职工</h2>
              <div class="entry-content">
                <p>职责：以提高客户需求为根本;坚持以客户为关注焦点;加强学习，努力提高技术水平和业务素质;
                	踏实肯干，端正态度;协同工作。<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></p>
                <a href="#" class="more-link">read more</a> </div>
            </div>
            <!-- /.inside -->
          </article>
          <!-- /.span4 -->
        </div>
        <!-- /.row -->
        <a href="#" class="btn btn-large">Go to our blog</a> </div>
      <!-- /.container -->
    </section>
    <hr>
    <!--******************** Team Section ********************-->
    <section id="team" class="single-page scrollblock">
      <div class="container">
        <div class="align"><i class="icon-group-circled" style="cursor:pointer;" onclick="apply()"></i></div>
        <h1>求职申请</h1>
        <!-- Five columns -->
        <div class="row">
          <div class="span2 offset1">
            <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-1.jpg" alt=""> </div>
            <h3>Andrew</h3>
            <div class="job-position">web designer</div>
          </div>
          <!-- ./span2 -->
          <div class="span2">
            <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-2.jpg" alt=""> </div>
            <h3>Stephen</h3>
            <div class="job-position">web developer</div>
          </div>
          <!-- ./span2 -->
          <div class="span2">
            <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-3.jpg" alt=""> </div>
            <h3>Maria</h3>
            <div class="job-position">graphic designer</div>
          </div>
          <!-- ./span2 -->
          <div class="span2">
            <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-4.jpg" alt=""> </div>
            <h3>John</h3>
            <div class="job-position">project manager</div>
          </div>
          <!-- ./span2 -->
          <div class="span2">
            <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-2.jpg" alt=""> </div>
            <h3>Ashton</h3>
            <div class="job-position">real owner</div>
          </div>
          <!-- ./span2 -->
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="span10 offset1">
            <hr class="featurette-divider">
            <div class="featurette">
              <h2 class="featurette-heading">Want to know more? <span class="muted">| a little about us</span></h2>
              <p>Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores.</p>
              <p>At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues.</p>
              <p>A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es.</p>
            </div>
            <!-- /.featurette -->
            <hr class="featurette-divider">
          </div>
          <!-- .span10 -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container -->
    </section>
    <!--******************** Contact Section ********************-->
    <section id="contact" class="single-page scrollblock">
      <div class="container">
        <div class="align"><i class="icon-mail-2"></i></div>
        <h1>员工信息</h1>
        <div class="row">
          <div class="span12">
            <div class="cform" id="theme-form">
              <form method="post" class="cform-form" id="form">
                <div align="center">
                <table border="1" style=" height:450px; width:800px" align="center">
		<tbody>
		<tr><td>员工编号</td>
			<td><input name="wnm" value="${worker.wid }"size="50" readonly/></td></tr>
		<tr><td>姓名</td>
			<td><input name="wnm" value="${worker.wnm }"size="50" readonly/></td></tr>
		<tr><td>性别</td>
			<td><input name="wsex" value="${worker.wsex }"size="50" readonly /></td></tr>
		<tr><td>民族</td>
			<td><input name="wna" value="${worker.wna }"size="50" readonly /></td></tr>
		<tr><td>身份证号</td>
			<td><input name="wiid" value="${worker.wiid }" size="50" readonly/></td></tr>
		<tr><td>联系电话</td>
			<td><input name="wtel" value="${worker.wtel }" size="50" readonly/></td></tr>
		<tr><td>学历</td>
			<td><input name="wedu" value="${worker.wedu }" size="50" readonly/></td></tr>
		<tr><td>住址</td>
			<td><input name="wloc" value="${worker.wloc }" size="50" readonly/></td></tr>
		</tbody>	
	</table>
    
                <div class="cform-response-output"></div>
              </form>
            </div>
          </div>
          <!-- ./span12 -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container -->
    </section>
    <hr>
    <div class="footer-wrapper">
      <div class="container">
        <footer>
          <small>&copy; 2013 Inbetwin Network. All rights reserved.</small>
        </footer>
      </div>
      <!-- ./container -->
    </div>
    <!-- Loading the javaScript at the end of the page -->
    <script type="text/javascript" src="js-js/bootstrap.js"></script>
    <script type="text/javascript" src="js-js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="js-js/site.js"></script>
    
    <!--ANALYTICS CODE-->
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-29231762-1']);
	  _gaq.push(['_setDomainName', 'dzyngiri.com']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
    </body>
    </html>