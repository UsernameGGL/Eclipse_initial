package com.neusoft.deptmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.commom.Getrowid;
import com.neusoft.deptmanage.domain.Dept;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;
/**
 * dao层接口的实现类
 * @author Clover
 *
 */
public class DeptDaoImpl implements DeptDao {
	private Connection conn;
	
	public DeptDaoImpl(Connection conn){
		this.conn = conn;
	}

    /**
     * 实现向数据库中增加一个部门
     */
	public void addDept(Dept dept) {
		String sql="insert into dept(id,dept_number,dept_name,dept_type,dept_tel,dept_fax,dept_super,dept_desc,dept_setdate,situation)"
			+"values(deptid.nextval,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDept_number());
			pstmt.setString(2, dept.getDept_name());
			pstmt.setInt(3, dept.getDept_type());
			pstmt.setString(4, dept.getDept_tel());
			pstmt.setString(5, dept.getDept_fax());
			pstmt.setInt(6, dept.getDept_super());
			pstmt.setString(7, dept.getDept_desc());
			pstmt.setDate(8, dept.getDept_setDate());
			pstmt.setInt(9, 1);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on adding a dept",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	/**
     * 实现查询数据库中部门的查询
     */
	public List<Dept> listDept(Dept dept) {
		String sql = "select b.id,b.dept_number,b.dept_name,b.dept_type,c.code_value dept_value,b.dept_tel,b.dept_fax,b.dept_super,a.dept_name dept_superName,b.dept_desc,b.dept_setDate from dept a,dept b, code c where a.id(+)=b.dept_super and b.dept_type=c.id and b.situation=1";
		if(dept.getDept_number()>0){
			sql = sql +" and b.dept_number="+dept.getDept_number();
		}
		if(dept.getDept_name()!=null&&!dept.getDept_name().equals("")){
			sql = sql +" and b.dept_name='"+dept.getDept_name()+"'";
		}
		if(dept.getDept_type()>0){
			sql = sql +" and b.dept_type="+dept.getDept_type();
		}
		
		Statement stmt = null;
		ResultSet set = null;
		List<Dept> deptList = new ArrayList<Dept>();
		try {
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()){
				Dept deptOther = new Dept();
				deptOther.setId(set.getInt("id"));
				deptOther.setDept_number(set.getInt("dept_number"));
				deptOther.setDept_name(set.getString("dept_name"));
				deptOther.setDept_type(set.getInt("dept_type"));
				deptOther.setDept_value(set.getString("dept_value"));
				deptOther.setDept_tel(set.getString("dept_tel"));
				deptOther.setDept_fax(set.getString("dept_fax"));
				deptOther.setDept_super(set.getInt("dept_super"));
				deptOther.setDept_superName(set.getString("dept_superName"));
				deptOther.setDept_desc(set.getString("dept_desc"));
				deptOther.setDept_setDate(set.getDate("dept_setDate"));
				deptList.add(deptOther);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on alistting depts",e);
		}finally{
			DBUtils.closeStatement(stmt);
		}
		return deptList;
	}
	/**
	 * 实现查询数据库中某一部门信息
	 */
	public Dept getDeptById(int id){
		String sql = "select b.id,b.dept_number,b.dept_name,b.dept_type,b.dept_tel,b.dept_fax,b.dept_super,a.dept_name dept_superName,b.dept_desc,b.dept_setDate from dept a,dept b where a.id=b.dept_super and b.id=? ";
		PreparedStatement pstmt = null;
		ResultSet set = null;
		Dept dept = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			set = pstmt.executeQuery();
			while(set.next()){
				dept = new Dept();
				dept.setDept_number(set.getInt("dept_number"));
				dept.setDept_name(set.getString("dept_name"));
				dept.setDept_type(set.getInt("dept_type"));
				dept.setDept_tel(set.getString("dept_tel"));
				dept.setDept_fax(set.getString("dept_fax"));
				dept.setDept_super(set.getInt("dept_super"));
				//System.out.println(dept.getDept_super());
				dept.setDept_superName(set.getString("dept_superName"));
				//System.out.println(dept.getDept_superName());
				dept.setDept_desc(set.getString("dept_desc"));
				dept.setDept_setDate(set.getDate("dept_setDate"));
				dept.setId(set.getInt("id"));				
			}
		} catch (SQLException e) {
			throw new DaoException("Error on agetting a dept",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
		return dept;
	}
    /**
     * 实现对数据库中某一部门的信息进行修改
     */
	public void editDept(Dept dept) {
		String sql = "update dept set dept_number=?,dept_name=?,dept_type=?,dept_tel=?,dept_fax=?,dept_super=?,dept_desc=?,dept_setDate=? where id="+dept.getId();
        PreparedStatement pstmt = null;
       
        try {
        	pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDept_number());
			pstmt.setString(2, dept.getDept_name());
			pstmt.setInt(3, dept.getDept_type());
			pstmt.setString(4, dept.getDept_tel());
			pstmt.setString(5, dept.getDept_fax());
			pstmt.setInt(6, dept.getDept_super());
			pstmt.setString(7, dept.getDept_desc());
			pstmt.setDate(8, dept.getDept_setDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on editting a dept",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	/**
     * 实现删除数据库中的某一部门
     */

	public void delDept(int dept_number) {
		String sql = "update dept set situation=0 where dept_number=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on deleting a dept",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}

	/**
	 * 验证数据库中某一部门是否存在
	 */
	public boolean getDept(int dept_number){
		String sql = "select count(id) countnum from dept where dept_number=?";
		PreparedStatement pstmt = null;
		ResultSet set = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept_number);
			set = pstmt.executeQuery();
			set.next();
			if(set.getInt("countnum")>0){
				return true;
			}else{
				return false;
			}		
		} catch (SQLException e) {
			throw new DaoException("Error on getting a dept",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	public List<Dept> getDept_superName(){
//		String sql = "select distinct dept_name as dept_superName,dept_super from dept where id=dept_super";
		String sql = "select  dept_name as dept_superName,ID dept_super from dept where situation=1";
		Statement stmt = null;
		ResultSet set = null;
		List<Dept> dept_superList = new ArrayList<Dept>();
		try {
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()){
				Dept dept = new Dept();
				dept.setDept_super(set.getInt("dept_super"));
				dept.setDept_superName(set.getString("dept_superName"));
				dept_superList.add(dept);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting dept_superName",e);
		}finally{
			DBUtils.closeStatement(stmt);
		}
		return dept_superList;
	}
}

