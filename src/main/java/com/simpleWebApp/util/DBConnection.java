package com.simpleWebApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static Logger logger = Logger.getLogger(DBConnection.class.getName());
	public static volatile Connection conn;
	
	private DBConnection() {
		
	}
	
	public static synchronized Connection getInstance() {
		if(conn == null) {
			try{					
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "test", "test");	
				logger.log(Level.INFO, "DB Connection established!!!");
			}catch(Exception e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}	
		return conn;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(conn != null) {
			logger.log(Level.INFO, "DB Connection being closed!!!");
			conn.close();
		}
	}
	
}
