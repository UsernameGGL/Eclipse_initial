package com.neusoft.employeemanage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;

public class EmployeeDaoImpl implements EmployeeDao{

	/**
	 * Ա�������Ĳ�ʵ�� ��Ҫ�������ݿ��еĲ���
	 * 
	 */
	private Connection connection;

	public EmployeeDaoImpl(Connection conn) {
		this.connection = conn;
	}

	/**
	 * �����û�,�������ڴ�������
	 * 
	 * @param employee����
	 */
	public Employee addEmployee(Employee employee) {
		String sql = "insert into employee(em_number, em_name, em_birth, sex, em_format, em_source,em_polity,em_folk,em_id,em_indate,em_worktime,em_birthplace,em_phone,em_mail,em_blood,em_wedlock,em_stature,dept_number,job_number,em_seat,em_learn,em_degree,em_graduate,em_specialty,em_gradate,em_homeplace,situation,id)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,empid.nextval)";
	PreparedStatement pstmt = null;
	try {
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, employee.getEm_number());
		pstmt.setString(2, employee.getEm_name());
		pstmt.setDate(3, employee.getEm_birth());
		pstmt.setInt(4, employee.getSex());
		pstmt.setInt(5, employee.getEm_format());
		pstmt.setInt(6, employee.getEm_source());
		pstmt.setInt(7, employee.getEm_polity());
		pstmt.setInt(8, employee.getEm_folk());
		pstmt.setString(9, employee.getEm_id());
		pstmt.setDate(10, employee.getEm_indate());
		pstmt.setDate(11, employee.getEm_worktime());
		pstmt.setString(12, employee.getEm_birthplace());
		pstmt.setString(13, employee.getEm_phone());
		pstmt.setString(14, employee.getEm_mail());
		pstmt.setInt(15, employee.getEm_blood());
		pstmt.setInt(16, employee.getEm_wedlock());
		pstmt.setString(17, employee.getEm_stature());
		pstmt.setInt(18, employee.getDept_number());
		pstmt.setInt(19, employee.getJob_number());
		pstmt.setString(20, employee.getEm_seat());
		pstmt.setInt(21, employee.getEm_learn());
		pstmt.setInt(22, employee.getEm_degree());
		pstmt.setString(23, employee.getEm_graduate());
		pstmt.setString(24, employee.getEm_specialty());
		pstmt.setDate(25, employee.getEm_gradate());
		pstmt.setString(26, employee.getEm_homeplace());
		pstmt.setInt(27, employee.getSituation());
//		pstmt.setInt(28, 4);	
		pstmt.executeUpdate();
		/*******job_ch*****/
		pstmt = connection.prepareStatement("update job set job_man = job_man+1 where job_number = ?");
		pstmt.setInt(1, employee.getJob_number());
		pstmt.executeUpdate();
		//***��ѯid
		ResultSet rs = null;
		pstmt = connection.prepareStatement("select * from employee where em_number=?");
		pstmt.setInt(1, employee.getEm_number());
		rs = pstmt.executeQuery();
		if (rs.next()) {
					employee.setId(rs.getInt("id"));
		}
		return employee;
		
	} catch (SQLException e) {
		throw new DaoException("Error on adding employee", e);
	} finally {
		DBUtils.closeStatement(pstmt);
	}
//	//���ر�־��
//	  return employee.getSituation();

	}
  
	/**
	 * ���ѯ������ѯԱ����
	 * ��ѯ����������  Ա����ţ�all.em_number
	 *         		Ա��������all.em_name
	 *              ���ű�ţ�all.dept_number
	 *         		�������ƣ�all.dept_name
	 *         		���ŵ�ת���ͣ�all.dept_chType
	 *              ���ſ�ʼ���ڣ�all.dept_startDate
	 *              ���Ž������ڣ�all.dept_endDate
	 *              ��λ���ƣ�all.job_name
	 *              ��λ��ת���ͣ�all.job_chType
	 *              ��λ��ʼ���ڣ�all.job_startDate
	 *              ��λ�������ڣ�all.job_endDate
	 * ��ѯ��������������Ա��
	 * @return List<Employee>
	 */
	public List<Employee> findAllEmployeeList(All all) {
		String sql = "select o.lz_type ,e.* ,d.dept_name dept_name,j.job_name job_name from domission o, employee e ,dept d ,job j where e.dept_number=d.dept_number(+) and e.job_number=j.job_number(+) and o.id(+)=e.id ";
		Statement stmt = null;
		ResultSet rs = null;
	             //situation=3 Ϊ��ְ״̬Ա��
		List<Employee> employeeList = new ArrayList<Employee>();	
		//�ж��Ƿ����ڲ�ѯ��ְԱ��
		if(all.getLz_type()>0){
			sql = sql+" and e.situation=3 and o.lz_type="+all.getLz_type();
		}else{
			sql = sql+" and e.situation<>3";
		}
		//����Ա�����
		if(all.getId()>0)
		{
			sql = sql+" and e.id="+all.getId();
		}
		//Ա�����  all.em_number
		if(all.getEm_number()>0){
			sql=sql+" and e.em_number="+all.getEm_number();
		}
		//Ա������ all.em_name
		if(all.getEm_name()!=null){
			sql=sql+" and e.em_name="+"'"+all.getEm_name()+"'";
		}
		//���ű�� all.dept_number
		if(all.getDept_number()>0){
			sql=sql+" and e.dept_number="+all.getDept_number();
		}
		//��λ��� all.job_number
		if(all.getJob_number()>0){
			sql=sql+" and e.job_number="+all.getJob_number();
		}
		//�������ƣ�all.dept_name
	    if(all.getDept_name()!=null&&!("").equals(all.getDept_name())){
	    	sql=sql+" and d.dept_name="+all.getDept_name();
	    }
	  //��λ���ƣ�all.job_name
	    if(all.getJob_name()!=null&&!("").equals(all.getJob_name())){
	    	sql=sql+" and j.job_name="+all.getJob_name();
	    }
	   // �ù���ʽ��all.em_format
	    if(all.getEm_format()>0){
	    	sql=sql+" and e.em_format="+all.getEm_format();
	    }
	    // ��ְ��ʼ���ڣ�all.begin_date 
	    if(all.getBegin_date()!=null){
	    	sql=sql+" and o.lz_date>=to_date('"+all.getBegin_date()+"','yyyy-mm-dd')";
	    }
	    //��ְ�������ڣ�all.end_date
	    if(all.getEnd_date()!=null){
	    	sql=sql+" and o.lz_date<=to_date('"+all.getEnd_date()+"','yyyy-mm-dd')";
	    }
	    
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee employee=new Employee();
				employee.setEm_number(rs.getInt("em_number"));
				employee.setEm_name(rs.getString("em_name"));
				employee.setEm_birth(rs.getDate("em_birth"));
				employee.setSex(rs.getInt("sex"));
				employee.setEm_format(rs.getInt("em_format"));
				employee.setEm_source(rs.getInt("em_source"));
				employee.setEm_polity(rs.getInt("em_polity"));
				employee.setEm_folk(rs.getInt("em_folk"));
				employee.setEm_id(rs.getString("em_id"));
				employee.setEm_indate(rs.getDate("em_indate"));
				employee.setEm_worktime(rs.getDate("em_worktime"));
				employee.setEm_birthplace(rs.getString("em_birthplace"));
				employee.setEm_phone(rs.getString("em_phone"));
				employee.setEm_mail(rs.getString("em_mail"));
				employee.setEm_blood(rs.getInt("em_blood"));
				employee.setEm_wedlock(rs.getInt("em_wedlock"));
				employee.setEm_stature(rs.getString("em_stature"));
				employee.setDept_number(rs.getInt("dept_number"));
				employee.setJob_number(rs.getInt("job_number"));
				employee.setEm_seat(rs.getString("em_seat"));
				employee.setEm_learn(rs.getInt("em_learn"));
				employee.setEm_degree(rs.getInt("em_degree"));
				employee.setEm_graduate(rs.getString("em_graduate"));
				employee.setEm_specialty(rs.getString("em_specialty"));
				employee.setEm_gradate(rs.getDate("em_gradate"));
				employee.setEm_homeplace(rs.getString("em_homeplace"));
//				employee.setProb_start(rs.getDate("prob_start"));
//				employee.setProb_end(rs.getDate("prob_end"));
				employee.setSituation(rs.getInt("situation"));
				employee.setId(rs.getInt("id"));
				employee.setDept_name(rs.getString("dept_name"));
				employee.setJob_name(rs.getString("job_name"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return employeeList;

	}
	

	
	
	/**
	 *  �޸�Ա����Ϣ �еı���
	 * @param Employee��employee����
	 */
	public void editEmployee(Employee employee) {
		String sql = "update employee set em_number=?, em_name=?, em_birth=?, sex=?, em_format=?, em_source=?,em_polity=?,em_folk=?,em_id=?,em_indate=?,em_worktime=?,em_birthplace=?,em_phone=?,em_mail=?,em_blood=?,em_wedlock=?,em_stature=?,dept_number=?,job_number=?,em_seat=?,em_learn=?,em_degree=?,em_graduate=?,em_specialty=?,em_gradate=?,em_homeplace=? where id=?";
		String sql2="update job set job_man=(job_man-1) where job_number=(select job_number from employee where em_number=?)";
		PreparedStatement pstmt = null;
		try {
			/******֮ǰ�ĸ�λ������һ********/			
			/*pstmt = connection.prepareStatement(sql2);
			pstmt.setInt(1, employee.getEm_number());
			pstmt.executeUpdate();*/
			/******֮ǰ�ĸ�λ������һ********/

		
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, employee.getEm_number());
			System.out.println(employee.getEm_number());
			pstmt.setString(2, employee.getEm_name());
			pstmt.setDate(3, employee.getEm_birth());
			pstmt.setInt(4, employee.getSex());
			pstmt.setInt(5, employee.getEm_format());
			pstmt.setInt(6, employee.getEm_source());
			pstmt.setInt(7, employee.getEm_polity());
			pstmt.setInt(8, employee.getEm_folk());
			pstmt.setString(9, employee.getEm_id());
			pstmt.setDate(10, employee.getEm_indate());
			pstmt.setDate(11, employee.getEm_worktime());
			pstmt.setString(12, employee.getEm_birthplace());
			pstmt.setString(13, employee.getEm_phone());
			pstmt.setString(14, employee.getEm_mail());
			pstmt.setInt(15, employee.getEm_blood());
			pstmt.setInt(16, employee.getEm_wedlock());
			pstmt.setString(17, employee.getEm_stature());
			pstmt.setInt(18, employee.getDept_number());
			pstmt.setInt(19, employee.getJob_number());
			pstmt.setString(20, employee.getEm_seat());
			pstmt.setInt(21, employee.getEm_learn());
			pstmt.setInt(22, employee.getEm_degree());
			pstmt.setString(23, employee.getEm_graduate());
			pstmt.setString(24, employee.getEm_specialty());
			pstmt.setDate(25, employee.getEm_gradate());
			pstmt.setString(26, employee.getEm_homeplace());	
			pstmt.setInt(27, employee.getId());
			System.out.println(employee.getId());
			pstmt.executeUpdate();
			
			/*****֮��ĸ�λ������һ********/	
			/*pstmt = connection.prepareStatement("update job set job_man=job_man+1 where job_number=?");
			pstmt.setInt(1, employee.getJob_number());
			pstmt.executeUpdate();*/
			
		} catch (SQLException e) {
			throw new DaoException("Error on updating employee", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ����Ա����Ų�ѯ�û�
	 */
	public Employee findEmployeeById (int id) {
		//String sql = "select * from employee where id=?";
		String sql= "select e.* ,d.dept_name,j.job_name from employee e,dept d,job j where e.dept_number=d.dept_number(+) AND e.job_number=j.job_number(+) AND e.id=?";
		Employee employee = new Employee();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
					employee.setEm_number(rs.getInt("em_number"));
					employee.setEm_name(rs.getString("em_name"));
					employee.setEm_birth(rs.getDate("em_birth"));
					employee.setSex(rs.getInt("sex"));
					employee.setEm_format(rs.getInt("em_format"));
					employee.setEm_source(rs.getInt("em_source"));
					employee.setEm_polity(rs.getInt("em_polity"));
					employee.setEm_folk(rs.getInt("em_folk"));
					employee.setEm_id(rs.getString("em_id"));
					employee.setEm_indate(rs.getDate("em_indate"));
					employee.setEm_worktime(rs.getDate("em_worktime"));
					employee.setEm_birthplace(rs.getString("em_birthplace"));
					employee.setEm_phone(rs.getString("em_phone"));
					employee.setEm_mail(rs.getString("em_mail"));
					employee.setEm_blood(rs.getInt("em_blood"));
					employee.setEm_wedlock(rs.getInt("em_wedlock"));
					employee.setEm_stature(rs.getString("em_stature"));
					employee.setDept_number(rs.getInt("dept_number"));
					employee.setJob_number(rs.getInt("job_number"));
					employee.setEm_seat(rs.getString("em_seat"));
					employee.setEm_learn(rs.getInt("em_learn"));
					employee.setEm_degree(rs.getInt("em_degree"));
					employee.setEm_graduate(rs.getString("em_graduate"));
					employee.setEm_specialty(rs.getString("em_specialty"));
					employee.setEm_gradate(rs.getDate("em_gradate"));
					employee.setEm_homeplace(rs.getString("em_homeplace"));
//					employee.setProb_start(rs.getDate("prob_start"));
//					employee.setProb_end(rs.getDate("prob_end"));
					employee.setSituation(rs.getInt("situation"));
					employee.setId(id);
					employee.setDept_name(rs.getString("dept_name"));
					employee.setJob_name(rs.getString("job_name"));
				}
		} catch (SQLException e) {
			throw new DaoException("Error on getting employee", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return employee;
	 }
	
	
//�ж�Ա������Ƿ��ظ��ķ���
	public Boolean findEmployeeByEm_number (int em_number) 
	{
		String sql = "select em_number from employee where em_number=?";
		Employee employee = new Employee();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, em_number);
			rs = pstmt.executeQuery();
			if (rs.next()) 
			{
				employee.setEm_number(rs.getInt("em_number"));
			}
			if(employee.getEm_number()==em_number){
				return true;
			}
			
		 } catch (SQLException e) 
		  {
		 	throw new DaoException("Error on getting employee", e);
		  } finally 
		  {
			DBUtils.closeStatement(pstmt);
		  }
		return false;
	}
	
}	
	
	