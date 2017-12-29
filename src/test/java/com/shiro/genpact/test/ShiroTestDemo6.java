package com.shiro.genpact.test;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTestDemo6 extends BaseTest {
	  @Test
	    public void testHasRole() {
	    	Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
	    	
	    	SecurityManager securityManager = factory.getInstance();
	    	
	    	SecurityUtils.setSecurityManager(securityManager);
	    	
	    	Subject currentUser = SecurityUtils.getSubject();
	    	
	    	UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
	    	currentUser.login(token);
	    	System.out.println(currentUser.isPermitted("user:delete"));
	    }

}
