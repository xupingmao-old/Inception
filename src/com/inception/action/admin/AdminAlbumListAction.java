package com.inception.action.admin;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.AdminPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.constants.Constants;
import com.inception.entity.Album;
import com.inception.log.MyLog;

public class AdminAlbumListAction extends AdminPageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Album> list;
	private String allist;
	
	public List<Album> getList(){
		return list;
	}
	
	public void setAlList(String allist){
		this.allist = allist;
	}

	public String execute() throws SQLException, NotLoginException, PermissionFailException{
		super.execute();
		
		if( method.equals("POST")){
			doDel();
		}
		
		int total = biz.getAlbumCount();
		list = biz.getAlbumList(0, 12);
		sessionStartName = "al-start";
		doPages(total, 12, Constants.albumListHref);
		
		return SUCCESS;
	}

	private void doDel() throws SQLException {
		MyLog.log(this, "del "+allist);
		if( allist == null || allist.isEmpty()){
			return;
		}
		String[] l = allist.split(",");
		for(int i = 0; i < l.length ; i++){
			int id = Integer.parseInt(l[i]);
			biz.deleteAlbumById(id);
		}
	}
}
