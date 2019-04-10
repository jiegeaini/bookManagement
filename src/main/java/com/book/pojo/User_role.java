package com.book.pojo;

/**
 * @author jiege
 * @explain 管理员与角色关联实体类
 * @time 2019/3/15 0:31
 */
public class User_role {
	/**管理员与角色关联id*/
	private int id;
	/**关联的管理员*/
	private User user;
	/**关联的角色*/
	private Role role;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
