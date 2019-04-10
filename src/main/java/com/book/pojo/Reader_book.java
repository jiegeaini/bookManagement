package com.book.pojo;

/**
 * @author jiege
 * @explain 读者借书关联实体类
 * @time 2019/3/15 0:50
 */
public class Reader_book {
	/**读者借书id*/
	private int id;
	/**关联的读者*/
	private Reader reader;
	/**关联的书籍*/
	private Book book;
	/**关联的状态*/
	private State state;
	/**租借时间*/
	private String time;
	/**到期时间*/
	private String expirationTime;
	/**收款*/
	private String money;
	/**押金*/
	private String TheDeposit;
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
	 * @return the reader
	 */
	public Reader getReader() {
		return reader;
	}
	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the expirationTime
	 */
	public String getExpirationTime() {
		return expirationTime;
	}
	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}
	/**
	 * @return the theDeposit
	 */
	public String getTheDeposit() {
		return TheDeposit;
	}
	/**
	 * @param theDeposit the theDeposit to set
	 */
	public void setTheDeposit(String theDeposit) {
		TheDeposit = theDeposit;
	}
	
	
}
