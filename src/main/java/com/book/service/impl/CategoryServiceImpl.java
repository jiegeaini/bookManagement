package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.CategoryMapper;
import com.book.pojo.Category;
import com.book.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper mapper;
	
	@Override
	public void addCategory(Category category) {
		mapper.addCategory(category);
	}

	@Override
	public void deleteCategory(int id) {
		mapper.deleteCategory(id);
	}

	@Override
	public void updateCategory(Category category) {
		mapper.updateCategory(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return mapper.getAllCategory();
	}

	@Override
	public Category getCategory(int id) {
		return mapper.getCategory(id);
	}

	@Override
	public Category get_nameCategory(String name) {
		return mapper.get_nameCategory(name);
	}

}
