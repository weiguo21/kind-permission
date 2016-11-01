/**
 * Project Name:kind-common-base
 * File Name:BaseException.java
 * Package Name:com.mcake.common.exception
 * Date:2016-3-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * Function:Dao处理异常. <br/>
 * Date:     2016年6月24日 上午10:49:49 <br/>
 * @author weiguo21
 * @version  
 * @since    JDK 1.7
 * @see
 */
@SuppressWarnings("serial")
public class DaoException extends BaseException {

	private Throwable rootCause;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
		this.rootCause = cause;
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
		this.rootCause = cause;
	}

	public String getTraceInfo() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	public Throwable getRootCause() {
		return rootCause;
	}

}
