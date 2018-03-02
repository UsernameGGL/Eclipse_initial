package com.neusoft.deptmanage.service;

import java.sql.Connection;
import java.util.List;

import com.neusoft.deptmanage.dao.DeptDaoImpl;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.dao.EmployeeDaoImpl;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;




/**
 * 对部门进行增删改查的管理的实现类
 * @author Clover
 *
 */
public class DeptService{
	//单例模式实现
	private static DeptService instance = new DeptService();
	
	public static DeptService getInstance(){
		return instance;
	}
	private DeptService(){
		
	}

	/**
	 * 增加部门
	 * @param Dept 对象
	 */
	public boolean addDept(Dept dept) {
		Connection conn = null;
		//获取数据库连接
		try{
			conn = DBUtils.getConnection();
			//声明dao层引用
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			//验证是否存在相同dept_number的部门
			if(deptDaoImpl.getDept(dept.getDept_number())){
				return false;
			}
		    //开启事物
			DBUtils.beginTransaction(conn);
			//调用dao层方法向数据库中插入一个部门
			deptDaoImpl.addDept(dept);
			//提交
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a dept",e);
		}finally{
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
               return true;			
	}
	
	/**
     * 查询部门信息
     * @param 
     */
	public List<Dept> listDept(Dept dept) {
		List<Dept> listDept = null;
		Connection conn = null;
		try{
			//获取数据库连接
			conn = DBUtils.getConnection();
			//声明dao层引用
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			//调用dao层方法查询数据库中的部门
			listDept = deptDaoImpl.listDept(dept);
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			throw new ServiceException("Error on listing dept",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return listDept;
	}
	
	/**
	 * 查询一个部门的具体信息
	 * @param dept
	 * @return
	 */
	public Dept getDeptById(int id){
		Dept dept = new Dept();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			dept = deptDaoImpl.getDeptById(id);
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			throw new ServiceException("Error on getting dept",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return dept;
	}
	
    /**
     *修改部门信息
     *@param DeptDomain对象
     */
	
	public void editDept(Dept dept) {
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			// 开启事物
			DBUtils.beginTransaction(conn);
			deptDaoImpl.editDept(dept);
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a dept",e);
		}finally{
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
          	
	}
	/**
	 * 删除部门
	 * @param DeptDomain对象
	 */
	public boolean delDept(int dept_number) {
		Connection conn =null;
		try{
			conn = DBUtils.getConnection();
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl(conn);
			All all = new All();
			all.setDept_number(dept_number);
			if(employeeDaoImpl.findAllEmployeeList(all)!=null&&!("").equals(employeeDaoImpl.findAllEmployeeList(all))){
				return false;
			}
			DBUtils.beginTransaction(conn);
			deptDaoImpl.delDept(dept_number);
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//回滚
			DBUtils.rollback(conn);
			throw new ServiceException("Error on delect a dept",e);
		}finally{
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}	
		return true;
	}
    public List<Dept> getDept_superName(){
    	Connection conn =null;
    	List<Dept> dept_superList = null;
    	try{
    		conn = DBUtils.getConnection();
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			dept_superList = deptDaoImpl.getDept_superName();
    	}catch(ServiceException s ){
    		throw s;
    	}catch(Exception e){
			throw new ServiceException("Error on getting dept_superName",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return dept_superList;
	}

}



