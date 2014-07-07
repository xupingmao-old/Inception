package com.inception.action.home;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.HomePageAction;
import com.inception.entity.Music;

public class ShowAllAction extends HomePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Music> list;
	
	public List<Music> getList(){
		return list;
	}
	
	public String execute() throws SQLException{
		super.execute();
		
		int count = biz.getMusicCount();
		sessionStartName = "h-m-start";
		doPages(count, 15, "/Inception/ShowAll.action?start=");
		list = biz.listMusicLimit(start, 15 );
		return SUCCESS;
	}
	

}
