package com.inception.entity;

public class Music {
	private int id;
	private String musicStyle; // 歌曲类型
	private String artistName; // 歌手
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMusicStyle() {
		return musicStyle;
	}
	public void setMusicStyle(String musicStyle) {
		this.musicStyle = musicStyle;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCTR() {
		return CTR;
	}
	public void setCTR(int cTR) {
		CTR = cTR;
	}
	private String musicName;
	private String uploadDate; // 加入时间
	private String description;
	private String publicDate; // 发布时间
    private String imageUrl; // the path of music file
    private int CTR;
}
