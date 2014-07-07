package com.inception.action.home;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MusicAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String path;
	private String url;
	private InputStream downloadFile;
	public String execute(){
		// 会自动获取get值;
		//url = ServletActionContext.getRequest().getParameter("url");
		fileName = url;
		path = "E:\\music\\"+url;
		downloadFile = ServletActionContext.getServletContext().getResourceAsStream(path);
		return SUCCESS;
	}
	
	public InputStream getDownloadFile() throws Exception{
		downloadFile = new FileInputStream(path);
		return downloadFile;
	}
	
	public void setDownloadFile(InputStream in){
		downloadFile = in;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
}
