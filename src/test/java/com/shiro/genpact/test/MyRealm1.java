package com.shiro.genpact.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;


public class MyRealm1 implements Realm{

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		String password =new String( (char[])token.getCredentials());
		  if(!"zhang".equals(username)) {  
	            throw new UnknownAccountException(); //如果用户名错误  
	        }  
	        if(!"123".equals(password)) {  
	            throw new IncorrectCredentialsException(); //如果密码错误  
	        }  
	        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
	        return new SimpleAuthenticationInfo(username, password, getName()); 
	}

	//返回一个唯一的Realm名字  
	public String getName() {
		return MyRealm1.class.getName();
	}

	public boolean supports(AuthenticationToken token) {
		 //仅支持usernamePasswordToken类型的Token  
        return token instanceof UsernamePasswordToken; 
	}
	
}
