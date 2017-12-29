package com.genpact.shiro.test;

import java.util.Set;

import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shiro.genpact.service.PermissionService;
import com.shiro.genpact.service.RoleService;
import com.shiro.genpact.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-main.xml")
public class MysqlApplicationTests {
	@Autowired private UserService userService;
	@Autowired private RoleService roleService;
	@Autowired private PermissionService permissionService;
//	@Test
//	public void contextLoads() {
//		User user = userService.findOne(1l);
//		System.out.println(user.toString());
//	}
	
//	@Test
//	public void createRoles() {
//		userService.correlationRoles(1l, 1l);
//	}
	
	//@Test
	public void createRoles() {
		
		roleService.correlationPermission(1l, 1l);
	}
	//@Test
	public void findUserRoleByUserName(){
		Set<String> roles = userService.findRoles("xsc");
		for (String role : roles) {
			System.out.println(role);
		}
	}
	@Test
	public void genPass(){
		final String pass = "521000";
		String hex = new DefaultHashService().computeHash(new HashRequest() {
			
			public ByteSource getSource() {
				return ByteSource.Util.bytes(pass);
			}
			
			public ByteSource getSalt() {
				return null;
			}
			
			public int getIterations() {
				return 2;
			}
			
			public String getAlgorithmName() {
				return "md5";
			}
		}).toHex();
		  
		System.out.println(hex);
	}
	//@Test
	public void base64(){
//		String str = "hello";
//		String base64Str = Base64.encodeToString(str.getBytes());
//		System.out.println(base64Str);
//		String str2  = Base64.decodeToString(base64Str);
//		System.out.println(str2);
//		System.out.println(str.equals(str2));
		
		
		
//		String str = "hello";  
//		String salt = "123";  
//		String md5 = new Md5Hash(str, salt).toString();
//		System.out.println(md5);		
		
		
		
	}
}
