package com.inception.action.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.inception.action.base.AdminBaseAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Album;
import com.inception.log.MyLog;
import com.inception.util.DateUtil;
import com.inception.util.IOUtil;
import com.inception.util.Tokenizer;

public class AddAlbumAction extends AdminBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Album al = new Album();
	private File img;
	private String imgFileName;
	
	public void setImg(File img){
		this.img = img;
	}
	
	public void setImgFileName(String name){
		imgFileName = name;
	}
	
	public void setAl(Album al){
		this.al = al;
	}
	
	public Album getAl(){
		return al;
	}

	public String execute() throws NotLoginException, PermissionFailException, SQLException
	{
		super.execute();
		if (method.equals("POST")){
			try {
				biz.addAlbum(al);
				MyLog.log(this, "name="+al.getAlbumName());
				MyLog.log(this, "zone="+al.getImageUrl());
			} catch (SQLException e) {
				e.printStackTrace();
				this.addFieldError("error", e.getMessage());
			}
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void validate(){
		super.validate();
		if( method.equals("POST") ){
			if( al.getAlbumName().isEmpty() ){
				this.addFieldError("error", Constants.nameIsNull);
				return;
			}
			if( al.getPublishDate().isEmpty()){
				al.setPublishDate(null);
			}
			if( img != null ){
				String ext = Tokenizer.getExtension(imgFileName);
				MyLog.log(this, "ext="+ext);
				if( !Tokenizer.isValidPicExt(ext) ){
					this.addFieldError("error", Constants.imgFormatCheck);
					return;
				}else{
					String newFileName = DateUtil.getTime() + ext;
					try {
						IOUtil.save(img, Constants.filePath + newFileName);
						al.setImageUrl(newFileName);
					} catch (IOException e) {
						this.addFieldError("error", Constants.fileSaveError);
						e.printStackTrace();
						return;
					} 
				}
			}
		}
	}
	
	
}
