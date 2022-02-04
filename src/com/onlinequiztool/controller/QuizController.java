package com.onlinequiztool.controller;

import com.onlinequiztool.main.OnlineQuizTool;
import com.onlinequiztool.model.Quiz;
import com.onlinequiztool.service.Service;
import com.onlinequiztool.service.ServiceImplements;
import com.onlinequiztool.view.ViewPage;

/**
 * <h1>QuizController</h1> The QuizController all the request and response the Controller
 * @author PandiarajkumarG
 *
 */
public class QuizController {
    private static final Service QUIZ_SERVICE = new ServiceImplements();
   
   	public static String checkName(final String name) {
	   return QUIZ_SERVICE.checkName(name);
	}
	
   	public static String checkEmail(final String email) {
		return QUIZ_SERVICE.checkEmail(email);
	}
    
	public static String checkPassword(final String password) {
		return QUIZ_SERVICE.checkPassword(password);
	}
	
	public static void signUpTableInsert(final int choice, final String name, final String email, final String password) {
		QUIZ_SERVICE.signUpValidation(choice, name, email, password);
	}
	
	public static void signInTableInsert(final int choice, final String email, final String password) {
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
	
	public static void questionInsertController(final int choice, Quiz QuizTools) {
		QUIZ_SERVICE.questionInsertService(choice, QuizTools);
	}
	
	public static void questionDeleteController(final int questionNumber) {
		QUIZ_SERVICE.questionDeleteService(questionNumber);
	}
}
