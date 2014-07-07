package com.inception.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inception.entity.Music;
import com.inception.entity.Preference;
import com.inception.util.JdbcUtil;

public class PreferenceDao {

	private JdbcUtil util = new JdbcUtil();
	private Connection conn = util.getConnection();
	
	public void add(int userId, int musicId) throws SQLException{
		String sql = "insert into inception_preference ( userId, musicId ) values (?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, musicId);
		ps.execute();
	}
	
	public void delete(int id) throws SQLException{
		String sql = "delete from inception_preference where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}
	
	public boolean has(int userId, int musicId) throws SQLException{
		String sql = "select * from inception_preference where userId = ? and musicId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, musicId);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	public List<Preference> getPreferenceLimit(int userId, int start, int count) throws SQLException{
		List<Preference> list = new ArrayList<Preference> ();
		
		String sql = "select * from inception_preference where userId = ? order by id desc limit ?, ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, start);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Preference p = new Preference();
			setInfo(p, rs);
			list.add(p);
		}
		return list;
	}

	private void setInfo(Preference p, ResultSet rs) throws SQLException {
		p.setId(rs.getInt("id"));
		p.setUserId(rs.getInt("userId"));
		p.setMusicId(rs.getInt("musicId"));
	}

	public void delete(int userId, int musicId)  throws SQLException{
		String sql = "delete from inception_preference where userId = ? and musicId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, musicId);
		ps.execute();
	}

	public int getCount(int i) throws SQLException{
		String sql = "select COUNT(*) from inception_preference where userId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, i);
		ResultSet rs = ps.executeQuery();
		if(rs.next() ){
			return rs.getInt(1);
		}
		return 0;
	}

	public List<Preference> get(int start, int size) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setMusicInfo(Music m, ResultSet rs) throws SQLException {
		m.setId(rs.getInt("musicId"));
		m.setMusicName(rs.getString("musicName"));
		m.setMusicStyle(rs.getString("musicStyle"));
		m.setMusicLanguage(rs.getString("musicLanguage"));
		m.setArtistName(rs.getString("artistName"));
		m.setAlbumName(rs.getString("albumName"));
		m.setImageUrl(rs.getString("imageUrl"));
		m.setMusicUrl(rs.getString("musicUrl"));
		m.setLyrics(rs.getString("lyrics"));
		m.setCTR(rs.getInt("CTR"));
		m.setPublishDate(rs.getString("publishDate"));
		m.setUploadDate(rs.getString("uploadDate"));
		m.setDescription(rs.getString("description"));
		m.setFileLength(rs.getInt("fileLength"));
		m.setMusicLength(rs.getInt("musicLength"));
	}

	public List<Music> getAllMusic(int id) throws SQLException{
		List<Music> list = new ArrayList<Music> ();
		String sql = "select * from inception_preference, inception_music where inception_preference.userId = ? and inception_preference.musicId = inception_music.id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Music m = new Music();
			setMusicInfo(m, rs);
			list.add(m);
		}
		return list;
	}
}
