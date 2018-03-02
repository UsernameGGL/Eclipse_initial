package com.neusoft.deptchangemanage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.deptchangemanage.dao.DeptChangeDao;
import com.neusoft.deptchangemanage.dao.DeptChangeDaoImpl;
import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;

/**
 * 对员工进行部门调动的类，调用dao层的方法
 * @author Clover
 *
 */
public class DeptChangeService{
	//单例模式
	private static DeptChangeService instance = new DeptChangeService();
	
	public static DeptChangeService getInstance(){
		return instance;
	}
	
	private DeptChangeService(){
		
	}
    /**
     * 对员工进行部门调动时调用
     * @param deptChange
     */
	public void addDeptChange(DeptChange deptChange) {
		Connection conn = null;
		
		try{
			//获取数据库连接
			conn = DBUtils.getConnection();
			//创建dao层对象
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//开启事物
			DBUtils.beginTransaction(conn);
			//调用dao层方法
			deptChangeDaoImpl.addDeptChange(deptChange);
			//提交事务
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding deptchange");
		}finally{
			DBUtils.closeConnection(conn);
		}
		
	}
	
    /**
     * 查询已调动员工具体信息
     * @param all
     * @return
     */
	public List<DeptChange> listDeptChange(All all) {
		Connection conn = null;
		List<DeptChange> deptChangeList = null;
		try{
			//获取数据库连接
			conn = DBUtils.getConnection();
			//创建dao层对象
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//调用dao层方法
			deptChangeList = deptChangeDaoImpl.listDeptChange(all);
		    }catch(ServiceException s){
				throw s;
			}catch(Exception e){
				throw new ServiceException("Error on listing dept",e);
			}finally{
				DBUtils.closeConnection(conn);
			}
			return deptChangeList;
	}
//	public List<DeptChange> listDeptChange(DeptChange deptChange) {
//		Connection conn = null;
//		List<DeptChange> deptChangeList = null;
//		try{
//			//获取数据库连接
//			conn = DBUtils.getConnection();
//			//创建dao层对象
//			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
//			//调用dao层方法
//			deptChangeList = deptChangeDaoImpl.listDeptChange(deptChange);
//		    }catch(ServiceException s){
//				throw s;
//			}catch(Exception e){
//				throw new ServiceException("Error on listing dept",e);
//			}finally{
//				DBUtils.closeConnection(conn);
//			}
//			return deptChangeList;
//	}
	
	public List<Dept> getDept_name(){
		Connection conn = null;
		List<Dept> dept_nameList = null;
		try{
			//获取数据库连接
			conn = DBUtils.getConnection();
			//创建dao层对象
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//调用dao层方法
			dept_nameList = deptChangeDaoImpl.getDept_Name();
			
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			throw new ServiceException("Error on getting dept_name",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return dept_nameList;
}
}