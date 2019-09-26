package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.dto.AnswerDto;
import com.dto.AnswerListDto;
import com.entity.Answer;
import com.entity.Question;
import com.entity.TrueAnswer;


@Component
public class Helper {

	public AnswerListDto convertQuestionsToModelAttribute(List<Question> questions){
		AnswerListDto attribute = new AnswerListDto();
		AnswerDto[] answers = new AnswerDto[questions.size()]; 
		for(int i = 0 ; i < questions.size() ; i++){
			answers[i] = new AnswerDto();
			answers[i].setQuestion(questions.get(i));
			answers[i].setAnswers(fill(questions.get(i).getTrueAnswers().size()));
		}
		attribute.setAttribs(answers);
		return attribute;
	}
	
	public List<Question> convertModelAttributeToQuestions(AnswerListDto attribute){
		List<Question> questions = new ArrayList<>();
		for(AnswerDto answer : attribute.getAttribs()){
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
