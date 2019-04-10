package com.book.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.pojo.Book;
import com.book.pojo.Category;
import com.book.service.BookService;
import com.book.service.CategoryService;

@Service
public class CategoryDataService {
	
	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	
	public boolean booleanDeleteCategory(int id) {		
		Category category = categoryService.getCategory(id);
		List<Book> list =  bookService.get_categoryBook(category);
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
