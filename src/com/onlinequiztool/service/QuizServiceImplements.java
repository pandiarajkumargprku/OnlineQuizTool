package com.onlinequiztool.service;

import java.util.ArrayList;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;
import com.onlinequiztool.dao.QuizDao;

/**
 * <h1>ServiceImplementation</h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class QuizServiceImplements implements QuizService {
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
	 * @throws mailIdNotFoundException 
	 */
	public void signUpValidation(final int choice, final String name, final String email, final String password) throws mailIdNotFoundException {
		
		if(choice ==1) {
			ArrayList adminDetails = QUIZ_DAO.checkAdminEmail(email);
			
			if(adminDetails.contains(email))
			{
				System.out.println("This Mail Id is already Exit");
			} else {
				QUIZ_DAO.adminSignUpInsert(name, email, password);
			}
		} else if(choice ==1) {
			ArrayList userDetails = QUIZ_DAO.checkUserEmail(email);
			
			if(userDetails.contains(email))
			{
				System.out.println("This Mail Id is already Exit");
			} else {
				QUIZ_DAO.userSignUpInsert(name, email, password);
			}
		}
	}
	
	/**
	 * Validate SignIn Admin or User
	 * 
	 * @param choice
	 * @param email
	 * @param password
	 * @throws AccessFailedException 
	 */
    public void signInValidation(final int choice, final String email, final String password) throws AccessFailedException {
    	
    	if (choice == 1) {
    		boolean isSignIn =QUIZ_DAO.getAdminSignIn(email, password);
    		
    		if (isSignIn) {
    			System.out.println("Admin SignIn Successfully");
    			QuizController.adminServices();
    		} else {
    			System.out.println("SignIn Failed");
    		}
    	} else if (choice == 2) {
    		boolean isSignIn = QUIZ_DAO.getUserSignIn(email, password);
    		
    		if (isSignIn) {
    			System.out.println("User signIn Successfully");
    			QuizController.userServices(email);
    		} else {
    			System.out.println("SignIn Failed");
    		}
    	}
    }
}
