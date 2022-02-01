package com.onlinequiztool.main;

public class UserPage {
	public void user(int choice) {
	    System.out.println("Are you new User ?");
		final String isNewUser = OnlineQuizTool.SCANNER.next();
		
		if("yes".equalsIgnoreCase(isNewUser)) {
		    OnlineQuizTool.signUp(choice);
		} else if("no".equalsIgnoreCase(isNewUser)) {
		    OnlineQuizTool.signIn(choice);
		}	
	}
}
