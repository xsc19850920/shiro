package com.shiro.genpact.dao;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shiro.genpact.entity.RolePermission;

public interface RolePermissionDao extends CrudRepository<RolePermission, Serializable>{
	public RolePermission findByRoleIdAndPermissionId(Long roleId,Long permissionId);
	
	@Query(value= "select permission 			"
				+ "		from sys_users u, 		"
				+ "		sys_roles r, 			"
				+ "		sys_permissions p, 		"
				+ "		sys_users_roles ur,		"
				+ "		sys_roles_permissions rp"
				+ "where u.username=:username 	"
				+ "and u.id=ur.user_id 			"
				+ "and r.id=ur.role_id 			"
				+ "and r.id=rp.role_id 			"
				+ "and p.id=rp.permission_id	"
			,nativeQuery=true)
	public Set<String> findPermissionsByRoleId(@Param("username")String username);
}
