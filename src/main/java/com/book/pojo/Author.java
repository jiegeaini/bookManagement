package com.book.pojo;

/**
 * @author jiege
 * @explain 书籍作者实体类
 * @time 2019/3/15 0:45
 */
public class Author {
	/**书籍作者id*/
	private int id;
	/**书籍作者名称*/
	private String name;
	/**书籍作者介绍*/
	private String desc_;
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
	
	
}
