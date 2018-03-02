package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kms.po.KeyWord;

/**封装从数据库中查询所需的报表信息
 * 
 * public List<String []> listProbation() 查询实习生报表的信息
 * public List<String []> listWorker() 查询在职员工报表的信息
 * public List<String []> listQuit() 查询离职员工报表的信息
 * public List<String []> listChange(KeyWord keyW) 查询指定日期范围内在职员工变更记录报表的信息
 * @author 刘嘉赓
 *
 */
public class ReportDao extends BaseDao {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/**查询实习生报表的信息，封装在返回的List<String []>中；
	 * 信息从左到右依次为：
	 * 实习生编号，姓名，性别，年龄，学历，部门名称，岗位名称，实习开始时间，实习结束时间
	 * @return List<String []>
	 */
	public List<String []> listProbation(){
		List<String []> list = new ArrayList<String []>();
		String sql=" SELECT pr.pid,pr.pnm nm,psex,page,pedu,dnm,po.pnm ponm,pst,pend "
				+ " FROM probationinfo pr,POSITION po,dept  WHERE ppos=po.pid AND pdept=did  ";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet = null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				String[] tmp = new String[9];
				tmp[0] = resultSet.getString("pr.pid");
				tmp[1] = resultSet.getString("nm");
				tmp[2] = resultSet.getString("psex");
				tmp[3] = Integer.toString(resultSet.getInt("page"));
				tmp[4] = resultSet.getString("pedu");
				tmp[5] = resultSet.getString("dnm");
				tmp[6] = resultSet.getString("ponm");
				tmp[7] = FORMAT.format(resultSet.getDate("pst"));
				tmp[8] = FORMAT.format(resultSet.getDate("pend"));
				list.add(tmp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**查询在职员工报表的信息，封装在返回的List<String []>中；
	 * 信息从左到右依次为：
	 * 在职员工编号，姓名，性别，年龄，民族，籍贯，学历，部门名称，岗位名称，薪金，联系方式
	 * @return List<String []>
	 */
	public List<String []> listWorker(){
		List<String []> list = new ArrayList<String []>();
		String sql=" select wid,wnm,wsex,jage,wna,wloc,wedu,dnm,pnm,jsal,wtel "
				+ " from jobinfo,workerinfo,position,dept "
				+ " where wid=jid and jpid=pid and jdid=did and jsal!=-1 ";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet = null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				String[] tmp = new String[11];
				tmp[0] = resultSet.getString("wid");
				tmp[1] = resultSet.getString("wnm");
				tmp[2] = resultSet.getString("wsex");
				tmp[3] = Integer.toString(resultSet.getInt("jage"));
				tmp[4] = resultSet.getString("wna");
				tmp[5] = resultSet.getString("wloc");
				tmp[6] = resultSet.getString("wedu");
				tmp[7] = resultSet.getString("dnm");
				tmp[8] = resultSet.getString("pnm");
				tmp[9] = Integer.toString(resultSet.getInt("jsal"));
				tmp[10] = resultSet.getString("wtel");
				list.add(tmp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**查询离职员工报表的信息，封装在返回的List<String []>中；
	 * 信息从左到右依次为：
	 * 离职员工编号，姓名，性别，年龄，民族，学历，部门名称，岗位名称，联系方式
	 * @return List<String []>
	 */
	public List<String []> listQuit(){
		List<String []> list = new ArrayList<String []>();
		String sql=" select wid,wnm,wsex,jage,wna,wedu,dnm,pnm,wtel "
				+ " from jobinfo,workerinfo,position,dept "
				+ " where wid=jid and jpid=pid and jdid=did and jsal=-1 ";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet = null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				String[] tmp = new String[9];
				tmp[0] = resultSet.getString("wid");
				tmp[1] = resultSet.getString("wnm");
				tmp[2] = resultSet.getString("wsex");
				tmp[3] = Integer.toString(resultSet.getInt("jage"));
				tmp[4] = resultSet.getString("wna");
				tmp[5] = resultSet.getString("wedu");
				tmp[6] = resultSet.getString("dnm");
				tmp[7] = resultSet.getString("pnm");
				tmp[8] = resultSet.getString("wtel");
				list.add(tmp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**查询指定日期范围内在职员工变更记录报表的信息，封装在返回的List<String []>中；
	 * 信息从左到右依次为：
	 * 记录编号，员工姓名，变更操作，原部门/岗位名称，现部门/岗位名称，原薪金，现薪金，变更时间
	 * @return List<String []>
	 */
	public List<String []> listChange(KeyWord keyW){
		List<String []> list = new ArrayList<String []>();
		String sql=" SELECT `rid`,`cnm`,`cop`,`cold`,`cnew`,`cosal`,`cnsal`,`cdate` FROM `test`.`change` "
				+ " where cdate between ? and ? ";
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet = null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			
			statement.setObject(1,keyW.getFormer());
			statement.setObject(2,keyW.getLatter());
			
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				String[] tmp = new String[8];
				tmp[0] = Integer.toString(resultSet.getInt("rid"));
				tmp[1] = resultSet.getString("cnm");
				tmp[2] = resultSet.getString("cop");
				tmp[3] = resultSet.getString("cold");
				tmp[4] = resultSet.getString("cnew");
				tmp[5] = Integer.toString(resultSet.getInt("cosal"));
				tmp[6] = Integer.toString(resultSet.getInt("cnsal"));
				tmp[7] = FORMAT.format(resultSet.getDate("cdate"));
				list.add(tmp);
			}
			System.out.println("listChange成功！");
		}catch(Exception e){
			System.out.println("listChange失败！"+e.getMessage());
			
		}finally{
			try {
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
