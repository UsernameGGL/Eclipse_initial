package com.neusoft.deptchangemanage.action;

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
import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.deptchangemanage.service.DeptChangeService;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.deptmanage.form.DeptForm;
import com.neusoft.deptmanage.service.DeptService;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;

import devoid.frame.web.BaseAction;

public class DeptChangeAction extends BaseAction {
	/**
	 *  ���"���ŵ�������"��"Ա����Ϣ"ʱ�����ø÷��������ڽ�Ա����ѯ����Ҫ�Ĳ���������ʾ����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forwardEmplList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����service����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("success");
	}
		
	/**
	 * ����"���ŵ�������>>Ա����Ϣ>>ҳ�棬�����ҳ���"��ѯ"��ťʱ���øķ��������ڲ�ѯԱ����Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listEmpl(ActionMapping mapping, ActionForm form,
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
		//���ű��
		if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
			all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
		
		///����һ��service������
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//����service��ķ���
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		request.setAttribute("employeeList", employeeList);
		//����service����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("success");
	}
	/**
	 * ��"���ŵ�������>>Ա����Ϣ>>���"���ŵ���"ת��Ա����Ϣȷ��ҳ��ʱ���ø÷���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getEmplById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//���Ա�����
		int id = Integer.parseInt(request.getParameter("id"));

		///����һ��service������
		EmployeeService employeeService  = EmployeeService.getInstance();
		//����service��ķ�����ͨ��Ա��id��ѯԱ��������Ϣ
		Employee emp = employeeService.findEmployeeById(id);
		request.setAttribute("emp", emp);
	
		//����service����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//����ҵ��㷽��������ֵ
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);
		
		request.setAttribute("dept_nameList", dept_nameList);
		request.setAttribute("dept_chTypeList", dept_chTypeList);
		
		return mapping.findForward("change");
	}

	/**
	 * �����"���ŵ�������>>Ա����Ϣ��ѯ>>ȷ��Ա������>>ҳ�棬�����ҳ���"����"ʱ���ø÷���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addDeptChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//����DeptChangeForm����
		DeptChangeForm deptChangeForm = (DeptChangeForm)form;
		//����DeptChangeService�Ķ���
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����service�㷽��
		deptChangeService.addDeptChange(deptChangeForm.getDeptChange());
		
		//����ҵ��㷽����ò�������
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		request.setAttribute("showAlert","�����ɹ�");
		
		//��������CodeService����
		CodeService codeService = CodeService.getInstance();
		//����ҵ��㷽����õ����������ֵ
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);		
		request.setAttribute("dept_chTypeList", dept_chTypeList);		
		return mapping.findForward("deptchanged");
	}
	/**
	 * ���"�ѵ�������Ա����Ϣ��ѯ"ʱ�����ø÷�������ʾ��ѯ����Ҫ�ĵ������͵����ֵ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forwardDeptChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//����ҵ��㷽��������ֵ
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);		
		request.setAttribute("dept_chTypeList", dept_chTypeList);		
		return mapping.findForward("deptchanged");
	}
	
	/**
	 * ����"���ŵ�������>>�ѵ�������Ա����Ϣ��ѯ>>ҳ�棬�����ҳ���"��ѯ"ʱ���ø÷���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listDeptChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//����All����
		All all = new All();
		//�жϻ�õĿ�ʼ���ڣ��������ڣ�Ա����ţ����������������Ƿ�Ϊ�գ���Ļ�����ȡ��ֵ�Ž�all��
		if(request.getParameter("dept_startDate")!=null&&!"".equals(request.getParameter("dept_startDate"))){
			all.setDept_startDate(request.getParameter("dept_startDate"));
		}
		if(request.getParameter("dept_endDate")!=null&&!"".equals(request.getParameter("dept_endDate"))){
			all.setDept_endDate(request.getParameter("dept_endDate"));
		}
		if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
			all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
		}
		if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
			all.setEm_name((request.getParameter("em_name")));
		}
		if(request.getParameter("dept_chType")!=null&&!"".equals(request.getParameter("dept_chType"))){
			all.setDept_chType(Integer.parseInt(request.getParameter("dept_chType")));
		}
		
		//����DeptChangeService����
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//����DeptChangeService����
		List<DeptChange> deptChangeList = deptChangeService.listDeptChange(all);
		request.setAttribute("deptChangeList", deptChangeList);
		
		//����CodeService����
		CodeService codeService = CodeService.getInstance();
		//����ҵ��㷽��������ֵ
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);
		request.setAttribute("dept_chTypeList", dept_chTypeList);
		
//		DeptChangeForm deptChangeForm = (DeptChangeForm)form;
//		DeptChange deptChange = deptChangeForm.getDeptChange();
//		List<DeptChange> deptChangeList = deptChangeService.listDeptChange(deptChange);
//		request.setAttribute("deptChangeList", deptChangeList);
		return mapping.findForward("deptchanged");
	}

}

