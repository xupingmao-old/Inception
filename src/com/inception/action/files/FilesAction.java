package com.inception.action.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.inception.biz.Biz;
import com.inception.entity.Music;
import com.inception.entity.User;
import com.inception.log.MyLog;
import com.opensymphony.xwork2.ActionSupport;

public class FilesAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private InputStream input;
	private Biz biz = Biz.newInstance();
	
	public String execute(String url) throws SQLException, IOException
	{
//		getInput();
		return SUCCESS;
		
	}
	
	
	public InputStream getInput() throws IOException, SQLException
	{
		url = ServletActionContext.getRequest().getParameter("url");
		Map<String, Object > session = ServletActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if( u == null){
			MyLog.log( getClass().toString() + ": user is null ");
		}
		else if( url == null || url.isEmpty() ){
			MyLog.log(getClass().toString() + ": url is null");
		}
		else
		{
			MyLog.log( getClass().toString() +": user = " + u.getUserName());
			Biz biz = Biz.newInstance();
			Music m = biz.findMusicByUrl(url);
			if( m != null ){
				
				biz.addHistory( u.getId(), m.getId() );
				MyLog.log("add history " + u.getId() + " " + m.getId());
				
			}
			
		}

		if( url != null && !url.isEmpty()){
			try {
				biz.musicCTRInc(url);
//				MyLog.log("update " +url);
				MyLog.log("click " + url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		input = new FileInputStream("E:\\music\\"+url);
//		
//		int size = 0;
//		byte[] buf = new byte[2048];
//		OutputStream out = response.getOutputStream();
//		
//		
//		while ( (size = input.read(buf)) > 0 ){
//			out.write(buf, 0, size);
//		}
//		input.close();
//		out.close();
		
		return input;
	}
}
