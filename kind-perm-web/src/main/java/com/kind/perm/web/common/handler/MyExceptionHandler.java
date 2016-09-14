/**
 * Project Name:kafa-back-web
 * Package Name:com.kafa.back.web.common.handler
 * Created on:2016年9月14日上午10:18:45
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.web.common.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kind.common.exception.ParameterException;
import com.kind.common.exception.ServiceException;

/**
 * Function:统一异常处理. <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		/**
		 * 根据不同错误转向不同页面
		 */
		if (ex instanceof ServiceException) {
			return new ModelAndView("business_error", model);
		} else if (ex instanceof ParameterException) {
			return new ModelAndView("parameter_error", model);
		} else {
			return new ModelAndView("error", model);
		}
	}

}
