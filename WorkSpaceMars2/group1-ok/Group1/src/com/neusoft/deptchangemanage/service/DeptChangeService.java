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
 * ��Ա�����в��ŵ������࣬����dao��ķ���
 * @author Clover
 *
 */
public class DeptChangeService{
	//����ģʽ
	private static DeptChangeService instance = new DeptChangeService();
	
	public static DeptChangeService getInstance(){
		return instance;
	}
	
	private DeptChangeService(){
		
	}
    /**
     * ��Ա�����в��ŵ���ʱ����
     * @param deptChange
     */
	public void addDeptChange(DeptChange deptChange) {
		Connection conn = null;
		
		try{
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao�����
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//��������
			DBUtils.beginTransaction(conn);
			//����dao�㷽��
			deptChangeDaoImpl.addDeptChange(deptChange);
			//�ύ����
			DBUtils.commit(conn);
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding deptchange");
		}finally{
			DBUtils.closeConnection(conn);
		}
		
	}
	
    /**
     * ��ѯ�ѵ���Ա��������Ϣ
     * @param all
     * @return
     */
	public List<DeptChange> listDeptChange(All all) {
		Connection conn = null;
		List<DeptChange> deptChangeList = null;
		try{
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao�����
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//����dao�㷽��
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
//			//��ȡ���ݿ�����
//			conn = DBUtils.getConnection();
//			//����dao�����
//			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
//			//����dao�㷽��
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
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao�����
			DeptChangeDaoImpl deptChangeDaoImpl = new DeptChangeDaoImpl(conn);
			//����dao�㷽��
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