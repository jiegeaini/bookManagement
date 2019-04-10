package com.book.dataservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.pojo.Reader_book;
import com.book.service.AuthorService;

import com.book.service.Reader_bookService;

@Service
public class StateDataService {

	@Autowired
	Reader_bookService rbService;
	@Autowired
	AuthorService authorService;
	
	public boolean deleteState(int id) {
		List<Reader_book> list = rbService.getAllReader_book();
		
		for (Reader_book reader_book : list) {
			if (reader_book.getState().getId() == id) {
				return false;
			}
		}
		return true;
	}
	
}
