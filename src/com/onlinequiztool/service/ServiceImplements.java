package com.onlinequiztool.service;

import com.onlinequiztool.controller.QuizController;
import com.onlinequiztool.dao.QuizDao;
import com.onlinequiztool.main.OnlineQuizTool;


public class ServiceImplements implements Service {
    public static final QuizDao QUIZDAO = new QuizDao();
    
	public String checkName(final String name) {
		
		if(!name.matches("^[A-Z]{1}[A-Za-z\s]{1,}$")) {
			System.out.println("Invalid Name");
			return QuizController.getName();
		}
		return name;
	}

	public String checkEmail(final String email) {
		
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Inavlid EmailId");
			return QuizController.getEmail();
		}
		return email;
	}

	public String checkPassword(final String password) {
		
		if(!password.matches("((?=\\S+$)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")) {
			System.out.println("Invalid Password");
			return QuizController.getPassword();
		}
		return password;
	}
	
	public void signUpDataInsert(final int choice, final String name, final String email, final String password) {
		
		if(choice == 1) {
			QUIZDAO.adminSignUpInserted(name, email, password);
		} else if(choice == 2) {
			QUIZDAO.userSignUpInserted(name, email, password);
		}
	}
	
    public void signInDataInsert(final int choice, final String email, final String password) {
		
    	if(choice == 1) {
    		QUIZDAO.adminSignInInserted(email, password);
    	} else if(choice == 2) {
    		QUIZDAO.userSignInInserted(email, password);
    	}
	}
    
    public void questionInsertService(int choice, int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer) {
    	
    	if(choice == 1) {
    		System.out.println("Which round to you inserted ?");
    		int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    		
    	    if(roundNumber == 1) {
    	    	QUIZDAO.firstRoundInserted(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    	    } else if(roundNumber == 2)	{
    			QUIZDAO.secondRoundInserted(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    	    } else if(roundNumber == 3) {
    			QUIZDAO.thirdRoundInserted(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    	    }
    	} else if(choice == 2) {
    		System.out.println("which round to you updated ?");
    		int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    		
    		if(roundNumber ==1) {
    			QUIZDAO.firstRoundUpdated(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    		} else if(choice ==2) {
    			QUIZDAO.secondRoundUpdated(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    		} else if(roundNumber == 3) {
    			QUIZDAO.thirdRoundUpdated(questionNumber, questions, firstOption, secondOption, thirdOption, fourthOption, correctAnswer);
    		}
    	}
    }
    
    public void questionDeleteService(int questionNumber) {
    	System.out.println("which round to ypu delete ?");
    	int roundNumber = OnlineQuizTool.SCANNER.nextInt();
    	
    	if(roundNumber == 1) {
    		
    	}
    }
}
