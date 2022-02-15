package com.quizonline.service;

import java.util.List;

import com.quizonline.model.Quiz;
import com.quizonline.model.User;

/**
 * <h1> Quiz Database Service </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public interface QuizDaoService {

	boolean signUpInsert(int choice, User user);
	
    boolean questionInsert(final int choice, Quiz quizTools);
    
    boolean questionDelete(final int questionNumber);

	List<Quiz> getRoundDetails(int level);
	
	boolean markInsert(int mark, final String email);
	
	boolean checkEmail(int choice, String email);

	boolean checkPassword(int choice, String password);

	boolean checkQuestionNumber(int choice, int questionNumber);

	boolean checkAnswer(String correctAnswer);

	boolean checkFirstOption(String firstOption);

	boolean checkSecondOption(String secondOption);

	boolean checkThirdOption(String thirdOption);

	boolean checkFourthOption(String fourthOption);
}
