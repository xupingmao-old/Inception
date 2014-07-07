package com.inception.action.user;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class UserLogoutAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		Map<String,Object> session = ServletActionContext.getContext().getSession();
		Object obj = session.get("user");
		if(obj != null){
			session.clear();
		}
		return SUCCESS;
	}
}
