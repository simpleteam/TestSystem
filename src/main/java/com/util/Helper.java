package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.entity.Answer;
import com.entity.Question;
import com.entity.TrueAnswer;
import com.view.AnswerViewList;
import com.view.AnswerView;


@Component
public class Helper {

	public AnswerViewList convertQuestionsToModelAttribute(List<Question> questions){
		AnswerViewList attribute = new AnswerViewList();
		AnswerView[] answers = new AnswerView[questions.size()]; 
		for(int i = 0 ; i < questions.size() ; i++){
			answers[i] = new AnswerView();
			answers[i].setQuestion(questions.get(i));
			answers[i].setAnswers(fill(questions.get(i).getTrueAnswers().size()));
		}
		attribute.setAttribs(answers);
		return attribute;
	}
	
	public List<Question> convertModelAttributeToQuestions(AnswerViewList attribute){
		List<Question> questions = new ArrayList<>();
		for(AnswerView answer : attribute.getAttribs()){
			Question question= new Question();
			question.setId(answer.getQuestion().getId());
			question.setKind(answer.getQuestion().getKind());
			question.setQuestion(answer.getQuestion().getQuestion());
			question.setTrueAnswers(arrayToSet(answer.getAnswers()));
			questions.add(question);
		}
		return questions;
	}
	
	private Set<TrueAnswer> arrayToSet(Answer[] answers){
		Set<TrueAnswer> setOfAnswers = new HashSet<>();
		if(answers != null){
			for(Answer answer : answers){
				if(answer.getAnswer() != null){
					TrueAnswer trueAnswer = new TrueAnswer();
					trueAnswer.setTrueAnswer(answer.getAnswer());
					setOfAnswers.add(trueAnswer);
				}
			}
		}
		return setOfAnswers;
	}
	
	private Answer[] fill(int size){
		Answer[] answers = new Answer[size];
		Arrays.fill(answers, new Answer());
		return answers;
	}
	
}
