package com.inception.action.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.inception.biz.Biz;
import com.inception.constants.Constants;
import com.inception.entity.Music;
import com.inception.entity.User;
import com.inception.log.MyLog;
import com.opensymphony.xwork2.ActionSupport;

public class UserHistoryAction extends ActionSupport
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private InputStream fis;
	private Biz biz = Biz.newInstance();
	
	public String execute(String url) throws SQLException, FileNotFoundException
	{
		Map<String, Object > session = ServletActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if( u == null){
			MyLog.log( getClass().toString() + ": user == null ");
		}else
		{
			MyLog.log( getClass().toString() +": user != null");
			Biz biz = Biz.newInstance();
			Music m = biz.findMusicByUrl(url);
			if( m != null ){
				biz.addHistory( u.getId(), m.getId() );
				MyLog.log(this, "add history " + u.getId() + " " + m.getId());
			}
			
		}

		
		try {
			biz.musicCTRInc(url);
//			new UserHistoryAction().add(url);
			MyLog.log("update " +url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		if(url == null || url.isEmpty()){
			url = "default.mp3";
		}
		else if( url.endsWith(".mp3")){
			response.setContentType("audio/mp3");
		}
		else if( url.endsWith(".jpg") ){
			response.setContentType("image/jpeg");
		}
		fis = new FileInputStream(Constants.filePath+url);
		
		
		return SUCCESS;
		
	}
	
	
	public InputStream getDownloadFile()
	{
		return fis;
	}
}
