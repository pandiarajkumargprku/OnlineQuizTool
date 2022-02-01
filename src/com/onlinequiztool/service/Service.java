package com.onlinequiztool.service;

public interface Service {
    String checkName(String name);
    
    String checkEmail(String email);
    
    String checkPassword(String password);
    
    void signUpDataInsert(final int choice, final String name, final String email, final String password);
    
    void signInDataInsert(final int choice, final String email, final String password);
    
    void questionInsertService(int choice, int questionNumber, String questions, String firstOption, String secondOption, String thirdOption, String fourthOption, String correctAnswer);
    
    void questionDeleteService(int questionNumber);
}
