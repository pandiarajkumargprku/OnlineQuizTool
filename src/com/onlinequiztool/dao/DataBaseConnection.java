package com.onlinequiztool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	public static final Connection getConnection() throws SQLException {
	    Connection connection = null;
	    
	 	try {
	 	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "@Rajkumar2805");
	 	} catch (SQLException exception) {
	 	   System.out.println(exception);
	 	}   
	 	return connection;
    }
}
