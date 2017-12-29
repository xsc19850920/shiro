package com.shiro.genpact.dao;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shiro.genpact.entity.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole, Serializable>{
	
	UserRole findUserRoleByUserIdAndRoleId(Long userId,Long roleId);
	@Query(value="SELECT r.role"
			+ " FROM sys_users_roles ur"
			+ " inner JOIN sys_users u ON ur.user_id = u.id"
			+ " inner JOIN sys_roles r ON ur.role_id = r.id"
			+ " WHERE u.username = :username"
			,nativeQuery=true)
	Set<String> findRolesByusername(@Param("username") String username);
}
