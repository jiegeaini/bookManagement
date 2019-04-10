package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.RoleMapper;
import com.book.pojo.Role;
import com.book.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper mapper;
	
	@Override
	public void addRole(Role role) {
		mapper.addRole(role);
	}

	@Override
	public void deleteRole(Role role) {
		mapper.deleteRole(role);
	}

	@Override
	public void updateRole(Role role) {
		mapper.updateRole(role);
	}

	@Override
	public List<Role> getAllRole() {
		return mapper.getAllRole();
	}

	@Override
	public Role getRole(int id) {
		return mapper.getRole(id);
	}

	@Override
	public Role get_nameRole(String desc) {
		return mapper.get_nameRole(desc);
	}

}
