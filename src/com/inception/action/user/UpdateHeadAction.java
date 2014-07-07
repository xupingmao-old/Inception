package com.inception.action.user;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.inception.action.base.UserBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.User;
import com.inception.log.MyLog;
import com.inception.util.DateUtil;
import com.inception.util.IOUtil;

public class UpdateHeadAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File upload;
	private String uploadFileName;
	private String newFileName;

	public String execute() throws NotLoginException, PermissionFailException, SQLException
	
	{
		super.execute();
		if( method.equals("POST") ){
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void validate()
	{
		super.validate();
		if( !method.equals("POST")){
			return;
		}
		if( uploadFileName.endsWith(".jpg")){
			newFileName = DateUtil.getTime() + ".jpg";
		}
		else if( uploadFileName.endsWith(".png")  ){
			newFileName = DateUtil.getTime() + ".png";
		}
		else{
			this.addFieldError("error", "必须为png或jpg图像");
			return;
		}
		//newFileName = "E:\\music\\" + newFileName;
		try {
			IOUtil.save(upload,"E:\\music\\" +  newFileName);
			IOUtil.deleteFile("E:\\music\\" + user.getImageUrl());
			MyLog.log(this, uploadFileName);
			biz.updateUserHead(user, newFileName);
			super.updateSession();
		} catch (IOException e) {
			this.addFieldError("error", "文件上传失败");
		} catch (SQLException e) {
			this.addFieldError("error", e.getMessage());
		}
	}
	
	public void setUser(User u){
		this.user = u;
	}
	
	public User getUser(){
		return user;
	}

	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUpload(File uploadFile) {
		this.upload = uploadFile;
	}

	/**
	 * @return the uploadFile
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
