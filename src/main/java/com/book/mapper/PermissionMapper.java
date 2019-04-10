package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Permission;


/**
 * @author jiege
 * @explain 权限信息操作接口
 * @time 2019/3/15 21:12
 */
public interface PermissionMapper {
	/**
	 * @function 权限增加
	 * @param Permission 权限实体类 
	 */
	void addPermission(Permission permission);
	/**
	 * @function 权限删除
	 * @param Permission 权限实体类 
	 */
	void deletePermission(Permission permission);
	/**
	 * @function 权限修改
	 * @param Permission 权限实体类 
	 */
	void updatePermission(Permission permission);
	/**
	 * @function 获取所有权限
	 * @return Permission 权限实体类 
	 */
	List<Permission> getAllPermission();
	/**
	 * @function 根据权限类ID获取对应权限
	 * @return Permission 权限实体类 
	 * @param id 权限id
	 */
	Permission getPermission(@Param("id")int id);
	/**
	 * @function 根据权限类名称获取对应权限
	 * @return Permission 权限实体类 
	 * @param name 权限名称
	 */
	Permission get_namePermission(@Param("name")String name);
}
