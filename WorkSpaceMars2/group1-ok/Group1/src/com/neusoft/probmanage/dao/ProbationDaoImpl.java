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
	 * 接收员工中心的请求，接收有试用期的员工的信息，并将信息保存到试用期表中
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
	 * 试用期员工查询
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
	 * 查询已转正员工信息
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
				probationBean.setProb_date(rs.getDate("prob_data"));//处理时间
				probationBean.setProb_reviews(rs.getString("prob_reviews"));//评语
				probationBean.setProb_notes(rs.getString("prob_notes"));//备注            
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
	 * 在页面点击保存时，保存试用期的信息
	 */
	public void editProbation(ProbationBean probationBean) {

		String sql1 = "update probation set prob_reviews=?,prob_results=?,prob_data=?,prob_notes=?,prob_end=? where em_id=?";
		String sql2 = "update probation set prob_reviews=?,prob_results=?,prob_data=?,prob_notes=? where em_id=?";
		String sql3 = "update employee set situation=2 where id=?";
		 
		PreparedStatement pstmt = null;
		try {
			//延期，将结束时间改成延期到的时间。
			if(probationBean.getProb_results()==32){
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, probationBean.getProb_reviews());//评语
				pstmt.setInt(2, probationBean.getProb_results());//考核结果
				pstmt.setDate(3, probationBean.getProb_date());//处理时间
				pstmt.setString(4, probationBean.getProb_notes());//备注
				pstmt.setDate(5, probationBean.getExtend_date());//将结束时间改为延期到的时间
				pstmt.setInt(6, probationBean.getId());//虚拟的员工编号
				pstmt.executeUpdate();
			}
			//转正
			//将转正后的信息保存进试用期表中，并改变员工表中员工的状态
			if(probationBean.getProb_results()==31){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, probationBean.getProb_reviews());//评语
				pstmt.setInt(2, probationBean.getProb_results());//考核结果
				pstmt.setDate(3, probationBean.getProb_date());//处理时间
				pstmt.setString(4, probationBean.getProb_notes());//备注
				pstmt.setInt(5, probationBean.getId());//员工编号
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, probationBean.getId());
				pstmt.executeUpdate();
			}
			//试用期未通过
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