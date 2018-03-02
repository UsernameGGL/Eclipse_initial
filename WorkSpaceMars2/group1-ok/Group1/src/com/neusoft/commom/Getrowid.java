package com.neusoft.commom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import devoid.frame.business.DBUtils;

public class Getrowid {
	public static int getRowid(){
		int rowid=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		try{
			conn = DBUtils.getConnection();
			DBUtils.beginTransaction(conn);			
			stmt = conn.createStatement();
			set = stmt.executeQuery("select deptid.nextval from dual");
			while(set.next()){
				rowid = Integer.parseInt(set.getString("nextval"));
			}
			DBUtils.commit(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowid;

}
}
