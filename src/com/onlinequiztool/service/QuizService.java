package com.onlinequiztool.service;

import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.customexception.CustomException.mailIdNotFoundException;

public interface QuizService {
    String checkName(final String name);
    
    String checkEmail(final String email);
    
    String checkPassword(final String password);
    
    void signUpValidation(final int choice, final String name, final String email, final String password) throws mailIdNotFoundException;
    
    void signInValidation(final int choice, final String email, final String password) throws AccessFailedException;
}
