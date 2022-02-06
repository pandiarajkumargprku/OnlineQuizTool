package com.onlinequiztool.dao;

import java.util.ArrayList;

import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.main.OnlineQuizTool;
import com.onlinequiztool.model.Quiz;

public class QuizDaoServiceImplements implements QuizServiceDao {
	private final QuizDao QUIZ_DAO = new QuizDao();
	
	/**
     * insert and update question into the database
     * 
     * @param choice
     * @param quizTools
     */
    public void questionInsert(final int choice, Quiz quizTools) {
    	
    	if (choice == 1) {
    		System.out.println("Which round to you inserted ?");
    		final int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    		
    	    if (roundNumber == 1) {
    	    	QUIZ_DAO.firstRoundInserted(quizTools);
    	    } else if (roundNumber == 2) {
    	    	QUIZ_DAO.secondRoundInserted(quizTools);
    	    } else if (roundNumber == 3) {
    	    	QUIZ_DAO.thirdRoundInserted(quizTools);
    	    }
    	} else if (choice == 2) {
    		System.out.println("which round to you updated ?");
    		final int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    		
    		if (roundNumber ==1) {
    			QUIZ_DAO.firstRoundUpdated(quizTools);
    		} else if (choice ==2) {
    			QUIZ_DAO.secondRoundUpdated(quizTools);
    		} else if (roundNumber == 3) {
    			QUIZ_DAO.thirdRoundUpdated(quizTools);
    		}
    	}
    }
    
    /**
     * delete the question into the database
     * 
     * @param questionNumber
     */
    public void questionDelete(final int questionNumber) {
    	System.out.println("which round to you delete ?");
    	final int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    	
    	if (roundNumber == 1) {
    		QUIZ_DAO.firstRoundDeleted(questionNumber);
    	} else if (roundNumber == 2) {
    		QUIZ_DAO.secondRoundDeleted(questionNumber);
    	} else if (roundNumber == 3) {
    		QUIZ_DAO.thirdRoundDeleted(questionNumber);
    	}
    }
    
    /**
     * getRoundDetails from dataBase
     * 
     * @param level
     * @throws AccessFailedException 
     */
    public ArrayList getRoundDetails(int level) throws AccessFailedException {
    	
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
     * 
     * @param mark
     * @param email
     */
    public boolean markInsert(int mark, String email) {
    	boolean isEmail = QUIZ_DAO.checkUserEmail(mark, email);
    	
    	if(isEmail) {
    		QUIZ_DAO.markInsert(mark, email);
    	} else {
    		return false;
    	}
    	return true;
    }
}
