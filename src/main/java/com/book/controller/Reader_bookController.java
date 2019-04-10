package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.bean_num.Reader_bookNum_Tenbook;
import com.book.dataservice.Reader_bookDataService;
import com.book.formbean.Reader_bookFormbean;
import com.book.pojo.Reader_book;
import com.book.service.Reader_bookService;

@Controller
public class Reader_bookController {
	
	@Autowired
	Reader_bookService rbService;
	@Autowired
	Reader_bookDataService rbDataService;
	
	@RequestMapping(value = "/addRb", method = RequestMethod.POST)
	public String addAuthor(Reader_book rb,Reader_bookFormbean rbfb,Model m) {
		if ("已归还".equals(rbfb.getStateName())) {
			m.addAttribute("error", "你不能添加已归还");
			return "error";
		}
				
		if (rbDataService.addRb_User(rbfb)) {
			if (rbDataService.addRb_book(rbfb)) {
				try {
					rbDataService.addRb(rbfb, rb);
					return "redirect:getReader_bookViewPage";
				} catch (Exception e) {
					m.addAttribute("error", "添加信息失败，请检查相应信息是否完整");
					return "error";
				}
			}else {
				m.addAttribute("error", "这本图书没有库存了！");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要添加的用户信息，请看看是否注册过");
			return "error";
		}
		
	}
	
	@RequestMapping(value = "/updateRb", method = RequestMethod.POST)
	public String updateRb(Reader_book rb,Reader_bookFormbean rbfb,Model m) {
		
		if (rbDataService.addRb_User(rbfb)) {
			if (rbDataService.addRb_book(rbfb)) {
				try {
					rbDataService.updateRb_book(rbfb, rb);
					return "redirect:getReader_bookViewPage";
				} catch (Exception e) {
					m.addAttribute("error", "修改信息失败，请检查相应信息是否完整");
					return "error";
				}
			}else {
				m.addAttribute("error", "这本图书没有库存了！");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要修改的用户信息，请看看是否注册过");
			return "error";
		}

	}
	
	@RequestMapping("/deleteRb")
	public String deleteRb(Integer id,Model m) {
		if (id != null) {
			rbService.deleteReader_book(id);
			return "redirect:getReader_bookViewPage";
		}else {
			m.addAttribute("error", "没有找到你想要删除的借书信息");
			return "error";
		}
	}
	
	/**
	 * @function 查出借书最多的图书前十名
	 * @return
	 */
	@RequestMapping("/geTenbooks")
	@ResponseBody
	public List<Reader_bookNum_Tenbook> geTenbooks(){
		return rbService.geTenbooks();
	};
	/**
	 * @function 查出借书最多的作者前十名
	 * @return
	 */
	@RequestMapping("/geTenauthor")
	@ResponseBody
	public List<Reader_bookNum_Tenbook> geTenauthor(){
		return rbService.geTenauthor();
	};
	/**
	 * @function 查出借书最多的读者前十名
	 * @return
	 */
	@RequestMapping("/geTenreader")
	@ResponseBody
	public List<Reader_bookNum_Tenbook> geTenreader(){
		return rbService.geTenreader();
	};
	/**
	 * @function 查出借书最多的分类前十名
	 * @return
	 */
	@RequestMapping("/geTencategory")
	@ResponseBody
	public List<Reader_bookNum_Tenbook> geTencategory(){
		return rbService.geTencategory();
	};
	
}
