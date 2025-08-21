package adv_Selenium_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateInsertPrintModifyDataBaseTableUsingJDBC {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql:49.249.28.218:3333/ninza_hrm";
        String dbName = "FaceBook_0102";
        String user = "root";
        String password = "root"; 
        
        try {
        
		//Step 1: load / register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("===Done===");
		
		//Step 3: create Sql statement & Create DataBase
		Statement stat = conn.createStatement();
		
		//Step 4: execute select query & get result
		 stat.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        System.out.println("Database created.");
		
        // 3. Create Table
        String createTable = "CREATE TABLE IF NOT EXISTS Employees (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(100)," +
                "role VARCHAR(50)," +
                "salary DOUBLE)";
        stat.executeUpdate(createTable);
        System.out.println("Table created.");
        // 4. Insert Records
        stat.executeUpdate("INSERT INTO Employees (name, role, salary) VALUES " +
                "('Alice', 'QA Engineer', 50000)," +
                "('Bob', 'Developer', 60000)," +
                "('Charlie', 'Manager', 80000)");
        System.out.println("Records inserted.");

        // 5. Print Records
        System.out.println("\nOriginal Records:");
        ResultSet rs = stat.executeQuery("SELECT * FROM Employees");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " +
                    rs.getString("role") + " | " + rs.getDouble("salary"));
        }

        // 6. Modify a Record (e.g., Update Bob's salary)
        stat.executeUpdate("UPDATE Employees SET salary = 65000 WHERE name = 'Bob'");
        System.out.println("\nRecord Updated.");

        // 7. Print Modified Record
        System.out.println("\nModified Record (Bob):");
        rs = stat.executeQuery("SELECT * FROM Employees WHERE name = 'Bob'");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " +
                    rs.getString("role") + " | " + rs.getDouble("salary"));
        }

        // Close connections
        rs.close();
        stat.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
//				 				 
//		 //Step 5: close the connection
//		 conn.close();
//		 
        }
	}
}

