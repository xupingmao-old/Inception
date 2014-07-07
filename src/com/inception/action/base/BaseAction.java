package com.inception.action.base;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.inception.biz.Biz;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String method = "";
	protected Map<String ,Object > session;
	protected Biz biz = Biz.newInstance();
	
	public void validate(){
		method = ServletActionContext.getRequest().getMethod();
		session = ServletActionContext.getContext().getSession();
	}
}
