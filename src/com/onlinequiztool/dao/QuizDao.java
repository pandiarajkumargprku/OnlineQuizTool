package com.onlinequiztool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.onlinequiztool.model.Quiz;
import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;

/**
 * <h1>QuizDao</h1>
 * 
 * @author PandiarajkumarG
 */
public class QuizDao {
	
	/**
	 * validate SignUp in Admin table
	 *
	 * @param email
	 * @return
	 * @throws mailIdNotFoundException 
	 */

	public ArrayList checkAdminEmail(final String email) throws mailIdNotFoundException {
		final String sqlQuery = "select email from admin_table";

		try (Connection connection = DataBaseConnection.getConnection();
			 PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			 ResultSet resultSet = prepareStatement.executeQuery();
			 ArrayList adminDetails = new ArrayList<>();
			 
			 while(resultSet.next()) {
			     adminDetails.add(resultSet.getString("email"));
			 }
			 return adminDetails;
		} catch(Exception e) {
			throw new mailIdNotFoundException("Admin Mail Id Not Found Exception");
		}
	}
	

	/**
	 * insert Admin details in admin Table
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public void adminSignUpInsert(final String name, final String email, final String password) {
		
		try (Connection connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into admin_table(name, email, password) values('" + name + "','" + email + "','"+ password + "') ");		          
			System.out.println("Succesfully Admin SignUp"); 
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * validate signIn in admin table
	 * 
	 * @param email
	 * @return
	 * @throws mailIdNotFoundException 
	 */
	public ArrayList checkUserEmail(final String email) throws mailIdNotFoundException {
		final String sqlQuery = "select email from user_table";

		try (Connection connection = DataBaseConnection.getConnection();
			 PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
			 ResultSet resultSet = prepareStatement.executeQuery();
			 ArrayList userDetails = new ArrayList<>();
			 
			 while(resultSet.next()) {
				 userDetails.add(resultSet.getString("email"));
			 }
			 return userDetails;
		} catch(Exception e) {
			throw new mailIdNotFoundException("Üser Mail Id Not Found Exception");
		}
	}
	
	/**
	 * insert user details into user table
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public void userSignUpInsert(final String name, final String email, final String password) {
		
		try (Connection connection = DataBaseConnection.getConnection();
		    Statement statement = connection.createStatement();) {
			int mark = 0;
			
		    statement.executeUpdate("insert into user_table(name, email, password, score) values('" + name + "','" + email + "','"+ password + "','"+ mark + "') ");		          
			System.out.println("Succesfully User SignUp");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * validate signIn in admin table
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean getAdminSignIn(final String email, final String password) {
		
		try (Connection connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();) {
		    ResultSet resultSet = statement.executeQuery("Select email, password from admin_table where email= '" + email + "' AND password='" + password + "'");
			
			while (resultSet.next()) {
			    return true;
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Validate SignIn in user table
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean getUserSignIn(final String email, final String password) {
	
		try (Connection connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();) {
		    ResultSet resultSet = statement.executeQuery("Select email, password from user_table where email= '" + email + "' AND password='" + password + "'");
			
			while (resultSet.next()) {
			    return true;
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * insert firstRound into firstRoundTable
	 * 
	 * @param quizTools
	 */
	public void firstRoundInserted(Quiz quizTools) {
	    final String sqlQuery = "insert into first_round_table values(?,?,?,?,?,?,?)";
	   
	    QuizDao.insertPrepareStatement(sqlQuery, quizTools);
	}
	
	/**
	 * insert secondRound into secondRoundTable
	 * 
	 * @param quizTools
	 */
	public void secondRoundInserted(Quiz quizTools) {
	    final String sqlQuery = "insert into second_round_table values(?,?,?,?,?,?,?)";
	    
	    QuizDao.insertPrepareStatement(sqlQuery, quizTools);
	}
	
	/**
	 * insert thirdRound into thirdRoundTable
	 * 
	 * @param quizTools
	 */
    public void thirdRoundInserted(Quiz quizTools) {
	    final String sqlQuery = "insert into third_round_table values(?,?,?,?,?,?,?)";
	    
	    QuizDao.insertPrepareStatement(sqlQuery, quizTools);
	}
	
    /**
     * execute query using prepareStatement
     * 
     * @param sqlQuery
     * @param quizTools
     */
	public static void insertPrepareStatement(final String sqlQuery, Quiz quizTools) {
		
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
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * update firstRound into firstRoundTable
	 * 
	 * @param quizTools
	 */
    public void firstRoundUpdated(Quiz quizTools) {
		final String sqlQuery = "Update first_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		QuizDao.updatePrepareStatement(sqlQuery, quizTools);
	}
	
    /**
     * update secondRound into secondRoundTable
     * 
     * @param quizTools
     */
    public void secondRoundUpdated(Quiz quizTools) {
		final String sqlQuery = "Update second_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		QuizDao.updatePrepareStatement(sqlQuery, quizTools);
	}
    
    /**
     * update thirdRound into thirdRoundTable
     * 
     * @param quizTools
     */
    public void thirdRoundUpdated(Quiz quizTools) {
		final String sqlQuery = "Update third_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";
		
		QuizDao.updatePrepareStatement(sqlQuery, quizTools);
	}
    
    /**
     * execute query using prepareStatament
     * 
     * @param sqlQuery
     * @param quizTools
     */
	public static void updatePrepareStatement(final String sqlQuery, Quiz quizTools) {
		
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
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * delete firstRound from firstRoundTable
	 * 
	 * @param questionNumber
	 */
	public void firstRoundDeleted(final int questionNumber) {
		final String sqlQuery = "Delete from first_round_table where question_number = ?";
		
		QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
	
	/**
	 * delete secondRound from secondRoundTable
	 * 
	 * @param questionNumber
	 */
    public void secondRoundDeleted(final int questionNumber) {
    	final String sqlQuery = "Delete from second_round_table where question_number = ?";
		
    	QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
    
    /**
     * delete thirdRound from thirdRoundTable
     * 
     * @param questionNumber
     */
    public void thirdRoundDeleted(final int questionNumber) {
    	final String sqlQuery = "Delete from third_round_table where question_number = ?";
		
    	QuizDao.deletePrepareStatement(sqlQuery, questionNumber);
	}
    
    /**
     * execute query using PrepareStatament
     * 
     * @param sqlQuery
     * @param questionNumber
     */
    private static void deletePrepareStatement(final String sqlQuery, int questionNumber) {
		
    	try (Connection connection = DataBaseConnection.getConnection();
			PreparedStatement prePareStatement = connection.prepareStatement(sqlQuery);) {
    		
    		prePareStatement.setInt(1, questionNumber);
    		prePareStatement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
    
    /**
     * get FirstRoundDetails 
     * 
     * @return 
     * @throws AccessFailedException 
     */
    public ArrayList<Quiz> getFirstRoundDetails() throws AccessFailedException {
    	
    	try (Connection connection = DataBaseConnection.getConnection();
    		Statement statement = connection.createStatement();) {
    		String sql = "select * from first_round_table";
    		ArrayList<Quiz> firstRoundDetails = QuizDao.getDetails(sql);
    		
    		return firstRoundDetails;
    	} catch(Exception exception) {
    		throw new AccessFailedException("DataBase AccessFailed");
    	}
    }

    /**
     * get secondRoundDetails
     * 
     * @return
     * @throws AccessFailedException 
     */
    public ArrayList<Quiz> getSecondRoundDetails() throws AccessFailedException {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	Statement statement = connection.createStatement();) {
        	String sql = "select * from second_round_table";
       		ArrayList<Quiz> secondRoundDetails = QuizDao.getDetails(sql);
        		
       		return secondRoundDetails;
       	} catch(Exception e) {
       		throw new AccessFailedException("DataBase AccessFailed");
        }
	}
    
    /**
     * get ThirdRoundDetails
     * 
     * @return
     * @throws AccessFailedException 
     */
    public ArrayList<Quiz> getThirdRoundDetails() throws AccessFailedException {
		
    	try (Connection connection = DataBaseConnection.getConnection();
        	Statement statement = connection.createStatement();) {
       		String sql = "select * from third_round_table";
       		ArrayList<Quiz> thirdRoundDetails = QuizDao.getDetails(sql);
        		
       		return thirdRoundDetails;
       	} catch(Exception e) {
       		throw new AccessFailedException("DataBase AccessFailed");	
        }
	}

    /**
     * get questions,options and correctAnswer from dataBase
     * 
     * @param sql
     * @return
     * @throws AccessFailedException 
     */
	public static ArrayList<Quiz> getDetails(String sql) throws AccessFailedException {
		
		try (Connection connection = DataBaseConnection.getConnection();
			Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(sql);			
			ArrayList<Quiz> questionDetails = new ArrayList<Quiz>();
			
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
	 * cheeck user email 
	 * 
	 * @param mark
	 * @param email
	 * @return
	 */
	public boolean checkUserEmail(int mark, String email) {
		final String sqlQuery = "Select email from user_table where email = ?";
		
		try (Connection connection = DataBaseConnection.getConnection();
			 PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
             prepareStatement.setString(1, email);
             ResultSet resultSet = prepareStatement.executeQuery();
             
             while(resultSet.next()) {
            	 return true;
             }
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * mark Insert into dataBase
	 * 
	 * @param score
	 * @param email
	 * @return
	 */
	public boolean markInsert(int score, String email) {
		final String sqlQuery = "Update user_table SET score = ? where email = ?";
		
        try (Connection connection = DataBaseConnection.getConnection();
			 PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
             prepareStatement.setInt(1, score);
             prepareStatement.setString(2, email);
            
             prepareStatement.executeUpdate();
             return true;
        } catch (Exception e) {
        	System.out.println(e);
        }
        return false;
	}
}
