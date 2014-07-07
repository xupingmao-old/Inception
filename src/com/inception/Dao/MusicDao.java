package com.inception.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inception.entity.Music;
import com.inception.util.DateUtil;
import com.inception.util.JdbcUtil;

public class MusicDao {
	
	private JdbcUtil util = new JdbcUtil();
	private Connection conn = util.getConnection();
	
	private void setMusicInfo(Music m, ResultSet rs) throws SQLException {
		m.setId(rs.getInt("id"));
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

	public List<Music> listMusicLimit(int start, int count) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select * from inception_music order by id desc limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<Music> list = new ArrayList<Music>();
		while(rs.next()){
			Music m = new Music();
			setMusicInfo(m, rs);
			list.add(m);
		}
		return list;
	}
	

	public void musicSave(Music m) throws SQLException{
		String sql = "insert into inception_music " +
				"( musicName, musicStyle," +
				" musicLanguage, artistName, albumName, " +
				"musicUrl, imageUrl, lyrics, " +
				"publishDate, description, " +
				"uploadedBy, uploadDate, fileLength, musicLength) " +
				"values (? , ? , ? , ? , ?, ?, ?, ? , ? , ?, ?, ?, ?, ?)";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, m.getMusicName());
		ps.setString(2, m.getMusicStyle());
		ps.setString(3, m.getMusicLanguage());
		ps.setString(4, m.getArtistName());
		ps.setString(5, m.getAlbumName());
		ps.setString(6, m.getMusicUrl());
		ps.setString(7, m.getImageUrl());
		ps.setString(8, m.getLyrics());
		ps.setString(9, m.getPublishDate());
		ps.setString(10, m.getDescription());
		ps.setInt(11, m.getUploadedBy());
		ps.setString(12, DateUtil.getDateTime());
		ps.setInt(13, m.getFileLength());
		ps.setInt(14, m.getMusicLength());
		ps.execute();
	}
	
	public void musicCTRInc(int id) throws SQLException{
		String sql = "update inception_music set CTR = CTR + 1 where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}
	
	public void musicCTRInc(String musicUrl) throws SQLException{
		String sql = "update inception_music set CTR = CTR + 1 where musicUrl = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, musicUrl);
		ps.execute();
	}
	

	public void deleteMusicById(int id) throws SQLException {
		String sql = "delete from inception_music where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}
	
	public Music getMusicById(int id) throws SQLException{
		String sql = "select * from inception_music where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		Music m = null;
		if( rs.next() ){
			m = new Music();
			setMusicInfo(m, rs);
		}
		
		return m;
	}

	public Music findMusicByUrl(String url) throws SQLException{
		String sql = "select * from inception_music where musicUrl = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, url);
		
		ResultSet rs = ps.executeQuery();
		Music m = null;
		if( rs.next() ){
			m = new Music();
			setMusicInfo(m, rs);
		}
		
		return m;
	}

	public void updateBaiscInfo(Music music) throws SQLException{
		String sql = "update inception_music set musicName = ?, musicStyle = ?," +
				" musicLanguage = ?, artistName = ?, albumName = ? where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		
		ps.setString(1, music.getMusicName());
		ps.setString(2, music.getMusicStyle());
		ps.setString(3, music.getMusicLanguage());
		ps.setString(4, music.getArtistName());
		ps.setString(5, music.getAlbumName());
		ps.setInt(6, music.getId());
		
		ps.execute();
	}

	public void updateMusicImage(Music m) throws SQLException {
		String sql = "update inception_music set imageUrl = ? where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, m.getImageUrl());
		ps.setInt(2, m.getId());
		ps.execute();
	}

	public List<Music> getTop(int start, int count) throws SQLException{
		String sql = "select * from inception_music order by CTR desc limit ? , ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<Music> list = new ArrayList<Music>();
		while(rs.next()){
			Music m = new Music();
			setMusicInfo(m, rs);
			list.add(m);
		}
		return list;
	}

	public List<Music> getLatest(int start, int count) throws SQLException{
		String sql = "select * from inception_music order by id desc limit ? , ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<Music> list = new ArrayList<Music>();
		while(rs.next()){
			Music m = new Music();
			setMusicInfo(m, rs);
			list.add(m);
		}
		return list;
	}

	public String getLrc(String url) throws SQLException {
		String sql = "select * from inception_music where musicUrl = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, url);
		
		ResultSet rs = ps.executeQuery();
		String lrc = "";
		if( rs.next() ){
			lrc = rs.getString("lyrics");
		}
		
		return lrc;
	}

	public void updateLrc(int id, String lrc) throws SQLException{
		String sql = "update inception_music set lyrics = ? where id = ?";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setString(1, lrc);
		ps.setInt(2, id);
		ps.execute();
	}

	public Music getLast() throws SQLException {
		String sql = "select * from inception_music order by id desc limit 1";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Music m = null;
		if( rs.next() ){
			m = new Music();
			setMusicInfo(m, rs);
		}
		return m;
	}

	public List<Music> getListByAlbum(String album) throws SQLException{
		String sql = "select * from inception_music where albumName = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, album);
		ResultSet rs = ps.executeQuery();
		List<Music> list = new ArrayList<Music>();
		
		while( rs.next() ){
			Music m = new Music();
			setMusicInfo(m, rs);
			list.add(m);
		}
		return list;
	}

}
