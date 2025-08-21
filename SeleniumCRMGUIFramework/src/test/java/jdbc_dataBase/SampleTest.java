package jdbc_dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws SQLException {
		
		//Step 1: load / register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("===Done===");
		
		//Step 3: create Sql statement
		Statement stat = conn.createStatement();
		
		//Step 4: execute select query & get result
		 ResultSet resultset = stat.executeQuery("select * from project");
		 //resultset.next();
		 while(resultset.next())
		 {
			 System.out.println(resultset.getString(1));
		 }
		 
		 //Step 5: close the connection
		 conn.close();
		
	}

}
