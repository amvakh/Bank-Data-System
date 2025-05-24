// BankDatabase.java
// Refactored version — variables, method names, and class structure updated for clarity
// Original logic preserved

// BankDatabase.java
// Refactored version - retains original logic with updated structure and naming

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

class Database {
	public static Connection connection;
	
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/bank_program?serverTimezone=EST", "root", "database28");
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}