package com.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dao.QuestionDao;
import com.entity.Question;


@Service
@Scope("prototype")
public class Exam {

	private static final Logger log = Logger.getLogger(Exam.class);
	
	@Autowired
	private QuestionDao questionDao;
	private int result = 0;
	private List<Question> questions;
	private List<Question> answers;
	
	public List<Question> getTasks(){
		log.debug("get tasks");
		questions = questionDao.getAllQuestion();
		Collections.shuffle(questions);
		questions = questions.subList(0, 5);
		return questions;
	}
	
	public void setAnswers(List<Question> answers){
		log.debug("set answers");
		clear();
		this.answers = answers;
	}
	
	private void clear(){
		result = 0;
	}
	
	public int getResult(){
		log.debug("get result");
		for(int i = 0 ; i < questions.size() ; i++){	
			if(questions.get(i).getTrueAnswers().equals(answers.get(i).getTrueAnswers())){
				result++;
			}
		}
		return result;
	}
	
}
