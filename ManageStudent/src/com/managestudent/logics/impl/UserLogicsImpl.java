/**
 * Copyright(C) K16SE 2014
 *
 * UserLogicsImpl.java, Sep 5, 2014 HaVH
 *
 */
package com.managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.UserDaoImpl;
import managestudent.entities.User;
import managestudent.logics.UserLogics;

/**
 *
 * @author HaVH
 *
 */
public class UserLogicsImpl implements UserLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#addUser(managestudent.entities.User)
	 */
	@Override
	public boolean addUser(User u) {
		UserDaoImpl userDao = new UserDaoImpl();
		boolean rs = userDao.addUser(u);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#deleteUserById(int)
	 */
	@Override
	public boolean deleteUserById(int userId) {
		UserDaoImpl userDao = new UserDaoImpl();
		boolean rs = userDao.deleteUserById(userId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> lsUser = userDao.getAllUsers();

		return lsUser;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#getUserById(int)
	 */
	@Override
	public User getUserById(int userId) {
		UserDaoImpl userDao = new UserDaoImpl();
		User u = userDao.getUserById(userId);

		return u;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#updateUserById(int, managestudent.entities.User)
	 */
	@Override
	public boolean updateUserById(int userId, User u) {
		UserDaoImpl userDao = new UserDaoImpl();
		boolean rs = userDao.updateUserById(userId, u);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.UserLogics#existsAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existsAccount(String loginId, String password) {
		UserDaoImpl userDao = new UserDaoImpl();
		boolean rs = userDao.existsAccount(loginId, password);

		return rs;
	}

}
