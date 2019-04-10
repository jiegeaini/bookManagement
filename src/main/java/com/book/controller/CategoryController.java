package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.dataservice.CategoryDataService;
import com.book.pojo.Category;
import com.book.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	CategoryDataService cdataService;
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(Category category,Model m) {
		if (category.getName() != null) {
			categoryService.addCategory(category);
			return "redirect:getCategoryPage";
		}else {
			m.addAttribute("error", "你所添加的书籍名字不能为空");
			return "error";
		}
		
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(Category category,Model m) {
		if (category.getName() != null && category.getId() > 0) {
			categoryService.updateCategory(category);
			return "redirect:getCategoryPage";
		}else {
			m.addAttribute("error", "没有找到你所修改的书籍");
			return "error";
		}
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(Integer id,Model m) {
		if (id != null) {
			boolean bl = cdataService.booleanDeleteCategory(id);
			if (bl) {
				categoryService.deleteCategory(id);
				return "redirect:getCategoryPage";
			}else {
				m.addAttribute("error", "你不能删除这个分类，要先删除这个分类的所有图书");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要修改的图书");
			return "error";
		}
	}
}
