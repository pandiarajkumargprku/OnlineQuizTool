package com.onlinequiztool.controller;

import java.util.ArrayList;

import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;
import com.onlinequiztool.dao.QuizDaoServiceImplements;
import com.onlinequiztool.dao.QuizServiceDao;
import com.onlinequiztool.main.OnlineQuizTool;
import com.onlinequiztool.model.Quiz;
import com.onlinequiztool.service.QuizService;
import com.onlinequiztool.service.QuizServiceImplements;
import com.onlinequiztool.view.ViewPage;

/**
 * <h1>QuizController</h1> 
 * <p>
 * </p>
 * 
 * @author PandiarajkumarG
 */
public class QuizController {
    private static final QuizService QUIZ_SERVICE = new QuizServiceImplements();
    private static final QuizServiceDao QUIZ_DAO_SERVICE = new QuizDaoServiceImplements();
   
   	public static String checkName(final String name) {
	   return QUIZ_SERVICE.checkName(name);
	}
	
   	public static String checkEmail(final String email) {
		return QUIZ_SERVICE.checkEmail(email);
	}
    
	public static String checkPassword(final String password) {
		return QUIZ_SERVICE.checkPassword(password);
	}
	
	public static void signUpTableInsert(final int choice, final String name, final String email, final String password) throws mailIdNotFoundException {
		QUIZ_SERVICE.signUpValidation(choice, name, email, password);
	}
	
	public static void signInTableInsert(final int choice, final String email, final String password) throws AccessFailedException {
		QUIZ_SERVICE.signInValidation(choice, email, password);
	}
	
	public static String getName() {
		return ViewPage.getName();
	}
	
	public static String getEmail() {
		return ViewPage.getEmail();
	}
	
	public static String getPassword() {
		return ViewPage.getPassword();
	}
	
	public static void adminServices() {
		OnlineQuizTool.adminServices();
	}
	
	public static void questionInsert(final int choice, Quiz QuizTools) {
		QUIZ_DAO_SERVICE.questionInsert(choice, QuizTools);
	}
	
	public static void questionDelete(final int questionNumber) {
		QUIZ_DAO_SERVICE.questionDelete(questionNumber);
	}

	public static void userServices(String email) throws AccessFailedException {
		ViewPage.userServices(email);
	}

	public static ArrayList getRoundDetails(int level) throws AccessFailedException {
		return QUIZ_DAO_SERVICE.getRoundDetails(level);
	}

	public static boolean markInsert(int mark, String email) {
		return QUIZ_DAO_SERVICE.markInsert(mark, email);
	}
}
