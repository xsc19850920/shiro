package com.shiro.genpact.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiro.genpact.entity.Permission;

public interface PermissionDao extends JpaRepository<Permission, Serializable>   {
	
}
