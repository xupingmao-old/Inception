package com.inception.action;

import com.inception.biz.UserBiz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport{

	private String userName;
	private String email;
	private String passwd;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserBiz biz = new UserBiz();
		System.out.println("Hello,welcome user: " + email);
		User u = biz.findUserByEmail(email);
		if( u == null){
			return ERROR;
		}
		if( passwd.equals(u.getPasswd()) ){
			return SUCCESS;
		}
		userName = email;
		return ERROR;
//		return super.execute();
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

}
