package com.onlinequiztool.main;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;
import com.onlinequiztool.model.Quiz;
import com.onlinequiztool.view.ViewPage;

/**
 * <h1>Admin class</h1>
 * 
 * @author PandiarajkumarG
 */
public class AdminPage {
	/**
	 * validate New Admin or not.
	 * 
	 * @param choice
	 * @throws mailIdNotFoundException 
	 * @throws AccessFailedException 
	 */
	public void admin(final int choice) throws mailIdNotFoundException, AccessFailedException {
		System.out.println("Are you new Admin ?");
		final String isNewAdmin = OnlineQuizTool.SCANNER.next();
		
		if ("yes".equalsIgnoreCase(isNewAdmin)) {
			OnlineQuizTool.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewAdmin)) {
		    OnlineQuizTool.signIn(choice);
		} else {
			admin(choice);
		}
    }
	
	/**
	 * insert in the question into database
	 *   
	 * @param choice
	 */
    public static void insertQuestion(final int choice) {
		final int questionNumber = ViewPage.getQuestionNumber();
		final String questions = ViewPage.getQuestions();
		final String firstOption = ViewPage.getFirstOption();
		final String secondOption = ViewPage.getSecondOption();
		final String thirdOption = ViewPage.getThirdOption();
		final String fourthOption = ViewPage.getFourthOption();
		final String correctAnswer = ViewPage.getCorrectAnswer();
		Quiz QuizTools = new Quiz(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
		
		QuizController.questionInsert(choice, QuizTools);
	}
    
    /**
     * update in the question into database
     * 
     * @param choice
     */
	public static void updateQuestion(final int choice) {
	    AdminPage.insertQuestion(choice);
	}
	
	/**
	 * delete in the question into database
	 * 
	 */
	public static void deleteQuestion() {
		final int questionNumber = ViewPage.getQuestionNumber();
		
		QuizController.questionDelete(questionNumber);
	}
}
