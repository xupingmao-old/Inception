package com.inception.entity;

public class UserLog {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogTitle() {
		return logTitle;
	}
	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	private String logTitle;
	private String content;
	private int userId;
	private String logDate;
	
	public UserLog(){
		
	}
}
