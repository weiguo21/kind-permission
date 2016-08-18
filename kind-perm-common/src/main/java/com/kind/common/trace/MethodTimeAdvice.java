/**
 * Project Name:kind-common-base
 * File Name:MethodTimeAdvice.java
 * Package Name:com.kind.common.trace
 * Date:2016年7月1日下午4:37:57
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/

package com.kind.common.trace;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Function:记录方法的执行时间. <br/>
 * Date: 2016年7月1日 下午4:37:57 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class MethodTimeAdvice implements MethodInterceptor {
	protected Logger logger = LoggerFactory.getLogger(MethodTimeAdvice.class);

	/**
	 * 拦截要执行的目标方法.
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		/**
		 * 用 commons-lang3 提供的 StopWatch计时，Spring也提供了一个 StopWatch
		 */
		StopWatch clock = new StopWatch();
		clock.start();
		Object result = invocation.proceed();
		clock.stop();

		/**
		 * 方法参数类型，转换成简单类型
		 */
		@SuppressWarnings("rawtypes")
		Class[] params = invocation.getMethod().getParameterTypes();
		String[] simpleParams = new String[params.length];
		for (int i = 0; i < params.length; i++) {
			simpleParams[i] = params[i].getSimpleName();
		}
		logger.debug("Takes:" + clock.getTime() + " ms [" + invocation.getThis().getClass().getName() + "."
				+ invocation.getMethod().getName() + "(" + StringUtils.join(simpleParams, ",") + ")] ");
		return result;
	}
}
