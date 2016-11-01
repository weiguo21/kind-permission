package com.kind.common.trace.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.kind.common.contants.Modules;
import com.kind.common.contants.SubSystem;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLogResouce {
	/**
	 * 子系统名称.
	 * @return
	 */
	SubSystem subSystem();

	/**
	 * 模块名称.
	 * 
	 * @return
	 */
	Modules module();

	/**
	 * 操作名称.
	 * 
	 * @return
	 */
	String operation();

	/**
	 * 操作者.
	 * 
	 * @return
	 */
	String actor();

	/**
	 * 登录IP.
	 * 
	 * @return
	 */
	String ipAddr() default "";

	/**
	 * 操作内容.
	 * 
	 * @return
	 */
	String content() default "";

}
