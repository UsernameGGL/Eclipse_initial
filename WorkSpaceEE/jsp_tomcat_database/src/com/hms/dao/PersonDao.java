package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hms.servlet.Person;

public class PersonDao extends BaseDao{
	public int addPerson(Person p){
		int i=-1;
		String sql = "INSERT INTO `test`.`person` ( `pnm`,  `pwd`,  `bdate`,  `rid`,  `mgid`,"
				+ "  `icon`) VALUES  (   ?,    ?,    ?,    ?,    ?,    ?  ) ;";
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, p.getPnm());
			preparedStatement.setObject(2, p.getPwd());
			preparedStatement.setObject(3, p.getBdate());
			preparedStatement.setObject(4, p.getRid());
			preparedStatement.setObject(5, p.getMgid());
			preparedStatement.setObject(6, p.getIcon());
			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出错！"+e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
}
