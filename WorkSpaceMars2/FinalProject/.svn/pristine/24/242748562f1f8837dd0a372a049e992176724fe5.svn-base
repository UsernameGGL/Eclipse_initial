package com.kms.action;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.kms.dao.DeptDao;
import com.kms.po.Dept;
import com.kms.po.JobInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**用于封装对部门管理模块的操作，响应相应的Action；
 * 
 * public String add() 添加新的部门信息；
 * public String delete() 删除指定的部门信息；
 * public String update() 修改部门名称；
 * public String listdept() 列举所有的部门信息；
 * public String listperson() 列举部门所属所有员工的员工编号，姓名，年龄，岗位，薪金
 * @author 刘嘉赓
 */
public class DeptFormAction extends ActionSupport implements ModelDriven<Dept> {
	private static final String ADD = "add";
	private static final String DELETE = "delete";
	private static final String UPDATE = "update";
	private static final String LISTDEPT = "listdept";
	private static final String LISTPERSON = "listperson";
	private static final String ERROR = "error";
	
	private Dept dept = new Dept();
	private DeptDao deptDao = new DeptDao();
	private List<Dept> listDept;
	private List<JobInfo> listPerson;
	
	@Override
	public Dept getModel() {
		if (this.getDept()==null){
			this.dept = new Dept();
		}
		return getDept();
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(dept.getDid());
		System.out.println(dept.getDnm());
		System.out.println(dept.getDnum());
		return SUCCESS;
	}
	
	/**添加新的部门信息，
	 * 需要从jsp页面获取新的部门名称
	 * @return String add
	 */
	public String add() {
		if (deptDao.addDept(dept) == 0){
			return ERROR;
		}else {
			System.out.println("--add---------------------------------");
			return this.listdept();
		}
	}

	/**删除指定的部门信息，
	 * 需要从jsp页面获取部门编号
	 * @return String delete
	 */
	public String delete() {
		if (deptDao.deleteDept(dept) == 0){
			return ERROR;
		}else {
			System.out.println("--delete---------------------------------");
			return this.listdept();
		}
	}

	/**修改部门名称，
	 * 需要从jsp页面获取部门编号以及新的部门名称
	 * @return String update
	 */
	public String update() {
		if (deptDao.updateDept(dept) == 0){
			System.out.println("--error---------------------------------");
			return ERROR;
		}else {
			System.out.println("--update---------------------------------");
			return this.listdept();
		}
	}
	
	/**列举所有的部门信息，
	 * 将从数据库查询到的结果返回到listDept中
	 * @return String listdept
	 */
	public String listdept() {
		System.out.println("--listdept--------------------------------");
		listDept = deptDao.listDept();
		return LISTDEPT;
	}
	
	/**列举部门所属所有员工的员工编号，姓名，年龄，岗位，薪金
	 * 将从数据库查询到的结果返回到listPerson中
	 * @return String listperson
	 */
	public String listperson() {
		System.out.println("--listperson--------------------------------");
		 listPerson = deptDao.listPerson(dept);
		return LISTPERSON;
	}

//	用于ModelDriven方法获取实例化的listDept的值
	public List<Dept> getListDept() {
		return listDept;
	}
//	用于ModelDriven方法获取实例化的listPerson的值
	public List<JobInfo> getListPerson() {
		return listPerson;
	}
//	用于ModelDriven方法获取实例化的dept的值
	public Dept getDept() {
		return dept;
	}
//	用于ModelDriven方法向实例化的dept传值
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
