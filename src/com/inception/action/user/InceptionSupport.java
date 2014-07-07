package com.inception.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.inception.constants.Constants;
import com.inception.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class InceptionSupport extends ActionSupport
	implements SessionAware, ApplicationAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> application;
	private Map<String, Object> session;
	private String task = null;
	private String token = null;
	private String host;
	private String password;
	private String password2;
	private String username = null;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSession(Map<String, Object> value) {
		session = value;
	}
	
	public Map<String, Object> getSession(){
		return session;
	}

	public void setApplication(Map<String, Object> value) {
		application = value;
	}
	
	public Map<String, Object> getApplication(){
		return application;
	}
	
	public String cancel(){
		return Constants.CANCEL;
	}
	
	public String getTask(){
		return task;
	}
	
	public void setTask(String value){
		task = value;
	}
	
	protected void copyUser(User src, User tar){
		if( src == null || tar == null){
			return;
		}
	}
	
}
