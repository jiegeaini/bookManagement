package com.book.pojo;

/**
 * @author jiege
 * @explain 角色与权限关联实体类
 * @time 2019/3/15 0:35
 */
public class Role_permission {
	/**角色与权限关联id*/
	private int id;
	/**关联角色*/
	private Role role;
	/**关联权限*/
	private Permission permission;
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
	/**
	 * @return the permission
	 */
	public Permission getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
}
