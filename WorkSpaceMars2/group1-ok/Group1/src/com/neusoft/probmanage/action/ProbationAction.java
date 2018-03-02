



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
	 * ����ת��Ա����Ϣ��ѯҳ����"Ա����Ϣ��ѯ"����ʱ���ã�����ת��Ա����Ϣ��ѯҳ��
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
	 * ��Ա����Ϣ��ѯҳ����"��ת��Ա����Ϣ��ѯ"ʱ���ø÷���������ת����ת��Ա����Ϣ��ѯҳ��
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
	 *   ����������ڲ�ѯҳ���"��ѯ"��ť���ñ�����,���ڲ�ѯʹ���ڵ�Ա����Ϣ
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
        //��ҳ��ȡ���������Ϣ���жϺ�����ALL��
		 
		if(request.getParameter("em_number")!=null&&!("").equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
		}
		//*Ա������
		if(request.getParameter("prob_name")!=null&&!("").equals(request.getParameter("prob_name"))){
			all.setEm_name(request.getParameter("prob_name"));
		}
		//��������
		if(request.getParameter("prob_branchName")!=null&&!"".equals(request.getParameter("prob_branchName"))){
			all.setDept_name(request.getParameter("prob_branchName"));
		}
		 //*��λ����
		if(request.getParameter("prob_jobName")!=null&&!"".equals(request.getParameter("prob_jobName"))){
			all.setJob_name(request.getParameter("prob_jobName"));
		}		 
		
		 //*�����ڿ�ʼ����
		if(request.getParameter("prob_start")!=null&&!("").equals(request.getParameter("prob_start"))){
			all.setProb_start((Date.valueOf(request.getParameter("prob_start"))));
		}
		//*�����ڽ�������
		if(request.getParameter("prob_end")!=null&&!("").equals(request.getParameter("prob_end"))){
			all.setProb_end((Date.valueOf(request.getParameter("prob_end"))));
		}
		//����ҵ���ʵ��
        ProbationService probationService=ProbationService.getInstance();
		//����ҵ��㷽��
		List<All> ProbationList =probationService.listProb(all);
		request.setAttribute("ProbationList", ProbationList);
		//ת��������Ա����Ϣ��ѯҳ��
		return mapping.findForward("probationlist");
	}

	/**
	 * �����"��Ա������"�����ӵ��ñ�����
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
		//���Ա�������id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//����service�����
		EmployeeService  employeeService =EmployeeService.getInstance();
		
		Employee employee = employeeService.findEmployeeById(id);
		
		request.setAttribute("employee", employee);
		
		//��������service����
		CodeService codeService = CodeService.getInstance();
		List<Code> codeList = codeService.getCode(Constant.PROB_RESULTS);
		request.setAttribute("codeList", codeList);
		return mapping.findForward("probationededit");
	}

	 /**
	  * ����������Ա���۵��е��"����"ʱ����,�����۵���Ϣ����������ڱ���
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
		
		//����form����
		ProbationForm probationForm = (ProbationForm)form;
		//�ռ�����
		ProbationBean probationBean =  probationForm.getProbation();
		
		///����һ��service������
		ProbationService probationService  = ProbationService.getInstance();
		//����service��ķ���
		 probationService.editProb(probationBean);
		 return mapping.findForward("probationlist");
		
	    }
	/**
	 *  ����� ��ת��Ա��ѯҳ���"��ѯ"��ť���ñ���������ѯ��ת��Ա����Ϣ
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
		
	    //��ҳ��ȡ���������Ϣ���жϺ�����ALL��
		
		//*Ա�����
		if(request.getParameter("em_number")!=null&&!("").equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
		}
		//*Ա������
		if(request.getParameter("em_name")!=null&&!("").equals(request.getParameter("em_name"))){
			all.setEm_name(request.getParameter("prob_name"));
		}
		//��������
		if(request.getParameter("dept_name")!=null&&!("").equals(request.getParameter("dept_name"))){
			all.setDept_name(request.getParameter("dept_name"));
		}
		 //*���ű��
		if(request.getParameter("dept_number")!=null&&!("").equals(request.getParameter("dept_number"))){
			all.setJob_name(request.getParameter("dept_number"));
		}
			
		//��ʼ��ѯʱ��
	    if(request.getParameter("prob_startDate")!=null&&!("").equals(request.getParameter("prob_startDate"))){
			all.setProb_startDate((request.getParameter("prob_startDate")));}
		
		 //*������ѯ����
		if(request.getParameter("prob_endDate")!=null&&!("").equals(request.getParameter("prob_endDate"))){
			all.setProb_endDate((request.getParameter("prob_endDate")));
		}
		//����ҵ���ʵ��
	    ProbationService probationService=ProbationService.getInstance();
		//����ҵ��㷽��
		List<ProbationBean> probationList =probationService.listProbed(all);
		request.setAttribute("probationList", probationList);
		return mapping.findForward("probationedlist");//�����ڲ�ѯ
	
	   }	
	}










