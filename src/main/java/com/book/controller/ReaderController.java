package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.dataservice.ReaderDataService;
import com.book.pojo.Reader;

import com.book.service.ReaderService;

@Controller
public class ReaderController {
	
	@Autowired
	ReaderService readerService;
	@Autowired
	ReaderDataService rdService;
	
	@RequestMapping(value = "/addReader", method = RequestMethod.POST)
	public String addReader(Reader reader,Model m) {
		
		try {
			readerService.addReader(reader);
			return "redirect:getReaderViewPage";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			m.addAttribute("error", "添加用户信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateReader", method = RequestMethod.POST)
	public String updateReader(Reader reader,Model m) {
		try {
			readerService.updateReader(reader);
			return "redirect:getReaderViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改用户信息失败，请检查相应信息是否完整");
			return "error";
		}

	}
	
	@RequestMapping("/deleteReader")
	public String deleteReader(Integer id,Model m) {
		if (id != null) {
			boolean bl = rdService.deleteReader(id);
			if (bl) {
				readerService.deleteReader(id);
				return "redirect:getReaderViewPage";
			}else {
				m.addAttribute("error", "你不能删除这个用户，要先删除这个用户关联的所有图书");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要删除的用户");
			return "error";
		}
	}
}
