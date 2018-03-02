package com.neusoft.deptmanage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.neusoft.code.domain.Code;
import com.neusoft.code.service.CodeService;
import com.neusoft.constant.Constant;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.deptmanage.form.DeptForm;
import com.neusoft.deptmanage.service.DeptService;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;

import devoid.frame.web.BaseAction;

public class DeptAction extends BaseAction {
	/**
	 * �����"���Ź���"ʱ�����ø÷���,��ȡ����е�ֵ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forwardDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����DeptForm����
		DeptForm deptForm = (DeptForm)form;
		//����һ������service����
		CodeService codeService = CodeService.getInstance();
		//�������service�㷽��
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		//ת��
		return mapping.findForward("success");
	}
	
	/**
	 * �����"����"��ťʱ�����ø÷���������ת�����Ӳ���ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addPrompt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����DeptForm����
		DeptForm deptForm = (DeptForm)form;
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//��������service����
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		//����service����
		DeptService deptService  = DeptService.getInstance();
		//����service������ȡ�ϼ�����
		List<Dept> dept_superList = deptService.getDept_superName();
		
		request.setAttribute("dept_typeList", dept_typeList);
		request.setAttribute("dept_superList", dept_superList);
		//ת��
		return mapping.findForward("add");
	}

    /**
     * ������ҳ��㱣��ʱ���ø÷���,����һ������     
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward addDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         String alert = "���ű���Ѵ���,��������";
		//����DeptForm����
		DeptForm deptForm = (DeptForm)form;
		//����һ��service������
		DeptService deptService  = DeptService.getInstance();
		//����service��ķ���
		if(deptService.addDept(deptForm.getDept())){
			alert="���ӳɹ�";
		};
		
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//��������service����
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		
		
		request.setAttribute("dept_typeList", dept_typeList);
		
        request.setAttribute("showAlert",alert);
		//ת��
		return mapping.findForward("success");
	}
	/**
	 *�������ѯҳ��ʱ���ڲ�ѯҳ����"��ѯ"���ø÷��������ڲ�Ѱ���ݿ��в��ŵ���Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����DeptForm����
		DeptForm deptForm = (DeptForm)form;
		
		//����һ��service�����ú�����service����
		DeptService deptService  = DeptService.getInstance();
        CodeService codeService = CodeService.getInstance();
		
		//����service��ķ���
		List<Dept> deptList = deptService.listDept(deptForm.getDept());
	    List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);	
	    
	    
		request.setAttribute("deptList", deptList);
        request.setAttribute("dept_typeList", dept_typeList);
      
		//ת��
		return mapping.findForward("success");
	}
	
	/**
	 * �����벿�Ż�����Ϣҳ�棬���"��������"ʱ���ø÷�������ѯĳһ�����ŵľ�����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getDeptById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DeptForm df = (DeptForm)form;
		//��ȡ���ű��
		int id = Integer.parseInt(request.getParameter("id"));
		//����һ��service������
		DeptService deptService  = DeptService.getInstance();
		
		//����service��ķ���
		Dept dept = deptService.getDeptById(id);
		
		request.setAttribute("dept", dept);
		
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//��������service����
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		List<Dept> dept_superList = deptService.getDept_superName();
		request.setAttribute("dept_superList", dept_superList);
		
		//ת��
		return mapping.findForward("edit");
	}
	
	/**
	 * �����벿�Ż�����Ϣҳ�棬���޸�ҳ���"����"ʱ���ø÷����������޸����ݿ��еĲ�����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String alert = "�޸ĳɹ�";
        //����DeptFrom����
		DeptForm deptForm = (DeptForm)form;
		//����һ��service������
		DeptService deptService  = DeptService.getInstance();
		//����service��ķ���
		
		deptService.editDept(deptForm.getDept());
			  		
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//��������service����
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
        request.setAttribute("showAlert", alert);
		//ת��
		return mapping.findForward("success");
		
	}
	/**
	 * �����ɾ��ʱ�����ø÷���������ɾ�����ݿ��е�һ������ 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
                String alert = "���Ŵ���Ա��,����ɾ��";
		//����DeptFrom����
		DeptForm deptForm = (DeptForm)form;
		//��ȡ�����������
		int dept_number = Integer.parseInt(request.getParameter("dept_number"));
		//����һ��service������
		DeptService deptService  = DeptService.getInstance();
		
		//����service��ķ���
		
		if(deptService.delDept(dept_number)){
			alert="ɾ���ɹ�";
		}
        //��������service����
        CodeService codeService = CodeService.getInstance();
        //��������service����
        List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		request.setAttribute("showAlert", alert);
		//ת��
		return mapping.findForward("success");
	}
	
	/**
	 * �����Ա��ʱ�����ø÷��������ڲ�ѯ���ݿ���ĳһ�����µ�����Ա��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listAllDeptEmpl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ�Ѳ鵽�Ĳ��ŵı��
		int dept_number = Integer.parseInt(request.getParameter("dept_number"));
		//����All����
		All all = new All();
		all.setDept_number(dept_number);
		///����һ��service������
		EmployeeService employeeService  = EmployeeService.getInstance();
		
		//����service��ķ���
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		
		request.setAttribute("employeeList", employeeList);
		//ת��
		return mapping.findForward("list");
	}
}
