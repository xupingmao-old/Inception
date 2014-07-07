package com.inception.action.user;

import java.sql.SQLException;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.User;
import com.inception.log.MyLog;

public class UserUpdateAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void validate()
	{
		super.validate();
	}
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException {
		super.execute();
		if( method.equals("POST")){
			if (sex == null) {
				user.setSex(0);
			} else if (sex.equals("ÄÐ")) {
				user.setSex(1);
			} else if (sex.equals("Å®")) {
				user.setSex(2);
			}
			MyLog.log(this, "name="+name);
			user.setUserName(name);
			biz.updateUser(user);
			MyLog.log(this,"userId = " + user.getId());
			MyLog.log(this,"userName = " + user.getUserName());
			MyLog.log(this,"sSex = " + user.getSSex());
			MyLog.log(this,"sex = " + user.getSex());
			super.updateSession();
			return SUCCESS;
		}else{
			name = user.getUserName();
			sex = user.getSSex();
		}

		return INPUT;
	}

	private String sex;
	private String name;

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return sex;
	}
	public User getUser(){
		return user;
	}
}
