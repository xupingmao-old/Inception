package com.inception.action.admin;

import java.sql.SQLException;
import java.util.List;

import com.inception.action.base.AdminPageAction;
import com.inception.action.exception.NotLoginException;
import com.inception.action.exception.PermissionFailException;
import com.inception.entity.Page;
import com.inception.entity.User;
import com.inception.log.MyLog;

public class AdminMainAction extends AdminPageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private List<User> list;
	private String userList;
	private int usersCount;
	private String operation;
	private String type;
//	
//	public AdminMainAction(){
//		super();
//	}
//	
	
	public void setType(String t){
		type = t;
	}
	public String getType(){
		return type;
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	// test passed, chinese characters are supported;
//	private String test = "����";
	
	public String execute() throws NotLoginException, PermissionFailException, SQLException{
		//operation = ServletActionContext.getRequest().getParameter("operation");
		super.execute();
		
		if( method.equals("POST" ) ){
			MyLog.log(this,operation);
			MyLog.log(this,userList);
			if( operation == null ){
				
			}
			else if( operation.equals("delete")){
				doDelete();
			}
			else if( operation.equals("permission_to_super") ){
				doSuper();
			}
			else if( operation.equals("permission_to_normal")){
				doNormal();
			}
			
			if( type != null && type.equals("music_add") ){
				return "music_add";
			}
			setUsersCount(biz.getUsersCount());
			recordsCount = usersCount;
			sessionStartName = "u-start";
			doPages(recordsCount, 10, "/Inception/AdminMain.action?start=");
			list = biz.findUsersLimit(start, 10);
			setUserName(user.getUserName());
			return SUCCESS;
		}
		setUsersCount(biz.getUsersCount());
		recordsCount = usersCount;
		doPages(recordsCount, 10, "/Inception/AdminMain.action?start=");
		list = biz.findUsersLimit(start, 10);
		setUserName(user.getUserName());
		return INPUT;
		
	}

	public void doSuper() throws SQLException {
		if( userList == null){
			return;
		}
		if( userList.isEmpty() ){
			return;
		}
		String[] ids = userList.split(",");
		for(int i = 0; i < ids.length; i++){
			int id = Integer.valueOf(ids[i]);
			biz.makeSuperUser(id);
			MyLog.log(this, "super "+id);
		}
	}
	
	public void doNormal() throws SQLException, PermissionFailException {
		if( user.getPermission() < 2 ){
			throw new PermissionFailException();
		}
		if( userList == null){
			return;
		}
		if( userList.isEmpty() ){
			return;
		}
		String[] ids = userList.split(",");
		for(int i = 0; i < ids.length; i++){
			int id = Integer.valueOf(ids[i]);
			biz.makeNormalUser(id);
			MyLog.log(this, "normal "+id);
		}
	}

	public void doDelete() throws NumberFormatException, SQLException, PermissionFailException {
		
		if( user.getPermission() < 2){
			throw new PermissionFailException();
		}
		
		if( userList == null){
			return;
		}
		if( userList.isEmpty() ){
			return;
		}
		String[] ids = userList.split(",");
		for(int i = 0; i < ids.length; i++){
			int id = Integer.valueOf(ids[i]);
			biz.deleteUserById(id);
			MyLog.log(this,"delete "+id);
		}
	}

	public int getId() {
		return user.getId();
	}

	public void setId(int id) {
		user.setId(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<User> list) {
		this.list = list;
	}

	/**
	 * @return the list
	 */
	public List<User> getList() {
		return list;
	}

	/**
	 * @param usersCount the usersCount to set
	 */
	public void setUsersCount(int usersCount) {
		this.usersCount = usersCount;
	}

	/**
	 * @return the usersCount
	 */
	public int getUsersCount() {
		return usersCount;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(String userList) {
		this.userList = userList;
	}

	/**
	 * @return the userList
	 */
	public String getUserList() {
		return userList;
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

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
}
