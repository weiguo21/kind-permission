/**
 * Project Name:kind-common-base
 * File Name:BaseException.java
 * Package Name:com.mcake.common.exception
 * Date:2016-3-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * Function: 验证码异常类. <br/>
 * Date: 2016年6月24日 上午10:49:34 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class CaptchaException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public CaptchaException() {
		super();
	}

	public CaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CaptchaException(String message) {
		super(message);
	}

	public CaptchaException(Throwable cause) {
		super(cause);
	}
}