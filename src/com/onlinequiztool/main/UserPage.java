package com.onlinequiztool.main;

import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;

/**
 * <h1>User class</h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class UserPage {
	
	/**
	 * User Validation
	 * 
	 * @param choice
	 * @throws mailIdNotFoundException 
	 * @throws AccessFailedException 
	 */
	public void user(final int choice) throws mailIdNotFoundException, AccessFailedException {
	    System.out.println("Are you new User ?");
		final String isNewUser = OnlineQuizTool.SCANNER.next();
		
		if ("yes".equalsIgnoreCase(isNewUser)) {
		    OnlineQuizTool.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewUser)) {
		    OnlineQuizTool.signIn(choice);
		} else {
			user(choice);
		}
	}
}
