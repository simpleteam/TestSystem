package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="kind")
	private String kind;
	
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Answer> answers;
	
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<TrueAnswer> trueAnswers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<TrueAnswer> getTrueAnswers() {
		return trueAnswers;
	}

	public void setTrueAnswers(Set<TrueAnswer> trueAnswers) {
		this.trueAnswers = trueAnswers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", kind="
				+ kind + ", answers=" + answers + ", trueAnswers="
				+ trueAnswers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + id;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((trueAnswers == null) ? 0 : trueAnswers.hashCode());
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
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (id != other.id)
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (trueAnswers == null) {
			if (other.trueAnswers != null)
				return false;
		} else if (!trueAnswers.equals(other.trueAnswers))
			return false;
		return true;
	}
	
}
