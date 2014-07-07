package com.inception.action.user;

import java.sql.SQLException;

import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;

public class UserLogAction extends UserMainAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		return SUCCESS;
	}
	
	public void validate(){
		super.validate();
	}
}
