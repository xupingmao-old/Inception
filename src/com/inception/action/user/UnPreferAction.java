package com.inception.action.user;

import java.sql.SQLException;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;

public class UnPreferAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		Music m = (Music)session.get("m");
		if( m != null ){
			biz.deletePrefer(user.getId(), m.getId());
			return SUCCESS;
		}else{
			return "fail";
		}
	}
}
