package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.PermissionMapper;
import com.book.pojo.Permission;
import com.book.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionMapper mapper;
	
	@Override
	public void addPermission(Permission permission) {
		mapper.addPermission(permission);
	}

	@Override
	public void deletePermission(Permission permission) {
		mapper.deletePermission(permission);
	}

	@Override
	public void updatePermission(Permission permission) {
		mapper.updatePermission(permission);
	}

	@Override
	public List<Permission> getAllPermission() {
		return mapper.getAllPermission();
	}

	@Override
	public Permission getPermission(int id) {
		return mapper.getPermission(id);
	}

	@Override
	public Permission get_namePermission(String desc) {
		return mapper.get_namePermission(desc);
	}

}
