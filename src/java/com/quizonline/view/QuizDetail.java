package com.quizonline.view;

import org.apache.log4j.Logger;

import com.quizonline.controller.QuizController;
import com.quizonline.main.OnlineQuizTool;
import com.quizonline.model.User;

/**
 *Quiz View
 * 
 * @author PandiarajkumarG
 */
public class QuizDetail {
	
	private static final Logger LOGGER = Logger.getLogger(QuizDetail.class);
	
	/**
	 * getchoice
	 */
	public static String getChoice() {
		String choice = OnlineQuizTool.SCANNER.nextLine().trim();
		
		return choice;
	}
    
	/**
     * Get Name to the user
     */
	public static String getName() {
		LOGGER.info("Enter name:");
	    final String name =OnlineQuizTool.SCANNER.nextLine().trim();
		boolean isNameValid =  QuizController.checkName(name);
		
		if (!isNameValid) {
            LOGGER.error("Pls Re-Enter Valid Name");
			return QuizDetail.getName();
		}
		return name;
	}
	
	/**
	 * Get Email to the user
	 */
	public static String getEmail() {
		LOGGER.info("Enter email:");
		final String email = OnlineQuizTool.SCANNER.nextLine().trim();
		boolean isEmailValid = QuizController.checkEmail(email);
		
		if(!isEmailValid) {
			 LOGGER.error("Pls Re-Enter Valid EmailId");
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
		boolean isPasswordValid =  QuizController.checkPassword(password);
		
		if(!isPasswordValid) {
			LOGGER.error("Pls Re-Enter Valid Password \n(Atleast one Numeric letter, special Characters, Uppercase & lowercase letter)");
			return QuizDetail.getPassword();
		}
		return password;
	}
    
	/**
     * Get QustionNumber to the user
     */
	public static int getQuestionNumber(int choice) {
		LOGGER.info("Enter question number");
		int questionNumber = 0;
		
		try {
			questionNumber = Integer.parseInt(OnlineQuizTool.SCANNER.nextLine());
			
		} catch(NumberFormatException e) {
			 LOGGER.error("Pls Re-Enter valid QuestionNumber");
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
		boolean isFirstOptionCorrect =  QuizController.checkFirstOption(firstOption);
		
		if(!isFirstOptionCorrect) {
			 LOGGER.error("Plese Re-Enter first option e.g[a.india]");
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
        boolean isSecondOptionCorrect =  QuizController.checkSecondOption(secondOption);
		
		if(!isSecondOptionCorrect) {
			 LOGGER.error("Plese Re-Enter Second option e.g[b.india]");
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
        boolean isThirdOptionCorrect =  QuizController.checkThirdOption(thirdOption);
		
		if(!isThirdOptionCorrect) {
			 LOGGER.error("Plese Re-Enter third option e.g[c.india]");
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
        boolean isFourthOptionCorrect =  QuizController.checkFourthOption(fourthOption);
		
		if(!isFourthOptionCorrect) {
			 LOGGER.error("Plese Re-Enter fourth option e.g[d.india]");
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
	    boolean isAnswerValid =  QuizController.checkCorrectAnswer(correctAnswer);
		
	    if(!isAnswerValid) {
	    	 LOGGER.error("Pls Re-Enter Correct Answer [a,b,c or d]");
	    	return QuizDetail.getCorrectAnswer();
	    }
		return correctAnswer;
	}
	
	/**
	 * check email
	 */
	private static String getEmailCheck(int choice) {
		final String email = QuizDetail.getEmail();
		boolean isEmailValid = QuizDetail.checkEmail(choice, email);
		
		if (isEmailValid) {
			 LOGGER.error("This Mail Id Already Exists \nPlease Re-Enter Mail Id");
			return QuizDetail.getEmailCheck(choice);
		}
		return email;
	}
	
	/**
	 * get signUp detail
	 */
	public static void signUp(final int choice) {
		final String name = QuizDetail.getName();
		final String email = QuizDetail.getEmailCheck(choice);
		final String password = QuizDetail.getPassword();
		
		User user = new User(name, email, password);
		boolean isSignUp = QuizController.signUpInsert(choice, user);
		
		if (isSignUp) {
			 LOGGER.info("Successfuly SignUp");
			isContinue(choice);
		} else {
			 LOGGER.error("SignUp failed");
			signUp(choice);
		}
	}
	
	/**
	 * continue or not
	 */
	private static void isContinue(int choice) {
		LOGGER.info("Do You Want to continue");
		String isContinue = OnlineQuizTool.SCANNER.nextLine();
		
		if("yes".equalsIgnoreCase(isContinue)) {
			signIn(choice);
		} else if("no".equalsIgnoreCase(isContinue)) {
			System.out.println("...");
		}
	}

	/**
	 * get password then check password
	 */
	private static boolean getPasswordCheck(int choice) {
		final String password = QuizDetail.getPassword();
		boolean isPasswordValid = QuizDetail.checkPassword(choice, password);
		
		if(!isPasswordValid) {
			 LOGGER.error("Passwowrd is Wrong");
			QuizDetail.getPasswordCheck(choice);
		}
		return isPasswordValid;
	}
	
	/**
	 * Method which makes SignIn function
	 */
	public static void signIn(final int choice) {
		final String email = QuizDetail.getUserEmailCheck(choice);
		final boolean passwordValid = QuizDetail.getPasswordCheck(choice);
		
		if (passwordValid) {
			 LOGGER.info("Successfully signIn");
			QuizDetail.Services(choice, email);
			
		} else {
			 LOGGER.error("SignIn Failed");
			QuizDetail.signIn(choice);
			
		}
	}
	
	/**
	 * get User email then email check 
	 */
	private static String getUserEmailCheck(int choice) {
		final String email = QuizDetail.getEmail();
		boolean isEmailValid = QuizDetail.checkEmail(choice, email);
		
		if (!isEmailValid) {
			 LOGGER.error("Email is wrong");
			QuizDetail.getUserEmailCheck(choice);
		}
		return email;
	}

	/**
	 * check password
	 */
	private static boolean checkPassword(int choice, String password) {
		boolean isPassword = QuizController.checkPassword(choice, password);
		
		return isPassword;
		
	}

	/**
	 * check email
	 */
	private static boolean checkEmail(int choice, String email) {
		boolean isEmail = QuizController.checkEmail(choice, email);
        
		return isEmail;
	}
	
	/**
	 * services admin or user
	 */
	private static void Services(int choice, String email) {
		 
		if (choice == 1) {
			AdminView.adminServices();
		} else if (choice == 2) {
			UserView.userServices(email);
		}
	}
}
