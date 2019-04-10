package com.book.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.pojo.Author;
import com.book.pojo.Book;
import com.book.service.AuthorService;
import com.book.service.BookService;

@Service
public class AuthorDataService {

	@Autowired
	BookService bookService;
	@Autowired
	AuthorService authorService;
	
	public boolean deleteAuthor(int id) {
		Author author = authorService.getAuthor(id);
		List<Book> books = bookService.get_authorBook(author);
		if (books.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
}
