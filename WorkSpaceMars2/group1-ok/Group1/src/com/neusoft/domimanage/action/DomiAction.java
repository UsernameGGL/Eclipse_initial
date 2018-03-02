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
	 * 点击主界面 离职员工管理 调用本方法 **** 
	 * 
	 * 在离职员工页面
	 */	
		public ActionForward login(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			CodeService codeService=CodeService.getInstance();
			List<Code> emList = codeService.getCode(Constant.EM_FORMAT);
			request.setAttribute("emList", emList);
			
			
			 return mapping.findForward("et");
			 //点击进入在职员工管理
			 //在职页面中超链接
			}
	/**
	 * 在职员工 页面中超链接 -- 离职员工界面查询
	 */	
		public ActionForward gologin(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		CodeService codeService=CodeService.getInstance();
		List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
		request.setAttribute("typeList", typeList);
			 return mapping.findForward("dt");
			 //离职页面的超链接
			}
		
	/**
	 * 在职员工查询页面中的 查询按钮
	 */	
		public ActionForward zcha(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//下拉菜单
			CodeService codeService=CodeService.getInstance();
			List<Code> emList = codeService.getCode(Constant.EM_FORMAT);
			request.setAttribute("emList", emList);
			
			DomiForm dform=(DomiForm)form;
			
			EmployeeService employeeService=EmployeeService.getInstance();
			//创建查询参数bean
			All all = new All();
	        //从页面取出输入的信息并判断后输入ALL中
			
			//*员工编号
			if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
				all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
				}
			//*部门名称
			if(request.getParameter("dept_name")!=null&&!"".equals(request.getParameter("dept_name"))){
				all.setEm_name(request.getParameter("dept_name"));
				}
			//部门编号
			if(request.getParameter("dept_number")!=null&&!"".equals(request.getParameter("dept_number"))){
				all.setDept_number(Integer.parseInt(request.getParameter("dept_number")));}
			 //*员工状态
			if(request.getParameter("em_format")!=null&&!"".equals(request.getParameter("em_format")))
				all.setEm_format(Integer.parseInt(request.getParameter("em_format")));
			//调用业务层方法
			List<Employee> elist=employeeService.listEmployeeByCondition(all);
			
			dform.setElist(elist);
			
			 return mapping.findForward("et");
			 //在职员工查询页面
			}
		
	/**
	 * 在职员工查询页面中的 离职超链接
	 */		
		public ActionForward lzc(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//下拉菜单
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
	 * 离职员工查询页面中的 查询按钮
	 */	
		public ActionForward lcha(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//下拉菜单
			CodeService codeService=CodeService.getInstance();
			List<Code> typeList = codeService.getCode(Constant.DOMI_TYPE);
			request.setAttribute("typeList", typeList);
			
            DomiForm dform=(DomiForm)form;
			
			EmployeeService employeeService=EmployeeService.getInstance();
			//创建查询参数bean
			All all = new All();
	        //从页面取出输入的信息并判断后输入ALL中
			
			//*员工编号
			if(request.getParameter("em_number")!=null&&!"".equals(request.getParameter("em_number"))){
				all.setEm_number(Integer.parseInt(request.getParameter("em_number")));
				}
			//员工姓名
			if(request.getParameter("em_name")!=null&&!"".equals(request.getParameter("em_name"))){
				all.setEm_name(request.getParameter("em_name"));
				}
			//*部门名称
			if(request.getParameter("dept_name")!=null&&!"".equals(request.getParameter("dept_name"))){
				all.setDept_name(request.getParameter("dept_name"));
				}
			//岗位名称
			if(request.getParameter("job_name")!=null&&!"".equals(request.getParameter("job_name"))){
				all.setJob_name(request.getParameter("job_name"));
				}
			 //*离职类型
			if(request.getParameter("lz_type")!=null&&!"".equals(request.getParameter("lz_type")))
				all.setLz_type(Integer.parseInt(request.getParameter("lz_type")));
			//开始日期
			if(request.getParameter("begin_date")!=null&&!"".equals(request.getParameter("begin_date")))
				all.setBegin_date(request.getParameter("begin_date"));
	
			//结束日期
			if(request.getParameter("end_date")!=null&&!"".equals(request.getParameter("end_date")))
				all.setEnd_date(request.getParameter("end_date"));
	
			
			
			//调用业务层方法
			List<Employee> elist=employeeService.listEmployeeByCondition(all);
			
			dform.setElist(elist);
			
			
			
			 return mapping.findForward("dt");
			 //离职页面的超链接
			}

		
	/**
	 * 离职  原因页面 确定
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
			 //离职页面的超链接
			}
}
		
		
		
		
		
		
//   /**
//    * 当点击查询时，查询员工信息，用于显示在界面上。
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
//			//创建业务层实例
//			DomiService domiService =new DomiService();
//			//调用业务层方法
//			List<DomiBean> listEmp = domiService.listEmp(domi);
//			dForm.setList(listEmp);
//		  return super.execute(mapping, form, request, response);
//	}
//	/**
//	 * 查询离职员工信息，用于显示在界面上。
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
//	 * 当点击离职时，跳转进入离职信息界面，并获得下拉菜单得值
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
//		 * 当点击离职信息中的确定按钮时，将员工信息删除，并且加入已离职员工信息表
//		 */
//		public ActionForward delEmp(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			// TODO Auto-generated method stub
//			 return super.execute(mapping, form, request, response);
//			}
//	/**
//	 * 当点击员工离职管理时，跳转到在职人员查询界面，当点击查询在职人员信息时也
//	 * 调用此action，跳转到在职人选查询界面
//	 */
//		public ActionForward forwardListEmp(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			CodeService codeService=CodeService.getInstance();
//			List<Code> list=codeService.getCode(Constant.EM_FORMAT);
//			 return mapping.findForward("employeeList");
//			}
//	/**
//	 * 当点击查询离职员工信息时，跳转到已离职人员查询界面
//	 */	
//		public ActionForward forwardListDomi(ActionMapping mapping, ActionForm form,
//				HttpServletRequest request, HttpServletResponse response)
//				throws Exception {
//			
//			 return mapping.findForward("domiList");
//			}
//}
