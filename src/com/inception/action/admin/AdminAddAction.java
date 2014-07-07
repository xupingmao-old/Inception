package com.inception.action.admin;

import java.sql.SQLException;

import com.inception.biz.Biz;
import com.inception.dao.UserExistsException;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAddAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		Biz biz = new Biz();
		User u = new User();
		u.setEmail(email);
		u.setPasswd(passwd);
		try {
			biz.saveUserByEmail(u);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} catch( UserExistsException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
