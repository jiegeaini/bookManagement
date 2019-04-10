package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.dataservice.BookDataService;
import com.book.pojo.Book;
import com.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	BookDataService bookDataService;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(Book book,String categoryName,String authorName,Model m) {
		boolean bl = bookDataService.booleanAddBook
				(categoryName, authorName,book.getName(),book.getId());
		if (bl) {
			bookService.addBook(book,categoryName,authorName);
			return "redirect:getBookViewPage";
		}else {
			m.addAttribute("error", "添加失败,请查看书籍是否重名或书籍信息是否完整");
			return "error";
		}
		
	}
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(Book book,String categoryName,String authorName,Model m) {
		boolean bl = bookDataService.booleanAddBook
				(categoryName, authorName,book.getName(),book.getId());
		if (bl) {
			bookService.updateBook(book, categoryName, authorName);
			return "redirect:getBookViewPage";
		}else {
			m.addAttribute("error", "添加失败,请查看书籍是否重名或书籍信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Integer id,Model m) {
		if (id != null) {
			bookService.deleteBook(id);
			return "redirect:getBookViewPage";
		}else {
			m.addAttribute("error", "没有找到你想要修改的图书");
			return "error";
		}
	}
	
	@RequestMapping("/geTencategory_num")
	@ResponseBody
	public List<Reader_bookNum_Tenbook> geTencategory_num(){
		return bookService.geTencategory_num();
	}
}
