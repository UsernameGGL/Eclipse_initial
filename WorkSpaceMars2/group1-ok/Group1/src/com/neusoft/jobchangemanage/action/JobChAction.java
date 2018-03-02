package com.neusoft.jobchangemanage.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.neusoft.code.domain.Code;
import com.neusoft.code.service.CodeService;
import com.neusoft.constant.Constant;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;
import com.neusoft.jobchangemanage.domain.JobCh;
import com.neusoft.jobchangemanage.form.JobChForm;
import com.neusoft.jobchangemanage.service.JobChService;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;
import devoid.frame.web.BaseAction;

public class JobChAction extends BaseAction {
	
	

	/**
	 * 点击"岗位调动管理>>员工信息>>'查询'" 调用本方法
	 */
	
	
	
	public ActionForward listEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//创建All对象
		All all = new All();
		// 判断获取的员工编号，员工姓名，部门编号是否为空，不为空的话将获取的员工编号，姓名，部门名称，岗位名称放进All里
		if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
			}
		//*员工姓名
		if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("em_name"));
			}
		//岗位编号
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number"))){
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));}
		
		///声明一个service的引用
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//调用service层的方法
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		
		request.setAttribute("employeeList", employeeList);
		
		//创建service对象
		JobChService jobChService = JobChService.getInstance();
		//调用业务层方法获得岗位名称
		List<Job> job_nameList = jobChService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		return mapping.findForward("success");
	}
	
	
	

	/**
	 * 点击"岗位调动管理>>员工信息查询>>岗位调动>>'保存'" 调用本方法
	 */
	
	
	
	
	public ActionForward addJobCh(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobChForm jForm = (JobChForm)form;
		JobChService jobChService = JobChService.getInstance();
		JobCh jobCh = jForm.getJobCh();
		jobChService.addJobCh(jobCh);
		List<JobCh> jobChList = jobChService.listDetailEmpl(jobCh);
		jForm.setList(jobChList);
		//列出所以调动员工信息
		return mapping.findForward("jobChList");
	}
	
	
	

	/**
	 * 点击"岗位调动管理>>已调动员工信息查询>>'查询'" 调用本方法
	 */
	
	
	
	
	public ActionForward listChEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobChForm jForm = (JobChForm)form;
		JobChService jobChService = JobChService.getInstance();
		JobCh jobCh = jForm.getJobCh();
		List<JobCh> jobChList = jobChService.listDetailEmpl(jobCh);
		jForm.setList(jobChList);
		return mapping.findForward("jobChList");
	}
	
	

	/**
	 * 点击"岗位调动管理>>员工信息查询>>'岗位调动'" 调用本方法
	 * 对要调动的员工进行调动编辑
	 */
	
	
	
	public ActionForward editJobCh(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		
		//创建code业务层实例
		CodeService codeService = CodeService.getInstance();
		//调用code业务层方法
		jForm.setId(Constant.JOB_CHTYPE);
		//调用业务层方法获得调转方式
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		JobChService jobChangeService = JobChService.getInstance();
		//调用业务层方法获得岗位名称
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		int id = Integer.parseInt(request.getParameter("id"));
		All all  = new All();
		all.setId(id);
		///声明一个service的引用
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//调用service层的方法
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		Employee employee =(Employee)employeeList.get(0);
				
		request.setAttribute("employee", employee);
		return mapping.findForward("editJobCh");
	}
	
	
	
	/**
	 * 点击"已调动岗位信息查询"调用本方法
	 */
	
	
	
	
	public ActionForward jobChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		//创建code业务层实例
		CodeService codeService = CodeService.getInstance();
		//调用code业务层方法
		jForm.setId(Constant.JOB_CHTYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);	
		return mapping.findForward("jobChByID");
	}
	
	
	
	
	/**
	 *  点击"岗位调动管理"或"员工信息"时，调用该方法，用于将员工规定为查询中需要的码表中的值显示出来
	 */
	
	
	
	
	public ActionForward forwardEmplList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//创建service对象
		JobChService jobChangeService = JobChService.getInstance();
		//调用业务层方法获得岗位名称
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		//request.setAttribute("job_nameList", job_nameList);
		
		return mapping.findForward("success");
	}
	
}
