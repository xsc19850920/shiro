package com.shiro.genpact.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.shiro.genpact.entity.Role;

public interface RoleDao extends CrudRepository<Role, Serializable>{
	
}
