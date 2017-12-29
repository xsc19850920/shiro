package com.shiro.genpact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import com.shiro.genpact.common.Constant;

@Controller
public class UserContoller {
	
	@Autowired ReloadableResourceBundleMessageSource bundleMessage;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return Constant.LOGIN;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String error = null;
		RequestContext reqContext = new RequestContext(request);
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = reqContext.getMessage("user.account.error");
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error =  reqContext.getMessage("user.account.error");
		} else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
			error =  reqContext.getMessage("user.account.lock");
		} else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
			error =  reqContext.getMessage("user.account.retryerror");
		} else if (exceptionClassName.equals("jcaptcha.error")) {
			error = reqContext.getMessage("jcaptcha.error");
		}else if (exceptionClassName != null) {
			error = reqContext.getMessage("user.account.othererror") + exceptionClassName;
		}
		model.addAttribute("error", error);
		return Constant.LOGIN;
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return Constant.INDEX;
	}

}
