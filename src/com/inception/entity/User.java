package com.inception.entity;

public class User {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int usertype) {
		this.userType = usertype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getQqNo() {
		return qqNo;
	}
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	public String getWeiboNo() {
		return weiboNo;
	}
	public void setWeiboNo(String weiboNo) {
		this.weiboNo = weiboNo;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public void setRenrenNo(String renrenNo) {
		this.renrenNo = renrenNo;
	}
	public String getRenrenNo() {
		return renrenNo;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getPermission() {
		return permission;
	}
	/**
	 * @param sPermission the sPermission to set
	 */
	public void setSPermission(String sPermission) {
		this.sPermission = sPermission;
	}
	/**
	 * @return the sPermission
	 */
	public String getSPermission() {
		return sPermission;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sSex the sSex to set
	 */
	public void setSSex(String sSex) {
		this.sSex = sSex;
	}
	/**
	 * @return the sSex
	 */
	public String getSSex() {
		return sSex;
	}
//	private String index; // for multi operation in jsp;
	private int id;
	private int userType ; // ÓÃ»§×¢²áÀàÐÍ 0 ±¾Õ¾×¢²á 1 weibo×¢²á 2 qq×¢²á 3 renren
	private int permission; // 
	private String sPermission;
	private int sex;
	private String sSex;
	private String email;
	private String userName;
	private String passwd;
	private String qqNo;
	private String weiboNo;
	private String renrenNo;
	private String updateDate;
	private String registDate;
}
