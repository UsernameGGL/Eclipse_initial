package com.neusoft.employeemanage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.neusoft.code.domain.Code;
import com.neusoft.code.service.CodeService;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.form.EmployeeActionForm;
import com.neusoft.employeemanage.service.EmployeeService;
import com.neusoft.jobchangemanage.service.JobChService;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.probmanage.service.ProbationService;
import com.neusoft.constant.Constant;
import com.neusoft.deptchangemanage.service.DeptChangeService;
import com.neusoft.deptmanage.domain.Dept;

import devoid.frame.web.BaseAction;



public class EmployeeAction extends BaseAction{
	/**
	 * 在主界面 进入录入员工界面 所调用的方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward loginEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//下拉菜单
		CodeService codeService=CodeService.getInstance();
		List<Code> sexList = codeService.getCode(Constant.SEX);
		List<Code> em_formatList = codeService.getCode(Constant.EM_FORMAT);
		List<Code> em_folkList = codeService.getCode(Constant.EM_FOLK);
		List<Code> em_sourceList = codeService.getCode(Constant.EM_SOURCE);
		List<Code> em_polityList = codeService.getCode(Constant.EM_POLITY);
		List<Code> em_bloodList = codeService.getCode(Constant.EM_BLOOD);
		List<Code> em_wedlockList = codeService.getCode(Constant.EM_WEDLOCK);
		List<Code> em_learnList = codeService.getCode(Constant.EM_LEARN);
		List<Code> em_degreeList = codeService.getCode(Constant.EM_DEGREE);
		request.setAttribute("sexList", sexList);
		request.setAttribute("em_formatList", em_formatList);
		request.setAttribute("em_folkList", em_folkList);
		request.setAttribute("em_sourceList", em_sourceList);
		request.setAttribute("em_polityList", em_polityList);
		request.setAttribute("em_bloodList", em_bloodList);
		request.setAttribute("em_wedlockList", em_wedlockList);
		request.setAttribute("em_learnList", em_learnList);
		request.setAttribute("em_degreeList", em_degreeList);
		
		JobChService jobChangeService = JobChService.getInstance();
		//调用业务层方法获得岗位名称
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		//创建service对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("Addemployee");//登陆界面 进入录入员工
	}
	
	
	/**
	 * 主页面 进入员工中心的方法
	 * 
	 */
	public ActionForward t(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("employCenter");//员工中心
	}
	
	/**
	 * 当点击加入员工后，确认提交时 调用本方法 使数据存入数据库
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//取出界面中输入的信息 创建form对象
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//创建业务层实例
		EmployeeService employeeService = EmployeeService.getInstance();
		
		Boolean b=employeeService.findEmployeeByEm_number(eAForm.getEm_number());
		
		  String alert = "员工增加成功";
		  
		  if(b)
		   {
			  CodeService codeService=CodeService.getInstance();
				List<Code> sexList = codeService.getCode(Constant.SEX);
				List<Code> em_formatList = codeService.getCode(Constant.EM_FORMAT);
				List<Code> em_folkList = codeService.getCode(Constant.EM_FOLK);
				List<Code> em_sourceList = codeService.getCode(Constant.EM_SOURCE);
				List<Code> em_polityList = codeService.getCode(Constant.EM_POLITY);
				List<Code> em_bloodList = codeService.getCode(Constant.EM_BLOOD);
				List<Code> em_wedlockList = codeService.getCode(Constant.EM_WEDLOCK);
				List<Code> em_learnList = codeService.getCode(Constant.EM_LEARN);
				List<Code> em_degreeList = codeService.getCode(Constant.EM_DEGREE);
				request.setAttribute("sexList", sexList);
				request.setAttribute("em_formatList", em_formatList);
				request.setAttribute("em_folkList", em_folkList);
				request.setAttribute("em_sourceList", em_sourceList);
				request.setAttribute("em_polityList", em_polityList);
				request.setAttribute("em_bloodList", em_bloodList);
				request.setAttribute("em_wedlockList", em_wedlockList);
				request.setAttribute("em_learnList", em_learnList);
				request.setAttribute("em_degreeList", em_degreeList);
				alert="员工编号有重复！添加错误！";
				request.setAttribute("showAlert",alert);
				JobChService jobChangeService = JobChService.getInstance();
				//调用业务层方法获得岗位名称
				List<Job> job_nameList = jobChangeService.getJob_name();
				request.setAttribute("job_nameList", job_nameList);
				
				//创建service对象
				DeptChangeService deptChangeService = DeptChangeService.getInstance();
				//调用业务层方法获得部门名称
				List<Dept> dept_nameList = deptChangeService.getDept_name();
				request.setAttribute("dept_nameList", dept_nameList);
				return mapping.findForward("Addemployee");//员工增加
			};
		//调用业务层方法
		Employee a=employeeService.addEmployee(eAForm.getEmployee());
		eAForm.setId(a.getId());
		//判断试用期
		ProbationService instance =ProbationService.getInstance() ;
		instance.addProbation(eAForm.getEmployee());
		
		 request.setAttribute("showAlert",alert);
		return mapping.findForward("employCenter");//员工中心
	}
	
	/**
	 * 当点击“员工中心中，查询按钮”调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward listEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//创建form对象
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//创建业务层实例
		EmployeeService employeeService=EmployeeService.getInstance();
		//创建查询参数bean
		All all = new All();
        //从页面取出输入的信息并判断后输入ALL中
		
		//*员工编号
		if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
			}
		//*员工姓名
		if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("em_name"));
			}
		//部门编号
		if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
			all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
		 //*岗位编号
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number")))
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));
		//调用业务层方法
		List<Employee> employeeList =employeeService.listEmployeeByCondition(all);
		
		eAForm.setList(employeeList);
		
		return mapping.findForward("employCenter");//员工中心
		
	}
	
	/** 
	 * 当用户在   修改  页面点击保存时调用该方法，用来把用户修改信息存入到数据库
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward saveEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//取出界面中输入的信息 创建form对象
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//创建业务层实例
		EmployeeService employeeService = EmployeeService.getInstance();

		Employee employee = eAForm.getEmployee();
		
		employeeService.editEmployee(employee);
		
		
		return mapping.findForward("employCenter");//员工中心
		
	}
	
	/**
	 * 当点击“  员工中心  中 修改 当用户点击修改时，执行此方法，用来把用户所有信息从数据库读出，设置到页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward editEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		//取出界面中输入的信息 创建form对象
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		
		int id=eAForm.getId();
		//创建业务层实例
		EmployeeService employeeService = EmployeeService.getInstance();
		//创建业务层实例
		CodeService codeService=CodeService.getInstance();
		
		List<Code> sexList = codeService.getCode(Constant.SEX);
		List<Code> em_formatList = codeService.getCode(Constant.EM_FORMAT);
		List<Code> em_folkList = codeService.getCode(Constant.EM_FOLK);
		List<Code> em_sourceList = codeService.getCode(Constant.EM_SOURCE);
		List<Code> em_polityList = codeService.getCode(Constant.EM_POLITY);
		List<Code> em_bloodList = codeService.getCode(Constant.EM_BLOOD);
		List<Code> em_wedlockList = codeService.getCode(Constant.EM_WEDLOCK);
		List<Code> em_learnList = codeService.getCode(Constant.EM_LEARN);
		List<Code> em_degreeList = codeService.getCode(Constant.EM_DEGREE);
		request.setAttribute("sexList", sexList);
		request.setAttribute("em_formatList", em_formatList);
		request.setAttribute("em_folkList", em_folkList);
		request.setAttribute("em_sourceList", em_sourceList);
		request.setAttribute("em_polityList", em_polityList);
		request.setAttribute("em_bloodList", em_bloodList);
		request.setAttribute("em_wedlockList", em_wedlockList);
		request.setAttribute("em_learnList", em_learnList);
		request.setAttribute("em_degreeList", em_degreeList);
		
		JobChService jobChangeService = JobChService.getInstance();
		//调用业务层方法获得岗位名称
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		//创建service对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		Employee employee = employeeService.findEmployeeById(id);
		
		eAForm.setEmployee(employee);
		
		return mapping.findForward("employee1");//转到修改界面
		
	}
}

