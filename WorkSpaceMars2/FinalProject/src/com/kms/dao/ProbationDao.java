package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kms.po.Apply;
import com.kms.po.Probation;

/**
 * 封装对实习生和实习申请的各种操作
 * @author 张金海
 *
 */
public class ProbationDao extends BaseDao{

	private int startWage=2000;//员工起始工资
	
	/**
	 * 延长实习期
	 * @param pid 实习生编号
	 * @param a 延长月数
	 */
	public void delay(String pid,int a){
		
		String sql="update probationinfo set pend=date_add(pend,interval ? month) where pid=? ;";
		Connection connection=getConnection();
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(sql);
			statement.setObject(1, a);
			statement.setObject(2, pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 添加一条实习记录
	 * @param p 实习记录
	 * @return
	 */
	public int add(Apply p){
		 int i=-1;
			String sql="insert into apply values(?,?,?,?,?,?,?,?,?,?,?)";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getRid());
				preparedStatement.setObject(2, p.getAnm());
				preparedStatement.setObject(3, p.getAedu());
				preparedStatement.setObject(4, p.getApos());
				preparedStatement.setObject(5, p.getAsex());
				preparedStatement.setObject(6, p.getAage());
				preparedStatement.setObject(7, p.getAna());
				preparedStatement.setObject(8, p.getAid());
				preparedStatement.setObject(9, p.getAtel());
				preparedStatement.setObject(10, p.getAloc());
				preparedStatement.setObject(11, p.getAdel());
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
	 * 从身份证号中得到年龄
	 * @param id 身份证号
	 * @return
	 */
	public int idToAge(String id){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);
		return Integer.parseInt(formatDate)-Integer.parseInt(id.substring(6, 10));
	}
	
	
	/**
	 *向jobinfo表中添加一条记录 
	 * @param p 一条实习生记录
	 * @return
	 */
	public int addToJobinfo(Probation p){
		 int i=-1;
	        int age=idToAge(p.getPiid());
	        System.out.println("-------"+age+"----------");
		 Map<String,Integer> pmap=unpositionConvert();
			Map<String,Integer> dmap=undeptConvert();
			String sql="insert into jobinfo values(?,?,?,?,?,?)";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getPid());
				preparedStatement.setObject(2, p.getPnm());
				preparedStatement.setObject(3, age);
				preparedStatement.setObject(4, pmap.get(p.getPpos()));
				preparedStatement.setObject(5, dmap.get(p.getPdept()));
				preparedStatement.setObject(6, startWage);
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
	 * @param p 一条实习生记录
	 * @return
	 */
	public int addToWorkerinfo(Probation p){
		 int i=-1;
			String sql="insert into workerinfo values(?,?,?,?,?,?,?,?);";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getPid());
				preparedStatement.setObject(2, p.getPnm());
				preparedStatement.setObject(3, p.getPsex());
				preparedStatement.setObject(4, p.getPna());
				preparedStatement.setObject(5, p.getPiid());
				preparedStatement.setObject(6, p.getPtel());
				preparedStatement.setObject(7, p.getPedu());
				preparedStatement.setObject(8, p.getPloc());
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
	 * 向实习生表probation中添加一条记录
	 * @param p 一条实习生记录
	 * @return
	 */
	public int addToProbation(Probation p){
		 int i=-1;
		 int age=idToAge(p.getPiid());
		 Map<String,Integer> pmap=unpositionConvert();
			Map<String,Integer> dmap=undeptConvert();
			String sql="insert into probationinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			Connection connection=null;
			PreparedStatement preparedStatement= null ;
			connection=super.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setObject(1, p.getPid());
				preparedStatement.setObject(2, p.getPnm());
				preparedStatement.setObject(3, p.getPsex());
				preparedStatement.setObject(4, age);
				preparedStatement.setObject(5, p.getPna());
				preparedStatement.setObject(6, p.getPiid());
				preparedStatement.setObject(7, p.getPtel());
				preparedStatement.setObject(8, p.getPedu());
				preparedStatement.setObject(9, p.getPloc());
				preparedStatement.setObject(10, p.getPst());
				preparedStatement.setObject(11, p.getPend());
				preparedStatement.setObject(12, pmap.get(p.getPpos()));
				preparedStatement.setObject(13, dmap.get(p.getPdept()));
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
	 * 将岗位名称映射为岗位编号
	 * @return
	 */
	public Map<String,Integer> unpositionConvert(){
		Map<String,Integer> map=new HashMap<String,Integer>();
		String sql=" select pid,pnm from position; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
				map.put( rSet.getString("pnm"),rSet.getInt("pid"));
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
	 * 将岗位名称映射为岗位编号
	 * @return
	 */
	public Map<String,Integer> undeptConvert(){
		Map<String,Integer> map=new HashMap<String,Integer>();
		String sql=" select did,dnm from dept; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
				map.put(rSet.getString("dnm"),rSet.getInt("did"));
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
	 * 获取实习生列表
	 * @return
	 */
	public List<Probation> showProbation(){
		Map<Integer, String> pmap=new WorkerDao().positionConvert();
		Map<Integer, String> dmap=new WorkerDao().deptConvert();
		List<Probation> apList=new ArrayList<Probation>();
		String sql=" select pid,pnm,psex,page,pna,piid,ptel,pedu,ploc,pst,pend,ppos,pdept from probationinfo where pend>CURDATE() ; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		Probation sal=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
				sal=new Probation();
				sal.setPid(rSet.getObject("pid")==null?"":rSet.getString("pid"));
				sal.setPnm(rSet.getObject("pnm")==null?"":rSet.getString("pnm"));
				sal.setPsex(rSet.getObject("psex")==null?"":rSet.getString("psex"));
				sal.setPage(rSet.getInt("page"));
				sal.setPna(rSet.getObject("pna")==null?"":rSet.getString("pna"));
				sal.setPiid(rSet.getObject("piid")==null?"":rSet.getString("piid"));
				sal.setPtel(rSet.getObject("ptel")==null?"":rSet.getString("ptel"));
				sal.setPedu(rSet.getObject("pedu")==null?"":rSet.getString("pedu"));
				sal.setPloc(rSet.getObject("ploc")==null?"":rSet.getString("ploc"));
				sal.setPst(rSet.getDate("pst"));
				sal.setPend(rSet.getDate("pend"));
				sal.setPpos(pmap.get(rSet.getInt("ppos")));
				sal.setPdept(dmap.get(rSet.getInt("pdept")));
				
				apList.add(sal);
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
		return apList;
	}
	
	
	
	/**
	 * 获取申请列表
	 * @return
	 */
	public List<Apply> showApply(){
		List<Apply> apList=new ArrayList<Apply>();
		String sql=" select rid,anm,aedu,apos,asex,aage,ana,aid,atel,aloc from apply where adel='0'; ";
		Connection connection=null;
		Statement statement=null;
		ResultSet rSet=null;
		Apply sal=null;
		try{
			connection=getConnection();
			statement=connection.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()){
					sal=new Apply();
					sal.setRid(rSet.getInt("rid"));
					sal.setAnm(rSet.getObject("anm")==null?"":rSet.getString("anm"));
					sal.setAedu(rSet.getObject("aedu")==null?"":rSet.getString("aedu"));
					sal.setApos(rSet.getObject("apos")==null?"":rSet.getString("apos"));
					sal.setAsex(rSet.getObject("asex")==null?"":rSet.getString("asex"));
					sal.setAage(rSet.getInt("aage"));
					sal.setAna(rSet.getObject("ana")==null?"":rSet.getString("ana"));
					sal.setAid(rSet.getObject("aid")==null?"":rSet.getString("aid"));
					sal.setAtel(rSet.getObject("atel")==null?"":rSet.getString("atel"));
					sal.setAloc(rSet.getObject("aloc")==null?"":rSet.getString("aloc"));
					apList.add(sal);
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
		return apList;
	}

	
	
	
	/**
	 * 寻找一条申请记录
	 * @param a 记录编号
	 * @return
	 */
	public Apply find(int a){
		String sql="SELECT   `rid`,  `anm`,  `aedu`,  `apos`,  `asex`,  `aage`,  `ana`,  `aid`,  `atel`,"
				+ "  `aloc`,  `adel` FROM  `test`.`apply` where rid=? ; ";
		Connection connection=null;
		PreparedStatement statement=null;
		Apply workInfo=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
					workInfo=new Apply();
					workInfo.setRid(rSet.getInt("rid"));
					workInfo.setAnm(rSet.getObject("anm")==null?"":rSet.getString("anm"));
					workInfo.setAsex(rSet.getObject("asex")==null?"":rSet.getString("asex"));
					workInfo.setAid(rSet.getObject("aid")==null?"":rSet.getString("aid"));
					workInfo.setAtel(rSet.getObject("atel")==null?"":rSet.getString("atel"));
					workInfo.setAedu(rSet.getObject("aedu")==null?"":rSet.getString("aedu"));
					workInfo.setAloc(rSet.getObject("aloc")==null?"":rSet.getString("aloc"));
					workInfo.setApos(rSet.getObject("apos")==null?"":rSet.getString("apos"));
					workInfo.setAna(rSet.getObject("ana")==null?"":rSet.getString("ana"));
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
	
	     
	public List<Apply> selectApplyByKey(String a){
		List<Apply> l=new ArrayList<Apply>();
		String sql="SELECT   `rid`,  `anm`,  `aedu`,  `apos`,  `asex`,  `aage`,  `ana`,  `aid`,  `atel`,"
				+ "  `aloc`,  `adel` FROM  `test`.`apply` where anm like ? or aedu like ? or apos like ? or asex like ? or aage like ? or ana like ? or aid like ? or atel like ? or aloc like ? ; ";
		Connection connection=null;
		PreparedStatement statement=null;
		Apply workInfo=null;
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
			statement.setObject(9,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
				workInfo=new Apply();
				workInfo.setRid(rSet.getInt("rid"));
				workInfo.setAnm(rSet.getObject("anm")==null?"":rSet.getString("anm"));
				workInfo.setAsex(rSet.getObject("asex")==null?"":rSet.getString("asex"));
				workInfo.setAid(rSet.getObject("aid")==null?"":rSet.getString("aid"));
				workInfo.setAtel(rSet.getObject("atel")==null?"":rSet.getString("atel"));
				workInfo.setAedu(rSet.getObject("aedu")==null?"":rSet.getString("aedu"));
				workInfo.setAloc(rSet.getObject("aloc")==null?"":rSet.getString("aloc"));
				workInfo.setApos(rSet.getObject("apos")==null?"":rSet.getString("apos"));
				workInfo.setAna(rSet.getObject("ana")==null?"":rSet.getString("ana"));
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
	
	
	public List<Probation> selectProbationByKey(String a){
		Map<Integer, String> pmap=new WorkerDao().positionConvert();
		Map<Integer, String> dmap=new WorkerDao().deptConvert();
		List<Probation> l=new ArrayList<Probation>();
		String sql="SELECT   pid,pnm,psex,page,pna,piid,ptel,pedu,ploc,pst,pend,ppos,pdept FROM  `test`.`apply` where pid like ? "
		+"or pnm like ? or psex like ? or page like ? or pna like ? or piid like ? or ptel like ? or pedu like ? "
		+"or ploc like ? or pst like ? or pend like ? or ppos like ? or pdept like ?; ";
		Connection connection=null;
		PreparedStatement statement=null;
		Probation workInfo=null;
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
			statement.setObject(9,a);
			statement.setObject(10,a);
			statement.setObject(11,a);
			statement.setObject(12,a);
			statement.setObject(13,a);
			ResultSet rSet=statement.executeQuery();
			while(rSet.next()){
				workInfo=new Probation();
				workInfo.setPid(rSet.getObject("pid")==null?"":rSet.getString("pid"));
				workInfo.setPnm(rSet.getObject("pnm")==null?"":rSet.getString("pnm"));
				workInfo.setPsex(rSet.getObject("psex")==null?"":rSet.getString("psex"));
				workInfo.setPage(rSet.getInt("page"));
				workInfo.setPna(rSet.getObject("pna")==null?"":rSet.getString("pna"));
				workInfo.setPiid(rSet.getObject("piid")==null?"":rSet.getString("piid"));
				workInfo.setPtel(rSet.getObject("ptel")==null?"":rSet.getString("ptel"));
				workInfo.setPedu(rSet.getObject("pedu")==null?"":rSet.getString("pedu"));
				workInfo.setPloc(rSet.getObject("ploc")==null?"":rSet.getString("ploc"));
				workInfo.setPst(rSet.getDate("pst"));
				workInfo.setPend(rSet.getDate("pend"));
				workInfo.setPpos(pmap.get(rSet.getInt("ppos")));
				workInfo.setPdept(dmap.get(rSet.getInt("pdept")));
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
	 * 寻找一条实习生记录
	 * @param a 实习生编号
	 * @return
	 */
	public Probation findProbation(String a){
		Map<Integer, String> pmap=new WorkerDao().positionConvert();
		Map<Integer, String> dmap=new WorkerDao().deptConvert();
		String sql=" select pid,pnm,psex,page,pna,piid,ptel,pedu,ploc,pst,pend,ppos,pdept from probationinfo where pid=? ; ";
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet rSet=null;
		Probation sal=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			rSet=statement.executeQuery();
			while(rSet.next()){
				sal=new Probation();
				sal.setPid(rSet.getObject("pid")==null?"":rSet.getString("pid"));
				sal.setPnm(rSet.getObject("pnm")==null?"":rSet.getString("pnm"));
				sal.setPsex(rSet.getObject("psex")==null?"":rSet.getString("psex"));
				sal.setPage(rSet.getInt("page"));
				sal.setPna(rSet.getObject("pna")==null?"":rSet.getString("pna"));
				sal.setPiid(rSet.getObject("piid")==null?"":rSet.getString("piid"));
				sal.setPtel(rSet.getObject("ptel")==null?"":rSet.getString("ptel"));
				sal.setPedu(rSet.getObject("pedu")==null?"":rSet.getString("pedu"));
				sal.setPloc(rSet.getObject("ploc")==null?"":rSet.getString("ploc"));
				sal.setPst(rSet.getDate("pst"));
				sal.setPend(rSet.getDate("pend"));
				sal.setPpos(pmap.get(rSet.getInt("ppos")));
				sal.setPdept(dmap.get(rSet.getInt("pdept")));
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
		return sal;
	}
	
	
	/**
	 * 删除一个实习生
	 * @param a 实习生记录
	 */
	public void delProbation(String a){
		String sql=" update probationinfo set pend=CURDATE() where pid=? ; ";
		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=getConnection();
			statement=connection.prepareStatement(sql);
			statement.setObject(1,a);
			int i=statement.executeUpdate();
			System.out.println(i);
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
		
	}

	
	
	/**
	 * 删除一条申请记录
	 * @param a 申请编号 
	 */
public void del(int a){
	String sql=" update apply set adel=1 where rid=? ; ";
	Connection connection=null;
	PreparedStatement statement=null;
	try{
		connection=getConnection();
		statement=connection.prepareStatement(sql);
		statement.setObject(1,a);
		int i=statement.executeUpdate();
		System.out.println(i);
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
	
}

public void delById(String a){
	String sql=" update apply set adel=1 where aid=? ; ";
	Connection connection=null;
	PreparedStatement statement=null;
	try{
		connection=getConnection();
		statement=connection.prepareStatement(sql);
		statement.setObject(1,a);
		int i=statement.executeUpdate();
		System.out.println(i);
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
	
}

public int getStartWage() {
	return startWage;
}

public void setStartWage(int startWage) {
	this.startWage = startWage;
}
}

