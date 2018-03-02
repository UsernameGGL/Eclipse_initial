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
	 *  点击"部门调动管理"或"员工信息"时，调用该方法，用于将员工查询中需要的部门名称显示出来
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
		//创建service对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("success");
	}
		
	/**
	 * 进入"部门调动管理>>员工信息>>页面，点击此页面的"查询"按钮时调用改方法，用于查询员工信息
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
		//部门编号
		if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
			all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
		
		///声明一个service的引用
		EmployeeService employeeService  = EmployeeService.getInstance();		
		//调用service层的方法
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		request.setAttribute("employeeList", employeeList);
		//创建service对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		
		return mapping.findForward("success");
	}
	/**
	 * 在"部门调动管理>>员工信息>>点击"部门调动"转到员工信息确认页面时调用该方法
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
		//获得员工编号
		int id = Integer.parseInt(request.getParameter("id"));

		///声明一个service的引用
		EmployeeService employeeService  = EmployeeService.getInstance();
		//调用service层的方法，通过员工id查询员工基本信息
		Employee emp = employeeService.findEmployeeById(id);
		request.setAttribute("emp", emp);
	
		//创建service对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用业务层方法获得码表值
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);
		
		request.setAttribute("dept_nameList", dept_nameList);
		request.setAttribute("dept_chTypeList", dept_chTypeList);
		
		return mapping.findForward("change");
	}

	/**
	 * 点进入"部门调动管理>>员工信息查询>>确认员工部门>>页面，点击此页面的"保存"时调用该方法
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
		
		//创建DeptChangeForm对象
		DeptChangeForm deptChangeForm = (DeptChangeForm)form;
		//创建DeptChangeService的对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用service层方法
		deptChangeService.addDeptChange(deptChangeForm.getDeptChange());
		
		//调用业务层方法获得部门名称
		List<Dept> dept_nameList = deptChangeService.getDept_name();
		request.setAttribute("dept_nameList", dept_nameList);
		request.setAttribute("showAlert","调动成功");
		
		//创建码表的CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用业务层方法获得调动类型码表值
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);		
		request.setAttribute("dept_chTypeList", dept_chTypeList);		
		return mapping.findForward("deptchanged");
	}
	/**
	 * 点击"已调动部门员工信息查询"时，调用该方法，显示查询中需要的调动类型的码表值
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
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用业务层方法获得码表值
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);		
		request.setAttribute("dept_chTypeList", dept_chTypeList);		
		return mapping.findForward("deptchanged");
	}
	
	/**
	 * 进入"部门调动管理>>已调动部门员工信息查询>>页面，点击此页面的"查询"时调用该方法
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
		
		//创建All对象
		All all = new All();
		//判断获得的开始日期，结束日期，员工编号，姓名，调动类型是否为空，否的话将获取的值放进all里
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
		
		//创建DeptChangeService对象
		DeptChangeService deptChangeService = DeptChangeService.getInstance();
		//调用DeptChangeService方法
		List<DeptChange> deptChangeList = deptChangeService.listDeptChange(all);
		request.setAttribute("deptChangeList", deptChangeList);
		
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用业务层方法获得码表值
		List<Code> dept_chTypeList  = codeService.getCode(Constant.DEPT_CHTYPE);
		request.setAttribute("dept_chTypeList", dept_chTypeList);
		
//		DeptChangeForm deptChangeForm = (DeptChangeForm)form;
//		DeptChange deptChange = deptChangeForm.getDeptChange();
//		List<DeptChange> deptChangeList = deptChangeService.listDeptChange(deptChange);
//		request.setAttribute("deptChangeList", deptChangeList);
		return mapping.findForward("deptchanged");
	}

}

