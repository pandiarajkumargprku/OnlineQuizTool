package com.quizonline.dao;

import java.sql.Connection;
import com.quizonline.customexception.CustomException.ConnectionException;
import java.sql.DriverManager;

/**
 *DataBaseConnection
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
	 	   throw new ConnectionException("Connection failed");
	 	}   
	    return connection;
	 }
}
