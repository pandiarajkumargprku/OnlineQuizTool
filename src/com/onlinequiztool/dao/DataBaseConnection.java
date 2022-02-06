package com.onlinequiztool.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <h1>DataBaseConnection</h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class DataBaseConnection {
	
	/**
	 * create a connection
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
	    try {
	 	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "@Rajkumar2805");
	 		
	 	} catch (Exception exception) {
	 	    System.out.println(exception);
	 	}   
	    return connection;
	 }
}
