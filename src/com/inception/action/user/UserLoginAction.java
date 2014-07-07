package com.inception.action.user;

import java.sql.SQLException;
import java.util.Map;

import com.inception.biz.Biz;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String passwd;
	private User user;
	private int id;
	@Override
	public String execute() throws Exception {
// Session 客户端之间独立.
		Map<String, Object> session = ActionContext.getContext().getSession();
//		 String ip = ServletActionContext.getRequest().getRemoteAddr();
		session.put("user", user);
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void validate(){
		boolean hasError = false;
		if(email.isEmpty()){
			this.addFieldError("emailError", "请填写邮箱");
			hasError = true;
		}
		if( passwd.isEmpty()){
			this.addFieldError("passwdError", "请填写密码");
			hasError = true;
		}
		if( hasError ){
			return;
		}
		Biz biz = Biz.newInstance();
		try {
			user = biz.findUserByEmail(email);
			if( user == null){
				this.addFieldError("emailError", "该用户不存在");
				return;
			}
			if( !passwd.equals(user.getPasswd()) ){
				this.addFieldError("passwdError", "密码错误");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			this.addFieldError("emailError", "查询错误");
			return;
		}
		
		
		
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
