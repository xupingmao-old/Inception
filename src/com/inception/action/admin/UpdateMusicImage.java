package com.inception.action.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Music;
import com.inception.log.MyLog;
import com.inception.util.DateUtil;
import com.inception.util.IOUtil;
import com.inception.util.Tokenizer;

public class UpdateMusicImage extends AdminBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Music music;
	private File upload;
	private String uploadFileName;

	private String newFileName;
	private int mid;
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException
	{
		super.execute();
		
		if( method.equals("POST")){
			MyLog.log(this, "id="+music.getId());
			return SUCCESS;
		}
		String m_id = ServletActionContext.getRequest().getParameter("mid");
		mid = Integer.parseInt(m_id);
		music = biz.findMusicById(mid);
		session.put("curMusic", music);
		return INPUT;
	}
	
	public String getLrc(){
		return music.getLyrics();
	}
	
	public String getName(){
		return music.getMusicName();
	}
	
	public String getUrl(){
		return music.getMusicUrl();
	}
	
	public String getImgUrl(){
		return music.getImageUrl();
	}
	
	public int getId(){
		return music.getId();
	}


	public void validate()
	{
		super.validate();
		if( notLoginException != null){
			return;
		}
		if( method.equals("POST" )){
			
			music = (Music)session.get("curMusic");
			if( music == null ){
				this.addFieldError("error", Constants.fileSaveError);
				return;
			}
			MyLog.log(this, uploadFileName);
			String ext = Tokenizer.getExtension(uploadFileName);
			if( Tokenizer.isValidPicExt(ext) ){
				newFileName = DateUtil.getTime() + ext;
			}else{
				this.addFieldError("error", Constants.imgFormatCheck);
			}
			if(upload!=null && newFileName != null){
				try {
					IOUtil.deleteFile(Constants.filePath + music.getImageUrl());
					IOUtil.save(upload, Constants.filePath + newFileName);
					MyLog.log(this, "old "+music.getImageUrl());
					MyLog.log(this, "new "+newFileName);
					music.setImageUrl(newFileName);
					biz.updateMusicImage(music);
				} catch (IOException e) {
					this.addFieldError("error", Constants.fileSaveError);
				} catch (SQLException e) {
					this.addFieldError("error", e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
}
