package com.onlinequiztool.dao;

import java.util.ArrayList;

import com.onlinequiztool.customexception.CustomException.AccessFailedException;
import com.onlinequiztool.model.Quiz;

public interface QuizServiceDao {
    void questionInsert(final int choice, Quiz quizTools);
    
    void questionDelete(final int questionNumber);

	ArrayList getRoundDetails(int level) throws AccessFailedException;
	
	boolean markInsert(int mark, String email);
	
}
