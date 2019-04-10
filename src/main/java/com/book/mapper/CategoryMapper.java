package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Category;

/**
 * @author jiege
 * @explain 书籍分类信息接口
 * @time 2019/3/15 21:27
 */
public interface CategoryMapper {
	/**
	 * @function 书籍分类增加
	 * @param Category 书籍分类实体类 
	 */
	void addCategory(Category category);
	/**
	 * @function 书籍分类删除
	 * @param id 
	 */
	void deleteCategory(@Param("id")int id);
	/**
	 * @function 书籍分类修改
	 * @param Category 书籍分类实体类 
	 */
	void updateCategory(Category category);
	/**
	 * @function 获取所有书籍分类
	 * @return Category 书籍分类实体类 
	 */
	List<Category> getAllCategory();
	/**
	 * @function 根据书籍分类类ID获取对应书籍分类
	 * @return Category 书籍分类实体类 
	 * @param id 书籍分类id
	 */
	Category getCategory(@Param("id")int id);
	/**
	 * @function 根据书籍分类类名称获取对应书籍分类
	 * @return Category 书籍分类实体类 
	 * @param name 书籍分类名称
	 */
	Category get_nameCategory(@Param("name")String name);
}
