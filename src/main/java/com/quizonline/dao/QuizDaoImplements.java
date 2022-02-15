package com.quizonline.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quizonline.model.Quiz;
import com.quizonline.model.User;
import com.quizonline.customexception.CustomException.ConnectionException;

/**
 * <h1> QuizDao </h1>
 * 
 * @author PandiarajkumarG
 */
public class QuizDaoImplements {
	
	/**
	 * Check signUp in admin table
	 * 
	 * @param email
	 */
	public boolean checkAdminEmail(final String email) {
		final String sqlQuery = "select email from admin_table where email = ?";
		
		return checkMailCredentials(email, sqlQuery);
	}
	
	/**
	 * Check signIn in user table
	 * 
	 * @param email
	 */
	public boolean checkUserEmail(final String email) {
		final String sqlQuery = "select email from user_table where email = ?";
		
		return checkMailCredentials(email, sqlQuery);
	}
	
	/**
	 * Check email and password
	 * 
	 * @param email
	 * @param sqlQuery
	 */
	private boolean checkMailCredentials(String email, String sqlQuery) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			prepareStatement.setString(1, email);
				 
		    try (ResultSet resultSet = prepareStatement.executeQuery();) {
				 
			    while (resultSet.next()) {
		            return true;
			    }
	        }
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
		return false;
	}

    /**
	 * Check admin password
	 * 
	 * @param password
	 */
	public boolean checkAdminPassword(final String password) {
		final String sqlQuery = "select email from admin_table where password = ?";
		
		return checkPasswordCredentials(password, sqlQuery);
	}
	
	/**
	 * Check user password
	 * 
	 * @param password
	 */
	public boolean checkUserPassword(final String password) {
		final String sqlQuery = "select email from user_table where password = ?";
	
		return checkPasswordCredentials(password, sqlQuery);
	}
	
	/***
	 * Check password credentials
	 * 
	 * @param password
	 * @param sqlQuery
	 */
	private boolean checkPasswordCredentials(String password, String sqlQuery) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			prepareStatement.setString(1, password);
			 
			try (ResultSet resultSet = prepareStatement.executeQuery();) {
			 
			    while (resultSet.next()) {
			        return true;
			    }
            }
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
		return false;
	}
	
    /**
	 * Insert admin details in admin table
	 * 
	 * @param user
	 */
	public boolean insertAdminSignUpDetail(final User user) {
		final String sqlQuery = "Insert Into admin_table(name, email, password) values (?, ?, ?)";
		
		return insertSignUpDetails(sqlQuery, user);
	}
	
	/**
	 * Insert user details into user table
	 * 
	 * @param user
	 */
	public boolean insertUserSignUpDetail(final User user) {
		final String sqlQuery = "Insert Into user_table(name, email, password) values (?, ?, ?)";
		
		return insertSignUpDetails(sqlQuery, user);
	}
	
	/**
	 * Insert signup details in to database
	 * 
	 * @param sqlQuery
	 * @param user
	 */
	private boolean insertSignUpDetails(String sqlQuery, User user) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
				
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());
			
			prepareStatement.executeUpdate();
			return true;
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
	}

	/**
	 * Insert firstRound into firstRoundTable
	 * 
	 * @param quizTools
	 */
	public boolean insertFirstRoundDetails(final Quiz quizTools) {
	    final String sqlQuery = "Insert Into first_round_table values (?, ?, ?, ?, ?, ?, ?)";
	    
	    return QuizDaoImplements.prepareStatementForInsertTable(sqlQuery, quizTools);
	}
	
	/**
	 * Insert secondRound into secondRoundTable
	 * 
	 * @param quizTools
	 */
	public boolean insertSecondRoundDetails(final Quiz quizTools) {
	    final String sqlQuery = "Insert Into second_round_table values(?, ?, ?, ?, ?, ?, ?)";
	    
	    return QuizDaoImplements.prepareStatementForInsertTable(sqlQuery, quizTools);
	}
	
	/**
	 * Insert thirdRound into thirdRoundTable
	 * 
	 * @param quizTools
	 */
    public boolean insertThirdRoundDetails(final Quiz quizTools) {
	    final String sqlQuery = "Insert Into third_round_table values(?, ?, ?, ?, ?, ?, ?)";
	    
	    return QuizDaoImplements.prepareStatementForInsertTable(sqlQuery, quizTools);
	}
	
    /**
     * Execute query using prepareStatement
     * 
     * @param Sqlquery
     * @param quizTools
     */
	private static boolean prepareStatementForInsertTable(final String sqlQuery, final Quiz quizTools) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			
			prepareStatement.setInt(1, quizTools.getQuestionNumber());
			prepareStatement.setString(2, quizTools.getQuestions());
			prepareStatement.setString(3, quizTools.getFirstOption());
			prepareStatement.setString(4, quizTools.getSecondOption());
			prepareStatement.setString(5, quizTools.getThirdOption());
			prepareStatement.setString(6, quizTools.getFourthOption());
			prepareStatement.setString(7, quizTools.getCorrectAnswer());
			
			prepareStatement.executeUpdate();
			
			return true;
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
	}
	
	/**
	 * Check first round question number
	 * 
	 * @param questionNumber
	 */
	public boolean checkFirstRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from first_round_table where question_number = ?";
        
		return checkQuestionNumber(questionNumber, sqlQuery);
	}
	
	/**
	 * Check second round question number
	 * 
	 * @param questionNumber
	 */
	public boolean checkSecondRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from second_round_table where question_number = ?";
		
		return checkQuestionNumber(questionNumber, sqlQuery);
	}
	
	/**
	 * Check third round question number
	 * 
	 * @param questionNumber
	 */
	public  boolean checkThirdRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from third_round_table where question_number = ?";
		
		return checkQuestionNumber(questionNumber, sqlQuery);
	}

	/**
	 * Check question number from database
	 * 
	 * @param questionNumber
	 * @param sqlQuery
	 */
	private boolean checkQuestionNumber(int questionNumber, String sqlQuery) {
		
		try (Connection connection = DataBaseConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
		    prepareStatement.setInt(1, questionNumber);
				 
		    try (ResultSet resultSet = prepareStatement.executeQuery();) {
				 
			    while (resultSet.next()) {
			        return true;
			    }
	        }
		} catch(SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
		return false;
	}
	
	/**
	 * Update firstRound into firstRoundTable
	 * 
	 * @param quizTools
	 */
    public boolean firstRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update first_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		return QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
	}
	
    /**
     * Update secondRound into secondRoundTable
     * 
     * @param quizTools
     */
    public boolean secondRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update second_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		return QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
	}
    
    /**
     * Update thirdRound into thirdRoundTable
     * 
     * @parma quizTools
     */
    public boolean thirdRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update third_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		return QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
	}
    
    /**
     * Execute query using prepareStatament
     * 
     * @param sqlQuery
     * @parma quizTools
     */
	public static boolean prepareStatementForUpdateTable(final String sqlQuery, final Quiz quizTools) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
		    
			prepareStatement.setString(1, quizTools.getQuestions());
			prepareStatement.setString(2, quizTools.getFirstOption());
			prepareStatement.setString(3, quizTools.getSecondOption());
			prepareStatement.setString(4, quizTools.getThirdOption());
			prepareStatement.setString(5, quizTools.getFourthOption());
			prepareStatement.setString(6, quizTools.getCorrectAnswer());
			prepareStatement.setInt(7, quizTools.getQuestionNumber());
			
			prepareStatement.executeUpdate();
			return true;
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
	}
	
	/**
	 * Delete firstRound from firstRoundTable
	 * 
	 * @param questionNumber
	 */
	public boolean firstRoundDelete(final int questionNumber) {
		final String sqlQuery = "Delete from first_round_table where question_number = ?";
		
		return QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
	}
	
	/**
	 * Delete secondRound from secondRoundTable
	 * 
	 * @param questionNumber
	 */
    public boolean secondRoundDelete(final int questionNumber) {
    	final String sqlQuery = "Delete from second_round_table where question_number = ?";
		
    	return QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    }
    
    /**
     * Delete thirdRound from thirdRoundTable
     * 
     * @param questionNumber
     */
    public boolean thirdRoundDelete(final int questionNumber) {
    	final String sqlQuery = "Delete from third_round_table where question_number = ?";
		
    	return QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    }
    
    /**
     * Execute query using PrepareStatament
     * 
     * @param sqlQuery
     * @param qurstionNumber
     */
    private static boolean prepareStatementForDeleteTable(final String sqlQuery, final int questionNumber) {
		
    	try (Connection connection = DataBaseConnection.getConnection();
			PreparedStatement prePareStatement = connection.prepareStatement(sqlQuery);) {
    		
    		prePareStatement.setInt(1, questionNumber);
    		prePareStatement.executeUpdate();
    		
    		return true;
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
	}
    
    /**
     * Get firstRoundDetails 
     */
    public List<Quiz> getFirstRoundDetails() {
    	
    	try (Connection connection = DataBaseConnection.getConnection();
    		Statement statement = connection.createStatement();) {
    		String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from first_round_table";
    		List<Quiz> firstRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
    		
    		return firstRoundDetails;
    	} catch (SQLException exception) {
    		throw new ConnectionException("Connection Failed");
    	}
    }

    /**
     * Get secondRoundDetails
     */
    public List<Quiz> getSecondRoundDetails() {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	Statement statement = connection.createStatement();) {
        	String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from second_round_table";
       		List<Quiz> secondRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
        		
       		return secondRoundDetails;
       	} catch (SQLException exception) {
       		throw new ConnectionException("Connection Failed");
        }
	}
    
    /**
     * Get thirdRoundDetails
     */
    public List<Quiz> getThirdRoundDetails() {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	Statement statement = connection.createStatement();) {
       		String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from third_round_table";
       		List<Quiz> thirdRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
        		
       		return thirdRoundDetails;
       	} catch (SQLException exception) {
       		throw new ConnectionException("Connection Failed");	
        }
	}

    /**
     * Get questions,options and correctAnswer from dataBase
     * 
     * @param sqlQuery
     */
	public static List<Quiz> getDetails(final String sqlQuery) {
		
		try (Connection connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery);) {		
			List<Quiz> questionDetails = new ArrayList<Quiz>();
			
			while (resultSet.next()) {
				final Quiz questionAnswer = new Quiz();
				
				questionAnswer.setQuestionNumber(resultSet.getInt(1));
				questionAnswer.setQuestions(resultSet.getString(2));
				questionAnswer.setFirstOption(resultSet.getString(3));
				questionAnswer.setSecondOption(resultSet.getString(4));
				questionAnswer.setThirdOption(resultSet.getString(5));
				questionAnswer.setFourthOption(resultSet.getString(6));
				questionAnswer.setCorrectAnswer(resultSet.getString(7));
				
				questionDetails.add(questionAnswer);
			}
			return questionDetails;
		} catch (SQLException exception) {
			throw new ConnectionException("Connection Failed");
		}
	}

	/**
	 * Mark insert into dataBase
	 * 
	 * @param score
	 * @param email
	 */
	public boolean markInsert(final int score, final String email) {
		final String sqlQuery = "Update user_table SET score = ? where email = ?";
		
        try (Connection connection = DataBaseConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
            prepareStatement.setInt(1, score);
            prepareStatement.setString(2, email);
            
            prepareStatement.executeUpdate();
            return true;
        } catch (SQLException exception) {
        	throw new ConnectionException("Connection Failed");
        }
	}
}
