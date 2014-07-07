package com.inception.action.admin;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;
import com.inception.entity.User;
import com.inception.log.MyLog;

public class AdminMusicUpdateAction extends AdminBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File musicUpload;
	private File lyricsUpload;
	private File imageUpload;
	private String musicUploadFileName;
	private String lyricsUploadFileName;
	private String imageUploadFileName;
	private Music music = new Music();
	
	private List<String> albumNames;
	
	public File getMusicUpload() {
		return musicUpload;
	}

	public void setMusicUpload(File musicUpload) {
		this.musicUpload = musicUpload;
	}

	public File getLyricsUpload() {
		return lyricsUpload;
	}

	public void setLyricsUpload(File lyricsUpload) {
		this.lyricsUpload = lyricsUpload;
	}

	public String getMusicUploadFileName() {
		return musicUploadFileName;
	}

	public void setMusicUploadFileName(String musicUploadFileName) {
		this.musicUploadFileName = musicUploadFileName;
	}

	public String getLyricsUploadFileName() {
		return lyricsUploadFileName;
	}

	public void setLyricsUploadFileName(String lyricsUploadFileName) {
		this.lyricsUploadFileName = lyricsUploadFileName;
	}
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		super.execute();
		String method = ServletActionContext.getRequest().getMethod();
		String s_mid = ServletActionContext.getRequest().getParameter("mid");
		int mid = Integer.parseInt(s_mid);
		MyLog.log(this, s_mid);
		if( method.equals("POST")){
			try {
				if( music.getPublishDate().isEmpty()){
					music.setPublishDate(null);
				}
				biz.updateMusicBasicInfo(music);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		else{
			try {
				albumNames = biz.getAlbumNames();
				music = biz.findMusicById(mid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return INPUT;
		}
		
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
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

	/**
	 * @param imageUploadFileName the imageUploadFileName to set
	 */
	public void setImageUploadFileName(String imageUploadFileName) {
		this.imageUploadFileName = imageUploadFileName;
	}

	/**
	 * @return the imageUploadFileName
	 */
	public String getImageUploadFileName() {
		return imageUploadFileName;
	}

	/**
	 * @param imageUpload the imageUpload to set
	 */
	public void setImageUpload(File imageUpload) {
		this.imageUpload = imageUpload;
	}

	/**
	 * @return the imageUpload
	 */
	public File getImageUpload() {
		return imageUpload;
	}

	/**
	 * @param albumNames the albumNames to set
	 */
	public void setAlbumNames(List<String> albumNames) {
		this.albumNames = albumNames;
	}

	/**
	 * @return the albumNames
	 */
	public List<String> getAlbumNames() {
		return albumNames;
	}

}
