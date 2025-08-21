package jdbc_dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		// Step 1: load / register the database driver

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// Step 2: connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("===Done===");

		// Step 3: create Sql statement
		Statement stat = conn.createStatement();

		// Step 4: execute select query & get result
		int result = stat.executeUpdate("insert into project values'Ty_0102', 'aichhika', '07/03/2025', 'FB_0102', 'On Going', '100');");
		System.out.println(result);

		// Step 5: close the connection
		conn.close();
	}
}
