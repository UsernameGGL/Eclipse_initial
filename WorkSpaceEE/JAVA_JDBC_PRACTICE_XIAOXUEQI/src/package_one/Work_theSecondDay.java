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
			System.err.println("����ʧ�ܣ�"+e.getMessage());
		}
	}
	@Test
	public void addWorker(int wno,String wname,int deptno){
		String sql="INSERT INTO WORKER VALUES( ? , ? , ? );";
		try {
			//1���������ݿ������
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2��������SQL����Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3����statement����ֵ
			statement.setInt(1, wno);
			statement.setString(2, wname);
			statement.setInt(3, deptno);
			//4ִ��SQL������Ӱ���¼������
			int i=statement.executeUpdate();
			System.out.println("����ɹ�"+i+"����Ӱ��");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�����ӵ�ִ�е�ĳһ��ʧ�ܣ�"+e.getMessage());
		}
		
	}
	//���������wnoֵɾ��Worker���еļ�¼��ֻ�ܸ���wno��ɾ��
	public void deleteWorker(int wno) throws SQLException  {
	        Connection connection=null;  
	        PreparedStatement st=null;
	        String sql=new String("DELETE FROM WORKER WHERE WNO=?;");
	        try {  
	            //1.��������  
	            connection=DriverManager.getConnection(URL, username, password);  
	            //2.�������  
	            st=connection.prepareStatement(sql);
	            //��?���ó�ȷ��ֵ
	            st.setInt(1, wno);
	            //3.ִ�����  
	            int i=st.executeUpdate();
	            System.out.println("ɾ���ɹ���"+i+"����Ӱ��");  
	            st.close();
	            connection.close();
	        }catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ɾ��ʧ�ܣ�"+e.getMessage());
			}
	}
	public void updateWorker(int wno,String newData){
		String sql=new String("UPDATE WORKER SET WNAME = ? WHERE WNO= ? ;");
		try {
			//1���������ݿ������
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2��������SQL����Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3����statement����ֵ
			statement.setObject(1, newData);
			statement.setInt(2, wno);
			//4ִ��SQL������Ӱ���¼������
			int i=statement.executeUpdate();
			System.out.println("�޸ĳɹ�"+i+"����Ӱ��");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�޸�ʧ�ܣ�"+e.getMessage());
		}
	}
	@Test
	public void selectWorker(int condition){
		String sql=new String("SELECT WNO, WNAME, DEPTNO FROM WORKER WHERE WNO > ? ;");
		try {
			//1���������ݿ������
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2��������SQL����Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			//3����statement����ֵ
			statement.setInt(1, condition);
			//4ִ��SQL��������������������˹���
			ResultSet resultset=statement.executeQuery();
			//5������
			while(resultset.next()){
				System.out.println(resultset.getInt("WNO"));
				System.out.println(resultset.getString("WNAME"));
				System.out.println(resultset.getInt("DEPTNO"));
			}
			System.out.println("��ѯ�ɹ���");
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯʧ�ܣ�"+e.getMessage());
		}
	}
}
