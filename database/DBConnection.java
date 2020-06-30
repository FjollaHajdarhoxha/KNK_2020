package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection dbConnection;
	
	private final static String host = System.getenv("DB_HOST"); //emri i hostit ne pc,localhost
	private final static String dbName = System.getenv("DB_NAME");
	private final static String username = System.getenv("DB_USERNAME");
	private final static String password = System.getenv("DB_PASSWORD");
	
	public static Connection getConnection() {
		if(dbConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = 
						DriverManager.getConnection("jdbc:mysql://" + host+ "/" + dbName, username, password);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return dbConnection;
	}

}
