package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/hw_database" + "?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "carina";
	
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		ConnectionFactory connFact = new ConnectionFactory();
		try {
			
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection conn) {
		
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
