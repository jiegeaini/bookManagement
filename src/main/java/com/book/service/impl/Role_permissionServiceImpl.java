package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.Role_permissionMapper;
import com.book.pojo.Role_permission;
import com.book.service.Role_permissionService;

@Service
public class Role_permissionServiceImpl implements Role_permissionService{

	@Autowired
	Role_permissionMapper mapper;
	
	@Override
	public void addRole_permission(Role_permission role_permission) {
		mapper.addRole_permission(role_permission);
	}

	@Override
	public void deleteRole_permission(Role_permission role_permission) {
		mapper.deleteRole_permission(role_permission);
	}

	@Override
	public void updateRole_permission(Role_permission role_permission) {
		mapper.updateRole_permission(role_permission);
	}

	@Override
	public List<Role_permission> getAllRole_permission() {
		return mapper.getAllRole_permission();
	}

	@Override
	public Role_permission getRole_permission(int id) {
		return mapper.getRole_permission(id);
	}

	@Override
	public List<Role_permission> get_RoleNameRole_permission(String name) {
		return mapper.get_RoleNameRole_permission(name);
	}

	@Override
	public List<Role_permission> get_PermissionNameRole_permission(String name) {
		return mapper.get_PermissionNameRole_permission(name);
	}

}
