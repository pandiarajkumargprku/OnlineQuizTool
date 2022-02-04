package com.onlinequiztool.controller;

import com.onlinequiztool.main.OnlineQuizTool;

import com.onlinequiztool.service.Service;
import com.onlinequiztool.service.ServiceImplements;
import com.onlinequiztool.view.ViewPage;

public class QuizController {
    private static final Service QUIZSERVICE = new ServiceImplements();
    
   	public static String checkName(String name) {
	   return QUIZSERVICE.checkName(name);
	}

	public static String checkEmail(String email) {
		return QUIZSERVICE.checkEmail(email);
	}

	public static String checkPassword(String password) {
		return QUIZSERVICE.checkPassword(password);
	}
	
	public static void signUpController(final int choice, final String name, final String email, final String password) {
		QUIZSERVICE.signUpDataInsert(choice, name, email, password);
	}
	
	public static void signInController(final int choice, final String email, final String password) {
		QUIZSERVICE.signInDataInsert(choice, email, password);
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
	
	public static void adminCrudOperations() {
		OnlineQuizTool.crudOperation();
	}
	
	public static void questionInsertController(int choice, int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
		QUIZSERVICE.questionInsertService(choice, questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
	}
	
	public static void questionDeleteController(int questionNumber) {
		QUIZSERVICE.questionDeleteService(questionNumber);
	}
}
