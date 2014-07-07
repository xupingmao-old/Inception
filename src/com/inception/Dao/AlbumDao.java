package com.inception.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inception.entity.Album;
import com.inception.util.JdbcUtil;

public class AlbumDao {

	private JdbcUtil util;
	private Connection conn;
	public AlbumDao(){
		util = new JdbcUtil();
		conn = util.getConnection();
	}
	
	public int getArtistCount() throws SQLException{
		String sql = "select COUNT(*) from inception_album order by id desc ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if( rs.next() ){
			int count = rs.getInt(1);
			return count;
		}
		return 0;
	}

	public List<Album> getList(int start, int size) throws SQLException{
		String sql = "select * from inception_album order by id desc limit ?,? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		List<Album> list = new ArrayList<Album>();
		
		while( rs.next() ){
			Album al = new Album();
			setInfo(al, rs);
			list.add(al);
		}
		return list;
	}

	private void setInfo(Album al, ResultSet rs) throws SQLException{
		al.setAlbumName(rs.getString("albumName"));
		al.setImageUrl(rs.getString("imageUrl"));
		al.setId(rs.getInt("id"));
		al.setPublishDate(rs.getString("publishDate"));
		al.setDescription(rs.getString("description"));
	}

	/*
	 * create table inception_album(
	id int primary key auto_increment,
	albumName varchar(50) NOT NULL,
	publishDate date default NULL,
	imageUrl varchar(1024) default NULL,
	recordCompany varchar(1024) default NULL,
	artistName varchar(100) default NULL,
	description varchar(1024) default NULL
);

	 */
	public void add(Album al) throws SQLException{
		String sql = "insert into inception_album (albumName, publishDate, imageUrl, artistName, description) values (?, ?, ?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, al.getAlbumName());
		ps.setString(2, al.getPublishDate());
		ps.setString(3, al.getImageUrl());
		ps.setString(4, al.getArtistName());
		ps.setString(5, al.getDescription());
		ps.execute();
	}

	public Album findAlbumById(int aid) throws SQLException{
		String sql = "select * from inception_album where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, aid);
		ResultSet rs = ps.executeQuery();
		Album al = new Album();
		if( rs.next() ){
			setInfo(al, rs);
		}
		return al;
	}

	public void updateImg(Album al) throws SQLException{
		String sql = "update inception_album set imageUrl = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, al.getImageUrl());
		ps.setInt(2, al.getId());
		ps.execute();
	}

	public List<String> getNames() throws SQLException{
		List<String> names = new ArrayList<String>();
		String sql = "select albumName from inception_album ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while( rs.next() ){
			String name = rs.getString(1);
			names.add(name);
		}
		return names;
	}

	public void delete(int id) throws SQLException{
		String sql = "delete from inception_album where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}

	public void update(Album al) throws SQLException {
		String sql = "update inception_album set albumName = ?, description = ?, imageUrl = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, al.getAlbumName());
		ps.setString(2, al.getDescription());
		ps.setString(3, al.getImageUrl());
		ps.setInt(4, al.getId());
		ps.execute();
	}
}
