package com.book.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.pojo.Author;
import com.book.pojo.Book;
import com.book.pojo.Category;
import com.book.service.AuthorService;
import com.book.service.BookService;
import com.book.service.CategoryService;

/**
 * 
 * @author jiege
 * @time 2019/3/19
 * @explain 用来进行对书籍数据处理的业务类
 */
@Service
public class BookDataService {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	AuthorService authorService;
	@Autowired
	BookService bookService;
	
	/**
	 * @function 在增加书籍前，判断关联的作者和分类是否为空
	 * @param categoryId
	 * @param authorName
	 * @return
	 */
	public boolean booleanAddBook(String categoryName,String authorName,String bookName,int id) {
		
		Category category = categoryService.get_nameCategory(categoryName);
		Author author = authorService.get_nameAuthor(authorName);
		if (id == 0) {
			Book book = bookService.get_nameBook(bookName);
			if(book != null) {
				System.out.println("书籍重名");
				return false;
			}
		}else {
			if (bookName != bookService.getBook(id).getName()) {
				Book book = bookService.get_nameBook(bookName);
				if(book != null) {
					return false;
				}
			}
		}
		
		
		
		if (category != null && author != null) {
			return true;
		} else {
			return false;
		}
	}
}
