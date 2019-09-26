package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
}
