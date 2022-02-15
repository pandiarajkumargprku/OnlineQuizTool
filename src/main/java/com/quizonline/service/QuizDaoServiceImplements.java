package com.quizonline.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.quizonline.dao.QuizDaoImplements;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;
import com.quizonline.model.User;

/**
 * <h1> Quiz Dao Service Implements </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class QuizDaoServiceImplements implements QuizDaoService {
	
	private static final Logger LOGGER = Logger.getLogger(QuizDaoServiceImplements.class);
	private static final QuizDaoImplements QUIZ_DAO = new QuizDaoImplements();
	
	/**
	 * Check signUp admin or user
	 * 
	 * @param choice
	 * @param user
	 */
	public boolean insertSignUpDetail(final int choice, final User user)  {
		boolean isSignUp = true;
		
		if (choice == 1) {
		    isSignUp =QUIZ_DAO.insertAdminSignUpDetail(user);
		} else if (choice == 2) {
			isSignUp = QUIZ_DAO.insertUserSignUpDetail(user);
		} 
		return isSignUp;
	}
	
	/**
	 * Check email
	 * 
	 * @param choice
	 * @param email
	 */
	public boolean checkEmail(final int choice, final String email) {
		boolean isValidEmail = true;
		
		if (choice == 1) {
			isValidEmail = QUIZ_DAO.checkAdminEmail(email);
		} else if (choice == 2) {
			isValidEmail = QUIZ_DAO.checkUserEmail(email);
		}
		return isValidEmail;
	}
	
	/**
	 * Check password
	 * 
	 * @param choice
	 * @param password
	 */
	public boolean checkPassword(final int choice, final String password) {
		boolean isValidPassword = true;
		
		if (choice == 1) {
			isValidPassword = QUIZ_DAO.checkAdminPassword(password);
		} else if (choice == 2) {
			isValidPassword = QUIZ_DAO.checkUserPassword(password);
		}
		return isValidPassword;
	}
	
	/**
     * Check insert or update question into the database
     * 
     * @param choice
     * @param quizTools
     */
    public boolean questionInsert(final int choice, final Quiz quizTools) {
    	boolean isQuestionInsert = true;
 
    	if (choice == 1) {
    		isQuestionInsert = QuizDaoServiceImplements.insertQuestion(quizTools);
    	} else if (choice == 2) {
    		isQuestionInsert = QuizDaoServiceImplements.updateQuestion(quizTools);
    	}
    	return isQuestionInsert;
    }
    
    /**
     * Question insert into database
     * 
     * @param quizTools
     */
    private static boolean insertQuestion(final Quiz quizTools) {
    	LOGGER.info("Which round to you insert ?");
		final int roundNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
		boolean isInsert = true;
	    
		if (roundNumber == 1) {
	    	 isInsert = QUIZ_DAO.insertFirstRoundDetails(quizTools);
	    } else if (roundNumber == 2) {
	    	 isInsert = QUIZ_DAO.insertSecondRoundDetails(quizTools);
	    } else if (roundNumber == 3) {
	    	 isInsert = QUIZ_DAO.insertThirdRoundDetails(quizTools);
	    }
    	return isInsert;
    }
    
    /**
     * Questions update into database
     * 
     * @param quizTools
    */
    private static boolean updateQuestion(final Quiz quizTools) {
    	LOGGER.info("which round to you update ?");
	    final int roundNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine()); 
	    boolean isUpdate = true;
	    
	    if (isUpdate) { 
	        
	        if (roundNumber == 1) {
	            isUpdate = QUIZ_DAO.firstRoundUpdate(quizTools);
	        } else if (roundNumber ==2) {
		        isUpdate = QUIZ_DAO.secondRoundUpdate(quizTools);
	        } else if (roundNumber == 3) {
		        isUpdate = QUIZ_DAO.thirdRoundUpdate(quizTools);
	        }
	    }
	    return isUpdate;
    }
    
   /**
    * Question delete into database
    * 
    * @param questionNumber
    */
   public boolean questionDelete(final int questionNumber) {
	   LOGGER.info("which round question to delete ?");
   	   final int roundNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
   	   boolean isDelete = true;
   	
   	   if (isDelete) {
          
   		   if (roundNumber == 1) {
    	       isDelete = QUIZ_DAO.firstRoundDelete(questionNumber);
   	       } else if (roundNumber == 2) {   		
   	    	   isDelete = QUIZ_DAO.secondRoundDelete(questionNumber);
 	       } else if (roundNumber == 3) {
  		       isDelete = QUIZ_DAO.thirdRoundDelete(questionNumber);
  	       }
   	   }
  	   return isDelete;
    }
   
    /**
     * GetRoundDetails from dataBase
     * 
     * @param level
     */
    public List<Quiz> getRoundDetails(final int level) {
    
        if (level == 1) {
            return QUIZ_DAO.getFirstRoundDetails();
    	} else if (level == 2) {
    		return QUIZ_DAO.getSecondRoundDetails();
    	} else if (level == 3) {
    		return QUIZ_DAO.getThirdRoundDetails();
    	} 
    	return null;
	}
    
    /**
     * Mark Insert into dataBase
     * 
     * @param mark
     * @param email
     */
    public boolean markInsert(final int mark, final String email) {
    	
    	if (QUIZ_DAO.checkUserEmail(email)) {
    		QUIZ_DAO.markInsert(mark, email);
    	} else {
    		return false;
    	}
    	return true;
    }

    /**
     * Check questionNumber
     * 
     * @param choice
     * @param questionNumber
     * 
     */
	public boolean checkQuestionNumber(final int choice, final int questionNumber) {
		boolean isQuestionNumber = true;
		
		if (choice == 1) {
		    isQuestionNumber = QUIZ_DAO.checkFirstRoundQuestionNumber(questionNumber);
		} else if (choice == 2) {
			isQuestionNumber = QUIZ_DAO.checkSecondRoundQuestionNumber(questionNumber);
		} else if (choice == 3) {
			isQuestionNumber = QUIZ_DAO.checkThirdRoundQuestionNumber(questionNumber);
		}
		return isQuestionNumber;
	}

	/**
	 * Check correctAnswer
	 * 
	 * @param correctAnswer
	 */
	public boolean checkAnswer(final String correctAnswer) {
		
		if ("a".equalsIgnoreCase(correctAnswer) || "b".equalsIgnoreCase(correctAnswer) || "c".equalsIgnoreCase(correctAnswer) || "d".equalsIgnoreCase(correctAnswer)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check firstOption
	 * 
	 * @param FirstOption
	 */
	public boolean checkFirstOption(final String firstOption) {
		
		if (firstOption.matches("[a]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * Check secondOption
	 * 
	 * @param SecondOption
	 */
	public boolean checkSecondOption(final String secondOption) {
		
		if (secondOption.matches("[b]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * Check thirdOption
	 * 
	 * @param thirdOption
	 */
	public boolean checkThirdOption(final String thirdOption) {
		
		if (thirdOption.matches("[c]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * Check fourthOption
	 * 
	 * @param fourthOption
	 */
	public boolean checkFourthOption(final String fourthOption) {
		
		if (fourthOption.matches("[d]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}
}
