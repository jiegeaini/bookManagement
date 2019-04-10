package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.pojo.Author;
import com.book.pojo.Reader_book;
import com.book.pojo.Category;


/**
 * @author jiege
 * @explain 读者借书信息操作接口
 * @time 2019/3/16 16:53
 */
public interface Reader_bookService {
	
	/**
	 * @function 读者借书增加
	 * @param Reader_book 读者借书实体类 
	 */
	void addReader_book(Reader_book reader_book);
	/**
	 * @function 读者借书删除
	 * @param Reader_book 读者借书实体类 
	 */
	void deleteReader_book(int id);
	/**
	 * @function 读者借书修改
	 * @param Reader_book 读者借书实体类 
	 */
	void updateReader_book(Reader_book reader_book);
	/**
	 * @function 获取所有读者借书
	 * @return Reader_book 读者借书实体类 
	 */
	List<Reader_book> getAllReader_book();
	/**
	 * @function 根据id获取对应读者借书
	 * @return Reader_book 读者借书实体类 
	 * @param id 
	 */
	Reader_book getReader_book(@Param("id")int id);
	/**
	 * @function 根据读者名称获取对应读者借书
	 * @return Reader_book 读者借书实体类 
	 * @param name 读者名称
	 */
	List<Reader_book> get_ReaderName_Reader_book(@Param("name")String name);
	/**
	 * @function 根据图书名称获取对应读者借书
	 * @return Reader_book 读者借书实体类 
	 * @param name 读者借书名称
	 */
	List<Reader_book> get_BookNameReader_book(@Param("name")String name);
	/**
	 * @function 根据读者借书分类获取对应读者借书
	 * @return Reader_book 读者借书实体类 
	 * @param category 读者借书分类
	 */
	List<Reader_book> get_categoryReader_book(Category category);
	/**
	 * @function 根据读者借书作者获取对应读者借书
	 * @return Reader_book 读者借书实体类 
	 * @param author 读者借书作者
	 */
	List<Reader_book> get_authorReader_book(Author author);
	/**
	 * @function 查出借书最多的图书前十名
	 * @return
	 */
	List<Reader_bookNum_Tenbook> geTenbooks();
	/**
	 * @function 查出借书最多的作者前十名
	 * @return
	 */
	List<Reader_bookNum_Tenbook> geTenauthor();
	/**
	 * @function 查出借书最多的读者前十名
	 * @return
	 */
	List<Reader_bookNum_Tenbook> geTenreader();
	/**
	 * @function 查出借书最多的分类前十名
	 * @return
	 */
	List<Reader_bookNum_Tenbook> geTencategory();
	/**
	 * @function 查出一共借了多少书
	 * @return
	 */
	int getReader_bookNum();
}
