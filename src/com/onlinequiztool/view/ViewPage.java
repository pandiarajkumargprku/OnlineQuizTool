package com.onlinequiztool.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.main.MarkValidate;
import com.onlinequiztool.model.Quiz;

/**
 * <h1>View Page</h1>
 * 
 * @author PandiarajkumarG
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
	
	/**
	 * user services
	 * @param email
	 * @throws AccessFailedException 
	 */
	public static void userServices(String email) throws AccessFailedException {
		int mark = 0;
		int level = 1;

		ViewPage.levelDetails(mark, level, email);
		
	}
	
	/**
	 *  questions,options and correctAnswer get from dataBase
	 *  
	 * @param mark
	 * @param level
	 * @param email
	 * @throws AccessFailedException 
	 */
	public static void levelDetails(int mark, int level, String email) throws AccessFailedException {
		int lastLevel = 3;
		
		System.out.println("Level "+ level);
		System.out.println("Total Questions 5");
		System.out.println("Marks:2 Mark for each question");
		System.out.println("Negative Marks:1 mark per wrong answer");
		System.out.println("Start Quiz");
		System.out.println("Contents of the Table: ");
		
		ArrayList<Quiz> details = QuizController.getRoundDetails(level);
		
		for(int index = 0;index<details.size();index++) {
		    Quiz questionAnswer = details.get(index);
		    System.out.println(questionAnswer);
		    System.out.println("Enter ur choice ");
		    String answer = SCANNER.next();
            mark = MarkValidate.validateMark(mark, answer, questionAnswer.getCorrectAnswer());
        }
		System.out.println("Your Score is" + mark);
		boolean isPass = MarkValidate.checkMark(mark, email);
	    
		if(!isPass) {
			System.out.println("your score is below average");
		} else if (isPass) {
			level = level+1;
			if(level <= lastLevel) {
				ViewPage.levelDetails(mark, level, email);
			} else {
				ViewPage.markInsert(mark, email);
			}
		} 
	}

	/**
	 *  mark insert into DataBase
	 * 
	 * @param mark
	 * @param email
	 */
	public static void markInsert(int mark, String email) {
		boolean isMarkUpdate = QuizController.markInsert(mark, email);
		
		if (isMarkUpdate) {
			System.out.println("Your mark was Updated Successfully");
		} else {
			System.out.println("Check your EMail");
		}
	}
}
