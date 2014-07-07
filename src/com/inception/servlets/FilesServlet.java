package com.inception.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inception.biz.Biz;
import com.inception.constants.Constants;
import com.inception.log.MyLog;

public class FilesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Biz biz = Biz.newInstance();



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		String s_uid = request.getParameter("uid");   
		if( url!= null && !url.isEmpty()){
			try {
				biz.musicCTRInc(url);
				MyLog.log(this, "click " + url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if( s_uid != null && !s_uid.isEmpty() ){
				int uid = Integer.valueOf(s_uid);
				try {
					biz.addHistory(uid, url);
					MyLog.log(this, "history "+uid+ " " + url);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		response.setStatus(304);
		if(url == null || url.isEmpty()){
			url = Constants.defaultMusic;
		}
		else if( url.endsWith(".mp3")){
			response.setContentType("audio/x-mpeg");
		}
		else if( url.endsWith(".jpg") ){
			response.setContentType("image/jpeg");
		}
		url = Constants.filePath + url;
		File f = new File(url);
		FileInputStream fis = new FileInputStream(f);
//		response.setContentLength((int)f.length());
//		response.setHeader("Content-Disposition","filename=default.m3");  
//		response.addHeader("", "");
		MyLog.log(this, "filelen=" + f.length());
		ServletOutputStream out = response.getOutputStream();
		
		int size = 0;
		byte[] buf = new byte[1024];
		
		while( (size = fis.read(buf)) > 0 ){
			out.write(buf, 0 , size);
		}
		out.flush();
		fis.close();
		
		out.close();
		
		

	}



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		resp.setStatus(304);
		MyLog.log(this, req.getMethod());
		resp.setStatus(304);
		doGet(req, resp);
		resp.setStatus(304);
//		resp.getOutputStream().write("hello,world".getBytes());
	}
	
}
