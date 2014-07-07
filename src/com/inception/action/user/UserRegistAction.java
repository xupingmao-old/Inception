package com.inception.action.user;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inception.action.base.BaseAction;
import com.inception.dao.UserExistsException;
import com.inception.entity.User;

public class UserRegistAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String passwd;
	private String passwd2;
	private User user = new User();
	private int id;
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
	public String execute() throws SQLException{
		if( method.equals("POST")){
			user = biz.findUserByEmail(email);
			session.put("user", user);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public boolean isValidEmail(String email){
		  boolean flag = false;
		  try{
			   String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			   Pattern regex = Pattern.compile(check);
			   Matcher matcher = regex.matcher(email);
			   flag = matcher.matches();
		  }catch(Exception e){
			  LOG.error("验证邮箱地址错误", e);
			  flag = false;
		  }
		  
		  return flag;
	}
	
	public void validate(){
		super.validate();
		boolean error = false;
		
		if(!method.equals("POST" )){
			return;
		}
		
		if( !isValidEmail(email) ){
			this.addFieldError("emailError", "请输入有效的邮箱");
			error = true;
		}
		
		if( !isValidPasswd(passwd)){
			this.addFieldError("passwdError", "请输入由6-20个字母或数字组成的有效密码");
			error = true;
		}
		
		if( !passwd.equals(passwd2)){
			this.addFieldError("passwd2Error", "两次密码不匹配");
			error = true;
		}
		
		if(error){
			return;
		}
		
		user.setEmail(email);
		user.setPasswd(passwd);
		try {
			biz.userRegistByEmail(user);
		} catch (SQLException e) {
			e.printStackTrace();
			this.addFieldError("registError", e.getMessage());
		} catch (UserExistsException e){
			e.printStackTrace();
			this.addFieldError("registError", "该邮箱已被使用");
		}
		
	}
	private boolean isValidPasswd(String passwd3) {
		if( passwd3.length() < 6 || passwd3.length() > 20){
			return false;
		}
		for(int i = 0; i < passwd3.length(); i++){
			char c = passwd3.charAt(i);
			if( (c >= '0' && c <= '9') || (c >= 'a' && c <='z') || (c >= 'A' && c <='Z') ){
				continue;
			}else{
				return false;
			}
		}
		return true;
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
}
