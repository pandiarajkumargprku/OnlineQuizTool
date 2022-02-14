package com.quizonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quizonline.model.Quiz;
import com.quizonline.model.User;
import com.quizonline.customexception.CustomException.MailIdNotFoundException;
import com.quizonline.customexception.CustomException.AccessFailedException;
import com.quizonline.customexception.CustomException.PasswordNotFoundException;
import com.quizonline.customexception.CustomException.ConnectionException;


/**
 * <h1>QuizDao</h1>
 * 
 * @author PandiarajkumarG
 */
public class QuizDaoImplements {
	
	/**
	 * check SignUp in Admin table
	 */
	public  boolean checkAdminEmail(final String email) {
		final String sqlQuery = "select email from admin_table where BINARY email = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			    prepareStatement.setString(1, email);
			 
			 try (ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while (resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new MailIdNotFoundException("Admin Mail Id Not Found");
		}
		return false;
	}
	
	/**
	 * check signIn in admin table
	 */
	public boolean checkUserEmail(final String email) {
		final String sqlQuery = "select email from user_table where BINARY email = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			 prepareStatement.setString(1, email);
			 
			 try (ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while (resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new MailIdNotFoundException("User Mail Id Not Found");
		}
		return false;
	}
	
	/**
	 * Check Admin Password
	 */
	public boolean checkAdminPassword(final String password) {
		final String sqlQuery = "select email from admin_table where BINARY password = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			 prepareStatement.setString(1, password);
			 
			 try(ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while(resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new PasswordNotFoundException("Admin Password not found");
		}
		return false;
	}
	
	/**
	 * check User Password
	 */
	public boolean checkUserPassword(final String password) {
		final String sqlQuery = "select email from user_table where BINARY password = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			 prepareStatement.setString(1, password);
			 
			 try(ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while(resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new MailIdNotFoundException("User Password Not Found");
		}
		return false;
	}
	
    /**
	 * insert Admin details in admin Table
	 */
	public boolean adminSignUpInsert(final User user) {
		final String sqlQuery = "Insert Into admin_table(name, email, password) values(?, ?, ?)";
		
		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());
			
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception exception) {
			
		}
		return false;
	}
	
	/**
	 * insert user details into user table
	 */
	public boolean userSignUpInsert(final User user) {
		final String sqlQuery = "Insert Into user_table(name, email, password) values(?, ?, ?)";
		
		try (Connection connection = DataBaseConnection.getConnection();
		        PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			
			 prepareStatement.setString(1, user.getName());
			 prepareStatement.setString(2, user.getEmail());
			 prepareStatement.setString(3, user.getPassword());
		   
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}

	/**
	 * Insert firstRound into firstRoundTable
	 */
	public boolean firstRoundInsert(final Quiz quizTools) {
	    final String sqlQuery = "insert into first_round_table values(?, ?, ?, ?, ?, ?, ?)";
	   
	    boolean isInserted = QuizDaoImplements. prepareStatementForInsertTable(sqlQuery, quizTools);
	    return isInserted;
	}
	
	/**
	 * Insert secondRound into secondRoundTable
	 */
	public boolean secondRoundInsert(final Quiz quizTools) {
	    final String sqlQuery = "insert into second_round_table values(?, ?, ?, ?, ?, ?, ?)";
	    
	    boolean isInserted = QuizDaoImplements. prepareStatementForInsertTable(sqlQuery, quizTools);
	    return isInserted;
	}
	
	/**
	 * insert thirdRound into thirdRoundTable
	 */
    public boolean thirdRoundInsert(final Quiz quizTools) {
	    final String sqlQuery = "insert into third_round_table values(?, ?, ?, ?, ?, ?, ?)";
	    
	    boolean isInserted = QuizDaoImplements. prepareStatementForInsertTable(sqlQuery, quizTools);
	    return isInserted;
	}
	
    /**
     * execute query using prepareStatement
     */
	public static boolean prepareStatementForInsertTable(final String sqlQuery, final Quiz quizTools) {
		
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
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return false;
	}
	
	/**
	 * check first round Question Number
	 */
	public  boolean checkFirstRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from first_round_table where question_number = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			    prepareStatement.setInt(1, questionNumber);
			 
			 try(ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while(resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new ConnectionException("DataBase Access Failed");
		}
		return false;
	}
	
	/**
	 * check second round Question Number
	 */
	public  boolean checkSecondRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from second_round_table where question_number = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			    prepareStatement.setInt(1, questionNumber);
			 
			 try(ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while(resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new ConnectionException("DataBase Access Failed");
		}
		return false;
	}
	
	/**
	 * check third round Question Number
	 */
	public  boolean checkThirdRoundQuestionNumber(int questionNumber) {
		final String sqlQuery = "select question_number from third_round_table where question_number = ?";

		try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			    prepareStatement.setInt(1, questionNumber);
			 
			 try(ResultSet resultSet = prepareStatement.executeQuery();){
			 
			     while(resultSet.next()) {
			         return true;
			     }
             }
		} catch(Exception e) {
			throw new ConnectionException("DataBase Access Failed");
		}
		return false;
	}
	
	/**
	 * update firstRound into firstRoundTable
	 */
    public boolean firstRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update first_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		boolean isUpdated = QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
		return isUpdated;
	}
	
    /**
     * update secondRound into secondRoundTable
     */
    public boolean secondRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update second_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		boolean isUpdated = QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
		return isUpdated;
	}
    
    /**
     * update thirdRound into thirdRoundTable
     */
    public boolean thirdRoundUpdate(final Quiz quizTools) {
		final String sqlQuery = "Update third_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		boolean isUpdated = QuizDaoImplements.prepareStatementForUpdateTable(sqlQuery, quizTools);
		return isUpdated;
	}
    
    /**
     * execute query using prepareStatament
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
		} catch (Exception exception) {
			throw new ConnectionException("DataBase Access Failed");
		}
	}
	
	/**
	 * delete firstRound from firstRoundTable
	 */
	public boolean firstRoundDelete(final int questionNumber) {
		final String sqlQuery = "Delete from first_round_table where question_number = ?";
		
		boolean isDelete = QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
		
		return isDelete;
	}
	
	/**
	 * delete secondRound from secondRoundTable
	 */
    public boolean secondRoundDelete(final int questionNumber) {
    	final String sqlQuery = "Delete from second_round_table where question_number = ?";
		
    	boolean isDelete = QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    	
    	return isDelete;
	}
    
    /**
     * delete thirdRound from thirdRoundTable
     */
    public boolean thirdRoundDelete(final int questionNumber) {
    	final String sqlQuery = "Delete from third_round_table where question_number = ?";
		
    	boolean isDelete = QuizDaoImplements.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    	
    	return isDelete;
	}
    
    /**
     * execute query using PrepareStatament
     */
    private static boolean prepareStatementForDeleteTable(final String sqlQuery, int questionNumber) {
		
    	try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prePareStatement = connection.prepareStatement(sqlQuery);) {
    		
    		prePareStatement.setInt(1, questionNumber);
    		prePareStatement.executeUpdate();
    		
    		return true;
		} catch(Exception e) {
			throw new ConnectionException("DataBase Access Failed");
		}
	}
    
    /**
     * get FirstRoundDetails 
     * 
     * @throws AccessFailedException 
     */
    public List<Quiz> getFirstRoundDetails() {
    	
    	try (Connection connection = DataBaseConnection.getConnection();
    		    Statement statement = connection.createStatement();) {
    		String sqlQuery = "select * from first_round_table";
    		List<Quiz> firstRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
    		
    		return firstRoundDetails;
    	} catch(Exception exception) {
    		throw new AccessFailedException("DataBase AccessFailed");
    	}
    }

    /**
     * get secondRoundDetails
     */
    public List<Quiz> getSecondRoundDetails() {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	    Statement statement = connection.createStatement();) {
        	String sqlQuery = "select * from second_round_table";
       		List<Quiz> secondRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
        		
       		return secondRoundDetails;
       	} catch(Exception e) {
       		throw new AccessFailedException("DataBase AccessFailed");
        }
	}
    
    /**
     * get ThirdRoundDetails
     */
    public List<Quiz> getThirdRoundDetails() {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	    Statement statement = connection.createStatement();) {
       		String sqlQuery = "select * from third_round_table";
       		List<Quiz> thirdRoundDetails = QuizDaoImplements.getDetails(sqlQuery);
        		
       		return thirdRoundDetails;
       	} catch(Exception e) {
       		throw new AccessFailedException("DataBase AccessFailed");	
        }
	}

    /**
     * get questions,options and correctAnswer from dataBase
     * 
     */
	public static List<Quiz> getDetails(String sqlQuery) {
		
		try (Connection connection = DataBaseConnection.getConnection();
			    Statement statement = connection.createStatement();
			    ResultSet resultSet = statement.executeQuery(sqlQuery);) {		
			List<Quiz> questionDetails = new ArrayList<Quiz>();
			
			while (resultSet.next()) {
				Quiz questionAnswer = new Quiz();
				
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
		} catch(Exception e) {
			throw new AccessFailedException("DataBase AccessFailed");	
		}
	}

	/**
	 * mark Insert into dataBase
	 */
	public boolean markInsert(final int score, final String email) {
		final String sqlQuery = "Update user_table SET score = ? where email = ?";
		
        try (Connection connection = DataBaseConnection.getConnection();
			    PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
             prepareStatement.setInt(1, score);
             prepareStatement.setString(2, email);
            
             prepareStatement.executeUpdate();
             return true;
        } catch (Exception e) {
        	throw new ConnectionException("DataBase Access Failed");
        }
	}
}
