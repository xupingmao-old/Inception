package com.inception.action.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Music;
import com.inception.log.MyLog;

public class UpdateMusicLyrics extends AdminBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Music music;
	private File upload;
	private String uploadFileName;
	private int mid;

	
	public String execute() throws NotLoginException, PermissionFailException, SQLException
	{
		super.execute();
		if( method.equals("POST")){
			return SUCCESS;
		}else{
			String m_id = ServletActionContext.getRequest().getParameter("mid");
			mid = Integer.parseInt(m_id);
			music = biz.findMusicById(mid);
			session.put("curMusic",music);
		}

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

	public void validate()
	{
		super.validate();
		if( notLoginException != null){
			return;
		}
		if( method.equals("POST" )){
			MyLog.log(this, uploadFileName);
			
			music = (Music)session.get("curMusic");
			if( music == null ){
				this.addFieldError("error", Constants.updateFail);
				return;
			}
			
			if(! (uploadFileName.endsWith(".lrc") || uploadFileName.endsWith(".txt" )) ){
				this.addFieldError("error", Constants.lrcFormatCheck);
				return;
			}
			String lrc="";
			if(upload!=null){
				try{
					String line;
					FileInputStream fis = new FileInputStream (upload);
					InputStreamReader r = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(r);
					while(  (line = br.readLine()) != null ){
						lrc += line+"\n";
//						MyLog.log(this, line);
					}
					biz.updateMusicLrc(music.getId(), lrc);
					fis.close();
				}catch (Exception e){
					this.addFieldError("error", e.getMessage());
				}
			}
//			MyLog.log(this, "id="+music.getId()+",lrc="+lrc);
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
