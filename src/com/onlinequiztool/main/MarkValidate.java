package com.onlinequiztool.main;

import com.onlinequiztool.view.ViewPage;

/**
 * <h1> mark validate </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class MarkValidate {

	/**
	 *calculation mark
	 * 
	 * @param mark
	 * @param answer
	 * @param correctAnswer
	 * @return
	 */
	public static int validateMark(int mark, String answer, String correctAnswer) {
		
		if(correctAnswer.equalsIgnoreCase(answer)) {
			mark = mark+2;
		} else {
			mark = mark-1;
		}
		return mark;
	}
	
	/**
	 * validate mark pass or fail 
	 * 
	 * @param mark
	 * @param email
	 * @return
	 */
	public static boolean checkMark(int mark, String email) {
		
		if(mark<=6) {
			ViewPage.markInsert(mark, email);
		} else {
			return true;
		}
		return false;
	}
}
