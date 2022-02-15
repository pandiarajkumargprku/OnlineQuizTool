package com.quizonline.service;

/**
 * <h1> Quiz Service </h1>
 * 
 * @author PandiarajkumarG
 *
 */
public interface QuizService {
   
	boolean validateName(final String name);
    
    boolean validateEmail(final String email);
    
    boolean validatePassword(final String password);
}
