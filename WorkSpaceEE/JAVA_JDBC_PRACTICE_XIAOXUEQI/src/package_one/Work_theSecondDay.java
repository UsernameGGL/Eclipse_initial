package package_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Work_theSecondDay {
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "root";
	static{
		try {
			Class.forName("java.sql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("导入失败："+e.getMessage());
		}
	}
	@Test
	public void addWorker(int wno,String wname,int deptno){
		String sql="INSERT INTO WORKER VALUES( ? , ? , ? );";
		try {
			//1建立到数据库的链接
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2建立传输SQL语句的Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3设置statement具体值
			statement.setInt(1, wno);
			statement.setString(2, wname);
			statement.setInt(3, deptno);
			//4执行SQL，返回影响记录的行数
			int i=statement.executeUpdate();
			System.out.println("插入成功"+i+"行受影响");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("从连接到执行的某一处失败！"+e.getMessage());
		}
		
	}
	//根据送入的wno值删除Worker表中的记录，只能根据wno来删除
	public void deleteWorker(int wno) throws SQLException  {
	        Connection connection=null;  
	        PreparedStatement st=null;
	        String sql=new String("DELETE FROM WORKER WHERE WNO=?;");
	        try {  
	            //1.建立连接  
	            connection=DriverManager.getConnection(URL, username, password);  
	            //2.创建语句  
	            st=connection.prepareStatement(sql);
	            //将?设置成确定值
	            st.setInt(1, wno);
	            //3.执行语句  
	            int i=st.executeUpdate();
	            System.out.println("删除成功！"+i+"行受影响");  
	            st.close();
	            connection.close();
	        }catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("删除失败！"+e.getMessage());
			}
	}
	public void updateWorker(int wno,String newData){
		String sql=new String("UPDATE WORKER SET WNAME = ? WHERE WNO= ? ;");
		try {
			//1建立到数据库的链接
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2建立传输SQL语句的Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3设置statement具体值
			statement.setObject(1, newData);
			statement.setInt(2, wno);
			//4执行SQL，返回影响记录的行数
			int i=statement.executeUpdate();
			System.out.println("修改成功"+i+"行受影响");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("修改失败！"+e.getMessage());
		}
	}
	@Test
	public void selectWorker(int condition){
		String sql=new String("SELECT WNO, WNAME, DEPTNO FROM WORKER WHERE WNO > ? ;");
		try {
			//1建立到数据库的链接
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2建立传输SQL语句的Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3设置statement具体值
			statement.setInt(1, condition);
			//4执行SQL，将结果送入结果集（搬运工）
			ResultSet resultset=statement.executeQuery();
			//5输出结果
			while(resultset.next()){
				System.out.println(resultset.getInt("WNO"));
				System.out.println(resultset.getString("WNAME"));
				System.out.println(resultset.getInt("DEPTNO"));
			}
			System.out.println("查询成功！");
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败！"+e.getMessage());
		}
	}
}
