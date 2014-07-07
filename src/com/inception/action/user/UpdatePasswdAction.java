package com.inception.action.user;

import java.sql.SQLException;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;

public class UpdatePasswdAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String oldpasswd;
	private String passwd;
	private String passwd2;

	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		if( method.equals("POST")){
			biz.updatePasswd(user.getId(), passwd);
			session.clear();
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void validate(){
		super.validate();
		if( !method.equals("POST")){
			return;
		}
		if( user!= null && !oldpasswd.equals(user.getPasswd())){
			this.addFieldError("error", "输入旧密码错误");
			return;
		}
		else if( !passwd.equals(passwd2)){
			this.addFieldError("error", "两次输入密码不一致");
			return;
		}
		else if( ! isValid(passwd)){
			this.addFieldError("error", "密码必须为6到20个字母或数字组成");
		}
	}

	private boolean isValid(String passwd3) {
		int l = passwd3.length();
		if( l < 6 || l > 20 ){
			return false;
		}
		
		for(int i = 0; i < l ; i++ ){
			char c = passwd3.charAt(i);
			if( c >= 'a' && c <= 'z' || c >='A' && c <= 'Z' || c >= '0' && c <= '9'){
				continue;
			}
			return false;
		}
		return true;
	}

	/**
	 * @param passwd2 the passwd2 to set
	 */
	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	/**
	 * @return the passwd2
	 */
	public String getPasswd2() {
		return passwd2;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param oldpasswd the oldpasswd to set
	 */
	public void setOldpasswd(String oldpasswd) {
		this.oldpasswd = oldpasswd;
	}

	/**
	 * @return the oldpasswd
	 */
	public String getOldpasswd() {
		return oldpasswd;
	}

}
