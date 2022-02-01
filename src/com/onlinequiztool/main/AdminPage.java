package com.onlinequiztool.main;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.view.Details;

public class AdminPage {
	public void admin(int choice) {
		System.out.println("Are you new Admin ?");
		final String isNewAdmin = OnlineQuizTool.SCANNER.next();
		
		if("yes".equalsIgnoreCase(isNewAdmin)) {
			OnlineQuizTool.signUp(choice);
		} else if("no".equalsIgnoreCase(isNewAdmin)) {
		    OnlineQuizTool.signIn(choice);
		}
    }
	
	public static void insertQuestion(final int choice) {
		final int questionNumber = Details.getQuestionNumber();
		final String questions = Details.getQuestions();
		final String firstOption = Details.getFirstOption();
		final String secondOption = Details.getSecondOption();
		final String thirdOption = Details.getThirdOption();
		final String fourthOption = Details.getFourthtOption();
		final String correctAnswer = Details.getCorrectAnswer();
		
		QuizController.questionInsertController(choice, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer );
	}
	
	public static void deleteQuestion() {
		final int questionNumber = Details.getQuestionNumber();
		
		QuizController.questionDeleteController(questionNumber);
	}
}
