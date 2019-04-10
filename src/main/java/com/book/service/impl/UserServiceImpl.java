package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.UserMapper;
import com.book.pojo.User;
import com.book.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper mapper;
	
	@Override
	public void addUser(User user) {
		mapper.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		mapper.deleteUser(user);
	}

	@Override
	public void updateUser(User user) {
		mapper.updateUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return mapper.getAllUser();
	}

	@Override
	public User getUser(int id) {
		return mapper.getUser(id);
	}

	@Override
	public User get_nameUser(String username) {
		return mapper.get_nameUser(username);
	}

}
