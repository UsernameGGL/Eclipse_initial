package com.neusoft.probmanage.service;

import java.sql.Connection;
import java.util.List;


import com.neusoft.domimanage.dao.DomiDaoImpl;
import com.neusoft.employeemanage.dao.EmployeeDaoImpl;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.employeemanage.service.EmployeeService;
import com.neusoft.probmanage.dao.ProbationDaoImpl;
import com.neusoft.probmanage.domain.ProbationBean;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;

public class ProbationService {
	 Connection conn = null;
	 
	private static ProbationService instance = new ProbationService();

	public static ProbationService getInstance() {
			return instance;
		}
	private ProbationService(){
		
	}
	
	public void addProbation(Employee employee){
		try{
			conn = DBUtils.getConnection();
			if(employee.getSituation()==0){
				//创建dao层对象
				ProbationDaoImpl probationDaoImpl = new ProbationDaoImpl(conn);
				//开启事物
				DBUtils.beginTransaction(conn);
				//调用dao层方法
				probationDaoImpl.addProbation(employee);
				//提交事物
				DBUtils.commit(conn);
		}		
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a probation",e);
		}finally{
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
              		
	}
	
	
	   /**
	    * 当在查询试用期工界面点击查询和点击员工评价的时候时，查询试用期员工信息
	    */
    public List<All> listProb(All all){
    	List<All> probationList = null;
    	try {
			//获取数据库连接
			conn = DBUtils.getConnection();
			//实例化DAO对象
			ProbationDaoImpl probationDaoImpl=new ProbationDaoImpl(conn);
		
		    probationList = probationDaoImpl.findProbationList(all);		
			
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error", e);
		} finally {
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
		return  probationList;
    }
    
        
	   /**
	    * 当在查询已经转正击查询时，查询已经转正员工信息
	    */
 public List<ProbationBean> listProbed(All all){
        List<ProbationBean> probationListed = null;
	   try {
			//获取数据库连接
			conn = DBUtils.getConnection();
			//实例化DAO对象
			ProbationDaoImpl probDao=new ProbationDaoImpl(conn);
			
			//调用DAO方法向数据库插入数据
			probationListed = probDao.findProbationedList(all);	
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error ", e);
		} finally {
			//提交
			DBUtils.commit(conn);
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}   
		return probationListed;
	  
 }
    
    
 
 /**
  * 当对员工进行评价后点击保存，调用将已评价的信息保存进数据库
  */
 public void editProb (ProbationBean probationBean){
	 
	 try {
		 
			//获取数据库连接
			conn = DBUtils.getConnection();
					
			//实例化DAO对象
			 ProbationDaoImpl probDao=new ProbationDaoImpl(conn);
			//开启事务
			DBUtils.beginTransaction(conn);
			//调用DAO方法向数据库插入数据
			probDao.editProbation(probationBean);
			//提交事物
			DBUtils.commit(conn);
		 		
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error ", e);
		} finally {
			//提交
			DBUtils.commit(conn);
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}   	 
    }

} 
    
    
    
    
    
    
    
    
    
    
    

  