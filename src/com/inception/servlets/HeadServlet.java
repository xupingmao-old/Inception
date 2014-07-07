package com.inception.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inception.constants.Constants;
import com.inception.log.MyLog;

public class HeadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		response.setContentType("text/html; charset=UTF-8");
		
		MyLog.log(this, url);
		if( url == null || url.isEmpty() ){
			url = "head.jpg";
		}

		if( url.endsWith(".jpg") ){
			response.setContentType("image/jpeg");
		}else if( url.endsWith( ".png" )){
			response.setContentType("image/png");
		}
		url = Constants.filePath + url;
		File f = new File(url);
		response.setContentLength((int) f.length());
		FileInputStream fis = new FileInputStream(f);

		OutputStream out = response.getOutputStream();
		int size = 0;

		byte[] buf = new byte[2048];

		while ((size = fis.read(buf)) > 0) {
			out.write(buf, 0, size);
		}

		fis.close();
		out.close();
	}
}
