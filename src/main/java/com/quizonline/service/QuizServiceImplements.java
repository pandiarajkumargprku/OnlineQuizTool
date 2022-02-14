package com.quizonline.service;

/**
 *ServiceImplementation
 * 
 * @author PandiarajkumarG
 *
 */
public class QuizServiceImplements implements QuizService {
    
    /**
     * Checks user name
     */
	public boolean checkName(final String name) {
		
		if (!name.matches("[A-Z][a-zA-Z\\s]*$")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks user email
	 */
    public boolean checkEmail(final String email) {
		
		if (!email.matches("^[A-Za-z0-9_-]+(\\.[A-Za-z]{1,}[0-9]{1,}+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,3})$")) {
			return false;
		}
		return true;
	}

    /**
     * Checks user password
     */
	public boolean checkPassword(final String password) {
		
		if (!password.matches("((?=\\S+$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{6,15})")) {
			return false;
		}
		return true;
	}	
}
