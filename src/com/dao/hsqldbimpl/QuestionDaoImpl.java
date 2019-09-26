package com.dao.hsqldbimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.dao.QuestionDao;
import com.entity.Question;



@Repository
public class QuestionDaoImpl extends Dao implements QuestionDao {

	private static final Logger log = Logger.getLogger(QuestionDaoImpl.class);
	
	@Transactional
	@Override
	public void addQuestion(Question question) {
		log.debug("add question");
		getCurrentSession().save(question);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Question> getAllQuestion() {
		log.debug("get all questions");
		return getCurrentSession().createQuery("from Question").list();
	}

	@Transactional
	@Override
	public Question getQuestion(int id) {
		log.debug("get question");
		return (Question) getCurrentSession().get(Question.class, id);
	}

	@Transactional
	@Override
	public void deleteQuestion(Question question) {
		log.debug("delete question");
		getCurrentSession().delete(question);
	}

}
