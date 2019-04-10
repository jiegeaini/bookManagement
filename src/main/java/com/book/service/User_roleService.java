package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.User_role;


/**
 * @author jiege
 * @explain 用户关联角色信息操作接口
 * @time 2019/3/17 15:34
 */
public interface User_roleService {
	
	/**
	 * @function 用户关联角色增加
	 * @param User_role 用户关联角色实体类 
	 */
	void addUser_role(User_role user_role);
	/**
	 * @function 用户关联角色删除
	 * @param User_role 用户关联角色实体类 
	 */
	void deleteUser_role(User_role user_role);
	/**
	 * @function 用户关联角色修改
	 * @param User_role 用户关联角色实体类 
	 */
	void updateUser_role(User_role user_role);
	/**
	 * @function 获取所有用户关联角色
	 * @return User_role 用户关联角色实体类 
	 */
	List<User_role> getAllUser_role();
	/**
	 * @function 根据用户关联角色类ID获取对应用户关联角色
	 * @return User_role 用户关联角色实体类 
	 * @param id 用户关联角色id
	 */
	User_role getUser_role(@Param("id")int id);
	/**
	 * @function 根据用户名查询相应角色
	 * @return User_role 用户关联角色实体类 
	 * @param name 用户名
	 */
	List<User_role> get_UserNameUser_role(@Param("name")String name);
	/**
	 * @function 根据角色名查询相应用户
	 * @return User_role 用户关联角色实体类 
	 * @param name 角色名
	 */
	List<User_role> get_RoleNameUser_role(@Param("name")String name);
}
