package com.book.pojo;

/**
 * @author jiege
 * @explain 权限实体类
 * @time 2019/3/15 0:27
 */
public class Permission {
	/**权限id*/
	private int id;
	/**权限名称*/
	private String name;
	/**权限介绍*/
	private String desc_;
	/**权限请求地址*/
	private String url;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the desc_
	 */
	public String getDesc_() {
		return desc_;
	}
	/**
	 * @param desc_ the desc_ to set
	 */
	public void setDesc_(String desc_) {
		this.desc_ = desc_;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
