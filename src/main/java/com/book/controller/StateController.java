package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.dataservice.StateDataService;

import com.book.pojo.State;

import com.book.service.StateService;

@Controller
public class StateController {
	
	@Autowired
	StateService stateService;
	@Autowired
	StateDataService sdService;
	
	@RequestMapping(value = "/addState", method = RequestMethod.POST)
	public String addAuthor(State state,Model m) {
		try {
			stateService.addState(state);
			return "redirect:getStateViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "添加状态信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public String updateState(State state,Model m) {
		Integer id = new Integer(state.getId());
		if (id != null) {
			if (id == 1 || id == 2) {
				m.addAttribute("error", "你不能修改这条记录");
				return "error";
			}
		}
		
		try {	
			stateService.updateState(state);
			return "redirect:getStateViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改状态信息失败，请检查相应信息是否完整");
			return "error";
		}
	
	}
	
	@RequestMapping("/deleteState")
	public String deleteState(Integer id,Model m) {
		
		if (id != null) {
			if (id == 1 || id == 2) {
				m.addAttribute("error", "你不能修改这条记录");
				return "error";
			}
		}
		
		if (id != null) {
			boolean bl = sdService.deleteState(id);
			if (bl) {
				stateService.deleteState(id);
				return "redirect:getStateViewPage";
			}else {
				m.addAttribute("error", "你不能删除这个状态");
				return "error";
			}
		}else {
			m.addAttribute("error", "没有找到你想要删除的状态");
			return "error";
		}
	}
}
