package com.shiro.genpact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.genpact.dao.PermissionDao;
import com.shiro.genpact.dao.RolePermissionDao;
import com.shiro.genpact.entity.Permission;

@Service
public class PermissionService {
	@Autowired private PermissionDao permissionDao;
	@Autowired private RolePermissionDao rolePermissionDao ;
	
	public Permission createPermission(Permission permission){
		return permissionDao.save(permission);
	}
	
	public void deletePermission(Long permissionId){
		rolePermissionDao.delete(permissionId);
		permissionDao.delete(permissionId);
	}
	
	
}
