package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.State;

/**
 * @author jiege
 * @explain 借书状态接口
 * @time 2019/3/15 0:57
 */
public interface StateMapper {
	/**
	 * @function 状态增加
	 * @param state 状态实体类 
	 */
	void addState(State state);
	/**
	 * @function 状态删除
	 * @param id
	 */
	void deleteState(int id);
	/**
	 * @function 状态修改
	 * @param state 状态实体类 
	 */
	void updateState(State state);
	/**
	 * @function 获取所有状态
	 * @return state 状态实体类 
	 */
	List<State> getAllState();
	/**
	 * @function 根据状态类ID获取对应状态
	 * @return state 状态实体类 
	 * @param id 状态id
	 */
	State getState(@Param("id")int id);
	/**
	 * @function 根据状态类名称获取对应状态
	 * @return state 状态实体类 
	 * @param name 状态名称
	 */
	State get_nameState(@Param("name")String name);
}
