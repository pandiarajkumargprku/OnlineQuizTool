package com.onlinequiztool.service;

import com.onlinequiztool.model.Quiz;

public interface Service {
    String checkName(final String name);
    
    String checkEmail(final String email);
    
    String checkPassword(final String password);
    
    void signUpValidation(final int choice, final String name, final String email, final String password);
    
    void signInValidation(final int choice, final String email, final String password);
    
    void questionInsertService(final int choice, Quiz quizTools);
    
    void questionDeleteService(final int questionNumber);
}
