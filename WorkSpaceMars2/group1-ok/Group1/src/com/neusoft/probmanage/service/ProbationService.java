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
				//����dao�����
				ProbationDaoImpl probationDaoImpl = new ProbationDaoImpl(conn);
				//��������
				DBUtils.beginTransaction(conn);
				//����dao�㷽��
				probationDaoImpl.addProbation(employee);
				//�ύ����
				DBUtils.commit(conn);
		}		
		}catch(ServiceException s){
			throw s;
		}catch (Exception e){
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding a probation",e);
		}finally{
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
              		
	}
	
	
	   /**
	    * ���ڲ�ѯ�����ڹ���������ѯ�͵��Ա�����۵�ʱ��ʱ����ѯ������Ա����Ϣ
	    */
    public List<All> listProb(All all){
    	List<All> probationList = null;
    	try {
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//ʵ����DAO����
			ProbationDaoImpl probationDaoImpl=new ProbationDaoImpl(conn);
		
		    probationList = probationDaoImpl.findProbationList(all);		
			
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error", e);
		} finally {
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
		return  probationList;
    }
    
        
	   /**
	    * ���ڲ�ѯ�Ѿ�ת������ѯʱ����ѯ�Ѿ�ת��Ա����Ϣ
	    */
 public List<ProbationBean> listProbed(All all){
        List<ProbationBean> probationListed = null;
	   try {
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//ʵ����DAO����
			ProbationDaoImpl probDao=new ProbationDaoImpl(conn);
			
			//����DAO���������ݿ��������
			probationListed = probDao.findProbationedList(all);	
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error ", e);
		} finally {
			//�ύ
			DBUtils.commit(conn);
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}   
		return probationListed;
	  
 }
    
    
 
 /**
  * ����Ա���������ۺ������棬���ý������۵���Ϣ��������ݿ�
  */
 public void editProb (ProbationBean probationBean){
	 
	 try {
		 
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
					
			//ʵ����DAO����
			 ProbationDaoImpl probDao=new ProbationDaoImpl(conn);
			//��������
			DBUtils.beginTransaction(conn);
			//����DAO���������ݿ��������
			probDao.editProbation(probationBean);
			//�ύ����
			DBUtils.commit(conn);
		 		
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error ", e);
		} finally {
			//�ύ
			DBUtils.commit(conn);
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}   	 
    }

} 
    
    
    
    
    
    
    
    
    
    
    

  