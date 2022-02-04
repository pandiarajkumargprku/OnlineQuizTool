package com.onlinequiztool.main;

import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.view.ViewPage;

/**
 * <h1>OnlineQuizTool</h1> The onlineQuizTool Application in which admin
 * maintains the questions for quiz so that user can signUp and signIn to take
 * three level online Quiz.
 * 
 *  @author PandiarajkumarG
 */
public class OnlineQuizTool {
	public static final Scanner SCANNER = new Scanner(System.in);
	private static final AdminPage ADMIN_PAGE = new AdminPage();
	private static final UserPage USER_PAGE = new UserPage();

	/**
	 * main method is validate admin or user .
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Choose 1.Admin 2.User");
		final int choice = SCANNER.nextInt();

		switch (choice) {
		case 1:
			ADMIN_PAGE.admin(choice);
			break;
		case 2:
			USER_PAGE.user(choice);
			break;
		default:
			SCANNER.close();
		}
	}

	/**
	 * Method which makes SignUp function
	 * 
	 * @param choice
	 */
	public static void signUp(final int choice) {
		final String name = ViewPage.getName();
		final String email = ViewPage.getEmail();
		final String password = ViewPage.getPassword();

		QuizController.signUpTableInsert(choice, name, email, password);
	}

	/**
	 * Method which makes SignIn function
	 * 
	 * @param choice
	 */
	public static void signIn(final int choice) {
		final String email = ViewPage.getEmail();
		final String password = ViewPage.getPassword();

		QuizController.signInTableInsert(choice, email, password);
	}

	/**
	 * Method which makes use of all services such as Insert, Update and Delete.
	 * 
	 */
	public static void adminServices() {
		do {
			System.out.println("1.Insert \n 2.Update \n 3.Delete \n 4.Exit \n Enter Your Choice");
			final int choice = SCANNER.nextInt();

			switch (choice) {
			case 1:
				AdminPage.insertQuestion(choice);
				break;
			case 2:
				AdminPage.updateQuestion(choice);
				break;
			case 3:
				AdminPage.deleteQuestion();
				break;
			case 4:
				SCANNER.close();
			}
		} while (true);
	}
}
