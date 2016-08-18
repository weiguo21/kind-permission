/**
 * Project Name:kind-common-base
 * File Name:BaseException.java
 * Package Name:com.mcake.common.exception
 * Date:2016-3-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.exception;

public class ExistedException extends ServiceException {

	/** 描述  */
	private static final long serialVersionUID = -598071452360556064L;

	public ExistedException() {
		super();
	}

	public ExistedException(String message) {
		super(message);
	}

	public ExistedException(Throwable cause) {
		super(cause);
	}

	public ExistedException(String message, Throwable cause) {
		super(message, cause);
	}
}
