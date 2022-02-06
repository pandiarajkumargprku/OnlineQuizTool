package com.onlinequiztool.main;

import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;
import com.onlinequiztool.view.ViewPage;

/**
 * <h1>OnlineQuizTool</h1> 
 * <p>
 *    The onlineQuizTool Application in which admin
 *    maintains the questions for quiz so that user can signUp and signIn to take
 *    three level online Quiz. 
 * </p>
 * 
 *  @author PandiarajkumarG
 */
public class OnlineQuizTool {
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final AdminPage ADMIN_PAGE = new AdminPage();
	private static final UserPage USER_PAGE = new UserPage();

	public static void main(String[] args) throws mailIdNotFoundException, AccessFailedException {
		OnlineQuizTool.checkAdminOrUser();
	}
	
	/**
	 * method check admin or user.
	 * @throws mailIdNotFoundException 
	 * @throws AccessFailedException 
	 */
	private static void checkAdminOrUser () throws mailIdNotFoundException, AccessFailedException {
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
			System.out.println("Enter valid number");
			checkAdminOrUser();
		}
	}

	/**
	 * Method which makes SignUp function
	 * 
	 * @param choice
	 * @throws mailIdNotFoundException 
	 */
	public static void signUp(final int choice) throws mailIdNotFoundException {
		final String name = ViewPage.getName();
		final String email = ViewPage.getEmail();
		final String password = ViewPage.getPassword();

		QuizController.signUpTableInsert(choice, name, email, password);
	}

	/**
	 * Method which makes SignIn function
	 * 
	 * @param choice
	 * @throws AccessFailedException 
	 */
	public static void signIn(final int choice) throws AccessFailedException {
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
