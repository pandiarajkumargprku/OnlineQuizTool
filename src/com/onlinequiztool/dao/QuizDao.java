package com.onlinequiztool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.onlinequiztool.controller.QuizController;

public class QuizDao extends DataBaseConnection {
	public void adminSignUpValidation(final String name, final String email, final String password) {
		
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
	
	public void userSignUpValidation(final String name, final String email, final String password) {
		
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
				QuizController.adminCrudOperations();
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
	
	public void firstRoundInserted(final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
	    final String sqlQuery = "insert into first_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public void secondRoundInserted(final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
	    final String sqlQuery = "insert into second_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public void thirdRoundInserted(final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
	    final String sqlQuery = "insert into third_round_table values(?,?,?,?,?,?,?)";
	    QuizDao.prepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public static void prepareStatement(final String sqlQuery, final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
		try (final Connection connection = getConnection();
			final PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			
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
	
    public void firstRoundUpdated(final int questionNumber, final String questions, final String firstOption, final String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		final String sqlQuery = "Update first_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
    public void secondRoundUpdated(final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
		final String sqlQuery = "Update second_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
    
    public void thirdRoundUpdated(final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
		final String sqlQuery = "Update third_round_table SET questions = ?, firstOption = ?, secondOption = ?, thirdOption = ?, fourthOption = ?, correctAnswer = ? WHERE questionNumber = ?";
		QuizDao.updatePrepareStatement(sqlQuery, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
    
	public static void updatePrepareStatement(String sqlQuery, final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer) {
		try (final Connection connection = getConnection();
		    final PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
		    
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
	
	public void firstRoundDeleted(final int questionNumber) {
		final String sqlQuery = "Delete from first_round_table where questionNumber = ?";
		QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
	
    public void secondRoundDeleted(final int questionNumber) {
    	final String sqlQuery = "Delete from second_round_table where questionNumber = ?";
		QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
    
    public void thirdRoundDeleted(final int questionNumber) {
    	final String sqlQuery = "Delete from third_round_table where questionNumber = ?";
		QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
    
    private static void deletePrepareStatement(final String sqlQuery, int questionNumber) {
		
    	try (final Connection connection = getConnection();
			final PreparedStatement prePareStatement = connection.prepareStatement(sqlQuery);) {
    		
    		prePareStatement.setInt(1, questionNumber);
    		
    		prePareStatement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
