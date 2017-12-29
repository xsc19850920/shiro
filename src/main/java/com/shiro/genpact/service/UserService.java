package com.shiro.genpact.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.genpact.dao.RolePermissionDao;
import com.shiro.genpact.dao.UserDao;
import com.shiro.genpact.dao.UserRoleDao;
import com.shiro.genpact.entity.User;
import com.shiro.genpact.entity.UserRole;

@Service
public class UserService {
	@Autowired private UserDao userDao;
	@Autowired private UserRoleDao userRoleDao;
	@Autowired private RolePermissionDao rolePermissionDao;

	public User createUser(User user) {
		return userDao.save(user);
	}

	public void updateUser(User user) {
		userDao.delete(user);
	}

	public void deleteUser(Long userId) {
		userDao.delete(userId);
	}

	/**
	 * 方法名:correlationRoles 描 述:用户添加角色 返回值:void 参 数:@param userId 参 数:@param
	 * roleIds 作 者:710009498 时 间:Dec 17, 2015 2:32:54 PM
	 */
	public void correlationRoles(Long userId, Long... roleIds) {
		if (userId == null) {
			return;
		}
		UserRole userRole = null;
		for (Long roleId : roleIds) {
			userRole = userRoleDao.findUserRoleByUserIdAndRoleId(userId, roleId);
			if (userRole == null) {
				userRoleDao.save(new UserRole(userId, roleId));
			}
		}

		;
	}

	public void uncorrelationRoles(Long userId, Long... roleIds) {
		if (userId == null) {
			return;
		}
		UserRole userRole = null;
		for (Long roleId : roleIds) {
			userRole = userRoleDao.findUserRoleByUserIdAndRoleId(userId, roleId);
			if (userRole != null) {
				userRoleDao.delete(userRole);
			}
		}
	}

	public User findOne(Long userId) {
		return userDao.findOne(userId);
	}

	public User findByusername(String username) {
		return userDao.findUserByusername(username);
	}

	public Set<String> findRoles(String username) {
		return userRoleDao.findRolesByusername(username);
	}

	public Set<String> findPermissions(String username) {
		return rolePermissionDao.findPermissionsByRoleId(username);
	}
}
