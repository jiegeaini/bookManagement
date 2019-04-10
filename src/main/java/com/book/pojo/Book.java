package com.book.pojo;

/**
 * @author jiege
 * @explain 图书实体类
 * @time 2019/3/15 0:46
 */
public class Book {
	/**图书id*/
	private int id;
	/**图书名称*/
	private String name;
	/**图书作者*/
	private Author author;
	/**图书分类*/
	private Category category;
	/**图书介绍*/
	private String desc_;
	/**图书库存*/
	private int inventory;
	/**图书定价*/
	private int money;
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
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
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
	 * @return the inventory
	 */
	public int getInventory() {
		return inventory;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", desc_=" + desc_
				+ ", inventory=" + inventory + ", money=" + money + "]";
	}
	
	
	
}
