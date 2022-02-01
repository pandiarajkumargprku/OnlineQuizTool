package com.onlinequiztool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlinequiztool.controller.QuizController;

public class QuizDao {
	public static final Connection getConnection() throws SQLException {
	    Connection connection = null;
	    
	 	try {
	 	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "@Rajkumar2805");
	 	} catch (SQLException exception) {
	 	   System.out.println(exception);
	 	}   
	 	return connection;
    }
	
	public void adminSignUpInserted(final String name, final String email, final String password) {
		
		try (Connection connection = getConnection();
			final Statement statement = connection.createStatement();) {
			boolean isSignUp = true;
		    final ResultSet resultSet = statement.executeQuery("select email from  admin_table where email = '" + email + "'");
		     
		    while (resultSet.next()) {
			    System.out.println("This mail id is already exists");
			    isSignUp = false;
			}
		     
		    if (isSignUp) {
			    statement.executeUpdate("insert into admin_table(name, email, password) values('" + name + "','" + email + "','"+ password + "') ");		          
			    System.out.println("Succesfully SignUp");
			} 
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public void userSignUpInserted(final String name, final String email, final String password) {
		
		try (final Connection connection = getConnection();
			final Statement statement = connection.createStatement();) {
			boolean isSignUp = true;
		    final ResultSet resultSet = statement.executeQuery("select email from  admin_table where email = '" + email + "'");
		     
		    while (resultSet.next()) {
			    System.out.println("This mail id is already exists");
			    isSignUp = false;
			}
		     
		    if (isSignUp) {
			    statement.executeUpdate("insert into user_table(name, email, password) values('" + name + "','" + email + "','"+ password + "') ");		          
			    System.out.println("Succesfully SignUp");
			} 
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public void adminSignInInserted(final String email, final String password) {
		
		try (final Connection connection = getConnection();
			final Statement statement = connection.createStatement();) {
			boolean isSignIn = true;
			final ResultSet resultSet = statement.executeQuery("Select * from admin_table where email= '" + email + "' AND password='" + password + "'");
			
			while (resultSet.next()) {
				System.out.println("SignIn succesfully");
				isSignIn = false;
				QuizController.adminSignInSuccess();
			}
			
			if (isSignIn) {
				System.out.println("signin failed");
			}
			
		} catch (Exception exception) {
	        System.out.println(exception);
		}
	}
	
	public void userSignInInserted(final String email, final String password) {
		try (final Connection connection = getConnection();
			final Statement statement = connection.createStatement();) {
		    boolean isSignIn = true;
			final ResultSet resultSet = statement.executeQuery("Select * from user_table where email= '" + email + "' AND password='" + password + "'");
			
			while (resultSet.next()) {
				System.out.println("SignIn succesfully");
				isSignIn = false;
				
			}
			
			if (isSignIn) {
				System.out.println("signin failed");
			}
			
		} catch (Exception exception) {
	        System.out.println(exception);
		}
	}
	
	public void firstRoundInserted(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
	    String sqlQuery = "insert into first_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public void secondRoundInserted(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
	    String sqlQuery = "insert into second_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public void thirdRoundInserted(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
	    String sqlQuery = "insert into third_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public void firstRoundUpdated(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		String sqlQuery = "Update first_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
    public void secondRoundUpdated(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		String sqlQuery = "Update second_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
    
    public void thirdRoundUpdated(int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		String sqlQuery = "Update third_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
    public static void prepareStatement(String sqlQuery, int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		try (final Connection connection = getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			
			prepareStatement.setInt(1, questionNumber);
			prepareStatement.setString(2, questions);
			prepareStatement.setString(3, firstOption);
			prepareStatement.setString(4, secondOption);
			prepareStatement.setString(5, thirdOption);
			prepareStatement.setString(6, fourthOption);
			prepareStatement.setString(7, correctAnswer);
			
			prepareStatement.executeUpdate();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	public static void updatePrepareStatement(String sqlQuery, int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		try (final Connection connection = getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
		    
			prepareStatement.setString(1, questions);
			prepareStatement.setString(2, firstOption);
			prepareStatement.setString(3, secondOption);
			prepareStatement.setString(4, thirdOption);
			prepareStatement.setString(5, fourthOption);
			prepareStatement.setString(6, correctAnswer);
			prepareStatement.setInt(7, questionNumber);
			
			prepareStatement.executeUpdate();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
