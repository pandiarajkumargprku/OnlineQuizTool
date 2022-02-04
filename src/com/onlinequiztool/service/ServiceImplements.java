package com.onlinequiztool.service;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.dao.QuizDao;
import com.onlinequiztool.main.OnlineQuizTool;
import com.onlinequiztool.model.Quiz;

/**
 * <h1>ServiceImplementation</h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class ServiceImplements implements Service {
    private final QuizDao QUIZ_DAO = new QuizDao();
    
    /**
     * Validate the name
     * 
     * @param name
     */
	public String checkName(final String name) {
		
		if (!name.matches("[A-Z][a-zA-Z\\s]*$")) {
			System.out.println("Invalid Name");
			return QuizController.getName();
		}
		return name;
	}
	
	/**
	 * Validate the email
	 * 
	 * @param email
	 */
    public String checkEmail(final String email) {
		
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Inavlid EmailId");
			return QuizController.getEmail();
		}
		return email;
	}

    /**
     * Validate password
     * 
     * @param password
     */
	public String checkPassword(final String password) {
		
		if (!password.matches("((?=\\S+$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{6,15})")) {
			System.out.println("Invalid Password");
			return QuizController.getPassword();
		}
		return password;
	}
	
	/**
	 * Validate SignUp Admin or User
	 * 
	 * @param choice
	 * @param name
	 * @param email
	 * @param password
	 */
	public void signUpValidation(final int choice, final String name, final String email, final String password) {
		
		if (choice == 1) {
			String adminEmailValidate = QUIZ_DAO.adminSignUpTableValidation(email);
			if (adminEmailValidate != null) {
				System.out.println("This Mail Id is alredy Exists");
			} else {
				QUIZ_DAO.adminSignUpDataInsert(name, email, password);
			}
		} else if(choice == 2) {
			String userEmailValidate = QUIZ_DAO.userSignUpTableValidation(email);
			if (userEmailValidate != null ) {
				System.out.println("This Mail Id is already Exists");
			} else {
				QUIZ_DAO.userSignUpDataInsert(name, email, password);
			}
		}
	}
	
	/**
	 * Validate SignIn Admin or User
	 * 
	 * @param choice
	 * @param email
	 * @param password
	 */
    public void signInValidation(final int choice, final String email, final String password) {
    	
    	if (choice == 1) {
    		boolean isSignIn =QUIZ_DAO.adminSignInValidation(email, password);
    		
    		if (isSignIn) {
    			System.out.println("Admin SignIn Successfully");
    			QuizController.adminServices();
    		} else {
    			System.out.println("SignIn Failed");
    		}
    	} else if (choice == 2) {
    		boolean isSignIn = QUIZ_DAO.userSignInValidation(email, password);
    		
    		if (isSignIn) {
    			System.out.println("User signIn Successfully");
    		} else {
    			System.out.println("SignIn Failed");
    		}
    	}
	}
    
    /**
     * insert and update question into the database
     * 
     * @param choice
     * @param quizTools
     */
    public void questionInsertService(final int choice, Quiz quizTools) {
    	
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
    public void questionDeleteService(final int questionNumber) {
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
}
