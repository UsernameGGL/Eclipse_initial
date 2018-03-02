package com.neusoft.jobmanage.action;

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
import com.neusoft.employeemanage.form.EmployeeActionForm;
import com.neusoft.employeemanage.service.EmployeeService;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;
import com.neusoft.jobmanage.service.JobService;
import devoid.frame.web.BaseAction;

public class JobAction extends BaseAction {

	/**
	 * 点击"岗位管理>>岗位信息查询的'查询'" 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward listJob(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		JobForm jForm = (JobForm)form;
		//创建业务层实例
		JobService jobService = JobService.getInstance();
		CodeService codeService = CodeService.getInstance();
		//调用业务层方法
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		return mapping.findForward("list");
	}

	/**
	 * 点击"岗位管理>>增加>>'保存'" 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addJob(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String alert = "岗位已存在,不能增加";
		JobForm jForm = (JobForm)form;
		JobService jobService = JobService.getInstance();
		//调用service层的方法
		Job job = jForm.getJob();
		
		if(jobService.addJob(job)){
			alert="增加成功";
			}
		jForm.reset(mapping, request);
		jForm.setJob_situation(1);//用于列出所有岗位
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		request.setAttribute("showAlert",alert);
		CodeService codeService = CodeService.getInstance();
		//调用code业务层方法
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		return mapping.findForward("list");
	}

	/**
	 * 点击"岗位的名称>>修改岗位>>'保存'" 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editJob(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		JobService jobService = JobService.getInstance();
		Job job = jForm.getJob();
		jobService.editJob(job);
		jForm.reset(mapping, request);
		jForm.setJob_situation(1);//用于列出所有岗位
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		return mapping.findForward("list");
	}

	/**
	 * 点击"岗位管理>>'员工'" 查询本岗位下的员工信息 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return super.execute(mapping, form, request, response);
	}

	/**
	 * 点击"岗位管理>>'删除'" 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delJob(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String alert = "不能删除有员工的岗位";
		JobForm jForm = (JobForm)form;
		JobService jobService = JobService.getInstance();
		Job job = jForm.getJob();
		List<Job> job_list = jobService.findJobList(jForm);
		Job jobman = job_list.get(0);
		if(jobman.getJob_man()==0){
			alert = "删除成功";
		    jobService.delJob(job.getJob_number());		  
			jForm.reset(mapping, request);
			jForm.setJob_situation(1);//用于列出所有岗位
			List<Job> jobList = jobService.findJobList(jForm);
			jForm.setList(jobList);
			}
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		request.setAttribute("showAlert",alert);
		return mapping.findForward("list");
	}

	/**
	 * 点击"岗位管理" 调用本方法
	 * 传值
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getJobByID(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		//创建code业务层实例
		CodeService codeService = CodeService.getInstance();
		//调用code业务层方法
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		return mapping.findForward("jobByID");
	}

	/**
	 * 点击'岗位的名字' 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward job(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		CodeService codeService = CodeService.getInstance();
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		JobService jobService = JobService.getInstance();
		List<Job> jobList = jobService.findJobList(jForm);
		Job job = (Job)jobList.get(0);
		jForm.setJob(job);
		jForm.setList(jobList);
		return mapping.findForward("jobName");
	}

	/**
	 * 点击"岗位管理>>'增加'" 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		//创建code业务层实例
		CodeService codeService = CodeService.getInstance();
		//调用code业务层方法
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		return mapping.findForward("job_add");
	}
	
	/**
	 * 点击'岗位调动管理' 调用本方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jobCh(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		jForm.setJob_situation(1);
		JobService jobService = JobService.getInstance();
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		return mapping.findForward("jobCh");
	}
	/**
	 * 查询员工
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
		 //*岗位编号
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number")))
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));
		//调用业务层方法
		List<Employee> employeeList =employeeService.listEmployeeByCondition(all);
		
		eAForm.setList(employeeList);
		
		return mapping.findForward("jobemployCenter");//员工中心
		
	}
	

}
