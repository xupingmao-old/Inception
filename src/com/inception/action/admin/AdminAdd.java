package com.inception.action.admin;

import java.sql.SQLException;

import com.inception.biz.UserBiz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAdd extends ActionSupport{

	private String email;
	private String passwd;
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String execute(){
		UserBiz biz = new UserBiz();
		User u = new User();
		u.setEmail(email);
		u.setPasswd(passwd);
		try {
			biz.saveUserByEmail(u);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
