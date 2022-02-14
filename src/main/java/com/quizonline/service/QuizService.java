package com.quizonline.service;

public interface QuizService {
    boolean checkName(final String name);
    
    boolean checkEmail(final String email);
    
    boolean checkPassword(final String password);
}
