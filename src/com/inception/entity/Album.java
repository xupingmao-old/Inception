package com.inception.entity;

public class Album {

	private int id;
	private String albumName;
	private String publishDate;
	private String imageUrl;
	private String artistName;
	private String description;
	private String encodeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param encodeName the encodeName to set
	 */
	public void setEncodeName(String encodeName) {
		this.encodeName = encodeName;
	}
	/**
	 * @return the encodeName
	 */
	public String getEncodeName() {
		return encodeName;
	}
	
}
