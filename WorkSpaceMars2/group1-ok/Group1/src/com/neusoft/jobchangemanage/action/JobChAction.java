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
	 * ���"��λ��������>>Ա����Ϣ>>'��ѯ'" ���ñ�����
	 */
	
	
	
	public ActionForward listEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����All����
		All all = new All();
		// �жϻ�ȡ��Ա����ţ�Ա�����������ű���Ƿ�Ϊ�գ���Ϊ�յĻ�����ȡ��Ա����ţ��������������ƣ���λ���ƷŽ�All��
		if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
			}
		//*Ա������
		if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("em_name"));
			}
		//��λ���
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number"))){
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));}
		
		///����һ��service������
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//����service��ķ���
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		
		request.setAttribute("employeeList", employeeList);
		
		//����service����
		JobChService jobChService = JobChService.getInstance();
		//����ҵ��㷽����ø�λ����
		List<Job> job_nameList = jobChService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		return mapping.findForward("success");
	}
	
	
	

	/**
	 * ���"��λ��������>>Ա����Ϣ��ѯ>>��λ����>>'����'" ���ñ�����
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
		//�г����Ե���Ա����Ϣ
		return mapping.findForward("jobChList");
	}
	
	
	

	/**
	 * ���"��λ��������>>�ѵ���Ա����Ϣ��ѯ>>'��ѯ'" ���ñ�����
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
	 * ���"��λ��������>>Ա����Ϣ��ѯ>>'��λ����'" ���ñ�����
	 * ��Ҫ������Ա�����е����༭
	 */
	
	
	
	public ActionForward editJobCh(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		
		//����codeҵ���ʵ��
		CodeService codeService = CodeService.getInstance();
		//����codeҵ��㷽��
		jForm.setId(Constant.JOB_CHTYPE);
		//����ҵ��㷽����õ�ת��ʽ
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);
		
		JobChService jobChangeService = JobChService.getInstance();
		//����ҵ��㷽����ø�λ����
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		int id = Integer.parseInt(request.getParameter("id"));
		All all  = new All();
		all.setId(id);
		///����һ��service������
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//����service��ķ���
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		Employee employee =(Employee)employeeList.get(0);
				
		request.setAttribute("employee", employee);
		return mapping.findForward("editJobCh");
	}
	
	
	
	/**
	 * ���"�ѵ�����λ��Ϣ��ѯ"���ñ�����
	 */
	
	
	
	
	public ActionForward jobChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JobForm jForm = (JobForm)form;
		//����codeҵ���ʵ��
		CodeService codeService = CodeService.getInstance();
		//����codeҵ��㷽��
		jForm.setId(Constant.JOB_CHTYPE);
		List<Code> codeList = codeService.getCode(jForm.getId());
		jForm.setCodeList(codeList);	
		return mapping.findForward("jobChByID");
	}
	
	
	
	
	/**
	 *  ���"��λ��������"��"Ա����Ϣ"ʱ�����ø÷��������ڽ�Ա���涨Ϊ��ѯ����Ҫ������е�ֵ��ʾ����
	 */
	
	
	
	
	public ActionForward forwardEmplList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����service����
		JobChService jobChangeService = JobChService.getInstance();
		//����ҵ��㷽����ø�λ����
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		//request.setAttribute("job_nameList", job_nameList);
		
		return mapping.findForward("success");
	}
	
}
