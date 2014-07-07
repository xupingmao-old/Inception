package com.inception.entity;

public class History {
	private int id;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
	/**
	 * @param musicName the musicName to set
	 */
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	/**
	 * @return the musicName
	 */
	public String getMusicName() {
		return musicName;
	}
	/**
	 * @param musicUrl the musicUrl to set
	 */
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	/**
	 * @return the musicUrl
	 */
	public String getMusicUrl() {
		return musicUrl;
	}
	private int musicId;
	private String historyDate;
	private String musicName;
	private String musicUrl;
}
