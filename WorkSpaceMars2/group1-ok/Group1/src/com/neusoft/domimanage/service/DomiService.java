package com.neusoft.domimanage.service;

import com.neusoft.domimanage.dao.DomiDaoImpl;

import com.neusoft.domimanage.domain.DomiBean;
import com.neusoft.employeemanage.service.EmployeeService;

import devoid.frame.business.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DomiService {
	
	private static DomiService instance = new DomiService();

	public static DomiService getInstance() {
		return instance;
	}

	private DomiService() {
	}
	
	
	
	   /**
	    * 当点击离职同时，将离职员工加入离职员工表
	    */
	   public void addDomi(DomiBean domi){
		   Connection conn = null;
			try {
				//获取数据库连接
				conn = DBUtils.getConnection();
				//实例化DAO对象
				DomiDaoImpl domiDao=new DomiDaoImpl(conn);
				//开启事务
				DBUtils.beginTransaction(conn);
				//调用DAO方法，
				domiDao.addDomi(domi);
				//提交
				DBUtils.commit(conn);
			} catch (ServiceException e) {
				throw e;
			} catch (Exception e) {
				//回滚事务
				DBUtils.rollback(conn);
				throw new ServiceException("Error on adding user", e);
			} finally {
				//关闭数据库连接
				DBUtils.closeConnection(conn);
			}
       }
//	   /**
//	    * 当在查询已离职员工界面点击查询时，查询已离职员工信息
//	    */
//       public List<DomiBean> listDomi(DomiBean domi){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法，查询已离职员工信息
//				return domiDao.listDomi(domi);	
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//提交
//				DBUtils.commit(conn);
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        *  当点击离职信息中确定时，将员工离职并加入离职员工表
//        * @param em_Number
//        */
//
//       public void delEmp(long em_Number){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法，将员工从employee表中删除，同时加入domi表
//				domiDao.delEmp(em_Number);	
//				//提交
//				DBUtils.commit(conn);
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * 当在查询员工界面点查询时，查询员工信息
//        */
//       public List<DomiBean> listEmp(DomiBean domi){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法，根据条件从数据库查询员工信息
//				return domiDao.listEmp(domi);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//提交
//				DBUtils.commit(conn);
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * 当点击员工离职管理和在职员工信息时，调用此方法来获得下拉菜单值
//        * @param type_id
//        * @return
//        */
//       public List<String> getEmpCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法，获得查询员工信息界面下拉菜单的值
//				return domiDao.		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//提交
//				DBUtils.commit(conn);
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * 当点击查询离职员工信息时，调用此方法来获得下拉菜单值
//        * @param type_id
//        * @return
//        */
//       public List<String> getSearDomiCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法，获得查询离职员工信息界面下拉菜单的值
//				return domiDao.getSearDomiCode(type_id);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//提交
//				DBUtils.commit(conn);
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * 当点击离职时，为离职信息获得下拉菜单的值
//        * @param type_id
//        * @return
//        */
//       public List<String> getDomiCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//获取数据库连接
//				conn = DBUtils.getConnection();
//				//实例化DAO对象
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//开启事务
//				DBUtils.beginTransaction(conn);
//				//调用DAO方法获得离职信息下拉菜单的值
//				return domiDao.getDomiCode(type_id);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//回滚事务
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//提交
//				DBUtils.commit(conn);
//				//关闭数据库连接
//				DBUtils.closeConnection(conn);
//			}   
//       }
}
