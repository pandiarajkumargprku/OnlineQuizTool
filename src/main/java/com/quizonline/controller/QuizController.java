package com.quizonline.controller;

import java.util.List;


import com.quizonline.model.Quiz;
import com.quizonline.model.User;
import com.quizonline.service.QuizDaoService;
import com.quizonline.service.QuizDaoServiceImplements;
import com.quizonline.service.QuizService;
import com.quizonline.service.QuizServiceImplements;
import com.quizonline.view.AdminView;

/**
 * <h1> QuizController </h1>
 *  
 * <p> This Controller getting the request from the main and
 *     gives in to the service.
 * </p>
 * 
 * @author PandiarajkumarG
 */
public class QuizController {
   
	private static final QuizService QUIZ_SERVICE = new QuizServiceImplements();
    private static final QuizDaoService QUIZ_DAO_SERVICE = new QuizDaoServiceImplements();
   
    /**
     * Validate the name of user and admin.
     * 
     * @param name
     */
   	public static boolean validateName(final String name) {
	   return QUIZ_SERVICE.validateName(name);
	}
	
   	/**
   	 * Validate the email of user and admin
   	 * 
   	 * @param email
   	 */
   	public static boolean validateEmail(final String email) {
		return QUIZ_SERVICE.validateEmail(email);
	}
    
   	/**
   	 * Validate the password of user and admin
   	 * 
   	 * @param password
   	 * @return
   	 */
	public static boolean validatePassword(final String password) {
		return QUIZ_SERVICE.validatePassword(password);
	}
	
	/**
	 * SignUp admin and user details
	 * 
	 * @param choice
	 * @param user
	 * @return
	 */
	public static boolean signUpInsert(final int choice, final User user) {
		return QUIZ_DAO_SERVICE.insertSignUpDetail(choice, user);
	}
	
	/**
	 * Checks the email of user and admin from database 
	 * 
	 * @param choice
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(int choice, final String email) {
		return QUIZ_DAO_SERVICE.checkEmail(choice, email);
	}
	
	/**
	 * Checks the password of user and admin from database
	 * 
	 * @param choice
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(final int choice, final String password) {
		return QUIZ_DAO_SERVICE.checkPassword(choice, password);
	}
	
	/**
	 * Provides service to admin as insert, update, delete questions from database
	 */
	public static void adminServices() {
		AdminView.adminServices();
	}
	
	/**
	 * Questions insert, update into databse
	 * 
	 * @param choice
	 * @param QuizTools
	 * @return
	 */
	public static boolean questionInsert(final int choice, final Quiz QuizTools) {
		return QUIZ_DAO_SERVICE.questionInsert(choice, QuizTools);
	}
	
	/**
	 * Questions delete from databse
	 * 
	 * @param questionNumber
	 * @return
	 */
	public static boolean questionDelete(final int questionNumber) {
		return QUIZ_DAO_SERVICE.questionDelete(questionNumber);
	}

	/**
	 * All level questions get from the database
	 * 
	 * @param level
	 * @return
	 */
	public static List<Quiz> getRoundDetails(final int level) {
		return QUIZ_DAO_SERVICE.getRoundDetails(level);
	}

	/**
	 * User mark insert in to database
	 * 
	 * @param mark
	 * @param email
	 * @return
	 */
	public static boolean markInsert(final int mark, final String email) {
		return QUIZ_DAO_SERVICE.markInsert(mark, email);
	}

	/**
	 * Check the question number
	 * @param choice
	 * @param questionNumber
	 * @return
	 */
	public static boolean checkQuestionNumber(final int choice, final int questionNumber) {
		return QUIZ_DAO_SERVICE.checkQuestionNumber(choice, questionNumber);
	}

	/**
	 * checks the correct answer
	 * 
	 * @param correctAnswer
	 * @return
	 */
	public static boolean checkCorrectAnswer(final String correctAnswer) {
		return QUIZ_DAO_SERVICE.checkAnswer(correctAnswer);
	}

	/**
	 * Checks the first option 
	 * 
	 * @param firstOption
	 * @return
	 */
	public static boolean checkFirstOption(final String firstOption) {
		return QUIZ_DAO_SERVICE.checkFirstOption(firstOption);
	}
	
	/**
	 * Checks the second option
	 * 
	 * @param secondOption
	 * @return
	 */
	public static boolean checkSecondOption(final String secondOption) {
		return QUIZ_DAO_SERVICE.checkSecondOption(secondOption);
	}
	
	/**
	 * Checks the third option
	 * 
	 * @param thirdOption
	 * @return
	 */
	public static boolean checkThirdOption(final String thirdOption) {
		return QUIZ_DAO_SERVICE.checkThirdOption(thirdOption);
	}
	
	/**
	 * Checks the fourth option
	 * 
	 * @param fourthOption
	 * @return
	 */
	public static boolean checkFourthOption(final String fourthOption) {
		return QUIZ_DAO_SERVICE.checkFourthOption(fourthOption);
	}
}
