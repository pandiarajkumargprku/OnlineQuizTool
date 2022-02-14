package com.quizonline.view;

import java.util.List;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;

/**
 *User View
 * 
 * @author PandiarajkumarG
 *
 */
public class UserView {
	
	private static final Logger LOGGER = Logger.getLogger(UserView.class);
	
	/**
	 * User Validation
	 */
	public static void user(final int choice) {
	    LOGGER.info("Are you new User ? (yes /no)");
		final String isNewUser = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if ("yes".equalsIgnoreCase(isNewUser)) {
			QuizDetail.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewUser)) {
			QuizDetail.signIn(choice);
		}else {
			LOGGER.info("Pls Enter Yes or No only");
			user(choice);
		}
	}
	
	/**
	 * user services
	 */
	public static void userServices(String email) {
		int mark = 0;
		int level = 1;

		levelDetails(mark, level, email);
	}
	
	/**
	 *questions,options and correctAnswer get from dataBase
	 */
	public static void levelDetails(int mark, int level, final String email) {
		int lastLevel = 3;
		
		LOGGER.info("Level"+level);
		LOGGER.info("Total Questions 5");
		LOGGER.info("Marks:2 Mark for each question");
		LOGGER.info("Negative Marks:1 mark per wrong answer");
		LOGGER.info("Start Quiz");
		LOGGER.info("Contents of the Table:");
		
		List<Quiz> details = QuizController.getRoundDetails(level);
		
		for(int index = 0;index<details.size();index++) {
		    Quiz questionAnswer = details.get(index);
		    LOGGER.info(questionAnswer);
		    LOGGER.info("Enter Answer");
		    String answer = OnlineQuizTool.SCANNER.next();
            mark = Validation.markCalculation(mark, answer, questionAnswer.getCorrectAnswer());
        }
		System.out.println("Your Score is" + mark);
		boolean isPass = Validation.checkMark(mark, email);
	    
		if (!isPass) {
			LOGGER.info("your score is below average");
		} else if (isPass) {
			level = level+1;
			if(level <= lastLevel) {
				levelDetails(mark, level, email);
			} else {
				markInsert(mark, email);
			}
		} 
	}

	/**
	 *  mark insert into DataBase
	 */
	public static void markInsert(int mark, final String email) {
		boolean isMarkUpdate = QuizController.markInsert(mark, email);
		
		if (isMarkUpdate) {
			System.out.println("Your mark was Updated Successfully");
		} else {
			System.out.println("Check your EMail");
		}
	}
}
