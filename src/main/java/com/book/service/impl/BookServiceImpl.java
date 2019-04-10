package com.book.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.mapper.BookMapper;
import com.book.pojo.Author;
import com.book.pojo.Book;
import com.book.pojo.Category;
import com.book.service.AuthorService;
import com.book.service.BookService;
import com.book.service.CategoryService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper mapper;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AuthorService authorService;
	
	@Override
	public void addBook(Book book,String categoryName,String authorName) {
		Category category = categoryService.get_nameCategory(categoryName);
		Author author = authorService.get_nameAuthor(authorName);
		book.setCategory(category);
		book.setAuthor(author);
		mapper.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		mapper.deleteBook(id);
	}

	@Override
	public void updateBook(Book book,String categoryName,String authorName) {
		Category category = categoryService.get_nameCategory(categoryName);
		Author author = authorService.get_nameAuthor(authorName);
		book.setCategory(category);
		book.setAuthor(author);
		mapper.updateBook(book);
	}

	@Override
	public List<Book> getAllBook() {
		return mapper.getAllBook();
	}

	@Override
	public Book getBook(int id) {
		return mapper.getBook(id);
	}

	@Override
	public Book get_nameBook(String name) {
		return mapper.get_nameBook(name);
	}

	@Override
	public List<Book> get_categoryBook(Category category) {
		return mapper.get_categoryBook(category);
	}

	@Override
	public List<Book> get_authorBook(Author author) {
		return mapper.get_authorBook(author);
	}

	@Override
	public List<Reader_bookNum_Tenbook> geTencategory_num() {
		float number = getBookNum();
		List<Reader_bookNum_Tenbook> rbtList = new ArrayList<>();
		List<Reader_bookNum_Tenbook> list = mapper.geTencategory_num();
		for (Reader_bookNum_Tenbook rbt : list) {
			float percent = (rbt.getNum()/number);
//			DecimalFormat decimalFormat=new DecimalFormat("0.00");
//			String p=decimalFormat.format(percent);
			rbt.setPercent(percent);
			rbtList.add(rbt);
		}
		return rbtList;
	}

	@Override
	public int getBookNum() {
		return mapper.getBookNum();
	}

}
