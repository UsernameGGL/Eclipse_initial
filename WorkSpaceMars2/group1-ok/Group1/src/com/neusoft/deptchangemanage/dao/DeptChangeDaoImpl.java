package com.neusoft.deptchangemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;
/**
 * dao层接口 DeptChangeDao的实现类
 * @author Clover
 *
 */
public class DeptChangeDaoImpl implements DeptChangeDao {
    
	private Connection conn;
	
	public DeptChangeDaoImpl(Connection conn){
		this.conn = conn;
	}

	/**
	 * 实现员工调转的功能，将调转后的员工信息保存进部门调转表中
	 */
	public void addDeptChange(DeptChange deptChange) {
		String sql = "insert into dept_change(id,em_id,dept_before,dept_after,dept_chType,dept_chReason,dept_chDate,dept_chExtra) values(deptchangeid.nextval,?,?,?,?,?,?,?)";
		String updatesql = "update employee set dept_number=? where id=?"; 
		PreparedStatement pstmt = null;        
        try {
 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptChange.getId());
			pstmt.setInt(2, deptChange.getDept_number());
			pstmt.setInt(3, deptChange.getDept_after());
			pstmt.setInt(4, deptChange.getDept_chType());
			pstmt.setString(5, deptChange.getDept_chReason());
			pstmt.setDate(6, deptChange.getDept_chDate());
			pstmt.setString(7, deptChange.getDept_chExtra());
			pstmt.executeUpdate();
			
			/**********调转后将员工表中员工原来的部门编号改成调转后的编号*******/
			pstmt = conn.prepareStatement(updatesql);
			pstmt.setInt(1, deptChange.getDept_after());
			pstmt.setInt(2, deptChange.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * 实现已调转员工信息查询
	 */
	public List<DeptChange> listDeptChange(All all) {

		String sql = "select e.em_number,e.em_name,d1.dept_name dept_oldname,d2.dept_name dept_newname,a.code_value dept_chValue ,c.dept_chReason,c.dept_chDate,c.dept_chExtra"+ 
  " from dept_change c,employee e ,code a,dept d1,dept d2 where e.id=c.em_id"+ 
  " and a.id=c.dept_chType and d1.dept_number=c.dept_before and d2.dept_number=c.dept_after";
		if(all.getDept_startDate()!=null&&!("").equals(all.getDept_startDate())){
			sql=sql+" and to_date('"+all.getDept_startDate()+"','yyyy-mm-dd')<=c.dept_chDate";
		}
		if(all.getDept_endDate()!=null&&!("").equals(all.getDept_endDate())){
			sql=sql+" and to_date('"+all.getDept_endDate()+"','yyyy-mm-dd')>=c.dept_chDate";
		}
		if(all.getEm_number()>0){
			sql = sql +" and e.em_number="+all.getEm_number();
		}
		if(all.getEm_name()!=null&&!all.getEm_name().equals("")){
			sql = sql +" and e.em_name='"+all.getEm_name()+"'";
		}
		if(all.getDept_chType()>0){
			sql = sql +" and c.dept_chType="+all.getDept_chType();
		}
		Statement stmt =null;
		ResultSet set = null;
		List<DeptChange> deptChangeList = new ArrayList<DeptChange>();
		try {
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()){
				DeptChange deptChange = new DeptChange();
				deptChange.setEm_number(set.getInt("em_number"));
				deptChange.setEm_name(set.getString("em_name"));
				deptChange.setDept_oldName(set.getString("dept_oldname"));
				//deptChange.setDept_after(set.getInt("dept_after"));
				deptChange.setDept_newName(set.getString("dept_newname"));
				//deptChange.setDept_chType(set.getInt("dept_chType"));
				deptChange.setDept_chReason(set.getString("dept_chReason"));
				deptChange.setDept_chValue(set.getString("dept_chValue"));
				deptChange.setDept_chDate(set.getDate("dept_chDate"));
				deptChange.setDept_chExtra(set.getString("dept_chExtra"));
				deptChangeList.add(deptChange);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on listing deptchange",e);
		}finally{
			DBUtils.closeStatement(stmt);
		}
		
		return deptChangeList;
	}
	
//	public List<DeptChange> listDeptChange(DeptChange deptChange) {
//
//		String sql = "select e.em_number,e.em_name,c.* from dept_change c,employee e where e.id=c.em_id";
////		if(deptChange.getDept_startDate()!=null&&deptChange.getDept_endDate()!=null&&!("").equals(deptChange.getDept_startDate())&&!("").equals(deptChange.getDept_endDate())){
////			sql = sql +" and dept_chDate= "+"between '"+deptChange.getDept_startDate()+"' and '"+deptChange.getDept_endDate()+"'";
////		}
//		if(deptChange.getDept_startDate()!=null&&!("").equals(deptChange.getDept_startDate())){
//			sql=sql+" and to_date('"+deptChange.getDept_startDate()+"','yyyy-mm-dd')<='"+deptChange.getDept_startDate()+"'";
//		}
//		if(deptChange.getDept_endDate()!=null&&!("").equals(deptChange.getDept_endDate())){
//			sql=sql+" and to_date('"+deptChange.getDept_endDate()+"','yyyy-mm-dd')>='"+deptChange.getDept_endDate()+"'";
//		}
//		if(deptChange.getEm_number()>0){
//			sql = sql +" and em_number="+deptChange.getEm_number();
//		}
//		if(deptChange.getEm_name()!=null&&!("").equals(deptChange.getEm_name())){
//			sql = sql +" and em_name='"+deptChange.getEm_name()+"'";
//		}
//		if(deptChange.getDept_chType()>0){
//			sql = sql +" and dept_chType="+deptChange.getDept_chType();
//		}
//		Statement stmt =null;
//		ResultSet set = null;
//		List<DeptChange> deptChangeList = new ArrayList<DeptChange>();
//		try {
//			stmt = conn.createStatement();
//			set = stmt.executeQuery(sql);
//			while(set.next()){
//				DeptChange deptChangeOther = new DeptChange();
//				deptChangeOther.setEm_number(set.getInt("em_number"));
//				deptChangeOther.setEm_name(set.getString("em_name"));
//				deptChangeOther.setDept_number(set.getInt("dept_before"));
//				deptChangeOther.setDept_after(set.getInt("dept_after"));
//				deptChangeOther.setDept_chType(set.getInt("dept_chType"));
//				deptChangeOther.setDept_chReason(set.getString("dept_chReason"));
//				deptChangeOther.setDept_chDate(set.getDate("dept_chDate"));
//				deptChangeOther.setDept_chReason(set.getString("dept_chExtra"));
//				deptChangeList.add(deptChangeOther);
//			}
//		} catch (SQLException e) {
//			throw new DaoException("Error on listing deptchange",e);
//		}finally{
//			DBUtils.closeStatement(stmt);
//		}
//		
//		return deptChangeList;
//	}
//	
	
	
	public List<Dept> getDept_Name(){
		String sql = "select  dept_name ,dept_number from dept";
		Statement stmt = null;
		ResultSet set = null;
		List<Dept> dept_nameList = new ArrayList<Dept>();
		try {
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()){
				Dept dept = new Dept();
				dept.setDept_name(set.getString("dept_name"));
				dept.setDept_number(set.getInt("dept_number"));
				dept_nameList.add(dept);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting dept_name",e);
		}finally{
			DBUtils.closeStatement(stmt);
		}
		return dept_nameList;
	}

	

}
