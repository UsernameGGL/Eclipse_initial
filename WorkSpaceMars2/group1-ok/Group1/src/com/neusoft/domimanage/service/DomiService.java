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
	    * �������ְͬʱ������ְԱ��������ְԱ����
	    */
	   public void addDomi(DomiBean domi){
		   Connection conn = null;
			try {
				//��ȡ���ݿ�����
				conn = DBUtils.getConnection();
				//ʵ����DAO����
				DomiDaoImpl domiDao=new DomiDaoImpl(conn);
				//��������
				DBUtils.beginTransaction(conn);
				//����DAO������
				domiDao.addDomi(domi);
				//�ύ
				DBUtils.commit(conn);
			} catch (ServiceException e) {
				throw e;
			} catch (Exception e) {
				//�ع�����
				DBUtils.rollback(conn);
				throw new ServiceException("Error on adding user", e);
			} finally {
				//�ر����ݿ�����
				DBUtils.closeConnection(conn);
			}
       }
//	   /**
//	    * ���ڲ�ѯ����ְԱ����������ѯʱ����ѯ����ְԱ����Ϣ
//	    */
//       public List<DomiBean> listDomi(DomiBean domi){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO��������ѯ����ְԱ����Ϣ
//				return domiDao.listDomi(domi);	
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ύ
//				DBUtils.commit(conn);
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        *  �������ְ��Ϣ��ȷ��ʱ����Ա����ְ��������ְԱ����
//        * @param em_Number
//        */
//
//       public void delEmp(long em_Number){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO��������Ա����employee����ɾ����ͬʱ����domi��
//				domiDao.delEmp(em_Number);	
//				//�ύ
//				DBUtils.commit(conn);
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * ���ڲ�ѯԱ��������ѯʱ����ѯԱ����Ϣ
//        */
//       public List<DomiBean> listEmp(DomiBean domi){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO�������������������ݿ��ѯԱ����Ϣ
//				return domiDao.listEmp(domi);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ύ
//				DBUtils.commit(conn);
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * �����Ա����ְ�������ְԱ����Ϣʱ�����ô˷�������������˵�ֵ
//        * @param type_id
//        * @return
//        */
//       public List<String> getEmpCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO��������ò�ѯԱ����Ϣ���������˵���ֵ
//				return domiDao.		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ύ
//				DBUtils.commit(conn);
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * �������ѯ��ְԱ����Ϣʱ�����ô˷�������������˵�ֵ
//        * @param type_id
//        * @return
//        */
//       public List<String> getSearDomiCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO��������ò�ѯ��ְԱ����Ϣ���������˵���ֵ
//				return domiDao.getSearDomiCode(type_id);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ύ
//				DBUtils.commit(conn);
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
//       /**
//        * �������ְʱ��Ϊ��ְ��Ϣ��������˵���ֵ
//        * @param type_id
//        * @return
//        */
//       public List<String> getDomiCode(int type_id){
//    	   Connection conn = null;
//    	   try {
//				//��ȡ���ݿ�����
//				conn = DBUtils.getConnection();
//				//ʵ����DAO����
//				DomiDaoImpl domiDao=new DomiDaoImpl();
//				//��������
//				DBUtils.beginTransaction(conn);
//				//����DAO���������ְ��Ϣ�����˵���ֵ
//				return domiDao.getDomiCode(type_id);		
//			} catch (ServiceException e) {
//				throw e;
//			} catch (Exception e) {
//				//�ع�����
//				DBUtils.rollback(conn);
//				throw new ServiceException("Error on adding user", e);
//			} finally {
//				//�ύ
//				DBUtils.commit(conn);
//				//�ر����ݿ�����
//				DBUtils.closeConnection(conn);
//			}   
//       }
}
