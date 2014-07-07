package com.inception.action.user;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;
import com.inception.log.MyLog;

public class PlayAllPrefer extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		MyLog.log(this, "id="+user.getId());
		List<Music> list = biz.getAllPrefer(user.getId());
		session.put("musicList", list);
		return SUCCESS;
	}
}
