package com.view;

import java.util.Arrays;

import com.entity.Answer;
import com.entity.Question;

public class AnswerView {

	private Question question;
	private Answer[] answers;
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Answer[] getAnswers() {
		return answers;
	}
	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "AnswerAttrib [question=" + question + ", answers="
				+ Arrays.toString(answers) + "]";
	}
	
}
