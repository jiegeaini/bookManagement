package com.book.controller;

import java.util.List;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.pojo.User;
import com.book.pojo.User_role;
import com.book.service.RoleService;
import com.book.service.UserService;
import com.book.service.User_roleService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	User_roleService urService;
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addAuthor(User user,int[] rolesId,Model m) {
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		int times = 2;
		String algorithmName = "md5";
		String encodedPassword = new SimpleHash(algorithmName, user.getPassword(), salt, times).toString();
		user.setPassword(encodedPassword);
		user.setSalt(salt);
		try {
			userService.addUser(user);
			for (int i = 0; i < rolesId.length; i++) {
				User_role uRole = new User_role();
				uRole.setRole(roleService.getRole(rolesId[i]));
				uRole.setUser(userService.get_nameUser(user.getUsername()));
				urService.addUser_role(uRole);
			}
			return "redirect:getUserViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "添加管理用户信息失败，请检查相应信息是否完整");
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateState(User user,int[] rolesId,Model m) {
		if (user.getPassword().length() != 0) {
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			int times = 2;
			String algorithmName = "md5";
			String encodedPassword = new SimpleHash(algorithmName, user.getPassword(), salt, times).toString();
			user.setSalt(salt);
			user.setPassword(encodedPassword);
		} else
			user.setPassword(null);
		try {	
			userService.updateUser(user);
			List<User_role> user_roles =  
					urService.get_UserNameUser_role(user.getUsername());
			
			for (User_role user_role2 : user_roles) {
				urService.deleteUser_role(user_role2);
			}
			
			for (int i = 0; i < rolesId.length; i++) {
				User_role uRole = new User_role();
				uRole.setRole(roleService.getRole(rolesId[i]));
				uRole.setUser(userService.get_nameUser(user.getUsername()));
				urService.addUser_role(uRole);
			}
			return "redirect:getUserViewPage";
		} catch (Exception e) {
			m.addAttribute("error", "修改管理员用户信息失败，请检查相应信息是否完整");
			return "error";
		}
	
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id,Model m) {

		if (id != null) {
			User user = userService.getUser(id);
			List<User_role> user_roles =  
					urService.get_UserNameUser_role(user.getUsername());
			for (User_role user_role : user_roles) {
				urService.deleteUser_role(user_role);
			}
			userService.deleteUser(user);
			return "redirect:getUserViewPage";
		}else {
			m.addAttribute("error", "没有找到你想要删除的管理员");
			return "error";
		}
	}
}
