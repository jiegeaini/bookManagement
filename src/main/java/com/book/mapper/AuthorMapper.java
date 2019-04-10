package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Author;


/**
 * @author jiege
 * @explain 作者信息操作接口
 * @time 2019/3/15 21:23
 */
public interface AuthorMapper {
	/**
	 * @function 作者增加
	 * @param Author 作者实体类 
	 */
	void addAuthor(Author author);
	/**
	 * @function 作者删除
	 * @param id 
	 */
	void deleteAuthor(@Param("id")int id);
	/**
	 * @function 作者修改
	 * @param Author 作者实体类 
	 */
	void updateAuthor(Author author);
	/**
	 * @function 获取所有作者
	 * @return Author 作者实体类 
	 */
	List<Author> getAllAuthor();
	/**
	 * @function 根据作者类ID获取对应作者
	 * @return Author 作者实体类 
	 * @param id 作者id
	 */
	Author getAuthor(@Param("id")int id);
	/**
	 * @function 根据作者类名称获取对应作者
	 * @return Author 作者实体类 
	 * @param name 作者名称
	 */
	Author get_nameAuthor(@Param("name")String name);
}
