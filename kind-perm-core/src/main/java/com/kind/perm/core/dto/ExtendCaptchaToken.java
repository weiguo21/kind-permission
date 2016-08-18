package com.kind.perm.core.dto;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 扩展添加验证码-继承用户验证类
 * 
 * @date: 2016年5月6日 上午11:01:00 <br/>
 *
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 */
public class ExtendCaptchaToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 5460646207589690719L;

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public ExtendCaptchaToken() {
		super();
	}

	public ExtendCaptchaToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

}