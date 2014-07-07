package com.inception.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inception.entity.History;
import com.inception.util.DateUtil;
import com.inception.util.JdbcUtil;

public class HistoryDao {
	
	private JdbcUtil util;
	
	public HistoryDao(){
		util = new JdbcUtil();
	}

	public void add(int userId, int musicId) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "insert into inception_history (userId, musicId, historyDate) values (?, ? , ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, musicId);
		ps.setString(3, DateUtil.getDateTime());
		ps.execute();
	}

	public List<History> getHistoryLimit(int uid, int start, int size) throws SQLException{
		List<History> list = new ArrayList<History>();
		String sql = "select userId, musicId, historyDate, musicName, musicUrl from inception_history, inception_music where inception_history.userId = ? and inception_history.musicId = inception_music.id order by inception_history.id desc limit ? , ?; ";
		PreparedStatement ps = util.getConnection().prepareStatement(sql);
		ps.setInt(1, uid);
		ps.setInt(2, start);
		ps.setInt(3, size);
		ResultSet rs = ps.executeQuery();
		while( rs.next() ){
			History h = new History();
			h.setUserId(rs.getInt("userId"));
			h.setMusicId(rs.getInt("musicId"));
			h.setMusicName(rs.getString("musicName"));
			h.setHistoryDate(rs.getString("historyDate"));
			h.setMusicUrl(rs.getString("musicUrl"));
			list.add(h);
		}
		return list;
	}

	public int getCount(int id) throws SQLException{
		Connection conn = util.getConnection();
		String sql = "select COUNT(*) from inception_history where userId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if( rs.next() ){
			return rs.getInt(1);
		}
		return 0;
	}

}
