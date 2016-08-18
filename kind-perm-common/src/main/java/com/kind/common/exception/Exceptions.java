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
 * Function:异常工具类. <br/>
 * Date: 2016年6月24日 上午10:50:25 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class Exceptions {
	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Exception e) {
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * 获取组合本异常信息与底层异常信息的异常描述, 适用于本异常为统一包装异常类，底层异常才是根本原因的情况。
	 */
	public static String getErrorMessageWithNested(Exception e) {
		Throwable nestedException = e.getCause();
		return new StringBuilder().append(e.getMessage()).append(" nested exception is ")
				.append(nestedException.getClass().getName()).append(":").append(nestedException.getMessage())
				.toString();
	}

	/**
	 * 判断异常是否由某些底层的异常引起.
	 */
	@SafeVarargs
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		// 直接引起的异常
		for (Class<? extends Exception> causeClass : causeExceptionClasses) {
			if (causeClass.isInstance(ex)) {
				return true;
			}
		}
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}
}
