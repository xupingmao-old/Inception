package com.inception.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.inception.log.MyLog;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUploadAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadFileName;
	
	
	public String getFileExtension(){
		int i = uploadFileName.length() - 1;
		for( ; i >= 0; i--){
			if(uploadFileName.charAt(i) == '.'){
				break;
			}
		}
		return uploadFileName.substring(i);
	}
	
	public String getTime(){
		return String.valueOf(new Date().getTime());
	}
	
	public String execute() throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream("D:\\files\\" + getTime() + getFileExtension());
			FileInputStream fis = new FileInputStream(upload);
			byte[] buf = new byte[1024];
			int length = 0;
			while( (length = fis.read(buf) ) > 0){
				try {
					fos.write(buf, 0, length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public void validate(){
		MyLog.log(this, uploadFileName);
		
		if( uploadFileName == null){
			this.addFieldError("msg", "上传文件失败");
			return;
		}
		
		if( uploadFileName.endsWith(".mp3") || uploadFileName.endsWith(".wmv") ){
			return;
		}
		this.addFieldError("msg", "请上传音乐文件");
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
