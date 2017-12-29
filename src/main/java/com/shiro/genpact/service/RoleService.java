package com.shiro.genpact.service;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.genpact.dao.RoleDao;
import com.shiro.genpact.dao.RolePermissionDao;
import com.shiro.genpact.entity.Role;
import com.shiro.genpact.entity.RolePermission;

@Service
public class RoleService {
	@Autowired private RoleDao roleDao;
	@Autowired private RolePermissionDao rolePermissionDao;
	
	public Role createRole(Role role){
		 return roleDao.save(role);
	}
	public void deleteRole(Long roleId){
		rolePermissionDao.delete(roleId);
		roleDao.delete(roleId);
	}
	public Role findOne(Long id){
		 return roleDao.findOne(id);
	}
	public List<Role>  findAll(){
		Iterable<Role> roles = roleDao.findAll();
		return (List<Role>)roles;
//		List<Role> list = new ArrayList<Role>();
//		for (Role role : roles) {
//			list.add(role);
//		}
//		return list;
	}
	
	public long count(){
		return roleDao.count();
	}
	/**
	 * 方法名:correlationPermission
	 * 描    述:添加角色权限
	 * 返回值:void
	 * 参    数:
	 * 作    者:710009498
	 * 时    间:Dec 17, 2015 2:17:26 PM
	 */
	public void correlationPermission(Long roleId, Long... permissionIds){
		if(ArrayUtils.isEmpty(permissionIds)){
			return ;
		}
		RolePermission rolePermission = null;
		for (Long permissionId : permissionIds) {
			rolePermission = rolePermissionDao.findByRoleIdAndPermissionId(roleId, permissionId);
			if(rolePermission == null){
				rolePermissionDao.save(new RolePermission(roleId,permissionId));
			}
		}
	}
	/**
	 * 方法名:uncorrelationPermission
	 * 描    述:删除角色权限
	 * 返回值:void
	 * 参    数:@param roleId
	 * 参    数:@param permissionIds
	 * 作    者:710009498
	 * 时    间:Dec 17, 2015 2:30:04 PM
	 */
	public void uncorrelationPermission(Long roleId, Long... permissionIds){
		if(ArrayUtils.isEmpty(permissionIds)){
			return ;
		}
		RolePermission rolePermission = null;
		for (Long permissionId : permissionIds) {
			rolePermission = rolePermissionDao.findByRoleIdAndPermissionId(roleId, permissionId);
			if(rolePermission != null){
				rolePermissionDao.delete(rolePermission);
			}
		}
	}
}
