package com.quizonline.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.quizonline.dao.QuizDaoImplements;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;
import com.quizonline.model.User;

public class QuizDaoServiceImplements implements QuizDaoService {
	
	private static final Logger LOGGER = Logger.getLogger(QuizDaoServiceImplements.class);
	private static final QuizDaoImplements QUIZ_DAO = new QuizDaoImplements();
	
	/**
	 * check SignUp Admin or User
	 */
	public boolean signUpInsert(final int choice, final User user)  {
		boolean isSignUp = true;
		
		if (choice == 1) {
		    isSignUp =QUIZ_DAO.adminSignUpInsert(user);
		} else if (choice == 2) {
			isSignUp = QUIZ_DAO.userSignUpInsert(user);
		}
		return isSignUp;
	}
	
	/**
	 * check email
	 */
	public boolean checkEmail(int choice, String email) {
		boolean isEmailValid = true;
		
		if (choice == 1) {
			isEmailValid = QUIZ_DAO.checkAdminEmail(email);
		} else if (choice == 2) {
			isEmailValid = QUIZ_DAO.checkUserEmail(email);
		}
		return isEmailValid;
	}
	
	/**
	 * check password
	 */
	public boolean checkPassword(int choice, String password) {
		boolean isPasswordValid = true;
		
		if (choice == 1) {
			isPasswordValid = QUIZ_DAO.checkAdminPassword(password);
		} else if (choice == 2) {
			isPasswordValid = QUIZ_DAO.checkUserPassword(password);
		}
		return isPasswordValid;
	}
	
	/**
     * insert and update question into the database
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
     * question insert into database
     */
    private static boolean insertQuestion(final Quiz quizTools) {
    	LOGGER.info("Which round to you insert ?");
		final int roundNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
		boolean isInsert = true;
	    
		if (roundNumber == 1) {
	    	 isInsert = QUIZ_DAO.firstRoundInsert(quizTools);
	    } else if (roundNumber == 2) {
	    	 isInsert = QUIZ_DAO.secondRoundInsert(quizTools);
	    } else if (roundNumber == 3) {
	    	 isInsert = QUIZ_DAO.thirdRoundInsert(quizTools);
	    }
    	return isInsert;
    }
    
    /**
     * questions update into database
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
    * questionDelete into database
    */
   public boolean questionDelete(final int questionNumber) {
	   LOGGER.info("which round question to delete ?");
   	   final int roundNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
   	   boolean isDelete = true;
   	
   	   if(isDelete) {
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
     * getRoundDetails from dataBase
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
     * mark Insert into dataBase
     */
    public boolean markInsert(final int mark, final String email) {
    	boolean isEmail = QUIZ_DAO.checkUserEmail(email);
    	
    	if (isEmail) {
    		QUIZ_DAO.markInsert(mark, email);
    	} else {
    		return false;
    	}
    	return true;
    }

    /**
     * check questionNumber
     * 
     */
	public boolean checkQuestionNumber(int choice, int questionNumber) {
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
	 * check correctAnswer
	 */
	public boolean checkAnswer(String correctAnswer) {
		
		if ("a".equalsIgnoreCase(correctAnswer) || "b".equalsIgnoreCase(correctAnswer) || "c".equalsIgnoreCase(correctAnswer) || "d".equalsIgnoreCase(correctAnswer)) {
			return true;
		}
		return false;
	}
	
	/**
	 * check firstOption
	 */
	public boolean checkFirstOption(String firstOption) {
		
		if (firstOption.matches("[a]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * check secondOption
	 */
	public boolean checkSecondOption(String secondOption) {
		
		if (secondOption.matches("[b]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * check thirdOption
	 */
	public boolean checkThirdOption(String thirdOption) {
		
		if (thirdOption.matches("[c]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}

	/**
	 * check fourthOption
	 */
	public boolean checkFourthOption(String fourthOption) {
		
		if (fourthOption.matches("[d]{1}[.]{1}[a-zA-Z0-9\\s]{1,}")) {
			return true;
		}
		return false;
	}
}
