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
	 * �������� ����¼��Ա������ �����õķ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward loginEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//�����˵�
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
		//����ҵ��㷽����ø�λ����
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		//����service����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("Addemployee");//��½���� ����¼��Ա��
	}
	
	
	/**
	 * ��ҳ�� ����Ա�����ĵķ���
	 * 
	 */
	public ActionForward t(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("employCenter");//Ա������
	}
	
	/**
	 * ���������Ա����ȷ���ύʱ ���ñ����� ʹ���ݴ������ݿ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//ȡ���������������Ϣ ����form����
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//����ҵ���ʵ��
		EmployeeService employeeService = EmployeeService.getInstance();
		
		Boolean b=employeeService.findEmployeeByEm_number(eAForm.getEm_number());
		
		  String alert = "Ա�����ӳɹ�";
		  
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
				alert="Ա��������ظ�����Ӵ���";
				request.setAttribute("showAlert",alert);
				JobChService jobChangeService = JobChService.getInstance();
				//����ҵ��㷽����ø�λ����
				List<Job> job_nameList = jobChangeService.getJob_name();
				request.setAttribute("job_nameList", job_nameList);
				
				//����service����
				DeptChangeService deptChangeService = DeptChangeService.getInstance();
				//����ҵ��㷽����ò�������
				List<Dept> dept_nameList = deptChangeService.getDept_name();
				request.setAttribute("dept_nameList", dept_nameList);
				return mapping.findForward("Addemployee");//Ա������
			};
		//����ҵ��㷽��
		Employee a=employeeService.addEmployee(eAForm.getEmployee());
		eAForm.setId(a.getId());
		//�ж�������
		ProbationService instance =ProbationService.getInstance() ;
		instance.addProbation(eAForm.getEmployee());
		
		 request.setAttribute("showAlert",alert);
		return mapping.findForward("employCenter");//Ա������
	}
	
	/**
	 * �������Ա�������У���ѯ��ť�����ñ�����
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
        //��ҳ��ȡ���������Ϣ���жϺ�����ALL��
		
		//*Ա�����
		if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
			}
		//*Ա������
		if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("em_name"));
			}
		//���ű��
		if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
			all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
		 //*��λ���
		if(request.getParameter("job_number")!=null&&!"".equals(request.getParameter("job_number")))
			all.setJob_number(Integer.parseInt(request.getParameter("job_number")));
		//����ҵ��㷽��
		List<Employee> employeeList =employeeService.listEmployeeByCondition(all);
		
		eAForm.setList(employeeList);
		
		return mapping.findForward("employCenter");//Ա������
		
	}
	
	/** 
	 * ���û���   �޸�  ҳ��������ʱ���ø÷������������û��޸���Ϣ���뵽���ݿ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward saveEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//ȡ���������������Ϣ ����form����
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		//����ҵ���ʵ��
		EmployeeService employeeService = EmployeeService.getInstance();

		Employee employee = eAForm.getEmployee();
		
		employeeService.editEmployee(employee);
		
		
		return mapping.findForward("employCenter");//Ա������
		
	}
	
	/**
	 * �������  Ա������  �� �޸� ���û�����޸�ʱ��ִ�д˷������������û�������Ϣ�����ݿ���������õ�ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward editEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		//ȡ���������������Ϣ ����form����
		EmployeeActionForm eAForm = (EmployeeActionForm) form;
		
		int id=eAForm.getId();
		//����ҵ���ʵ��
		EmployeeService employeeService = EmployeeService.getInstance();
		//����ҵ���ʵ��
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
		//����ҵ��㷽����ø�λ����
		List<Job> job_nameList = jobChangeService.getJob_name();
		request.setAttribute("job_nameList", job_nameList);
		
		//����service����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		Employee employee = employeeService.findEmployeeById(id);
		
		eAForm.setEmployee(employee);
		
		return mapping.findForward("employee1");//ת���޸Ľ���
		
	}
}

