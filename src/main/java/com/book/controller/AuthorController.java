package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.dataservice.AuthorDataService;
import com.book.pojo.Author;
import com.book.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	@Autowired
	AuthorDataService adService;
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
	public String addAuthor(Author author,Model m) {
		Author author2 = authorService.get_nameAuthor(author.getName());
		if (author2 != null) {
			m.addAttribute("error", "你不能添加相同的作者");
			return "error";
		}
		try {
			authorService.addAuthor(author);
			return "redirect:getAuthorViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "添加作者信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
	public String updateAuthor(Author author,Model m) {
		if (authorService.getAuthor(author.getId()).getName() != author.getName() ) {
			Author author2 = authorService.get_nameAuthor(author.getName());
			if (author2 != null) {
				m.addAttribute("error", "你不能修改相同的作者");
				return "error";
			}
		}
		
		try {
			authorService.updateAuthor(author);
			return "redirect:getAuthorViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改作者信息失败，请检查相应信息是否完整");
			return "error";
		}

	}
	
	@RequestMapping("/deleteAuthor")
	public String deleteAuthor(Integer id,Model m) {
		if (id != null) {
			boolean bl = adService.deleteAuthor(id);
			if (bl) {
				authorService.deleteAuthor(id);
				return "redirect:getAuthorViewPage";
			}else {
				m.addAttribute("error", "你不能删除这个作者，要先删除这个作者的所有图书");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要删除的作者");
			return "error";
		}
	}
}
