package com.dto;

import java.util.Arrays;

public class AnswerListDto {

	private AnswerDto[] answerViews;
	
	public AnswerDto[] getAttribs() {
		return answerViews;
	}

	public void setAttribs(AnswerDto[] attribs) {
		this.answerViews = attribs;
	}
	
	public String size(){
		return String.valueOf(answerViews.length);
	}

	@Override
	public String toString() {
		return "AnsAttr [attribs=" + Arrays.toString(answerViews) + "]";
	}
	
}
