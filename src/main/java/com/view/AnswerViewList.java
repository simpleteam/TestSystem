package com.view;

import java.util.Arrays;

public class AnswerViewList {

	private AnswerView[] answerViews;
	
	public AnswerView[] getAttribs() {
		return answerViews;
	}

	public void setAttribs(AnswerView[] attribs) {
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
