package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kms.po.Probation;
import com.kms.po.WorkInfo;
import com.kms.po.WorkerSalary;

/**
 * 封装对workerinfo表的操作，两个从数据库获取的映射；
 * public WorkInfo find(String a)  从workerinfo表中找一条记录
 * public Map<Integer, String> positionConvert()
 * public Map<Integer, String> deptConvert()
 * public List<WorkerSalary> showSalary()
 * public List<WorkInfo> showAllWorker()
 * public int edit(WorkInfo p)
 * public int add(WorkInfo p)
 * public int del(String p)
 * public int delSalary(String p)
 * @author 张金海
 *
 */

public class WorkerDao extends BaseDao{
	public WorkerDao(){}
	
	/**
	 * 从workerinfo表中找一条记录
	 * @param a 记录的主键
	 * @return
	 */
	public WorkInfo find(String a){
		String sql=" select wid,wnm,wsex,wna,wiid,wtel,wedu,wloc from workerinfo where wid=? ; ";
		Connection connection=null;
		PreparedStatement statement=null;
		WorkInfo workInfo=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
					workInfo=new WorkInfo();
					workInfo.setWid(rSet.getString("wid"));
					workInfo.setWnm(rSet.getObject("wnm")==null?"":rSet.getString("wnm"));
					workInfo.setWsex(rSet.getObject("wsex")==null?"":rSet.getString("wsex"));
					workInfo.setWna(rSet.getObject("wna")==null?"":rSet.getString("wna"));
					workInfo.setWiid(rSet.getObject("wiid")==null?"":rSet.getString("wiid"));
					workInfo.setWtel(rSet.getObject("wtel")==null?"":rSet.getString("wtel"));
					workInfo.setWedu(rSet.getObject("wedu")==null?"":rSet.getString("wedu"));
					workInfo.setWloc(rSet.getObject("wloc")==null?"":rSet.getString("wloc"));
			}
			rSet.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {	
				statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return workInfo;
	}
	
	
	public List<WorkerSalary> selectSalByKey(String a){
		List<WorkerSalary> l=new ArrayList<WorkerSalary>();
		Map<Integer, String> pmap=positionConvert();
		Map<Integer, String> dmap=deptConvert();
		String sql=" select jid,jnm,jage,jpid,jdid,jsal from jobinfo where jsal!=-1 and (jid like ? "
		+"or jnm like ? or jage like ? or jpid like ? or jdid like ? or jsal like ?); ";
		Connection connection=null;
		PreparedStatement statement=null;
		WorkerSalary workInfo=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			statement.setObject(2,a);
			statement.setObject(3,a);
			statement.setObject(4,a);
			statement.setObject(5,a);
			statement.setObject(6,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
				workInfo=new WorkerSalary();
				workInfo.setJid(rSet.getObject("jid")==null?"":rSet.getString("jid"));
				workInfo.setJnm(rSet.getObject("jnm")==null?"":rSet.getString("jnm"));
				workInfo.setJage(rSet.getInt("jage"));
				workInfo.setJposi(pmap.get(rSet.getInt("jpid")));
				workInfo.setJdept(dmap.get(rSet.getInt("jdid")));
				workInfo.setJsal(rSet.getInt("jsal"));
				l.add(workInfo);
			}
			rSet.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {	
				statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}
	
	public List<WorkInfo> selectWorkInfoByKey(String a){
		List<WorkInfo> l=new ArrayList<WorkInfo>();
		String sql=" select wid,wnm,wsex,wna,wiid,wtel,wedu,wloc from workerinfo,jobinfo where jid=wid and jsal!=-1 and (wid like ? "
		+"or wnm like ? or wsex like ? or wna like ? or wiid like ? or wtel like ? or wedu like ? or wloc like ?); ";
		Connection connection=null;
		PreparedStatement statement=null;
		WorkInfo workInfo=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			statement.setObject(2,a);
			statement.setObject(3,a);
			statement.setObject(4,a);
			statement.setObject(5,a);
			statement.setObject(6,a);
			statement.setObject(7,a);
			statement.setObject(8,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
				workInfo=new WorkInfo();
				workInfo.setWid(rSet.getObject("wid")==null?"":rSet.getString("wid"));
				workInfo.setWnm(rSet.getObject("wnm")==null?"":rSet.getString("wnm"));
				workInfo.setWsex(rSet.getObject("wsex")==null?"":rSet.getString("wsex"));
				workInfo.setWna(rSet.getObject("wna")==null?"":rSet.getString("wna"));
				workInfo.setWiid(rSet.getObject("wiid")==null?"":rSet.getString("wiid"));
				workInfo.setWtel(rSet.getObject("wtel")==null?"":rSet.getString("wtel"));
				workInfo.setWedu(rSet.getObject("wedu")==null?"":rSet.getString("wedu"));
				workInfo.setWloc(rSet.getObject("wloc")==null?"":rSet.getString("wloc"));
				l.add(workInfo);
			}
			rSet.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {	
				statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}
	
	/**
	 * 从岗位表中获取的编号对名称的映射
	 * @return
	 */
	public Map<Integer, String> positionConvert(){
		Map<Integer,String> map=new HashMap<Integer,String>();
		String sql=" select pid,pnm from position; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
					map.put(rSet.getInt("pid"), rSet.getString("pnm"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				rSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	/**
	 * 从部门表中获取编号对名称的映射
	 * @return
	 */
	public Map<Integer, String> deptConvert(){
		Map<Integer,String> map=new HashMap<Integer,String>();
		String sql=" select did,dnm from dept; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
					map.put(rSet.getInt("did"), rSet.getString("dnm"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				rSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	/**
	 * 获取薪资信息列表
	 * @return
	 */
	public List<WorkerSalary> showSalary(){
		List<WorkerSalary> salList=new ArrayList<WorkerSalary>();
		Map<Integer, String> pmap=positionConvert();
		Map<Integer, String> dmap=deptConvert();
		String sql=" select jid,jnm,jage,jpid,jdid,jsal from jobinfo where jsal!=-1; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		WorkerSalary sal=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
					sal=new WorkerSalary();
					sal.setJid(rSet.getObject("jid")==null?"":rSet.getString("jid"));
					sal.setJnm(rSet.getObject("jnm")==null?"":rSet.getString("jnm"));
					sal.setJage(rSet.getInt("jage"));
					sal.setJposi(pmap.get(rSet.getInt("jpid")));
					sal.setJdept(dmap.get(rSet.getInt("jdid")));
					sal.setJsal(rSet.getInt("jsal"));
					salList.add(sal);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				rSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salList;
	}
	
	
	/**
	 * 获取职工信息列表
	 * @return
	 */
	public List<WorkInfo> showAllWorker(){
		List<WorkInfo> listWorker=new ArrayList<WorkInfo>();
		String sql=" select wid,wnm,wsex,wna,wiid,wtel,wedu,wloc from workerinfo,jobinfo where jid=wid and jsal!=-1; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		WorkInfo workInfo=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
					workInfo=new WorkInfo();
					workInfo.setWid(rSet.getObject("wid")==null?"":rSet.getString("wid"));
					workInfo.setWnm(rSet.getObject("wnm")==null?"":rSet.getString("wnm"));
					workInfo.setWsex(rSet.getObject("wsex")==null?"":rSet.getString("wsex"));
					workInfo.setWna(rSet.getObject("wna")==null?"":rSet.getString("wna"));
					workInfo.setWiid(rSet.getObject("wiid")==null?"":rSet.getString("wiid"));
					workInfo.setWtel(rSet.getObject("wtel")==null?"":rSet.getString("wtel"));
					workInfo.setWedu(rSet.getObject("wedu")==null?"":rSet.getString("wedu"));
					workInfo.setWloc(rSet.getObject("wloc")==null?"":rSet.getString("wloc"));
					listWorker.add(workInfo);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				rSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listWorker;
	}
	
	
	
	public int updateSDP(String p,int sal,int dept,int position){
		 int i=-1;
			String sql="update jobinfo set jsal=?, jdid=? ,jpid=? where jid=? ";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, sal);
				preparedStatement.setObject(2, dept);
				preparedStatement.setObject(3, position);
				preparedStatement.setObject(4, p);
				i=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{ 
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return i;
	}
	
	
	/**
	 * 更新workerinfo表中的一条记录
	 * @param p 保存记录的对象
	 * @return
	 */
	public int edit(WorkInfo p){
		 int i=-1;
			String sql="UPDATE  `test`.`workerinfo` SET `wnm` = ?, `wsex` = ?,`wna` = ?,  `wiid` = ?,`wtel` = ?, `wedu` = ?,  `wloc` = ? WHERE `wid` = ? ;";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getWnm());
				preparedStatement.setObject(2, p.getWsex());
				preparedStatement.setObject(3, p.getWna());
				preparedStatement.setObject(4, p.getWiid());
				preparedStatement.setObject(5, p.getWtel());
				preparedStatement.setObject(6, p.getWedu());
				preparedStatement.setObject(7, p.getWloc());
				preparedStatement.setObject(8, p.getWid());
				i=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{ 
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return i;
	}
	
	
	/**
	 * 向workerinfo表中添加一条记录
	 * @param p 要添加的记录对象
	 * @return
	 */
	 public int add(WorkInfo p){
		 int i=-1;
			String sql="insert into workerinfo values(?,?,?,?,?,?,?,?)";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getWid());
				preparedStatement.setObject(2, p.getWnm());
				preparedStatement.setObject(3, p.getWsex());
				preparedStatement.setObject(4, p.getWna());
				preparedStatement.setObject(5, p.getWiid());
				preparedStatement.setObject(6, p.getWtel());
				preparedStatement.setObject(7, p.getWedu());
				preparedStatement.setObject(8, p.getWloc());
				i=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{ 
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return i;
	}
	 
	 
	 /**
	  * 删除workerinfo表中的一条记录
	  * @param p 要删除的记录主键
	  * @return
	  */
	 public int del(String p){
		 int i=-1;
			String sql="update jobinfo set jsal=-1 where jid= ? ";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p);
				i=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{ 
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return i;
	}
	 
	 
	 /**
	  * 删除一条jobInf中，薪资记录
	  * @param p 记录主键
	  * @return
	  */
	 public int delSalary(String p){
		 int i=-1;
		 String sql="update jobinfo set jsal=-1 where jid= ?  ";
		 Connection connection=null;
		 PreparedStatement preparedStatement= null ;
		 connection=super.getConnection();
		 try {
			 preparedStatement=connection.prepareStatement(sql);
			 preparedStatement.setObject(1, p);
			 i=preparedStatement.executeUpdate();
		 } catch (SQLException e) {
			 
			 e.printStackTrace();
		 }finally{ 
			 try {
				 preparedStatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
			 try {
				 connection.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return i;
	 }
}
