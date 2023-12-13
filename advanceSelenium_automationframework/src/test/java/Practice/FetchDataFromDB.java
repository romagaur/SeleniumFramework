package Practice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class FetchDataFromDB {

	public static void main(String[] args) throws Throwable {
		
		 Driver driverRef = new Driver();
		 
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
		Statement state=conn.createStatement();
		
		String query="select * from qspiders";
		
		ResultSet result= state.executeQuery(query);
		
		while (result.next())
		{
			System.out.println(result.getString(1)+"/t"+result.getString(2)+"/t"+result.getString(3)+"/t"+result.getString(4));
					
		}
		
		conn.close();
		
	}
	
}
