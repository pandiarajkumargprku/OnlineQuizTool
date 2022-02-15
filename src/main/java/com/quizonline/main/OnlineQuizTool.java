package com.quizonline.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.quizonline.view.AdminView;
import com.quizonline.view.QuizDetail;
import com.quizonline.view.UserView;

/**
 * <h1> OnlineQuizTool </h1>
 * 
 * <p>
 *    The onlineQuizTool Application in which admin
 *    maintains the questions for quiz so that user can signUp and signIn to take
 *    three level online Quiz. 
 * </p>
 * 
 *  @author PandiarajkumarG
 */
public class OnlineQuizTool {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(OnlineQuizTool.class); 
   
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final Properties properties = new Properties();
		
		properties.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(properties);
		LOGGER.info("Online Quiz Application");
		checkAdminOrUser();
	}
	
	/**
	 * Check admin or user.
	 */
	public static void checkAdminOrUser() {
	    LOGGER.info("Choose 1.Admin 2.User");
		
		try {
			int choice = Integer.parseInt(QuizDetail.getChoice());
		   
			switch (choice) {
	        case 1:
		        AdminView.admin(choice);
		        break;
		    case 2:
		        UserView.user(choice);
		        break;
	        default:
		        LOGGER.error("Enter valid number [1-2]");
		        checkAdminOrUser();
	        }
		} catch(NumberFormatException exception) {
			LOGGER.error("Re-Enter valid choice");
			checkAdminOrUser();
		}
	}		
}
