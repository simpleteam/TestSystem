package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="trueAnswer")
public class TrueAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@Column(name="trueAnswer")
	private String trueAnswer;
	
	@ManyToOne
	@JoinColumn(name="question")
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((trueAnswer == null) ? 0 : trueAnswer.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrueAnswer other = (TrueAnswer) obj;
		if (trueAnswer == null) {
			if (other.trueAnswer != null)
				return false;
		} else if (!trueAnswer.toLowerCase().equals(other.trueAnswer.toLowerCase()))
			return false;
		return true;
	}
	
}
