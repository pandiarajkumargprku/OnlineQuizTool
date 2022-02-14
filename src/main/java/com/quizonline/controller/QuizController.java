package com.quizonline.controller;

import java.util.List;

import com.quizonline.model.Quiz;
import com.quizonline.model.User;
import com.quizonline.service.QuizDaoService;
import com.quizonline.service.QuizDaoServiceImplements;
import com.quizonline.service.QuizService;
import com.quizonline.service.QuizServiceImplements;
import com.quizonline.view.AdminView;
import com.quizonline.view.UserView;

/**
 * QuizController
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
   
   	public static boolean checkName(final String name) {
	   return QUIZ_SERVICE.checkName(name);
	}
	
   	public static boolean checkEmail(final String email) {
		return QUIZ_SERVICE.checkEmail(email);
	}
    
	public static boolean checkPassword(final String password) {
		return QUIZ_SERVICE.checkPassword(password);
	}
	
	public static boolean signUpInsert(final int choice, final User user) {
		return QUIZ_DAO_SERVICE.signUpInsert(choice, user);
	}
	
	public static boolean checkEmail(int choice, String email) {
		return QUIZ_DAO_SERVICE.checkEmail(choice, email);
	}
	
	public static boolean checkPassword(int choice, String password) {
		return QUIZ_DAO_SERVICE.checkPassword(choice, password);
	}
	
	public static void adminServices() {
		AdminView.adminServices();
	}
	
	public static boolean questionInsert(final int choice, final Quiz QuizTools) {
		return QUIZ_DAO_SERVICE.questionInsert(choice, QuizTools);
	}
	
	public static boolean questionDelete(final int questionNumber) {
		return QUIZ_DAO_SERVICE.questionDelete(questionNumber);
	}

	public static void userServices(final String email) {
		UserView.userServices(email);
	}

	public static List<Quiz> getRoundDetails(int level) {
		return QUIZ_DAO_SERVICE.getRoundDetails(level);
	}

	public static boolean markInsert(int mark, final String email) {
		return QUIZ_DAO_SERVICE.markInsert(mark, email);
	}

	public static boolean checkQuestionNumber(int choice, int questionNumber) {
		return QUIZ_DAO_SERVICE.checkQuestionNumber(choice, questionNumber);
	}

	public static boolean checkCorrectAnswer(String correctAnswer) {
		return QUIZ_DAO_SERVICE.checkAnswer(correctAnswer);
	}

	public static boolean checkFirstOption(String firstOption) {
		return QUIZ_DAO_SERVICE.checkFirstOption(firstOption);
	}
	
	public static boolean checkSecondOption(String secondOption) {
		return QUIZ_DAO_SERVICE.checkSecondOption(secondOption);
	}
	
	public static boolean checkThirdOption(String thirdOption) {
		return QUIZ_DAO_SERVICE.checkThirdOption(thirdOption);
	}
	
	public static boolean checkFourthOption(String fourthOption) {
		return QUIZ_DAO_SERVICE.checkFourthOption(fourthOption);
	}
}
