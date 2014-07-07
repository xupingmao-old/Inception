package com.inception.action.base;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.inception.biz.Biz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class HomeBaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected User user;
	protected Map<String , Object> session;
	protected Biz biz = Biz.newInstance();
	protected String method = "";
	
	public String execute() throws SQLException{
		session = ServletActionContext.getContext().getSession();
		method = ServletActionContext.getRequest().getMethod();
		user = (User) session.get("user");
		return SUCCESS;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
}
