package com.inception.entity;

public class Page {
	private int index;
	private String href;
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param count the count to set
	 */
	public void setIndex(int count) {
		this.index = count;
	}
	/**
	 * @return the count
	 */
	public int getIndex() {
		return index;
	}
}
