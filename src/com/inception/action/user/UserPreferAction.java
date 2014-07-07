package com.inception.action.user;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.UserPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;
import com.inception.entity.Preference;

public class UserPreferAction extends UserPageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Preference> list;
	
	public List<Preference> getList(){
		return list;
	}

	public String execute() throws SQLException, NotLoginException, PermissionFailException{
		super.execute();
		recordsCount = biz.getPreferCount(user.getId());
		sessionStartName = "u-p-start";
		doPages(recordsCount, 10, "/Inception/UserPrefer.action?start=");
		
		list = biz.getPreferList(user.getId(), start, 10);
		for(int i = 0; i < list.size(); i++){
			Preference p = list.get(i);
			Music m = biz.findMusicById(p.getMusicId());
			p.setMusic(m);
		}
		return SUCCESS;
	}
}
