package com.quizonline.view;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.Quiz;

/**
 * Admin View
 * 
 * @author PandiarajkumarG
 */
public class AdminView {
	
	private static final Logger LOGGER = Logger.getLogger(AdminView.class); 
	   
	/**
	 * validate New Admin or not.
	 */
	public static void admin(final int choice) {
		LOGGER.info("Are you new Admin (yes / no) ?");
		final String isNewAdmin = OnlineQuizTool.SCANNER.nextLine().trim();
	
		if ("yes".equalsIgnoreCase(isNewAdmin)) {
			QuizDetail.signUp(choice);
		} else if ("no".equalsIgnoreCase(isNewAdmin)) {
			QuizDetail.signIn(choice);
		} else {
			System.out.println("Pls Enter Yes or No only");
			admin(choice);
		}
    }
	
	/**
	 * which makes use of all services such as Insert, Update and Delete.
	 * 
	 */
	public static void adminServices() {
		int choice = 0;
		LOGGER.info("1.Insert \n2.Update \n3.Delete \nEnter Your Choice");
    
	    try {
	    	choice = Integer.parseInt(QuizDetail.getChoice());
		    
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
	 * insert Question
	 */
	private static void insertQuestion(int choice) {
		final int questionNumber = QuizDetail.getQuestionNumber(choice);
		boolean isQuestionNumber = QuizController.checkQuestionNumber(choice, questionNumber);
		
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
	 * insert in the question into database 
	 */
    public static boolean insertQuestions(final int choice, int questionNumber) {
    	boolean isInsert = true;
	
		final String questions = QuizDetail.getQuestions();
		final String firstOption = QuizDetail.getFirstOption();
		final String secondOption = QuizDetail.getSecondOption();
		final String thirdOption = QuizDetail.getThirdOption();
		final String fourthOption = QuizDetail.getFourthOption();
		final String correctAnswer = QuizDetail.getCorrectAnswer();
		final Quiz QuizTools = new Quiz(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
		
		isInsert = QuizController.questionInsert(choice, QuizTools);
		    
		if (isInsert && choice == 1) {
	        LOGGER.info("Successfully Inserted");
			AdminView.isContinue();
	    } else if (!isInsert && choice == 1){
			LOGGER.info("Inserted failed");
			AdminView.isContinue();
		} 
		return isInsert;
    }
    
    /**
     * continue or not 
     */
	private static void isContinue() {
		LOGGER.info("Do you Want to continue ? (Yes /No)");
		String isContinue =  OnlineQuizTool.SCANNER.nextLine().trim();
		
		if ("yes".equalsIgnoreCase(isContinue)) {
			adminServices();
		} else if ("no".equalsIgnoreCase(isContinue)) {
			LOGGER.info("....");
		}
	}

	/**
     * update in the question into database
     */
	public static void updateQuestion(final int choice, int questionNumber) {
	    boolean isUpdate= AdminView.insertQuestions(choice, questionNumber);
	    
	    if (isUpdate) {
	    	LOGGER.info("Successfully updated");
	    	AdminView.isContinue();
	    } else {
	    	LOGGER.error("updated Failed");
	    	AdminView.isContinue();
	    }
	}
	
	/**
	 * delete in the question into database 
	 */
	public static void deleteQuestion(int choice, int questionNumber) {
		boolean isQuestion = QuizController.questionDelete(questionNumber);
		
		if (isQuestion) {
			LOGGER.info("Successfully deleted");
			AdminView.isContinue();
		} else {
			LOGGER.error("Deleted Failed");
			AdminView.isContinue();
		}
	}
}
