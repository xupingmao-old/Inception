package com.inception.action.admin;

import java.util.List;

import com.inception.biz.UserBiz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class Admin extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> list;
	public String execute(){
		UserBiz biz = new UserBiz();
		setList(biz.findAllUsers());
		
		for(int i = 0; i < list.size(); i++){
			
			System.out.println(list.get(i).getUserName());
		}
		return SUCCESS;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public List<User> getList() {
		return list;
	}
}
