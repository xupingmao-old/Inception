package com.inception.action.home;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.HomePageAction;
import com.inception.entity.Album;
import com.inception.util.UrlUtil;

public class AlbumAction extends HomePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Album> list;
	
	public List<Album> getList(){
		return list;
	}
	
	public String execute() throws SQLException{
		super.execute();
		int count = biz.getAlbumCount();
		sessionStartName = "h-al-start";
		doPages(count, 8, "/Inception/Album.action?start=");
		list = biz.getAlbumList(start, 8);
		//session.put("musicList", list);
		for(int i = 0; i < list.size(); i++){
			Album al = list.get(i);
			String name = al.getAlbumName();
			al.setEncodeName( UrlUtil.encode(name));
		}
		return SUCCESS;
	}
	

}
