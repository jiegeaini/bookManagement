package com.book.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.mapper.Reader_bookMapper;
import com.book.pojo.Author;
import com.book.pojo.Category;
import com.book.pojo.Reader_book;
import com.book.service.Reader_bookService;

@Service
public class Reader_bookServiceImpl implements Reader_bookService{

	@Autowired
	Reader_bookMapper mapper;
	
	@Override
	public void addReader_book(Reader_book reader_book) {
		mapper.addReader_book(reader_book);
	}

	@Override
	public void deleteReader_book(int id) {
		mapper.deleteReader_book(id);
	}

	@Override
	public void updateReader_book(Reader_book reader_book) {
		mapper.updateReader_book(reader_book);
	}

	@Override
	public List<Reader_book> getAllReader_book() {
		return mapper.getAllReader_book();
	}

	@Override
	public Reader_book getReader_book(int id) {
		return mapper.getReader_book(id);
	}

	@Override
	public List<Reader_book> get_ReaderName_Reader_book(String name) {
		return mapper.get_ReaderName_Reader_book(name);
	}

	@Override
	public List<Reader_book> get_BookNameReader_book(String name) {
		return mapper.get_BookNameReader_book(name);
	}

	@Override
	public List<Reader_book> get_categoryReader_book(Category category) {
		return mapper.get_categoryReader_book(category);
	}

	@Override
	public List<Reader_book> get_authorReader_book(Author author) {
		return mapper.get_authorReader_book(author);
	}

	@Override
	public List<Reader_bookNum_Tenbook> geTenbooks() {
		return mapper.geTenbooks();
	}

	@Override
	public List<Reader_bookNum_Tenbook> geTenauthor() {
		return mapper.geTenauthor();
	}

	@Override
	public List<Reader_bookNum_Tenbook> geTenreader() {
		return mapper.geTenreader();
	}

	@Override
	public List<Reader_bookNum_Tenbook> geTencategory() {
		float number = getReader_bookNum();
		List<Reader_bookNum_Tenbook> rbtList = new ArrayList<>();
		List<Reader_bookNum_Tenbook> list = mapper.geTencategory();
		for (Reader_bookNum_Tenbook rbt : list) {
			float percent = rbt.getNum()/number;
//			DecimalFormat decimalFormat=new DecimalFormat("0.00");
//			String p=decimalFormat.format(percent);
			rbt.setPercent(percent);
			rbtList.add(rbt);
		}
		return rbtList;
	}

	@Override
	public int getReader_bookNum() {
		return mapper.getReader_bookNum();
	}

}
