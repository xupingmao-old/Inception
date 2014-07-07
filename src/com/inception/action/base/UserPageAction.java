package com.inception.action.base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Page;

public class UserPageAction extends UserBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	protected List<Page> pageList = new ArrayList<Page>();
	protected int pageCount;
	protected int start;
	protected int countPerPage = 10;
	protected int recordsCount ;
	protected int curPage;
	protected String baseHref = "/Inception/AdminMain.action?start=";
	protected String sessionStartName = "start";
	
	
	public void setPageInfo(int total, int count, String href){
		recordsCount = total;
		countPerPage = count;
		baseHref = href;
	}
	
	public void doPages(int total, int count, String href){
		setPageInfo(total, count, href);
		if( recordsCount % countPerPage == 0){
			pageCount = recordsCount / countPerPage;
		}else{
			pageCount = recordsCount / countPerPage + 1;
		}
		
		pageList.clear();
		for(int i = 0; i < pageCount; i++){
			Page p = new Page();
			p.setIndex(i+1);
			p.setHref(baseHref+i);
			pageList.add(p);
		}
		
		String s_start = ServletActionContext.getRequest().getParameter("start");
		if( s_start == null){
			start = 0;
			s_start = (String) session.get(sessionStartName);
		}

		if( s_start != null ){
			start = Integer.parseInt(s_start);
		}
		
		session.put(sessionStartName, String.valueOf(start));
		curPage = start + 1;
		start = start * countPerPage;
	}
	
	public String execute() throws SQLException, NotLoginException, PermissionFailException{

		return super.execute();
	}

	/**
	 * @param pageList the pageList to set
	 */
	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}

	/**
	 * @return the pageList
	 */
	public List<Page> getPageList() {
		return pageList;
	}
	
	public String getCurPage(){
		return String.valueOf(curPage);
	}
}
