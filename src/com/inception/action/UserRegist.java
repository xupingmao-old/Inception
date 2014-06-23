package com.inception.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserRegist extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String passwd;
	private String passwd2;
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
	public String getPasswd2() {
		return passwd2;
	}
	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}
	public String execute(){
		return SUCCESS;
	}
}
