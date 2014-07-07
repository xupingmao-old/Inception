package com.inception.dao;

import com.inception.constants.Constants;

public class UserExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistsException(){
		super(Constants.userExists);
	}
}
