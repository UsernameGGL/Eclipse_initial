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
 * �Բ��Ž�����ɾ�Ĳ�Ĺ����ʵ����
 * @author Clover
 *
 */
public class DeptService{
	//����ģʽʵ��
	private static DeptService instance = new DeptService();
	
	public static DeptService getInstance(){
		return instance;
	}
	private DeptService(){
		
	}

	/**
	 * ���Ӳ���
	 * @param Dept ����
	 */
	public boolean addDept(Dept dept) {
		Connection conn = null;
		//��ȡ���ݿ�����
		try{
			conn = DBUtils.getConnection();
			//����dao������
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			//��֤�Ƿ������ͬdept_number�Ĳ���
			if(deptDaoImpl.getDept(dept.getDept_number())){
				return false;
			}
		    //��������
			DBUtils.beginTransaction(conn);
			//����dao�㷽�������ݿ��в���һ������
			deptDaoImpl.addDept(dept);
			//�ύ
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a dept",e);
		}finally{
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
               return true;			
	}
	
	/**
     * ��ѯ������Ϣ
     * @param 
     */
	public List<Dept> listDept(Dept dept) {
		List<Dept> listDept = null;
		Connection conn = null;
		try{
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao������
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			//����dao�㷽����ѯ���ݿ��еĲ���
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
	 * ��ѯһ�����ŵľ�����Ϣ
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
     *�޸Ĳ�����Ϣ
     *@param DeptDomain����
     */
	
	public void editDept(Dept dept) {
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DeptDaoImpl deptDaoImpl = new DeptDaoImpl(conn);
			// ��������
			DBUtils.beginTransaction(conn);
			deptDaoImpl.editDept(dept);
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a dept",e);
		}finally{
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
          	
	}
	/**
	 * ɾ������
	 * @param DeptDomain����
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
			//�ع�
			DBUtils.rollback(conn);
			throw new ServiceException("Error on delect a dept",e);
		}finally{
			//�ر����ݿ�����
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



