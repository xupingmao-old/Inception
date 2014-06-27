package com.inception.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inception.entity.User;
import com.inception.entity.UserLog;
import com.inception.util.JdbcUtil;

public class UserDao{

	private JdbcUtil util;
	public UserDao(){
		util = new JdbcUtil();
	}
	
	public final void setUserInfo(User user, ResultSet rs) throws SQLException{
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("userName"));
		user.setUserType(rs.getInt("userType"));
		user.setPermission(rs.getInt("permission"));
		user.setPasswd(rs.getString("passwd"));
		user.setSex(rs.getInt("sex"));
		user.setQqNo(rs.getString("qqNo"));
		user.setWeiboNo(rs.getString("weiboNo"));
		user.setRenrenNo(rs.getString("renrenNo"));
		user.setRegistDate(rs.getString("registDate"));
		user.setUpdateDate(rs.getString("updateDate"));
//		System.out.println(rs.getString("updateDate"));
//		user.setUpdateDate(rs.getTimestamp("updateDate").toLocaleString());
		
	}
	
	
	public void userDelById(int id) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "delete from inception_user where id = ?;";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}
	
	public static void main(String args[]){
		System.out.println(new java.sql.Time(new Date().getTime()));
		System.out.println(new Date().toLocaleString());
	}
	
	public final String getDateTime(){
		return new Date().toLocaleString();
	}

	public List<User> userListAll() throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery(sql);
		list = new ArrayList<User>();
		while( rs.next() ){
			user = new User();
			setUserInfo(user, rs);
			list.add(user);
		}
		return list;
	}
	
	public List<User> userListLimit(int start, int size) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_user limit ?,?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, size);
		rs = ps.executeQuery();
		list = new ArrayList<User>();
		while( rs.next() ){
			user = new User();
			setUserInfo(user, rs);
			list.add(user);
		}
		return list;
	}

	public User userListByUserId(int id) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_user where id = ?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id );
		ResultSet rs = ps.executeQuery();
		User user = null;
		if( rs.next()){
			user = new User();
			setUserInfo(user, rs);
		}
		return user;
	}

	public void userUpdate(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "update inception_user set (userName, email, permission, updateDate ) values (?, ?, ?, ?) where id = ?;";
		// update inception_user set userName = ? , email = ?, permission=?, updateDate=? where id = ?
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setInt(3, user.getPermission());
		ps.setString(4, getDateTime());
		ps.setInt(5, user.getId());
		
		ps.execute();
	}

	public void userUpdatePasswdById(int id, String oldpasswd, String newpasswd) {
		// TODO Auto-generated method stub
		
	}
	
	public void userSaveByEmail(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_user (userName, email, passwd,registDate, updateDate) values (?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(new Date().getTime()));
		ps.setString(2,user.getEmail());
		ps.setString(3,user.getPasswd());
		String date = getDateTime();
		ps.setString(4, date);
		ps.setString(5, date);
		ps.execute();
	}


	public void userSaveDefault(User user) throws SQLException {
		this.userSaveByEmail(user);
	}


	public void userSaveQQ(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_user (userName, qqNo, registDate, updateDate) values (?, ?, ?, ?);";
		
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(new Date().getTime()));
		ps.setString(2, user.getQqNo());
		String date = getDateTime();
		ps.setString(3, date);
		ps.setString(4, date);
		ps.execute();
	}


	public void userSaveWeibo(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_user (userName, weiboNo, registDate) values (?, ?, ?);";
		
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(new Date().getTime()));
		ps.setString(2, user.getWeiboNo());
		ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
		ps.execute();
	}


	public User userListByEmail(String email) throws SQLException {
		Connection conn = util.getConnection();
		String sql = "select * from inception_user where email = ?;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if( rs.next() ){
			user = new User();
			setUserInfo(user, rs);
		}
		return user;
	}
	
	public User uerListByQQ(String qq) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_user where qqNo = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, qq);
		rs = ps.executeQuery();
		if( rs.next() ){
			user = new User();
			setUserInfo(user, rs);
		}
		return user;
	}
	
	public void writeLog(UserLog log) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_log (logTitle, content, logDate, userId) values( ?, ?, ?, ?);";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, log.getLogTitle());
		ps.setString(2, log.getContent());
		ps.setString(3, log.getLogDate());
		ps.setInt(4, log.getId());
		ps.execute();
	}

	public int getUsersCount() throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select COUNT(*) from inception_user;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if( rs.next()){
			// index starts at 1;
			return rs.getInt(1);
		}
		return 0;
	}
	
	public void delteUserById(int id) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "delete from inception_user where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}
}
