package com.quizonline.view;

import java.util.List;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;

/**
 * <h1> User View </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public class UserView {
	
	private static final Logger LOGGER = Logger.getLogger(UserView.class);
	
	/**
	 * User validation
	 * 
	 * @param choice
	 */
	public static void user(final int choice) {
	    LOGGER.info("Are you new User ? (yes /no)");
		final String isNewUser = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if ("yes".equalsIgnoreCase(isNewUser)) {
			QuizDetail.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewUser)) {
			QuizDetail.signIn(choice);
		} else {
			LOGGER.warn("Enter Yes or No only");
			user(choice);
		}
	}
	
	/**
	 * User services
	 * 
	 * @param email
	 */
	public static void userServices(final String email) {
		int mark = 0;
		int level = 1;

		levelDetails(mark, level, email);
	}
	
	/**
	 * Level details 
	 * 
	 * @param mark
	 * @param level
	 * @param email
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
		
		for (int index = 0;index<details.size();index++) {
		    Quiz questionAnswer = details.get(index);
		    LOGGER.info(questionAnswer);
		    String answer = QuizDetail.getCorrectAnswer();
            mark = Validation.markCalculation(mark, answer, questionAnswer.getCorrectAnswer());
        }
		System.out.println("Your Score is" + mark);
		boolean isPass = Validation.checkMark(mark, email);
	    
		if (!isPass) {
			LOGGER.info("your score is below average");
			LOGGER.info("Do you Want to COntinue");
			checkContinue();
		} else if (isPass) {
			level = level+1;
			
			if (level <= lastLevel) {
				levelDetails(mark, level, email);
			} else {
				markInsert(mark, email);
			}
		} 
	}
	
	/**
	 * Continue or not
	 * 
	 */
	private static void checkContinue() {
		LOGGER.info("Do You Want to continue");
		String isContinue = OnlineQuizTool.SCANNER.nextLine();
		
		if ("yes".equalsIgnoreCase(isContinue)) {
			OnlineQuizTool.checkAdminOrUser();
		} else if ("no".equalsIgnoreCase(isContinue)) {
			LOGGER.info("Thank You for Attend the Quiz");
		}
	}

	/**
	 *  Mark insert into dataBase
	 *  
	 *  @param mark
	 *  @param email
	 */
	public static void markInsert(int mark, final String email) {
		boolean isMarkUpdated = QuizController.markInsert(mark, email);
		
		if (isMarkUpdated) {
			LOGGER.info("Your mark was Updated Successfully");
		} else {
			LOGGER.warn("Check your EMail");
		}
	}
}
