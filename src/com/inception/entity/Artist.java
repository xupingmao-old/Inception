package com.inception.entity;

public class Artist {
	/*
	 * 	id int primary key auto_increment,
	artistName varchar(50) NOT NULL,
	artistPhoto varchar(1024) NOT NULL,
	description varchar(1024) default NULL,
	popularity int default 0,
	zoneName varchar(100) default 0
	 */
	private int id;
	private String artistName;
	private String artistPhoto;
	private String description;
	private int popularity;
	private String zoneName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistPhoto() {
		return artistPhoto;
	}
	public void setArtistPhoto(String artistPhoto) {
		this.artistPhoto = artistPhoto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
}
