package com.neusoft.domimanage.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.neusoft.code.domain.Code;
import com.neusoft.code.service.CodeService;
import com.neusoft.constant.Constant;
import com.neusoft.domimanage.domain.DomiBean;
import com.neusoft.domimanage.form.DomiForm;
import com.neusoft.domimanage.service.DomiService;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;

import devoid.frame.web.BaseAction;



public class DomiAction extends BaseAction{
	
	/**
	 * ��������� ��ְԱ������ ���ñ����� **** 
	 * 
	 * ����ְԱ��ҳ��
	 */	
		public ActionForward login(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			CodeService codeService=CodeService.getInstance();
			List<Code> emList = codeService.getCode(Constant.EM_FORMAT);
			request.setAttribute("emList", emList);
			
			
			 return mapping.findForward("et");
			 //���������ְԱ������
			 //��ְҳ���г�����
			}
	/**
	 * ��ְԱ�� ҳ���г����� -- ��ְԱ�������ѯ
	 */	
		public ActionForward gologin(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		CodeService codeService=CodeService.getInstance();
		List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
		request.setAttribute("typeList", typeList);
			 return mapping.findForward("dt");
			 //��ְҳ��ĳ�����
			}
		
	/**
	 * ��ְԱ����ѯҳ���е� ��ѯ��ť
	 */	
		public ActionForward zcha(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//�����˵�
			CodeService codeService=CodeService.getInstance();
			List<Code> emList = codeService.getCode(Constant.EM_FORMAT);
			request.setAttribute("emList", emList);
			
			DomiForm dform=(DomiForm)form;
			
			EmployeeService employeeService=EmployeeService.getInstance();
			//������ѯ����bean
			All all = new All();
	        //��ҳ��ȡ���������Ϣ���жϺ�����ALL��
			
			//*Ա�����
			if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
				all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
				}
			//*��������
			if(request.getParameter("dept_name")!=null&&!"".equals(request.getParameter("dept_name"))){
				all.setEm_name(request.getParameter("dept_name"));
				}
			//���ű��
			if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
				all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
			 //*Ա��״̬
			if(request.getParameter("em_format")!=null&&!"".equals(request.getParameter("em_format")))
				all.setEm_format(Integer.parseInt(request.getParameter("em_format")));
			//����ҵ��㷽��
			List<Employee> elist=employeeService.listEmployeeByCondition(all);
			
			dform.setElist(elist);
			
			 return mapping.findForward("et");
			 //��ְԱ����ѯҳ��
			}
		
	/**
	 * ��ְԱ����ѯҳ���е� ��ְ������
	 */		
		public ActionForward lzc(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//�����˵�
			CodeService codeService=CodeService.getInstance();
			
			List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
			
			request.setAttribute("typeList", typeList);
			
			DomiForm dform=(DomiForm)form;
			
			int id=dform.getId();
			
			EmployeeService employeeService = EmployeeService.getInstance();
			
			Employee employee = employeeService.findEmployeeById(id);
			
			dform.setEmployee(employee);
			
			
			 return mapping.findForward("el");
			 //del
			}
		
	/**
	 * ��ְԱ����ѯҳ���е� ��ѯ��ť
	 */	
		public ActionForward lcha(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//�����˵�
			CodeService codeService=CodeService.getInstance();
			List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
			request.setAttribute("typeList", typeList);
			
            DomiForm dform=(DomiForm)form;
			
			EmployeeService employeeService=EmployeeService.getInstance();
			//������ѯ����bean
			All all = new All();
	        //��ҳ��ȡ���������Ϣ���жϺ�����ALL��
			
			//*Ա�����
			if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
				all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
				}
			//Ա������
			if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
				all.setEm_name(request.getParameter("em_name"));
				}
			//*��������
			if(request.getParameter("dept_name")!=null&&!"".equals(request.getParameter("dept_name"))){
				all.setDept_name(request.getParameter("dept_name"));
				}
			//��λ����
			if(request.getParameter("job_name")!=null&&!"".equals(request.getParameter("job_name"))){
				all.setJob_name(request.getParameter("job_name"));
				}
			 //*��ְ����
			if(request.getParameter("lz_type")!=null&&!"".equals(request.getParameter("lz_type")))
				all.setLz_type(Integer.parseInt(request.getParameter("lz_type")));
			//��ʼ����
			if(request.getParameter("begin_date")!=null&&!"".equals(request.getParameter("begin_date")))
				all.setBegin_date(request.getParameter("begin_date"));
	
			//��������
			if(request.getParameter("end_date")!=null&&!"".equals(request.getParameter("end_date")))
				all.setEnd_date(request.getParameter("end_date"));
	
			
			
			//����ҵ��㷽��
			List<Employee> elist=employeeService.listEmployeeByCondition(all);
			
			dform.setElist(elist);
			
			
			
			 return mapping.findForward("dt");
			 //��ְҳ��ĳ�����
			}

		
	/**
	 * ��ְ  ԭ��ҳ�� ȷ��
	 * 
	 */	
		public ActionForward que(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			DomiForm dfrom=(DomiForm)form;
			
			DomiService domiService=DomiService.getInstance();
			
			DomiBean domi=dfrom.getDomiBean();
			
			domiService.addDomi(domi);
			
			CodeService codeService=CodeService.getInstance();
			List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
			request.setAttribute("typeList", typeList);
			
			 return mapping.findForward("dt");
			 //��ְҳ��ĳ�����
			}
}
		
		
		
		
		
		
//   /**
//    * �������ѯʱ����ѯԱ����Ϣ��������ʾ�ڽ����ϡ�
//    * @param mapping
//    * @param form
//    * @param request
//    * @param response
//    * @return
//    * @throws Exception
//    */
//	   public ActionForward listEmp(ActionMapping mapping, ActionForm form,
//			   HttpServletRequest request, HttpServletResponse response)
//			   throws Exception {
//		   DomiBean domi = null;
//		   DomiForm dForm = (DomiForm)form;
//		   dForm.getBegin_Date(begin_Date)
//			//����ҵ���ʵ��
//			DomiService domiService =new DomiService();
//			//����ҵ��㷽��
//			List<DomiBean> listEmp = domiService.listEmp(domi);
//			dForm.setList(listEmp);
//		  return super.execute(mapping, form, request, response);
//	}
//	/**
//	 * ��ѯ��ְԱ����Ϣ��������ʾ�ڽ����ϡ�
//	 * @param mapping
//	 * @param form
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//		public ActionForward listDomi(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			// TODO Auto-generated method stub
//			return super.execute(mapping, form, request, response);
//		}
//	/**
//	 * �������ְʱ����ת������ְ��Ϣ���棬����������˵���ֵ
//	 * @param mapping
//	 * @param form
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//		public ActionForward forwardDomi(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			// TODO Auto-generated method stub
//			 return super.execute(mapping, form, request, response);
//			}
//		/**
//		 * �������ְ��Ϣ�е�ȷ����ťʱ����Ա����Ϣɾ�������Ҽ�������ְԱ����Ϣ��
//		 */
//		public ActionForward delEmp(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			// TODO Auto-generated method stub
//			 return super.execute(mapping, form, request, response);
//			}
//	/**
//	 * �����Ա����ְ����ʱ����ת����ְ��Ա��ѯ���棬�������ѯ��ְ��Ա��ϢʱҲ
//	 * ���ô�action����ת����ְ��ѡ��ѯ����
//	 */
//		public ActionForward forwardListEmp(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			CodeService codeService=CodeService.getInstance();
//			List<Code> list=codeService.getCode(Constant.EM_FORMAT);
//			 return mapping.findForward("employeeList");
//			}
//	/**
//	 * �������ѯ��ְԱ����Ϣʱ����ת������ְ��Ա��ѯ����
//	 */	
//		public ActionForward forwardListDomi(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			
//			 return mapping.findForward("domiList");
//			}
//}
