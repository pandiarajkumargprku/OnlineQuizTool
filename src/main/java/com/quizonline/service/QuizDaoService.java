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

	boolean insertSignUpDetail(final int choice, final User user);
	
    boolean questionInsert(final int choice, final Quiz quizTools);
    
    boolean questionDelete(final int questionNumber);

	List<Quiz> getRoundDetails(final int level);
	
	boolean markInsert(final int mark, final String email);
	
	boolean checkEmail(final int choice, final String email);

	boolean checkPassword(final int choice, final String password);

	boolean checkQuestionNumber(final int choice, final int questionNumber);

	boolean checkAnswer(final String correctAnswer);

	boolean checkFirstOption(final String firstOption);

	boolean checkSecondOption(final String secondOption);

	boolean checkThirdOption(final String thirdOption);

	boolean checkFourthOption(final String fourthOption);
}
