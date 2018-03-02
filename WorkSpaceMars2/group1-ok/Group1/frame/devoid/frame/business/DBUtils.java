package devoid.frame.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.*;
import javax.sql.DataSource;

public class DBUtils {	
	private static DBUtils dBUtils;
	
	private DataSource dataSource;
	
	private DBUtils() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/user");
		} catch (NamingException e) {
			throw new ServiceException("Error on using naming service", e);
		}
	}
	
	public static Connection getConnection() {
		if (dBUtils == null) {
			dBUtils = new DBUtils();
		}
		try {
			Connection conn = dBUtils.dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			throw new ServiceException("Can not get connection",e);
		}
	}
	
	public static void beginTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new ServiceException("Can not begin transaction", e);
		}
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new ServiceException("Can not commit transaction", e);
		} 
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new ServiceException("Can not rollback transaction", e);
		} 
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DaoException("Can not close statement", e);
		}
	}
}
