package com.inception.biz;

import java.sql.SQLException;
import java.util.List;

import com.inception.dao.UserDao;
import com.inception.entity.User;
import com.inception.entity.UserLog;

public class UserBiz {
	private UserDao userDao;
	private static UserBiz self = null;
	
	public UserBiz(){
		userDao = new UserDao();
	}
	
	public static UserBiz newInstance(){
		if( self == null){
			self = new UserBiz();
		}
		return self;
	}
	
	public void userRegistDefault(User user) throws SQLException{
		userDao.userSaveDefault(user);
	}
	
	public void userRegistByEmail(User user) throws SQLException{
		userDao.userSaveByEmail(user);
	}
	
	public User findUserByEmail(String email) throws SQLException{
		return userDao.userListByEmail(email);
	}
	
	public User findUserById(int id) throws SQLException{
		return userDao.userListByUserId(id);
	}
	
	public List<User> findAllUsers() throws SQLException{
		return userDao.userListAll();
	}
	
	public List<User> findUsersLimit(int start, int size) throws SQLException{
		return userDao.userListLimit(start, size);
	}
	
	public void saveUserByEmail(User user) throws SQLException{
		userDao.userSaveByEmail(user);
	}
	
	public void writeUserLog(UserLog log) throws SQLException{
		userDao.writeLog(log);
	}
}
