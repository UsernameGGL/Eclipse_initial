package com.neusoft.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.code.domain.Code;



import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;


public class CodeDaoImpl implements CodeDao {
    private Connection conn;
	public CodeDaoImpl(){
		
	}
	public CodeDaoImpl(Connection conn){
		this.conn = conn;
	}
	public List<Code> getCode(int type_id){
		String sql = "select id,code_value from code where type_id=?";
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Code> codeList = new ArrayList<Code>();
	    try {
		     pstmt = conn.prepareStatement(sql);
		     pstmt.setInt(1, type_id);
		     rs = pstmt.executeQuery();  
				while(rs.next()){
					Code code = new Code();
					code.setId(rs.getInt("id"));
					code.setCode_value(rs.getString("code_value"));
					codeList.add(code);
				}
				return codeList;
	     } catch (SQLException e) {
		     throw new DaoException("Error on adding Domi", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
	}
	
}

