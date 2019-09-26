package com.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.QuestionDao;
import com.entity.Answer;
import com.entity.Question;
import com.entity.TrueAnswer;

@Component
public class QuestionInitializer {

	@Autowired
	private QuestionDao questionDao;

	private List<Question> list = new ArrayList<>();

	public QuestionInitializer() {

	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public List<Question> getList() {
		return questionDao.getAllQuestion();
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	@PostConstruct
	public void set() {

		add(1, "one", "how many is one plus one?", setA("1", "2", "3"), setTA("2"));
		add(2, "many", "who live in london?", setA("John", "Winston", "Hvedja", "Apu"), setTA("John", "Winston"));
		add(3, "string", "what is the capital of Honduras?", setA(), setTA("tegucigalpa"));
		add(4, "one", "what is the capital of Ukraine?", setA("Kyiv", "Lviv", "Odesa", "Dnipropetrovsk", "Kharkiv"),
				setTA("Kyiv"));
		add(5, "one", "who is the president of Ukraine?",
				setA("Homer J Simpson", "Pes Ryabko", "Poroshenko Petro", "Vasya Pupkin"), setTA("Poroshenko Petro"));

	}

	public void add(int id, String kind, String question, Set<Answer> answers, Set<TrueAnswer> trueAnswers) {
		Question q = new Question();
		q.setId(id);
		q.setKind(kind);
		q.setQuestion(question);
		for (Answer answer : answers) {
			answer.setQuestion(q);
		}
		q.setAnswers(answers);

		for (TrueAnswer trueAnswer : trueAnswers) {
			trueAnswer.setQuestion(q);
		}
		q.setTrueAnswers(trueAnswers);
		list.add(q);

		System.out.println(questionDao);

		questionDao.addQuestion(q);
	}

	public Set<Answer> setA(String... answers) {
		Set<Answer> set = new HashSet<>();

		for (String string : answers) {
			Answer answer = new Answer();
			answer.setAnswer(string);
			set.add(answer);
		}
		return set;
	}

	public Set<TrueAnswer> setTA(String... answers) {
		Set<TrueAnswer> set = new HashSet<>();

		for (String string : answers) {
			TrueAnswer answer = new TrueAnswer();
			answer.setTrueAnswer(string);
			set.add(answer);
		}
		return set;
	}

}
