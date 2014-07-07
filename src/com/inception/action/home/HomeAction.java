package com.inception.action.home;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.HomeBaseAction;
import com.inception.entity.Music;

public class HomeAction extends HomeBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Music> list;
	private List<Music> hotList;
	
	public String execute() throws SQLException{
		super.execute();
//		int start = 0;
//		
//		String s_start = ServletActionContext.getRequest().getParameter("start");
//		if( s_start != null && !s_start.isEmpty()){
//			start = Integer.parseInt(s_start);
//		}
		list = biz.getLatestMusic(0, 12);
		hotList = biz.getTopMusic(0, 12);
		return SUCCESS;
	}
	
	public List<Music> getHotList(){
		return hotList;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Music> list) {
		this.list = list;
	}

	/**
	 * @return the list
	 */
	public List<Music> getList() {
		return list;
	}
}
