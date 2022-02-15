package com.quizonline.view;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;

/**
 * <h1> Admin View </h1>
 * 
 * @author PandiarajkumarG
 */
public class AdminView {
	
	private static final Logger LOGGER = Logger.getLogger(AdminView.class); 
	   
	/**
	 * Validate new admin or not.
	 * 
	 * @param choice
	 */
	public static void admin(final int choice) {
		LOGGER.info("Are you new Admin (yes / no) ?");
		final String isNewAdmin = OnlineQuizTool.SCANNER.nextLine().trim();
	
		if ("yes".equalsIgnoreCase(isNewAdmin)) {
			QuizDetail.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewAdmin)) {
			QuizDetail.signIn(choice);
		} else {
			System.out.println("Enter Yes or No only");
			admin(choice);
		}
    }
	
	/**
	 * Which makes use of all services such as Insert, Update and Delete.
	 * 
	 */
	public static void adminServices() {
		LOGGER.info("1.Insert \n2.Update \n3.Delete \nEnter Your Choice");
    
	    try {
	    	int choice = Integer.parseInt(QuizDetail.getChoice());
		    
	        if(choice == 1) {
	    	    AdminView.insertQuestion(choice);
	        } else if(choice == 2) {
	    	    AdminView.insertQuestion(choice);
	        } else if(choice == 3) {
	    	    AdminView.insertQuestion(choice);
	        } else {
	    	    System.out.println("Enter number only [1-3]");
	    	    AdminView.adminServices();
	        }
	    } catch(NumberFormatException e) {
	    	LOGGER.error("Enter the valid Input");
	    	AdminView.adminServices();
	    }
	}
	
	/**
	 * Question insert
	 * 
	 * @param choice
	 */
	private static void insertQuestion(int choice) {
		final int questionNumber = QuizDetail.getQuestionNumber(choice);
		final boolean isQuestionNumber = QuizController.checkQuestionNumber(choice, questionNumber);
		
		if (!isQuestionNumber && choice == 1) {
			AdminView.insertQuestions(choice, questionNumber);
		} else if (!isQuestionNumber && choice == 2) {
			AdminView.updateQuestion(choice, questionNumber);
		} else if (!isQuestionNumber && choice == 3) {
			AdminView.deleteQuestion(choice, questionNumber);
		} else if (isQuestionNumber && choice == 1 ) {
			LOGGER.error("QuestionNumber is ALready exists");
			AdminView.insertQuestion(choice);
		} else if(isQuestionNumber) {
			LOGGER.error("Question NUmber is not found");
			AdminView.insertQuestion(choice);
		}
	}
	
	/**
	 * Insert in the question into database 
	 * 
	 * @param choice
	 * @param questionNumber
	 */
    public static boolean insertQuestions(final int choice, int questionNumber) {
		final String questions = QuizDetail.getQuestions();
		final String firstOption = QuizDetail.getFirstOption();
		final String secondOption = QuizDetail.getSecondOption();
		final String thirdOption = QuizDetail.getThirdOption();
		final String fourthOption = QuizDetail.getFourthOption();
		final String correctAnswer = QuizDetail.getCorrectAnswer();
		final Quiz QuizTools = new Quiz(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
		final boolean isInserted = QuizController.questionInsert(choice, QuizTools);
		    
		if (isInserted && choice == 1) {
	        LOGGER.info("Successfully Inserted");
			getIsContinue();
	    } else if (!isInserted && choice == 1){
			LOGGER.info("Insertion failed");
			getIsContinue();
		} 
		return isInserted;
    }
    
    /**
     * Continue or not 
     */
	private static void getIsContinue() {
		LOGGER.info("Do you Want to continue ? (Yes /No)");
		final String isContinue =  OnlineQuizTool.SCANNER.nextLine().trim();
		
		if ("yes".equalsIgnoreCase(isContinue)) {
			adminServices();
		} else if ("no".equalsIgnoreCase(isContinue)) {
			LOGGER.info("....");
		}
	}

	/**
     * Update in the question into database
     */
	public static void updateQuestion(final int choice, int questionNumber) {
	    final boolean isUpdated = AdminView.insertQuestions(choice, questionNumber);
	    
	    if (isUpdated) {
	    	LOGGER.info("Successfully updated");
	    	getIsContinue();
	    } else {
	    	LOGGER.error("updated Failed");
	    	getIsContinue();
	    }
	}
	
	/**
	 * Delete in the question into database 
	 */
	public static void deleteQuestion(int choice, int questionNumber) {
		final boolean isQuestionPresent = QuizController.questionDelete(questionNumber);
		
		if (isQuestionPresent) {
			LOGGER.info("Successfully deleted");
			getIsContinue();
		} else {
			LOGGER.error("Deleted Failed");
			getIsContinue();
		}
	}
}
