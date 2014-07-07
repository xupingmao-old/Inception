package com.inception.action.base;

import java.sql.SQLException;

import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;

public class AdminBaseAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PermissionFailException permissisonFailException = null;
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		if( permissisonFailException != null){
			throw permissisonFailException;
		}
		return SUCCESS;
	}
	
	public void validate()
	{
		super.validate();
		if( user != null && user.getPermission() < 1){
			permissisonFailException = new PermissionFailException();
		}
		
	}
}
