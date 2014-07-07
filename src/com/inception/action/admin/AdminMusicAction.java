package com.inception.action.admin;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.AdminPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;
import com.inception.entity.Page;
import com.inception.entity.User;
import com.inception.util.IOUtil;

public class AdminMusicAction extends AdminPageAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Music> list;
	private String operation;
	private String musicList;
	
	public AdminMusicAction(){
		super();
	}

	public String execute() throws NotLoginException, PermissionFailException, SQLException {
		super.execute();
		if( method.equals("POST" )){
			doDelete();
		}
		
		recordsCount = biz.getMusicCount();
		
		sessionStartName = "m-start";
		doPages(recordsCount, 12, "/Inception/AdminMusic.action?start=");
		list = biz.listMusicLimit(start, 12);
		return SUCCESS;
	}
	private void doDelete() throws SQLException{
		if( musicList == null){
			return;
		}
		musicList = musicList.trim();
		if( musicList.isEmpty() ){
			return;
		}
		String [] ids = musicList.split(",");
		for(int i = 0; i < ids.length; i++){
			int id = Integer.parseInt(ids[i]);
			Music m = biz.findMusicById(id);
			if(m == null){
				break;
			}
			IOUtil.deleteFile("E:\\music\\"+m.getMusicUrl());
			biz.deleteMusicById(id);
		}
		operation = null;
		musicList = null;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		user.setId(id);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return user.getId();
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
	
	public void setPageList(List<Page> list){
		pageList = list;
	}
	
	public List<Page> getPageList(){
		return pageList;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param musicList the musicList to set
	 */
	public void setMusicList(String musicList) {
		this.musicList = musicList;
	}

	/**
	 * @return the musicList
	 */
	public String getMusicList() {
		return musicList;
	}
}
