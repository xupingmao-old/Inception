package com.inception.biz;

import java.sql.SQLException;
import java.util.List;

import com.inception.Dao.IUserDao;
import com.inception.Dao.UserDao;
import com.inception.entity.User;

public class UserBiz {
	private UserDao userDao;
	
	public UserBiz(){
		userDao = new UserDao();
	}
	
	public void userRegistDefault(User user) throws SQLException{
		userDao.userSaveDefault(user);
	}
	
	public User findUserByEmail(String email) throws SQLException{
		return userDao.userListByEmail(email);
	}
	
	public List<User> findAllUsers(){
		return userDao.userListAll();
	}
	
	public void saveUserByEmail(User user) throws SQLException{
		userDao.userSaveByEmail(user);
	}
}
