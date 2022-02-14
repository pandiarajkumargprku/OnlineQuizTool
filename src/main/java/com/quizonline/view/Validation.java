package com.quizonline.view;

import com.quizonline.controller.QuizController;

/**
 *mark validation 
 * 
 * @author PandiarajkumarG
 *
 */
public class Validation {

	/**
	 * validate Mark
	 */
	public static int markCalculation(int mark, String answer, String correctAnswer) {
		boolean isAnswerValid = QuizController.checkCorrectAnswer(correctAnswer);
		
		if(!isAnswerValid) {
		    System.out.println("Please Enter Correct option [a,b,c or d]");
		} 
		if (correctAnswer.equalsIgnoreCase(answer)) {
			mark = mark+2;
		} else {
			mark = mark-1;
		}
		return mark;
	}
	
	/**
	 * check mark pass or fail 
	 */
	public static boolean checkMark(int mark, final String email) {
		
		if (mark<=6) {
			UserView.markInsert(mark, email);
		} else {
			return true;
		}
		return false;
	}
}
