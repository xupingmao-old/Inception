package com.inception.entity;

public class Music {
	private int id;
	private String musicName;
	private String musicStyle; // 歌曲类型
	private String musicLanguage; // 歌曲语言
	private String artistName; // 歌手
	private String albumName;
	private String imageUrl; // the path of music file
	private String musicUrl; 
	private String lyrics;
	private String description;
	private String publishDate; // 发布时间
    private int CTR;
    private int musicLength;
    private int fileLength;
    private String uploadDate; // 加入时间
    private int uploadedBy; // 上传者
    
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publicDate) {
		this.publishDate = publicDate;
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
	/**
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(int uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	/**
	 * @return the uploadedBy
	 */
	public int getUploadedBy() {
		return uploadedBy;
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
	/**
	 * @param musicLanguage the musicLanguage to set
	 */
	public void setMusicLanguage(String musicLanguage) {
		this.musicLanguage = musicLanguage;
	}
	/**
	 * @return the musicLanguage
	 */
	public String getMusicLanguage() {
		return musicLanguage;
	}
	/**
	 * @param albumName the albumName to set
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	/**
	 * @return the albumName
	 */
	public String getAlbumName() {
		return albumName;
	}
	/**
	 * @param lyrics the lyrics to set
	 */
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	/**
	 * @return the lyrics
	 */
	public String getLyrics() {
		return lyrics;
	}
	/**
	 * @param fileLength the fileLength to set
	 */
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}
	/**
	 * @return the fileLength
	 */
	public int getFileLength() {
		return fileLength;
	}
	/**
	 * @param musicLength the musicLength to set
	 */
	public void setMusicLength(int musicLength) {
		this.musicLength = musicLength;
	}
	/**
	 * @return the musicLength
	 */
	public int getMusicLength() {
		return musicLength;
	}
}
