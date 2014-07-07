package com.inception.action.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inception.action.base.HomeBaseAction;
import com.inception.entity.Music;

public class ClearPlayListAction extends HomeBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		super.execute();
		List<Music> list = (List<Music>)session.get("musicList");
		
		if( list == null ){
			list = new ArrayList<Music>();
		}else{
			list.clear();
		}
		session.put("musicList", list);
		return SUCCESS;
	}
}
