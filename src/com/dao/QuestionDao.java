package com.dao;

import java.util.List;

import com.entity.Question;


public interface QuestionDao {

	public void addQuestion(Question question);
	
	public List<Question> getAllQuestion();
	
	public Question getQuestion(int id);
	
	public void deleteQuestion(Question question);
	
}
