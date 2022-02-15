package com.quizonline.service;

/**
 * <h1> ServiceImplementation </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class QuizServiceImplements implements QuizService {
    
    /**
     * Checks user name
     */
	public boolean validateName(final String name) {
		
		if (!name.matches("[A-Z][a-zA-Z\\s]*$")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks user email
	 */
    public boolean validateEmail(final String email) {
		
		if (!email.matches("^[A-Za-z0-9_-]*@[^-][A-Za-z0-9-]*(\\.[A-Za-z]{2,3})$")) {
			return false;
		}
		return true;
	}

    /**
     * Checks user password
     */
	public boolean validatePassword(final String password) {
		
		if (!password.matches("((?=\\S+$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{6,15})")) {
			return false;
		}
		return true;
	}	
}
