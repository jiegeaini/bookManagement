package com.book.pojo;

/**
 * @author jiege
 * @explain 借书读者实体类
 * @time 2019/3/15 0:40
 */
public class Reader {
	/**借书读者id*/
	private int id;
	/**借书读者名称*/
	private String name;
	/**借书读者身份证号*/
	private String IdNumber;
	/**借书读者手机号*/
	private String Number;
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
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return IdNumber;
	}
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return Number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		Number = number;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", IdNumber=" + IdNumber + ", Number=" + Number + "]";
	}
	
	
	
}
