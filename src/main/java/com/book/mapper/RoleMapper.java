package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Role;

/**
 * @author jiege
 * @explain 角色信息操作接口
 * @time 2019/3/15 19:16
 */
public interface RoleMapper {
	/**
	 * @function 角色增加
	 * @param Role 角色实体类 
	 */
	void addRole(Role role);
	/**
	 * @function 角色删除
	 * @param Role 角色实体类 
	 */
	void deleteRole(Role role);
	/**
	 * @function 角色修改
	 * @param Role 角色实体类 
	 */
	void updateRole(Role role);
	/**
	 * @function 获取所有角色
	 * @return Role 角色实体类 
	 */
	List<Role> getAllRole();
	/**
	 * @function 根据角色类ID获取对应角色
	 * @return Role 角色实体类 
	 * @param id 角色id
	 */
	Role getRole(@Param("id")int id);
	/**
	 * @function 根据角色类名称获取对应角色
	 * @return Role 角色实体类 
	 * @param desc 角色名称
	 */
	Role get_nameRole(@Param("name")String name);
}
