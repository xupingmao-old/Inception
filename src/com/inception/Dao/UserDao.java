package com.inception.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inception.entity.User;
import com.inception.sql.SqlStatement;
import com.inception.util.JdbcUtil;

public class UserDao{

	private JdbcUtil util;
	public UserDao(){
		util = new JdbcUtil();
	}
	
	
	public void userDelById(int id) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "delete from inception_user where id = ?;";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}

	public List<User> userListAll() {
		Connection conn = util.getConnection();
		String sql = "select * from inception_user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			list = new ArrayList<User>();
			while( rs.next() ){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserType(rs.getInt("userType"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("userName"));
				user.setPasswd(rs.getString("passwd"));
				user.setRegistDate(rs.getString("registDate"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			user.setId(id);
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("userName"));
			user.setUserType(rs.getInt("userType"));
			user.setPasswd(rs.getString("passwd"));
			user.setQqNo(rs.getString("qqNo"));
			user.setWeiboNo(rs.getString("weiboNo"));
			user.setRenrenNo(rs.getString("renrenNo"));
			user.setRegistDate(rs.getString("registDate"));
			user.setUpdateDate(rs.getString("updateDate"));
		}
		return user;
	}

	public void userUpdate(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "update inception_user set (userName, email, permission ) values (?, ?, ?) where id = ?;";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setInt(3, user.getPermission());
		ps.setInt(4, user.getId() );
		
		ps.execute();
	}

	public void userUpdatePasswdById(int id, String oldpasswd, String newpasswd) {
		// TODO Auto-generated method stub
		
	}
	
	public void userSaveByEmail(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_user (userName, email, passwd,registDate) values (?, ?, ?, ?);";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(new Date().getTime()));
		ps.setString(2,user.getEmail());
		ps.setString(3,user.getPasswd());
		ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
		ps.execute();
	}


	public void userSaveDefault(User user) throws SQLException {
		Connection conn = util.getConnection();
		String sql = SqlStatement.insertDefaultUser;
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1,user.getUserName());
		ps.setString(2,user.getPasswd());
		ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
		ps.execute();
	}


	public void userSaveQQ(User user) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_user (userName, qqNo, registDate) values (?, ?, ?);";
		
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(new Date().getTime()));
		ps.setString(2, user.getQqNo());
		ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
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
			user.setId(rs.getInt("id"));
			user.setEmail(email);
			user.setUserName(rs.getString("userName"));
			user.setPasswd(rs.getString("passwd"));
			user.setRegistDate(rs.getString("registDate"));
		}
		return user;
	}
	
	public User uerListByQQ(String qq) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_user where qqNo = '?'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, qq);
		rs = ps.executeQuery(sql);
		if( rs.next() ){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("qqNo"));
			user.setUserName(rs.getString("userName"));
			user.setPasswd(rs.getString("passwd"));
			user.setRegistDate(rs.getString("registDate"));
		}
		return user;
	}

}
