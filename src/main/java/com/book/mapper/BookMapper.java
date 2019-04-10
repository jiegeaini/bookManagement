package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.pojo.Author;
import com.book.pojo.Book;
import com.book.pojo.Category;


/**
 * @author jiege
 * @explain 图书信息操作接口
 * @time 2019/3/15 19:02
 */
public interface BookMapper {
	
	/**
	 * @function 图书增加
	 * @param Book 图书实体类 
	 */
	void addBook(Book book);
	/**
	 * @function 图书删除
	 * @param id 图书id
	 */
	void deleteBook(@Param("id")int id);
	/**
	 * @function 图书修改
	 * @param Book 图书实体类 
	 */
	void updateBook(Book book);
	/**
	 * @function 获取所有图书
	 * @return Book 图书实体类 
	 */
	List<Book> getAllBook();
	/**
	 * @function 根据图书类ID获取对应图书
	 * @return Book 图书实体类 
	 * @param id 图书id
	 */
	Book getBook(@Param("id")int id);
	/**
	 * @function 根据图书类名称获取对应图书
	 * @return Book 图书实体类 
	 * @param name 图书名称
	 */
	Book get_nameBook(@Param("name")String name);
	/**
	 * @function 根据图书分类获取对应图书
	 * @return Book 图书实体类 
	 * @param category 图书分类
	 */
	List<Book> get_categoryBook(Category category);
	/**
	 * @function 根据图书作者获取对应图书
	 * @return Book 图书实体类 
	 * @param author 图书作者
	 */
	List<Book> get_authorBook(Author author);
	/**
	 * @function 查询各个分类的图书有多少个
	 * @return
	 */
	List<Reader_bookNum_Tenbook> geTencategory_num();
	/**
	 * @function 查询图书有多少个
	 * @return
	 */
	int getBookNum();
}
