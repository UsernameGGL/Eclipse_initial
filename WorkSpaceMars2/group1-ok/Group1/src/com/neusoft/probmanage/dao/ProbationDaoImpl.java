package com.neusoft.probmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.probmanage.domain.ProbationBean;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;

public class ProbationDaoImpl implements ProbationDao {

	private Connection conn;

	public ProbationDaoImpl() {
	}

	public ProbationDaoImpl(Connection conn) {
		this.conn = conn;
	}
	/**
	 * ����Ա�����ĵ����󣬽����������ڵ�Ա������Ϣ��������Ϣ���浽�����ڱ���
	 * @param employee
	 */
    public void addProbation(Employee employee){
    	String sql = "insert into probation (id,em_id,prob_start,prob_end)values(probid.nextval,?,?,?)";
    	PreparedStatement pstmt = null;
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employee.getId());
			pstmt.setDate(2, employee.getProb_start());
			pstmt.setDate(3, employee.getProb_end());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	/**
	 * ������Ա����ѯ
	 * @return List<All>
	 */
	public List<All> findProbationList(All all) {
		StringBuffer sql = new StringBuffer("select b.id,b.em_id,a.em_number,a.em_name,d.dept_name,j.job_name,b.prob_data,b.prob_start,b.prob_end");
		sql.append(" from Probation b,employee a, dept d,job j");
		sql.append(" where a.id=b.em_id and a.dept_number=d.dept_number(+) and a.job_number=j.job_number(+) and a.situation=0");
		if(all.getEm_number()>0){
			sql.append(" and a.em_number="+all.getEm_number());
			
		}
		if(all.getEm_name()!=null&&!"".equals(all.getEm_name())){
			sql.append(" and a.em_name='"+all.getEm_name()+"'");
			
		}
		if(all.getDept_name()!=null&&!"".equals(all.getDept_name())){
			sql.append(" and d.dept_name='"+all.getDept_name()+"'");
			
		}
		if(all.getJob_name()!=null&&!"".equals(all.getJob_name())){
			sql.append(" and j.job_name='"+all.getJob_name()+"'");
			
		}
		if(all.getProb_start()!=null&&!"".equals(all.getProb_start())){
			sql.append(" and to_date('"+all.getProb_start()+"','yyyy-mm-dd')<=prob_start");
			
		}
		if(all.getProb_end()!=null&&!"".equals(all.getProb_end())){
	    	sql.append(" and to_date('"+all.getProb_end()+"','yyyy-mm-dd')>=prob_end");
	    }
		Statement stmt = null;
		List<All> listProbBean = new ArrayList<All>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			All allOther = null;
			while (rs.next()) {
				allOther = new All();
				allOther.setId((rs.getInt("em_id")));
				allOther.setEm_number(rs.getInt("em_number"));
				allOther.setEm_name(rs.getString("em_name"));
				allOther.setDept_name(rs.getString("dept_name"));
				allOther.setJob_name(rs.getString("job_name"));
				allOther.setProb_start(rs.getDate("prob_start"));
				allOther.setProb_end(rs.getDate("prob_end"));
				allOther.setProb_Date(rs.getDate("prob_data"));
				listProbBean.add(allOther);			
			}
			
		} catch (SQLException e) {
			throw new DaoException("Error", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return listProbBean;
	
	}

	/**
	 * ��ѯ��ת��Ա����Ϣ
	 * @return List<ProbationBean>
	 */

	public List<ProbationBean> findProbationedList(All all) {
		
		StringBuffer sql = new StringBuffer("select a.em_number,a.em_name,d.dept_name,j.job_name,b.prob_data,b.prob_reviews,b.prob_notes");
		sql.append(" from Probation b,employee a, dept d,job j");
		sql.append(" where a.id=b.em_id and a.dept_number=d.dept_number(+) and a.job_number=j.job_number(+) and a.situation=2");
		if(all.getEm_number()>0){
			sql.append(" and a.em_number="+all.getEm_number());
			
		}
		if(all.getEm_name()!=null&&!"".equals(all.getEm_name())){
			sql.append(" and a.em_name='"+all.getEm_name()+"'");
			
		}
		if(all.getDept_number()>0){
			sql.append(" and d.dept_number="+all.getDept_number());
			
		}
		if(all.getDept_name()!=null&&!"".equals(all.getDept_name())){
			sql.append(" and d.dept_name='"+all.getDept_name()+"'");
			
		}
		if(all.getProb_startDate()!=null&&!"".equals(all.getProb_startDate())){
			sql.append(" and to_date('"+all.getProb_startDate()+"','yyyy-mm-dd')<=prob_data");
			
		}
	    if(all.getProb_endDate()!=null&&!"".equals(all.getProb_endDate())){
	    	sql.append("and to_date('"+all.getProb_endDate()+"','yyyy-mm-dd')>=prob_data");
	    }
		Statement stmt = null;
		List<ProbationBean> listProbBean = new ArrayList<ProbationBean>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			ProbationBean probationBean = null;
			while (rs.next()) {
				probationBean = new ProbationBean();
				probationBean.setEm_number(rs.getInt("em_number"));
				probationBean.setProb_name(rs.getString("em_name"));
				probationBean.setProb_branchName(rs.getString("dept_name"));
				probationBean.setProb_jobName(rs.getString("job_name"));
				probationBean.setProb_date(rs.getDate("prob_data"));//����ʱ��
				probationBean.setProb_reviews(rs.getString("prob_reviews"));//����
				probationBean.setProb_notes(rs.getString("prob_notes"));//��ע            
				listProbBean.add(probationBean);		
				}
				
	     } catch (SQLException e) {
		     throw new DaoException("Error ", e);
	     } finally {
		     DBUtils.closeStatement(stmt);
	     }
	     return listProbBean;
	}

	/**
	 * ��ҳ��������ʱ�����������ڵ���Ϣ
	 */
	public void editProbation(ProbationBean probationBean) {

		String sql1 = "update probation set prob_reviews=?,prob_results=?,prob_data=?,prob_notes=?,prob_end=? where em_id=?";
		String sql2 = "update probation set prob_reviews=?,prob_results=?,prob_data=?,prob_notes=? where em_id=?";
		String sql3 = "update employee set situation=2 where id=?";
		 
		PreparedStatement pstmt = null;
		try {
			//���ڣ�������ʱ��ĳ����ڵ���ʱ�䡣
			if(probationBean.getProb_results()==32){
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, probationBean.getProb_reviews());//����
				pstmt.setInt(2, probationBean.getProb_results());//���˽��
				pstmt.setDate(3, probationBean.getProb_date());//����ʱ��
				pstmt.setString(4, probationBean.getProb_notes());//��ע
				pstmt.setDate(5, probationBean.getExtend_date());//������ʱ���Ϊ���ڵ���ʱ��
				pstmt.setInt(6, probationBean.getId());//�����Ա�����
				pstmt.executeUpdate();
			}
			//ת��
			//��ת�������Ϣ����������ڱ��У����ı�Ա������Ա����״̬
			if(probationBean.getProb_results()==31){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, probationBean.getProb_reviews());//����
				pstmt.setInt(2, probationBean.getProb_results());//���˽��
				pstmt.setDate(3, probationBean.getProb_date());//����ʱ��
				pstmt.setString(4, probationBean.getProb_notes());//��ע
				pstmt.setInt(5, probationBean.getId());//Ա�����
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, probationBean.getId());
				pstmt.executeUpdate();
			}
			//������δͨ��
			if(probationBean.getProb_results()==33){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, probationBean.getProb_reviews());
				pstmt.setInt(2, probationBean.getProb_results());
				pstmt.setDate(3, probationBean.getProb_date());
				pstmt.setString(4, probationBean.getProb_notes());
				pstmt.setInt(5, probationBean.getId());
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new DaoException("Error", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}

	}

	
}