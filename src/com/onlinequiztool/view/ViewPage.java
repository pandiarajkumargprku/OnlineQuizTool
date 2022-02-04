package com.onlinequiztool.view;

import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;

/**
 * 
 * @author PandiarajkumarG
 *
 */
public class ViewPage {
	private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Get Name to the user
     * 
     * @return
     */
	public static String getName() {
		System.out.println("Enter name:");
	    final String name = QuizController.checkName(SCANNER.nextLine());
		
		return name;
	}
	/**
	 * Get Email to the user
	 * 
	 * @return
	 */
	public static String getEmail() {
		System.out.println("Enter email:");
		final String email = QuizController.checkEmail(SCANNER.next());
		
		return email;
	}
	/**
	 * Get password to the user
	 * 
	 * @return
	 */
	public static String getPassword() {
		System.out.println("Enter password");
		final String password = QuizController.checkPassword(SCANNER.next());
		
		return password;
	}
    /**
     * Get QuationNumber to the user
     * 
     * @return
     */
	
	public static int getQuestionNumber() {
		System.out.println("Enter question number");
		final int questionNumber = SCANNER.nextInt();
		
		return questionNumber;
	}
    /**
     * Get question to the user
     * 
     * @return
     */
	
	public static String getQuestions() {
	    System.out.println("Enter Questions");
	    final String questions = SCANNER.next();
		
	    return questions;
	}
	/**
	 * Get firstOption to the user
	 * 
	 * @return
	 */
	
	public static String getFirstOption() {
		System.out.println("Enter first option");
		final String firstOption = SCANNER.next();
		
		return firstOption;
	}
    /**
     * Get secondOption to the user
     * 
     * @return
     */
	
	public static String getSecondOption() {
		System.out.println("Enter second option");
		final String secondOption = SCANNER.next();
		
		return secondOption;
	}
    /**
     * Get thirdOption to the user
     * 
     * @return
     */
	
	public static String getThirdOption() {
		System.out.println("Enter third option");
		final String thirdOption = SCANNER.next();
		
		return thirdOption;
	}
    /**
     * Get fourthOption to the user
     * 
     * @return
     */
	public static String getFourthOption() {
		System.out.println("Enter fourth option");
		final String fourthOption = SCANNER.next();
		
		return fourthOption;
	}
	/**
	 * Get correctAnswer to the user
	 * 
	 * @return
	 */

	public static String getCorrectAnswer() {
	    System.out.println("Enter correctanswer");
	    final String correctAnswer = SCANNER.next();
		
		return correctAnswer;
	}
}
