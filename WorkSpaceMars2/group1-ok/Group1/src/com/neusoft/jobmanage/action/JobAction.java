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
	 * ���"��λ����>>��λ��Ϣ��ѯ��'��ѯ'" ���ñ�����
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
		//����ҵ���ʵ��
		JobService jobService = JobService.getInstance();
		CodeService codeService = CodeService.getInstance();
		//����ҵ��㷽��
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		return mapping.findForward("list");
	}

	/**
	 * ���"��λ����>>����>>'����'" ���ñ�����
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
		String alert = "��λ�Ѵ���,��������";
		JobForm jForm = (JobForm)form;
		JobService jobService = JobService.getInstance();
		//����service��ķ���
		Job job = jForm.getJob();
		
		if(jobService.addJob(job)){
			alert="���ӳɹ�";
			}
		jForm.reset(mapping, request);
		jForm.setJob_situation(1);//�����г����и�λ
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		request.setAttribute("showAlert",alert);
		CodeService codeService = CodeService.getInstance();
		//����codeҵ��㷽��
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		return mapping.findForward("list");
	}

	/**
	 * ���"��λ������>>�޸ĸ�λ>>'����'" ���ñ�����
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
		jForm.setJob_situation(1);//�����г����и�λ
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		return mapping.findForward("list");
	}

	/**
	 * ���"��λ����>>'Ա��'" ��ѯ����λ�µ�Ա����Ϣ ���ñ�����
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
	 * ���"��λ����>>'ɾ��'" ���ñ�����
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
		String alert = "����ɾ����Ա���ĸ�λ";
		JobForm jForm = (JobForm)form;
		JobService jobService = JobService.getInstance();
		Job job = jForm.getJob();
		List<Job> job_list = jobService.findJobList(jForm);
		Job jobman = job_list.get(0);
		if(jobman.getJob_man()==0){
			alert = "ɾ���ɹ�";
		    jobService.delJob(job.getJob_number());		  
			jForm.reset(mapping, request);
			jForm.setJob_situation(1);//�����г����и�λ
			List<Job> jobList = jobService.findJobList(jForm);
			jForm.setList(jobList);
			}
		List<Job> jobList = jobService.findJobList(jForm);
		jForm.setList(jobList);
		request.setAttribute("showAlert",alert);
		return mapping.findForward("list");
	}

	/**
	 * ���"��λ����" ���ñ�����
	 * ��ֵ
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
		//����codeҵ���ʵ��
		CodeService codeService = CodeService.getInstance();
		//����codeҵ��㷽��
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		return mapping.findForward("jobByID");
	}

	/**
	 * ���'��λ������' ���ñ�����
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
	 * ���"��λ����>>'����'" ���ñ�����
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
		//����codeҵ���ʵ��
		CodeService codeService = CodeService.getInstance();
		//����codeҵ��㷽��
		jForm.setId(Constant.JOB_TYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		return mapping.findForward("job_add");
	}
	
	/**
	 * ���'��λ��������' ���ñ�����
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
	 * ��ѯԱ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward listEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//����form����
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//����ҵ���ʵ��
		EmployeeService employeeService=EmployeeService.getInstance();
		//������ѯ����bean
		All all = new All();		
		 //*��λ���
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number")))
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));
		//����ҵ��㷽��
		List<Employee> employeeList =employeeService.listEmployeeByCondition(all);
		
		eAForm.setList(employeeList);
		
		return mapping.findForward("jobemployCenter");//Ա������
		
	}
	

}
