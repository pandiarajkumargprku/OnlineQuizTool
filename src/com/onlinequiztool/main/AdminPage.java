package com.onlinequiztool.main;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.view.ViewPage;

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
	
	public static void insertQuestionTable(final int choice) {
		final int questionNumber = ViewPage.getQuestionNumber();
		final String questions = ViewPage.getQuestions();
		final String firstOption = ViewPage.getFirstOption();
		final String secondOption = ViewPage.getSecondOption();
		final String thirdOption = ViewPage.getThirdOption();
		final String fourthOption = ViewPage.getFourthtOption();
		final String correctAnswer = ViewPage.getCorrectAnswer();
		
		QuizController.questionInsertController(choice, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer );
	}
	
	public static void deleteQuestionTable() {
		final int questionNumber = ViewPage.getQuestionNumber();
		
		QuizController.questionDeleteController(questionNumber);
	}
}
