package com.inception.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Music;
import com.inception.entity.User;
import com.inception.log.MyLog;
import com.inception.util.DateUtil;
import com.inception.util.IOUtil;

public class AdminMusicAddAction extends AdminBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File musicUpload;
	private File lyricsUpload;
	private File imageUpload;
	private String musicExt;
	private String imageExt;
	private String musicUploadFileName;
	private String lyricsUploadFileName;
	private String imageUploadFileName;
	private String musicUrl;
	private String imageUrl;
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
		
		if( method.equals("POST" )){
			MyLog.log(this,"name="+music.getMusicName());
			MyLog.log(this,"file="+musicUploadFileName);
			MyLog.log(this,"image="+imageUploadFileName);
			return SUCCESS;
		}
		albumNames = biz.getAlbumNames();
		return INPUT;
	}
	
	public void doNames(){
		try {
			albumNames = biz.getAlbumNames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validate(){
		super.validate();
		
		if( !method.equals("POST")){
			return;
		}
		
		if( musicUpload == null){
			this.addFieldError("musicUploadError", "没有选择上传文件");
			doNames();
			return;
		}
		
		if( musicUploadFileName.endsWith(".mp3") ){
			musicExt = ".mp3";
		}else if( musicUploadFileName.endsWith(".wav") ){
			musicExt = ".wav";
		}else{
			musicExt = null;
		}
		
		if( musicExt == null ){
			this.addFieldError("musicUploadError", "错误的文件类型");
			doNames();
			return;
		}else{
			musicUrl = DateUtil.getTime() + musicExt;
			music.setMusicUrl(musicUrl);
			music.setFileLength((int) musicUpload.length());
		}
		
		if( imageUpload != null){
			if( imageUploadFileName.endsWith(".jpg")){
				imageExt = ".jpg";
			}
			else if( imageUploadFileName.endsWith(".png")){
				imageExt = ".png";
			}
			else{
				imageExt = null;
			}
			if( imageExt == null){
				this.addFieldError("imageError", "只支持jpg和png图片");
				return;
			}	
			else{
				imageUrl = DateUtil.getTime() + imageExt;
				music.setImageUrl(imageUrl);
			}
			
		}
		
		if( lyricsUpload != null ){
			if( ! (lyricsUploadFileName.endsWith(".lrc")
					|| lyricsUploadFileName.endsWith(".txt")) ){
				this.addFieldError("lyricsError", "错误的文件类型,支持.lrc,.txt");
				doNames();
				return;
			}
		}

		
		music.setUploadedBy(user.getId());
		
		if( music.getPublishDate().isEmpty()){
			music.setPublishDate(null);
		}
		
		try{
			saveFile();
			biz.musicSave(music);
			System.out.println("save " + musicUploadFileName + " success!");
			
		}catch(SQLException e){
			this.addFieldError("uploadError", e.getMessage());
			doNames();
		} catch (IOException e) {
			this.addFieldError("uploadError", e.getMessage());
			doNames();
		}
	}


	private void saveFile() throws IOException {
		if(imageUpload != null){
			IOUtil.save(imageUpload, Constants.filePath + imageUrl);
		}
		
		if(musicUpload != null){
			IOUtil.save(musicUpload, Constants.filePath + musicUrl);
		}
		
		if(lyricsUpload != null){
			FileInputStream fis = new FileInputStream(lyricsUpload);
			byte[] buf = new byte[1024];
			String ss = "";
			int size = 0;
			while( (size = fis.read(buf)) > 0){
				String s = new String(buf, 0, size);
				ss+=s;
			}
			music.setLyrics(ss);
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		user.setId(id);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return user.getId();
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
