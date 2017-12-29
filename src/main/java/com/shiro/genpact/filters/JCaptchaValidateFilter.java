package com.shiro.genpact.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.octo.captcha.service.image.ImageCaptchaService;

public class JCaptchaValidateFilter extends AccessControlFilter {
	private boolean jcaptchaEbabled = true;// 是否开启验证码支持
	private String failureKeyAttribute = "shiroLoginFailure"; //验证码验证失败后存储到的属性名
	@Autowired
	private ImageCaptchaService imageCaptchaService;
	

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// 1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
		request.setAttribute("jcaptchaEbabled", jcaptchaEbabled);
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		// 2、判断验证码是否禁用 或不是表单提交（允许访问）
		if (!jcaptchaEbabled || !"post".equalsIgnoreCase(httpRequest.getMethod())) {
			return true;
		}
		// 3、此时是表单提交，验证验证码是否正确
		return imageCaptchaService.validateResponseForID(httpRequest.getSession().getId(),  httpRequest.getParameter("captcha"));
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		//如果验证码失败了，存储失败key属性  
        request.setAttribute(failureKeyAttribute, "jcaptcha.error");  
        return true;  
	}

	public boolean isJcaptchaEbabled() {
		return jcaptchaEbabled;
	}

	public void setJcaptchaEbabled(boolean jcaptchaEbabled) {
		this.jcaptchaEbabled = jcaptchaEbabled;
	}

	public String getFailureKeyAttribute() {
		return failureKeyAttribute;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}
	
	

}
