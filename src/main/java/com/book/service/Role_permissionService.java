package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Role_permission;

/**
 * @author jiege
 * @explain 角色关联权限信息操作接口
 * @time 2019/3/17 16:46
 */
public interface Role_permissionService {
	/**
	 * @function 角色关联权限增加
	 * @param user 角色关联权限实体类 
	 */
	void addRole_permission(Role_permission role_permission);
	/**
	 * @function 角色关联权限删除
	 * @param Role_permission 角色关联权限实体类 
	 */
	void deleteRole_permission(Role_permission role_permission);
	/**
	 * @function 角色关联权限修改
	 * @param Role_permission 角色关联权限实体类 
	 */
	void updateRole_permission(Role_permission role_permission);
	/**
	 * @function 获取所有角色关联权限
	 * @return Role_permission 角色关联权限实体类 
	 */
	List<Role_permission> getAllRole_permission();
	/**
	 * @function 根据角色关联权限类ID获取对应角色关联权限
	 * @return Role_permission 角色关联权限实体类 
	 * @param id 角色关联权限id
	 */
	Role_permission getRole_permission(@Param("id")int id);
	/**
	 * @function 根据角色名查询相应权限
	 * @return Role_permission 角色关联权限实体类 
	 * @param name 角色名
	 */
	List<Role_permission> get_RoleNameRole_permission(@Param("name")String name);
	/**
	 * @function 根据权限名查询相应权限
	 * @return Role_permission 角色关联权限实体类 
	 * @param name 权限名
	 */
	List<Role_permission> get_PermissionNameRole_permission(@Param("name")String name);
}
