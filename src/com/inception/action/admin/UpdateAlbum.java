package com.inception.action.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Album;
import com.inception.log.MyLog;
import com.inception.util.DateUtil;
import com.inception.util.IOUtil;
import com.inception.util.Tokenizer;

public class UpdateAlbum extends AdminBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Album al;
	private File upload;
	private String uploadFileName;
	private String name;
	private String description;
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return al.getAlbumName();
	}
	
	public void setDescription(String des){
		this.description = des;
	}
	
	public String getDescription(){
		return al.getDescription();
	}

	public String execute() throws NotLoginException, PermissionFailException, SQLException
	{
		super.execute();
		
		if( method.equals("POST")){
			if( al == null ){
				return INPUT;
			}
			biz.updateAlbum(al);
			return SUCCESS;
		}
		String m_id = ServletActionContext.getRequest().getParameter("aid");
		int aid = Integer.parseInt(m_id);
		al = biz.findAlbumById(aid);
		session.put("album", al);
		return INPUT;
	}
	
	public Album getAl(){
		return al;
	}
	
	
	public String getUrl(){
		return al.getImageUrl();
	}

	public void validate()
	{
		super.validate();
		if( notLoginException != null){
			return;
		}
		if( method.equals("POST" )){
			al = (Album) session.get("album");
			if(al == null ){
				return;
			}
			MyLog.log(this, al.getAlbumName());
			if( upload != null ){
				String ext = Tokenizer.getExtension(uploadFileName);
				MyLog.log(this, "ext="+ext);
				if( !Tokenizer.isValidPicExt(ext) ){
					this.addFieldError("error", Constants.imgFormatCheck);
					return;
				}else{
					String newFileName = DateUtil.getTime() + ext;
					try {
						IOUtil.deleteFile(Constants.filePath + al.getImageUrl());
						IOUtil.save(upload, Constants.filePath + newFileName);
						al.setImageUrl(newFileName);
					} catch (IOException e) {
						this.addFieldError("error", Constants.fileSaveError);
						e.printStackTrace();
						return;
					} 
				}
			}
			
			al.setAlbumName(name);
			al.setDescription(description);
			MyLog.log(this, al.getAlbumName());
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
