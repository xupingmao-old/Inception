package com.inception.action.user;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.UserPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.History;

public class UserHistory extends UserPageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<History> list;
	
	public List<History> getList(){
		return list;
	}

	public String execute() throws SQLException, NotLoginException, PermissionFailException{
		super.execute();
		recordsCount = biz.getHistoryCount(user.getId());

		sessionStartName = "u-h-start";
		countPerPage = 10;
		doPages(recordsCount, 10, "/Inception/UserHistory.action?start=");
		list = biz.getHistoryLimit(user.getId(), start, 10);
		return SUCCESS;
	}
}
