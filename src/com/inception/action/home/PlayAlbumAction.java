package com.inception.action.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.HomeBaseAction;
import com.inception.entity.Music;
import com.inception.util.UrlUtil;

public class PlayAlbumAction extends HomeBaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Music> list;
	private String album;
	private Music m;
	
	public List<Music> getList(){
		return list;
	}
	
	public Music getM(){
		return m;
	}
	
	public String getLrc(){
		if( m != null ){
			return m.getLyrics();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		super.execute();
		HttpServletRequest req = ServletActionContext.getRequest();
		album = req.getParameter("album");
		album = UrlUtil.decode(album);
		List<Music> list2 = biz.getMusicListByAlbum(album);
		list = (List<Music>) session.get("musicList");
		if( list == null ){
			list = new ArrayList<Music>();
		}
		for(int i = 0; i < list2.size(); i++){
			Music m2 = list2.get(i);
			if( !listHas(list, m2 ) ){
				list.add(m2);
			}
		}
		if( list2.size() != 0){
			m = list2.get(0);
		}else{
			if( list.size() == 0){
				m = biz.getLastMusic();
				list.add(m);
			}else{
				m = list.get(0);
			}
		}
		biz.musicCTRInc(m.getMusicUrl());
		session.put("musicList", list);
		session.put("m", m);
		return SUCCESS;
		
	}
	
	public boolean listHas(List<Music> list, Music m){
		for(int i = 0; i < list.size() ; i++){
			Music m1 = list.get(i);
			if( m.getId() == m1.getId() ){
				return true;
			}
		}
		return false;
	}

}
