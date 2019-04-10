package com.book.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.pojo.Permission;

import com.book.pojo.Role_permission;
import com.book.service.PermissionService;

import com.book.service.Role_permissionService;


@Controller
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	@Autowired
	Role_permissionService rpService;
	
	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
	public String addPermission(Permission permission,Model m) {
		try {
			permissionService.addPermission(permission);
			return "redirect:getPermissionViewPage";
			}
		catch (Exception e) {
			m.addAttribute("error", "添加权限信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
	public String updatePermission(Permission permission,Model m) {
		
		try {	
			permissionService.updatePermission(permission);
			return "redirect:getPermissionViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改权限信息失败，请检查相应信息是否完整");
			return "error";
		}
	
	}
	
	@RequestMapping("/deletePermission")
	public String deletePermission(Integer id,Model m) {
		if (id != null) {
			Permission permission = permissionService.getPermission(id);
			List<Role_permission> rPermissions =  
					rpService.get_PermissionNameRole_permission
					(permission.getName());
			
			for (Role_permission role_permission : rPermissions) {
				rpService.deleteRole_permission(role_permission);
			}
			permissionService.deletePermission(permission);
			return "redirect:getPermissionViewPage";
		}else {
			m.addAttribute("error", "没有找到你想要删除的权限");
			return "error";
		}
	}
}
