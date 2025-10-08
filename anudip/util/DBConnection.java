package org.anudip.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/movie_booking_db?useSSL=false&serverTimezone=UTC";
	private static final String USER="root";
	private static final String PASS="Nandhini@260405";
	static {
		try {
			//optional for newer drivers,Class.forName("com.sql.cj.jdbc.Driver");
			Class.forName("com.sql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.print("MySQLJDBC Driver not found. Add Connector/J to classpath.");
		}
	}
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(URL,USER,PASS);
	}

}
