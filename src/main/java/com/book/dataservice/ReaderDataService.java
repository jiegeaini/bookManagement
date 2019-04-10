package com.book.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.pojo.Reader;
import com.book.pojo.Reader_book;
import com.book.service.ReaderService;
import com.book.service.Reader_bookService;

@Service
public class ReaderDataService {
	
	@Autowired
	ReaderService readerService;
	@Autowired
	Reader_bookService reader_bookService;
	
	public boolean deleteReader(int id) {
		Reader reader = readerService.getReader(id);
		List<Reader_book> reader_books = 
				reader_bookService.get_ReaderName_Reader_book(reader.getName());
		if (reader_books.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
