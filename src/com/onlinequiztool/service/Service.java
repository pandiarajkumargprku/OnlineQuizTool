package com.onlinequiztool.service;

public interface Service {
    String checkName(final String name);
    
    String checkEmail(final String email);
    
    String checkPassword(final String password);
    
    void signUpDataInsert(final int choice, final String name, final String email, final String password);
    
    void signInDataInsert(final int choice, final String email, final String password);
    
    void questionInsertService(final int choice, final int questionNumber, final String questions, final String firstOption, final String secondOption, final String thirdOption, final String fourthOption, final String correctAnswer);
    
    void questionDeleteService(final int questionNumber);
}
