package com.inception.action.base;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.biz.Biz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserBaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Biz biz = Biz.newInstance();
	protected User user;
	protected Map<String ,Object > session;
	protected String method;
	protected NotLoginException notLoginException = null;
	
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		if( notLoginException != null){
			throw notLoginException;
		}
		return SUCCESS;
	}
	
	public void validate()
	{
		session = ServletActionContext.getContext().getSession();
		method = ServletActionContext.getRequest().getMethod();
		user = (User) session.get("user");
		if( user == null){
			notLoginException = new NotLoginException();
			return;
		}
		method = ServletActionContext.getRequest().getMethod();
	}

	public void updateSession() throws SQLException {
		if( user != null ){
			user = biz.findUserById(user.getId());
			session.put("user",user);
		}
	}
	
	public User getUser(){
		return user;
	}
}
