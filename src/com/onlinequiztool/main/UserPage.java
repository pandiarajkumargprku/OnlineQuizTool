package com.onlinequiztool.main;
/**
 * <h1>User class</h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class UserPage {
	/**
	 * validate user or not
	 * @param choice
	 */
	public void user(final int choice) {
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
