package com.neusoft.domimanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.domimanage.domain.DomiBean;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;

public class DomiDaoImpl implements DomiDao {
	
	private Connection conn;

	public DomiDaoImpl(Connection conn) {
		this.conn = conn;
	}
    /**
     * ʵ��DomiDao�ӿ�
     */
	/**
	 * ʵ�ֽ���ְԱ��������ְԱ������
	 */
	public void addDomi(DomiBean domi) {
		String sql = "insert into domission(id,lz_extra,lz_go,lz_type,lz_date) "
			+ "values(?, ?, ?, ?, ?)";
	    PreparedStatement pstmt = null;
	    try {
		     pstmt = conn.prepareStatement(sql);
		     pstmt.setInt(1, domi.getId());
		     pstmt.setString(2, domi.getLz_extra());
		     pstmt.setString(3, domi.getLz_go());
		     pstmt.setInt(4, domi.getLz_type());
		     pstmt.setDate(5, domi.getLz_date());
		     pstmt.executeUpdate();
		     
		     pstmt = conn.prepareStatement("update  employee set situation=3 where id=" + domi.getId());
		     pstmt.executeUpdate();
		     
		     /*******job_ch*****/
				pstmt = conn.prepareStatement("update job set job_man = job_man-1 where job_number = ?");
				pstmt.setInt(1, domi.getJob_number());
				pstmt.executeUpdate();
		     
	     } catch (SQLException e) {
		     throw new DaoException("Error on adding Domi", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
	}
//	/**
//	 * �������ְ��Ϣ�е�ȷ����ťʱ����Ա����Ϣɾ����������Ա����״̬Ϊ��ְ��������ʵ�ʵ�ɾ��
//	 */
//	public void delEmp(long em_Number) {
//		String sql = "delete from user_info where em_Numeber=?";
//	    PreparedStatement pstmt = null;
//	    try {
//		     pstmt = conn.prepareStatement(sql);
//		     pstmt.setLong(1, em_Number);
//		     pstmt.executeUpdate();
//	     } catch (SQLException e) {
//		     throw new DaoException("Error on adding Domi", e);
//	     } finally {
//		     DBUtils.closeStatement(pstmt);
//	     }
//
//	}
//	/**
//	 * ʵ�ֲ�ѯ����ְԱ���ķ���
//	 */
//	public List<DomiBean> listDomi(DomiBean domi) {
//		String sql = "select * from ";
//	    Statement stmt = null;
//	    List<DomiBean> listDomiBean=new ArrayList<DomiBean>();
//	    try {
//		     stmt = conn.createStatement();
//		     ResultSet rs=stmt.executeQuery(sql);
//				while(rs.next()){
//					String num=rs.getString(1);
//					String s=rs.getString(2);
//					domi.setEm_Number(num);
//					domi.setEm_Name(s);
//					listDomiBean.add(domi);
//				}
//				return listDomiBean;
//	     } catch (SQLException e) {
//		     throw new DaoException("Error on adding Domi", e);
//	     } finally {
//		     DBUtils.closeStatement(stmt);
//	     }
//	}
//	/**
//	 * ʵ�ֲ�ѯԱ���ķ���
//	 */
//	public List<DomiBean> listEmp(DomiBean domi) {
//		String sql = "select * from ";
//	    Statement stmt = null;
//	    List<DomiBean> listDomiBean=new ArrayList<DomiBean>();
//	    try {
//		     stmt = conn.createStatement();
//		     ResultSet rs=stmt.executeQuery(sql);
//				while(rs.next()){
//					String num=rs.getString(1);
//					String s=rs.getString(2);
//					domi.setEm_Number(num);
//					domi.setEm_Name(s);
//					listDomiBean.add(domi);
//				}
//				return listDomiBean;
//	     } catch (SQLException e) {
//		     throw new DaoException("Error on adding Domi", e);
//	     } finally {
//		     DBUtils.closeStatement(stmt);
//	     }
//	}
//	/**
//	 * ʵ�ֻ��Ա����Ϣ��ѯ�е������˵��ķ��� 
//	 */
//	public List<String> getEmpCode(int type_id){
//		
//		return null;
//	}
//	/**
//	 * ʵ�ֻ����ְԱ����Ϣ��ѯ�е������˵��ķ���
//	 */
//	public List<String> getSearDomiCode(int type_id){
//		
//		return null;
//	}
//	/**
//	 * ʵ����ְ��Ϣ�������˵�ֵ�Ļ��
//	 */
//	public List<String> getDomiCode(int type_id){
//		return null;
//	}

}
