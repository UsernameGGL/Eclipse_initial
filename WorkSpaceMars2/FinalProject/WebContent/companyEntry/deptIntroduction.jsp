<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
	//basePath : the  ROOT of this APP
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN" >
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- do NOT move Pre 3 metas tag -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>部门简介</title>

<!-- Bootstrap -->
<link href="${ basePath}css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-color:#FFE4E1">

	<!-- HTML HERE -->
<ul id="myTab" class="nav nav-tabs" style="background-color:#FFC1C1">
    <li class="active li_color" style="background-color:#FFC1C1">
        <a href="#PersonnelLogisticsDepartment" data-toggle="tab"><i class="fa fa-user">人  事  后  勤  部</i>
        </a>
    </li>
    <li style="background-color:#FFC1C1"><a href="#FinanceDepartment" data-toggle="tab" >
    	<i class="fa fa-money"></i>  财   务   部</a></i></li>
    <li style="background-color:#FFC1C1"><a href="#GoodsManage" data-toggle="tab">
    	<i class="fa fa-truck">物  资  管  理  部</i></a></li>
    <li style="background-color:#FFC1C1"><a href="#ManufacturingDepartment" data-toggle="tab">
    	<i class="fa fa-wrench">生  产  制  造  部</i></a></li>
    <li style="background-color:#FFC1C1"><a href="#TechnologyDevelopmentDepartment" data-toggle="tab">
    	<i class="fa fa-desktop">技  术  开  发  部</i></a></li>
    <li style="background-color:#FFC1C1"><a href="#QualityControlDepartment" data-toggle="tab">
    	<i class="fa fa-cogs">质  量  管  理  部</i></a></li>
    <li style="background-color:#FFC1C1"><a href="#MarketingDepartment" data-toggle="tab">
    	<i class="fa fa-bullhorn">营   销    部</i></a></li>
</ul>
<div id="myTabContent" class="tab-content" >
    <div class="tab-pane fade in active" id="PersonnelLogisticsDepartment">
        <p style="font-size:20px">后勤部直接作用于团体内部其它部门，对其它部门的正常运作具有至关重要的作用，对实现团体目标任务起间接作用。</p>
        <p style="font-size:25px ;font-style:italic">岗位职责：</p></br>
        <ol style="font-size:20px">
    		<li>执行上级的命令和指示。</li>
   			<li>全面负责行政后勤部的工作。</li>
    		<li>负责制定职责范围内的相关管理制度并督导管理执行。</li>
    		<li>负责做好与有关业务单位和酒店有关部门的沟通、协调工作。</li>
    		<li>做好员工的政治思想工作，关心员工生活。</li>
    		<li>做好副总经理安排的其它工作。</li>
		</ol>
    </div>
    <div class="tab-pane fade" id="FinanceDepartment">
        <p style="font-size:20px">主要职能是在本机构一定的整体目标下，关于资产的购置(投资)，资本的融通(筹资)和经营中现金流量(营运资金)，以及利润分配的管理。</p>
        <p style="font-size:25px ;font-style:italic">岗位职责：</p>
        <ol style="font-size:20px">
    		<li>利润最大化。</li>
   			<li>管理当局收益最大化。</li>
    		<li>企业财富（价值）最大化。</li>
    		<li>社会责任最大化。</li>
		</ol>
    </div>
    <div class="tab-pane fade" id="GoodsManage">
        <ol type=I style="font-size:20px">
        	<li>目的作用： 
        	<ol type=i>
        		<li>可作为供应部开展工作的规范依据。</li>
        		<li>可作为公司领导考核供应部工作业绩的衡量依据。</li>
        		<li>可作为供应部人员工作中相互监督与协作配合的依据。</li>
        	</ol>
        	</li>
        	<li>工作职责：
        		<ol type=i style="font-size:20px">
        			<li>采购计划的编制。</li>
        			<li>物资供应。</li>
        			<li>采购物资的入库与结算。</li>
        			<li>供货单位的质量审核。</li>
        			<li>负责企业外委托加工的出入库业务。</li>
        			<li>与企业内各部门加强沟通配合，处理好生产经营过程中发生的各物流管理需求协调平衡的事项和突发问题。</li>
        			<li>完成公司领导交办的其他工作任务。</li>
        		</ol>
        	</li>
        </ol>
    </div>
    <div class="tab-pane fade" id="ManufacturingDepartment">
        <p style="font-size:20px">负责对各种设备事故、工伤、伤亡事故、急性中毒事故以及环境污染事故的调查处理，并制订改进措施计划。</p>
		<p style="font-size:25px ;font-style:italic">职责：</p>
		<ol style="font-size:20px">
			<li>根据销售部要货计划、车间生产能力及总经理意见，负责组织安排编制公司年度、月度生产计划。</li>
			<li>负责组织制订物料消耗定额和各种生产技术经济指标。</li>
			<li>按照公司年度、月度生产计划的要求组织车间贯彻施实，及时掌握生产作业进度。</li>
			<li>负责全公司的生产调度工作，定期召开生产调度会议，组织衡生产，加强定额管理、降低消耗，提高劳动生产率，严格按品种、数量、质量、交货期限、安全等要求完成生产任务。</li>
			<li>根据国家和上级主管部门颁布的有关规定，制定公司安全生产的管理标准和规定，并组织各部门制订安全技术组织措施计划及不安全隐患的改进措施，并监督检查。</li>
			<li>负责对各种设备事故、工伤、伤亡事故、急性中毒事故以及环境污染事故的调查处理，并制订改进措施计划。</li>
		</ol>
    </div>
    <div class="tab-pane fade" id="TechnologyDevelopmentDepartment" style="font-size:20px">
        负责公司的新产品开发、产品改良及公司技术标准的制定和管理工作,确保公司产品开发满足市场需求
管理权限:行使公司技术引进、新产品开发研究、新技术推广应用、技术标准制定、技术指导与监督、协调、管理的权利，并承担执行公司规程及工作
    </div>
    <div class="tab-pane fade" id="QualityControlDepartment" style="font-size:20px">
        <p style="font-size:25px ;font-style:italic">质量管理部门的主要职能：</p>
        <ol style="font-size:20px">
        	<li>组织公司内部质量管理体系的策划、实施、监督和评审工作。</li>
        	<li>负责产品认证的组织、协调工作。</li>
        	<li>按照技术文件编制检验标准和检验规范；组织实施对原材料、外协件、外购件、自制件的检验，以及对产品工序、成品的检验，并出具检测报告。</li>
        	<li>组织公司内部对不合格品的评审，针对质量问题组织制订纠正、预防和改进措施，并追踪验证。</li>
        	<li>负责质量记录的统筹管理，定期进行质量分析和考核。</li>
        	<li>负责全公司产品的质量检验工作。</li>
        	<li>负责计量管理工作，完成计量仪器的定期检定并做好检定记录和标识。</li>
        	<li>负责检验测量和试验设备的控制，确保产品质量满足规定的要求。</li>
        	<li>参加对供方的评审，参加用户反馈意见的分析和处理。</li>
        	<li>负责外发合格证（铁科院、四方所）的申领、保管和发放。</li>
        	<li>完成公司交办的临时任务。</li>
        </ol>
    </div>
    <div style="font-size:20px"class="tab-pane fade" id="MarketingDepartment">
        <p>营销部是一个企业的经济命脉,营销部业绩的好坏直接影响到企业的收入.一般来说,营销部负责人的要求比较高,要有较好的沟通能力。</p>
        <p style="font-size:25px ;font-style:italic">职责：</p>
        <ol style="font-size:20px">
        	<li>负责市场调查工作。</li>
        	<li>负责市场企划工作。</li>
        	<li>负责编制和组织实施年度营销计划。</li>
        	<li>负责具体销售合同（定单）的评审与组织实施。</li>
        	<li>负责客户管理和信用风险管理。</li>
        	<li>负责售后服务管理。</li>
        	<li>负责营销收入和销售费用的管理。</li>
        	<li>负责品牌建设。</li>
        	<li>负责营销人员队伍建设。</li>
        	<li>参与企业年度工作报告的编制，负责向财务部提供相应资料。</li>
        	<li>参与制定科技发展战略，负责向技术中心提供国、内外音视频产品市场状况及趋势分析报告。</li>
        	<li>参与集团公司年度新产品研发计划，负责向技术中心提供新产品研发市场信息。</li>
        	<li>参与科研项目的立项及评审工作，负责向技术中心提供产品的市场需求意向及价格定位报告。</li>
        	<li>参与网络信息建设，负责向综合办提供职责范围内的相应资料。</li>
        	<li>参与企业文化建设，负责向综合办提供职责范围内企业文化建设资料。</li>
        	<li>负责上级领导交办的其他事项。</li>
        </ol>
    </div>
</div>
 
	<!-- END HTML -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ basePath}js/jquery-min-1.12.4.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->