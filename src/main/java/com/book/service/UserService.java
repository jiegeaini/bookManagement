package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.User;


/**
 * @author jiege
 * @explain 管理员信息操作接口
 * @time 2019/3/15 19:02
 */
public interface UserService {
	
	/**
	 * @function 管理员增加
	 * @param user 管理员实体类 
	 */
	void addUser(User user);
	/**
	 * @function 管理员删除
	 * @param user 管理员实体类 
	 */
	void deleteUser(User user);
	/**
	 * @function 管理员修改
	 * @param user 管理员实体类 
	 */
	void updateUser(User user);
	/**
	 * @function 获取所有管理员
	 * @return user 管理员实体类 
	 */
	List<User> getAllUser();
	/**
	 * @function 根据管理员类ID获取对应管理员
	 * @return user 管理员实体类 
	 * @param id 管理员id
	 */
	User getUser(@Param("id")int id);
	/**
	 * @function 根据管理员类名称获取对应管理员
	 * @return user 管理员实体类 
	 * @param username 管理员名称
	 */
	User get_nameUser(@Param("username")String username);
}
