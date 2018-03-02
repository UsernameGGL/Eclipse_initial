package package_one;

import java.sql.SQLException;

public class Main_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Work_theSecondDay JDBC_CLASS=new Work_theSecondDay();
		JDBC_CLASS.addWorker(21, "NAME_21", 21);
		/*JDBC_CLASS.addWorker(22, "NAME_22", 22);
		try {
			JDBC_CLASS.deleteWorker(21);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBC_CLASS.updateWorker(22, "NAME_HASUPDATED");
		JDBC_CLASS.selectWorker(1);*/
	}

}
