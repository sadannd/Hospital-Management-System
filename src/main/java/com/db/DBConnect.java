package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	public static Connection conn;

	public static Connection getConn() {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
			 conn=DriverManager.getConnection(  
					 "jdbc:oracle:thin:@localhost:1522:prod","hospital","qwerty");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}