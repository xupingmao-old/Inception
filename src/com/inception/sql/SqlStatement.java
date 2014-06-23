package com.inception.sql;

public class SqlStatement {
	public static final String insertDefaultUser = "insert into inception_user (username, passwd) values (?,?)";
	public static final String insertQQUser = "insert into inception_user (usertype, username, passwd, qqNo) values (2, ?,?,?)";
	public static final String insertWeiboUser = "insert into inception_user (usertype, username, passwd, weiboNo) values (1, ?,?,?)";
	public static final String deleteUserById = "delete from inception_user where id = ?";
	public static final String queryUserByEmail = "select * from inception_user where email = '?'"; 
	
}
