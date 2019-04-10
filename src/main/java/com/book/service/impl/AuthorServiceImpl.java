package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.AuthorMapper;
import com.book.pojo.Author;
import com.book.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorMapper mapper;
	
	@Override
	public void addAuthor(Author author) {		
		mapper.addAuthor(author);		
	}

	@Override
	public void deleteAuthor(int id) {
		mapper.deleteAuthor(id);
	}

	@Override
	public void updateAuthor(Author author) {
		mapper.updateAuthor(author);
	}

	@Override
	public List<Author> getAllAuthor() {
		return mapper.getAllAuthor();
	}

	@Override
	public Author getAuthor(int id) {
		return mapper.getAuthor(id);
	}

	@Override
	public Author get_nameAuthor(String name) {
		return mapper.get_nameAuthor(name);
	}

}
