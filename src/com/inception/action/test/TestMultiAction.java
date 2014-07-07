package com.inception.action.test;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class TestMultiAction extends ActionSupport{

	private List<String> list = new ArrayList<String>();
	public String execute(){
		for(int i = 0; i < list.size();i++){
			System.out.print(list.get(i) + ",");
		}
		System.out.println();
		return SUCCESS;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<String> list) {
		this.list = list;
	}
	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}
}
