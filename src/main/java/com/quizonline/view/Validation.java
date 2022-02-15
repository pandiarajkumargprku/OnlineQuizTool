package com.quizonline.view;

/**
 * <h1> Mark validation </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class Validation {

	/**
	 * Validate Mark
	 * 
	 * @param mark
	 * @param answer
	 * @param correctAnswer
	 */
	public static int markCalculation(int mark, String answer, String correctAnswer) {
		
		if (correctAnswer.equalsIgnoreCase(answer)) {
			mark = mark+2;
		} else {
			mark = mark-1;
		}
		return mark;
	}
	
	/**
	 * Check mark pass or fail 
	 * 
	 * @param mark
	 * @param email
	 */
	public static boolean checkMark(int mark, final String email) {
		
		if (mark <= 6) {
			UserView.markInsert(mark, email);
		} else {
			return true;
		}
		return false;
	}
}
