package com.onlinequiztool.view;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.main.OnlineQuizTool;

public class Details {
    public static String getName() {
		System.out.println("Enter the name:");
	    final String name = QuizController.checkName(OnlineQuizTool.SCANNER.next());
		
		return name;
	}
	
	public static String getEmail() {
		System.out.println("Enter the email:");
		final String email = QuizController.checkEmail(OnlineQuizTool.SCANNER.next());
		
		return email;
	}
	
	public static String getPassword() {
		System.out.println("Enter the password");
		final String password = QuizController.checkPassword(OnlineQuizTool.SCANNER.next());
		
		return password;
	}

	public static int getQuestionNumber() {
		System.out.println("Enter the question number");
		int questionNumber = OnlineQuizTool.SCANNER.nextInt();
		
		return questionNumber;
	}

	public static String getQuestions() {
	    System.out.println("Enter the Questions");
	    String questions = OnlineQuizTool.SCANNER.next();
		
	    return questions;
	}
	
	public static String getFirstOption() {
		System.out.println("Enter the firstoption");
		String firstOption = OnlineQuizTool.SCANNER.next();
		
		return firstOption;
	}

	public static String getSecondOption() {
		System.out.println("Enter the secondoption");
		String secondOption = OnlineQuizTool.SCANNER.next();
		
		return secondOption;
	}

	public static String getThirdOption() {
		System.out.println("Enter the thirdoption");
		String thirdOption = OnlineQuizTool.SCANNER.next();
		
		return thirdOption;
	}

	public static String getFourthtOption() {
		System.out.println("Enter the fourthoption");
		String fourthOption = OnlineQuizTool.SCANNER.next();
		
		return fourthOption;
	}

	public static String getCorrectAnswer() {
	    System.out.println("Enter the correctanswer");
		String correctAnswer = OnlineQuizTool.SCANNER.next();
		
		return correctAnswer;
	}
}
