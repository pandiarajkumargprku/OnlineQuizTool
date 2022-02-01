package com.onlinequiztool.main;

import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.view.Details;

public class OnlineQuizTool {
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final AdminPage ADMINSIGNUPSIGNIN = new AdminPage();
	public static final UserPage USERSIGNUPSIGNIN = new UserPage();
	
	public static void main(String[] args) {
		System.out.println("Choose 1.Admin 2.User");
		final int choice = SCANNER.nextInt();
		
		switch(choice) {
		case 1:
		    ADMINSIGNUPSIGNIN.admin(choice);
		   	break;
		case 2:
			USERSIGNUPSIGNIN.user(choice);
		    break;
		 default:
			 SCANNER.close();
		}
    }
	
    public static void signUp(int choice) {
		final String name = Details.getName();
		final String email = Details.getEmail();
	    final String password = Details.getPassword();
	    
	    QuizController.signUpController(choice, name, email, password);
	}
	
	public static void signIn(int choice) {
		final String email = Details.getEmail();
		final String password = Details.getPassword();
		
		QuizController.signInController(choice, email, password);
	}
	
	public static void crudOperation() {
		System.out.println("1.QuestionInsert \t 2.QuestionUpdate \t 3.QuestionDelete \t 4.Exit");
	    System.out.println("Enter your choice");	
	    final int choice = SCANNER.nextInt();
	    
	    switch(choice) {
	    case 1:
	    	AdminPage.insertQuestion(choice);
	    	break;
	    case 2:
	    	AdminPage.insertQuestion(choice);
	    	break;
	    case 3:
	    	AdminPage.deleteQuestion();
	    	break;
	    case 4:
	    	SCANNER.close();
	    }
	}
}
