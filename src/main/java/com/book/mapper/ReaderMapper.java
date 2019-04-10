package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Reader;

/**
 * @author jiege
 * @explain 读者信息操作接口
 * @time 2019/3/16 15:12
 */
public interface ReaderMapper {
	/**
	 * @function 读者增加
	 * @param Reader 读者实体类 
	 */
	void addReader(Reader reader);
	/**
	 * @function 读者删除
	 * @param id
	 */
	void deleteReader(int id);
	/**
	 * @function 读者修改
	 * @param Reader 读者实体类 
	 */
	void updateReader(Reader reader);
	/**
	 * @function 获取所有读者
	 * @return Reader 读者实体类 
	 */
	List<Reader> getAllReader();
	/**
	 * @function 根据读者类ID获取对应读者
	 * @return Reader 读者实体类 
	 * @param id 读者id
	 */
	Reader getReader(@Param("id")int id);
	/**
	 * @function 根据读者类名称获取对应读者
	 * @return Reader 读者实体类 
	 * @param name 读者名称
	 */
	Reader get_nameReader(@Param("name")String name);
}
