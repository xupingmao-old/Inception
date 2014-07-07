package com.inception.action.user;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.History;
import com.inception.entity.User;

public class UserMainAction extends UserBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String update = null;
	private List<History> historyList;
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		historyList = biz.getHistoryLimit(user.getId(), 0, 12);
		return SUCCESS;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param update the update to set
	 */
	public void setUpdate(String update) {
		this.update = update;
	}

	/**
	 * @return the update
	 */
	public String getUpdate() {
		return update;
	}

	/**
	 * @param historyList the historyList to set
	 */
	public void setHistoryList(List<History> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the historyList
	 */
	public List<History> getHistoryList() {
		return historyList;
	}
}
