package com.simpleWebApp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static volatile Connection conn;
	
	private DBConnection() {
		
	}
	
	public static synchronized Connection getInstance() {
		if(conn == null) {
			try{					
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "test", "test");				
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}	
		return conn;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(conn != null) {
			conn.close();
		}
	}
	
}
