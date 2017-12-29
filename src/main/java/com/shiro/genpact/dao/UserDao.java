package com.shiro.genpact.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.shiro.genpact.entity.User;

public interface UserDao extends CrudRepository<User, Serializable> ,JpaSpecificationExecutor<User>{
	User findUserByusername(String username);
}
