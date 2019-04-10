package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.User_roleMapper;
import com.book.pojo.User_role;
import com.book.service.User_roleService;

@Service
public class User_roleServiceImpl implements User_roleService{

	@Autowired
	User_roleMapper mapper;
	
	@Override
	public void addUser_role(User_role user_role) {
		mapper.addUser_role(user_role);
	}

	@Override
	public void deleteUser_role(User_role user_role) {
		mapper.deleteUser_role(user_role);
	}

	@Override
	public void updateUser_role(User_role user_role) {
		mapper.updateUser_role(user_role);
	}

	@Override
	public List<User_role> getAllUser_role() {
		return mapper.getAllUser_role();
	}

	@Override
	public User_role getUser_role(int id) {
		return mapper.getUser_role(id);
	}

	@Override
	public List<User_role> get_UserNameUser_role(String name) {
		return mapper.get_UserNameUser_role(name);
	}

	@Override
	public List<User_role> get_RoleNameUser_role(String name) {
		return mapper.get_RoleNameUser_role(name);
	}

}
