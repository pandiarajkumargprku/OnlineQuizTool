package com.quizonline.view;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.User;

/**
 * <h1> Quiz View </h1>
 * 
 * @author PandiarajkumarG
 */
public class QuizDetail {
	
	private static final Logger LOGGER = Logger.getLogger(QuizDetail.class);
	
	/**
	 * Get choice from user
	 */
	public static String getChoice() {
	    return OnlineQuizTool.SCANNER.nextLine().trim();
	}
    
	/**
     * Get name to the user
     */
	public static String getName() {
		LOGGER.info("Enter name:");
	    final String name = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.validateName(name)) {
            LOGGER.warn("Re-Enter Valid Name");
			return QuizDetail.getName();
		}
		return name;
	}
	
	/**
	 * Get email to the user
	 */
	public static String getEmail() {
		LOGGER.info("Enter email:");
		final String email = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.validateEmail(email)) {
			LOGGER.warn("Re-Enter Valid EmailId");
		    return QuizDetail.getEmail();
		}
		return email;
	}
	
	/**
	 * Get password to the user
	 */
	public static String getPassword() {
		LOGGER.info("Enter password");
		final String password = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.validatePassword(password)) {
			LOGGER.warn("Re-Enter Valid Password \n(Atleast one Numeric letter, special Characters, Uppercase & lowercase letter)");
			return QuizDetail.getPassword();
		}
		return password;
	}
    
	/**
     * Get QustionNumber to the user
     */
	public static int getQuestionNumber(final int choice) {
		LOGGER.info("Enter question number");
		int questionNumber = 0;
		
		try {
			questionNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
			
		} catch(NumberFormatException exception) {
			LOGGER.warn("Re-Enter valid QuestionNumber");
			return QuizDetail.getQuestionNumber(choice);
		}
		return questionNumber;
	}
    
	/**
     * Get question to the user
     */
    public static String getQuestions() {
    	LOGGER.info("Enter Questions");
	    final String question = OnlineQuizTool.SCANNER.nextLine().trim();
		
	    return question;
	}
	
    /**
	 * Get firstOption to the user
	 */
	public static String getFirstOption() {
		LOGGER.info("Enter first option");
		final String firstOption = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.checkFirstOption(firstOption)) {
		    LOGGER.warn("Re-Enter first option e.g[a.india]");
			return QuizDetail.getFirstOption();
		}
		return firstOption;
	}
   
	/**
     * Get secondOption to the user
     */
	public static String getSecondOption() {
		LOGGER.info("Enter second option");
		final String secondOption = OnlineQuizTool.SCANNER.nextLine().trim();
       
		if (!QuizController.checkSecondOption(secondOption)) {
			LOGGER.warn("Re-Enter Second option e.g[b.india]");
			return QuizDetail.getSecondOption();
		}
		return secondOption;
	}
   
	/**
     * Get thirdOption to the user
     */
	public static String getThirdOption() {
		LOGGER.info("Enter third option");
		final String thirdOption = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.checkThirdOption(thirdOption)) {
			LOGGER.warn("Re-Enter third option e.g[c.india]");
			return QuizDetail.getThirdOption();
		}
		return thirdOption;
	}
   
	/**
     * Get fourthOption to the user
     */
	public static String getFourthOption() {
		LOGGER.info("Enter fourth option");
		final String fourthOption = OnlineQuizTool.SCANNER.nextLine().trim();
		
		if (!QuizController.checkFourthOption(fourthOption)) {
			LOGGER.warn("Re-Enter fourth option e.g[d.india]");
			return QuizDetail.getFourthOption();
		}
		return fourthOption;
	}
	
	/**
	 * Get correctAnswer to the user
	 */
	public static String getCorrectAnswer() {
		LOGGER.info("Enter correctanswer");
	    final String correctAnswer = OnlineQuizTool.SCANNER.nextLine();
		
	    if (!QuizController.checkCorrectAnswer(correctAnswer)) {
	    	LOGGER.warn("Re-Enter Correct Answer [a, b, c, d]");
	    	return QuizDetail.getCorrectAnswer();
	    }
		return correctAnswer;
	}
	
	/**
	 * Get email from user
	 * 
	 * @param choice
	 */
	private static String getAdminEmailCheck(final int choice) {
		final String email = QuizDetail.getEmail();
		
		if (QuizController.checkEmail(choice, email)) {
			LOGGER.warn("This Mail Id Already Exists \nRe-Enter Mail Id");
			return QuizDetail.getAdminEmailCheck(choice);
		}
		return email;
	}
	
	/**
	 * Get signUp detail
	 * 
	 * @param choice
	 */
	public static void signUp(final int choice) {
		final String name = QuizDetail.getName();
		final String email = QuizDetail.getAdminEmailCheck(choice);
		final String password = QuizDetail.getPassword();
		final User user = new User(name, email, password);
		
		if (QuizController.signUpInsert(choice, user)) {
			 LOGGER.info("Successfuly SignUp");
			 checkContinue(choice);
		} else {
			 LOGGER.error("SignUp failed");
			 signUp(choice);
		}
	}
	
	/**
	 * Checks continue 
	 * 
	 * @param choice
	 */
	private static void checkContinue(final int choice) {
		LOGGER.info("Do You Want to continue");
		final String isContinue = OnlineQuizTool.SCANNER.nextLine();
		
		if ("yes".equalsIgnoreCase(isContinue)) {
			signIn(choice);
		} else if ("no".equalsIgnoreCase(isContinue)) {
			LOGGER.info("...");
		} else {
			checkContinue(choice);
		}
	}

	/**
	 * Get password then check password
	 * 
	 * @param choice
	 */
	private static boolean getPasswordCheck(final int choice) {
		final String password = QuizDetail.getPassword();
		final boolean isValidPassword = QuizController.checkPassword(choice, password);
		
		if (!isValidPassword) {
			LOGGER.warn("Passwowrd is Wrong");
			QuizDetail.getPasswordCheck(choice);
		}
		return isValidPassword;
	}
	
	/**
	 * Which makes signIn function
	 * 
	 * @param choice
	 */
	public static void signIn(final int choice) {
		final String email = QuizDetail.getUserEmailCheck(choice);
		final boolean isValidPassword = QuizDetail.getPasswordCheck(choice);
		
		if (isValidPassword) {
		    LOGGER.info("Successfully signIn");
			QuizDetail.Services(choice, email);
		} else {
			LOGGER.error("SignIn Failed");
			QuizDetail.signIn(choice);
		}
	}
	
	/**
	 * Get user email then email check
	 * 
	 *  @param choice
	 */
	private static String getUserEmailCheck(int choice) {
		final String email = QuizDetail.getEmail();
		
		if (!QuizController.checkEmail(choice, email)) {
			LOGGER.warn("Email is wrong");
			QuizDetail.getUserEmailCheck(choice);
		}
		return email;
	}

	/**
	 * Services admin or user
	 * 
	 * @param choice
	 * @param email
	 */
	private static void Services(final int choice,final String email) {
		 
		if (choice == 1) {
			AdminView.adminServices();
		} else if (choice == 2) {
			UserView.userServices(email);
		}
	}
}
