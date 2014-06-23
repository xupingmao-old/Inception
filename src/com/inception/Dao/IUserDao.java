package com.inception.Dao;

import java.util.List;

import com.inception.entity.User;

public interface IUserDao {
	
	public void userSaveDefault(User user);
	public void userSaveQQ(User user);
	public void userSaveWeibo(User user);
	public void userUpdate(User user);
	public User userListByUserId(int id);
	public List<User> userListAll();
	public void userDelById(int id);
    public void userUpdatePasswdById(int id, String oldpasswd, String newpasswd);
	public User userListByEmail(String email);

}
