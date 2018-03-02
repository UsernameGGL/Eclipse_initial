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
	 * 当点击"部门管理"时，调用该方法,获取码表中的值
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
		//创建DeptForm对象
		DeptForm deptForm = (DeptForm)form;
		//声明一个码表的service引用
		CodeService codeService = CodeService.getInstance();
		//调用码表service层方法
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		//转向
		return mapping.findForward("success");
	}
	
	/**
	 * 当点击"增加"按钮时，调用该方法，用于转到增加部门页面
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
		//创建DeptForm对象
		DeptForm deptForm = (DeptForm)form;
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用码表的service方法
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		//创建service对象
		DeptService deptService  = DeptService.getInstance();
		//调用service方法获取上级部门
		List<Dept> dept_superList = deptService.getDept_superName();
		
		request.setAttribute("dept_typeList", dept_typeList);
		request.setAttribute("dept_superList", dept_superList);
		//转向
		return mapping.findForward("add");
	}

    /**
     * 在增加页面点保存时调用该方法,增加一个部门     
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
         String alert = "部门编号已存在,不能增加";
		//创建DeptForm对象
		DeptForm deptForm = (DeptForm)form;
		//声明一个service的引用
		DeptService deptService  = DeptService.getInstance();
		//调用service层的方法
		if(deptService.addDept(deptForm.getDept())){
			alert="增加成功";
		};
		
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用码表的service方法
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		
		
		request.setAttribute("dept_typeList", dept_typeList);
		
        request.setAttribute("showAlert",alert);
		//转向
		return mapping.findForward("success");
	}
	/**
	 *当进入查询页面时，在查询页面点击"查询"调用该方法，用于查寻数据库中部门的信息
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
		//创建DeptForm对象
		DeptForm deptForm = (DeptForm)form;
		
		//声明一个service的引用和码表的service引用
		DeptService deptService  = DeptService.getInstance();
        CodeService codeService = CodeService.getInstance();
		
		//调用service层的方法
		List<Dept> deptList = deptService.listDept(deptForm.getDept());
	    List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);	
	    
	    
		request.setAttribute("deptList", deptList);
        request.setAttribute("dept_typeList", dept_typeList);
      
		//转向
		return mapping.findForward("success");
	}
	
	/**
	 * 当进入部门基本信息页面，点击"部门名称"时调用该方法，查询某一个部门的具体信息
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
		//获取部门编号
		int id = Integer.parseInt(request.getParameter("id"));
		//声明一个service的引用
		DeptService deptService  = DeptService.getInstance();
		
		//调用service层的方法
		Dept dept = deptService.getDeptById(id);
		
		request.setAttribute("dept", dept);
		
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用码表的service方法
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		List<Dept> dept_superList = deptService.getDept_superName();
		request.setAttribute("dept_superList", dept_superList);
		
		//转向
		return mapping.findForward("edit");
	}
	
	/**
	 * 当进入部门基本信息页面，在修改页面点"保存"时调用该方法，用来修改数据库中的部门信息
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
		String alert = "修改成功";
        //创建DeptFrom对象
		DeptForm deptForm = (DeptForm)form;
		//声明一个service的引用
		DeptService deptService  = DeptService.getInstance();
		//调用service层的方法
		
		deptService.editDept(deptForm.getDept());
			  		
		//创建CodeService对象
		CodeService codeService = CodeService.getInstance();
		//调用码表的service方法
		List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
        request.setAttribute("showAlert", alert);
		//转向
		return mapping.findForward("success");
		
	}
	/**
	 * 当点击删除时，调用该方法，用于删除数据库中的一个部门 
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
                String alert = "部门存在员工,不能删除";
		//创建DeptFrom对象
		DeptForm deptForm = (DeptForm)form;
		//获取部门主键编号
		int dept_number = Integer.parseInt(request.getParameter("dept_number"));
		//声明一个service的引用
		DeptService deptService  = DeptService.getInstance();
		
		//调用service层的方法
		
		if(deptService.delDept(dept_number)){
			alert="删除成功";
		}
        //声明码表的service引用
        CodeService codeService = CodeService.getInstance();
        //调用码表的service方法
        List<Code> dept_typeList = codeService.getCode(Constant.DEPT_TYPE);
		request.setAttribute("dept_typeList", dept_typeList);
		request.setAttribute("showAlert", alert);
		//转向
		return mapping.findForward("success");
	}
	
	/**
	 * 当点击员工时，调用该方法，用于查询数据库中某一部门下的所有员工
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
		//获取已查到的部门的编号
		int dept_number = Integer.parseInt(request.getParameter("dept_number"));
		//创建All对象
		All all = new All();
		all.setDept_number(dept_number);
		///声明一个service的引用
		EmployeeService employeeService  = EmployeeService.getInstance();
		
		//调用service层的方法
		List<Employee> employeeList= employeeService.listEmployeeByCondition(all);
		
		request.setAttribute("employeeList", employeeList);
		//转向
		return mapping.findForward("list");
	}
}
