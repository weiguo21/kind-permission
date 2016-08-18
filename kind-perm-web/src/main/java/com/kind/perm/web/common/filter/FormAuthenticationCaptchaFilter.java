package com.kind.perm.web.common.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.kind.perm.core.dto.ExtendCaptchaToken;

/**
 * 
 * Function:扩展认证默认过滤. <br/>
 * 
 * @date:2016年5月12日 上午11:17:31 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {
		return captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = super.isRememberMe(request);
		String host = getHost(request);
		char[] passwords = new char[] {};
		if (StringUtils.isNotEmpty(password)) {
			passwords = password.toCharArray();
		}
		return new ExtendCaptchaToken(username, passwords, rememberMe, host, captcha);
	}

}