package com.dao.hsqldbimpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.dao.Dao;
import com.dao.UserDao;
import com.entity.User;


@Repository
@Transactional
public class UserDaoImpl extends Dao implements UserDao {

	private static final Logger log = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public void addUser(User user) {
		log.debug("add user");
		getCurrentSession().save(user);
	}

	@Override
	public User getUser(int id) {
		log.debug("get user");
		return (User) getCurrentSession().get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		log.debug("delete user");
		getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		log.debug("update user");
		getCurrentSession().update(user);
	}

}
