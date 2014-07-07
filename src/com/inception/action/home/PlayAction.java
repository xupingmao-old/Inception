package com.inception.action.home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.HomeBaseAction;
import com.inception.entity.Music;
import com.inception.log.MyLog;


public class PlayAction extends HomeBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private Music m;
	private List<Music> list;
	private boolean prefer;
	
	public boolean getPrefer(){
		return prefer;
	}
	
	public List<Music> getList(){
		return list;
	}
	
	public Music getM(){
		return m;
	}
	
	public String getLrc(){
		if( m != null )
			return m.getLyrics();
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		super.execute();
		url = ServletActionContext.getRequest().getParameter("url");
//		album = ServletActionContext.getRequest().getParameter("album");
//		if( album != null && !album.isEmpty() ){
//			album = UrlUtil.decode(album);
//			list = biz.getMusicListByAlbum(album);
//		}
		list = (List<Music>)session.get("musicList");
		if( list == null ){
			list = new ArrayList<Music>();
		}
		if( url == null || url.isEmpty() ){
			
			if( list.size() == 0 ){
				m = biz.getLastMusic();
				list.add(m);
			}else{
				m = list.get(0);
			}
		}else{
			m = biz.findMusicByUrl(url);
			if( !listHas(list, m) ){
				list.add(m);
			}
		}
		biz.musicCTRInc(m.getMusicUrl());
		
		if( user!= null && url != null){
			biz.addHistory(user.getId(), url);
			MyLog.log(this, "history "+user.getId()+ " " + url);
		}
//		MyLog.log(this, "lrc="+lrc);
		session.put("musicList", list);
		if( user != null ){
			prefer = biz.isPrefered(user.getId(), m.getId());
		}
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
