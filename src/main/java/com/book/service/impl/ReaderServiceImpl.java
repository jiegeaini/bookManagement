package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.ReaderMapper;
import com.book.pojo.Reader;
import com.book.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	ReaderMapper mapper;
	
	@Override
	public void addReader(Reader reader) {
		mapper.addReader(reader);
	}

	@Override
	public void deleteReader(int id) {
		mapper.deleteReader(id);
	}

	@Override
	public void updateReader(Reader reader) {
		mapper.updateReader(reader);
	}

	@Override
	public List<Reader> getAllReader() {
		return mapper.getAllReader();
	}

	@Override
	public Reader getReader(int id) {
		return mapper.getReader(id);
	}

	@Override
	public Reader get_nameReader(String name) {
		return mapper.get_nameReader(name);
	}

}
