package com.book.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.book.pojo.Role;
import com.book.pojo.Role_permission;
import com.book.service.PermissionService;
import com.book.service.RoleService;
import com.book.service.Role_permissionService;


@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	@Autowired
	Role_permissionService rpService;
	@Autowired
	PermissionService pService;
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String addRole(Role role,int[] permissions,Model m) {
		try {
			roleService.addRole(role);
			for (int i = 0; i < permissions.length; i++) {
				Role_permission rPermission = new Role_permission();
				rPermission.setRole(roleService.get_nameRole(role.getName()));
				rPermission.setPermission(pService.getPermission(permissions[i]));
				rpService.addRole_permission(rPermission);
			}
			return "redirect:getRoleViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "添加角色信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public String updateRole(Role role,int[] permissions,Model m) {
		try {	
			roleService.updateRole(role);
			List<Role_permission> rPermissions =  
					rpService.get_RoleNameRole_permission(role.getName());
			
			for (Role_permission role_permission : rPermissions) {
				rpService.deleteRole_permission(role_permission);
			}
			for (int i = 0; i < permissions.length; i++) {
				Role_permission rPermission = new Role_permission();
				rPermission.setRole(roleService.get_nameRole(role.getName()));
				rPermission.setPermission(pService.getPermission(permissions[i]));
				
				rpService.addRole_permission(rPermission);
			}
			return "redirect:getRoleViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改角色信息失败，请检查相应信息是否完整");
			return "error";
		}
	
	}
	
	@RequestMapping("/deleteRole")
	public String deleteRole(Integer id,Model m) {
		if (id != null) {
			Role role = roleService.getRole(id);
			List<Role_permission> rPermissions =  
					rpService.get_RoleNameRole_permission(role.getName());
			
			for (Role_permission role_permission : rPermissions) {
				rpService.deleteRole_permission(role_permission);
			}
			roleService.deleteRole(role);
			return "redirect:getRoleViewPage";
		}else {
			m.addAttribute("error", "没有找到你想要删除的角色");
			return "error";
		}
	}
}
