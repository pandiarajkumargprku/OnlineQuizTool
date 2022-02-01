package com.onlinequiztool.main;

import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.view.ViewPage;

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
		final String name = ViewPage.getName();
		final String email = ViewPage.getEmail();
	    final String password = ViewPage.getPassword();
	    
	    QuizController.signUpController(choice, name, email, password);
	}
	
	public static void signIn(int choice) {
		final String email = ViewPage.getEmail();
		final String password = ViewPage.getPassword();
		
		QuizController.signInController(choice, email, password);
	}
	
	public static void crudOperation() {
		System.out.println("1.QuestionInsert \t 2.QuestionUpdate \t 3.QuestionDelete \t 4.Exit");
	    System.out.println("Enter your choice");	
	    final int choice = SCANNER.nextInt();
	    
	    switch(choice) {
	    case 1:
	    	AdminPage.insertQuestionTable(choice);
	    	break;
	    case 2:
	    	AdminPage.insertQuestionTable(choice);
	    	break;
	    case 3:
	    	AdminPage.deleteQuestionTable();
	    	break;
	    case 4:
	    	SCANNER.close();
	    }
	}
}
