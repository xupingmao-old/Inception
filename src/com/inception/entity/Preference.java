package com.inception.entity;

public class Preference {
	private int id;
	private int userId;
	private int musicId;
	private String musicUrl;
	private Music music;
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
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}
	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}
}
