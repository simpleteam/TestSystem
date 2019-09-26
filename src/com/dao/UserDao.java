package com.dao;

import com.entity.User;

public interface UserDao {

	public void addUser(User user);
	
	public User getUser(int id);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
}
