



package com.neusoft.probmanage.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.code.domain.Code;
import com.neusoft.code.service.CodeService;
import com.neusoft.constant.Constant;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;
import com.neusoft.probmanage.domain.ProbationBean;
import com.neusoft.probmanage.form.ProbationForm;
import com.neusoft.probmanage.service.ProbationService;

import devoid.frame.web.BaseAction;


public class ProbationAction extends BaseAction {
	
	/**
	 * 在已转正员工信息查询页面点击"员工信息查询"连接时调用，用于转向员工信息查询页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forwardProbationList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("probationlist");
	} 
	
	/**
	 * 在员工信息查询页面点击"已转正员工信息查询"时调用该方法，用于转向已转正员工信息查询页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forwardProbationedList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("probationedlist");
	} 
	
	/**
	 *   当点击试用期查询页面的"查询"按钮调用本方法,用于查询使用期的员工信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */	
	public ActionForward findProbationList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		All all = new All();
        //从页面取出输入的信息并判断后输入ALL中
		 
		if(request.getParameter("em_number")!=null&&!("").equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
		}
		//*员工姓名
		if(request.getParameter("prob_name")!=null&&!("").equals(request.getParameter("prob_name"))){
			all.setEm_name(request.getParameter("prob_name"));
		}
		//部门名称
		if(request.getParameter("prob_branchName")!=null&&!"".equals(request.getParameter("prob_branchName"))){
			all.setDept_name(request.getParameter("prob_branchName"));
		}
		 //*岗位名称
		if(request.getParameter("prob_jobName")!=null&&!"".equals(request.getParameter("prob_jobName"))){
			all.setJob_name(request.getParameter("prob_jobName"));
		}		 
		
		 //*试用期开始日期
		if(request.getParameter("prob_start")!=null&&!("").equals(request.getParameter("prob_start"))){
			all.setProb_start((Date.valueOf(request.getParameter("prob_start"))));
		}
		//*试用期结束日期
		if(request.getParameter("prob_end")!=null&&!("").equals(request.getParameter("prob_end"))){
			all.setProb_end((Date.valueOf(request.getParameter("prob_end"))));
		}
		//创建业务层实例
        ProbationService probationService=ProbationService.getInstance();
		//调用业务层方法
		List<All> ProbationList =probationService.listProb(all);
		request.setAttribute("ProbationList", ProbationList);
		//转向试用期员工信息查询页面
		return mapping.findForward("probationlist");
	}

	/**
	 * 当点击"对员工评价"超链接调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward Probationedit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获得员工虚拟的id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//创建service层对象
		EmployeeService  employeeService =EmployeeService.getInstance();
		
		Employee employee = employeeService.findEmployeeById(id);
		
		request.setAttribute("employee", employee);
		
		//创建码表的service对象
		CodeService codeService = CodeService.getInstance();
		List<Code> codeList = codeService.getCode(Constant.PROB_RESULTS);
		request.setAttribute("codeList", codeList);
		return mapping.findForward("probationededit");
	}

	 /**
	  * 对试用期人员评价当中点击"保存"时调用,将评价的信息保存进试用期表中
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */

	public ActionForward editProbation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//创建form对象
		ProbationForm probationForm = (ProbationForm)form;
		//收集数据
		ProbationBean probationBean =  probationForm.getProbation();
		
		///声明一个service的引用
		ProbationService probationService  = ProbationService.getInstance();
		//调用service层的方法
		 probationService.editProb(probationBean);
		 return mapping.findForward("probationlist");
		
	    }
	/**
	 *  当点击 已转正员查询页面的"查询"按钮调用本方法，查询已转正员工信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	
	public ActionForward findProbationedList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		All all = new All();
		
	    //从页面取出输入的信息并判断后输入ALL中
		
		//*员工编号
		if(request.getParameter("em_number")!=null&&!("").equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
		}
		//*员工姓名
		if(request.getParameter("em_name")!=null&&!("").equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("prob_name"));
		}
		//部门名称
		if(request.getParameter("dept_name")!=null&&!("").equals(request.getParameter("dept_name"))){
			all.setDept_name(request.getParameter("dept_name"));
		}
		 //*部门编号
		if(request.getParameter("dept_number")!=null&&!("").equals(request.getParameter("dept_number"))){
			all.setJob_name(request.getParameter("dept_number"));
		}
			
		//开始查询时间
	    if(request.getParameter("prob_startDate")!=null&&!("").equals(request.getParameter("prob_startDate"))){
			all.setProb_startDate((request.getParameter("prob_startDate")));}
		
		 //*结束查询日期
		if(request.getParameter("prob_endDate")!=null&&!("").equals(request.getParameter("prob_endDate"))){
			all.setProb_endDate((request.getParameter("prob_endDate")));
		}
		//创建业务层实例
	    ProbationService probationService=ProbationService.getInstance();
		//调用业务层方法
		List<ProbationBean> probationList =probationService.listProbed(all);
		request.setAttribute("probationList", probationList);
		return mapping.findForward("probationedlist");//试用期查询
	
	   }	
	}










