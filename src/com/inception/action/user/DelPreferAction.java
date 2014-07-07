package com.inception.action.user;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.inception.action.base.UserPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Music;
import com.inception.entity.Preference;

public class DelPreferAction extends UserPageAction{

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
		pageCount = biz.getPreferCount(user.getId());
		String id = ServletActionContext.getRequest().getParameter("id");
		if( id != null && !id.isEmpty()){
			int iid = Integer.parseInt(id);
			biz.deletePrefer(iid);
		}
		list = biz.getPreferList(user.getId(), start, 10);
		for(int i = 0; i < list.size(); i++){
			Preference p = list.get(i);
			Music m = biz.findMusicById(p.getMusicId());
			p.setMusic(m);
		}
		sessionStartName = "u-p-start";
		doPages(pageCount, 10, "/Inception/UserPrefer.action?start=");
		return SUCCESS;
	}
}
