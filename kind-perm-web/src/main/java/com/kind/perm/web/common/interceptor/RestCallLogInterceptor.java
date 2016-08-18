package com.kind.perm.web.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * Function:rest服务日志拦截器. <br/>
 * @date:2016年5月12日 上午11:16:46 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public class RestCallLogInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(RestCallLogInterceptor.class);
	private final String headerToken = "TC_CALL_STAMP";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			/**
			 * 记录调用日志
			 */
			logger.info(this.getIp(request) + ":" + request.getRequestURI());

			String token = request.getHeader(headerToken);
			if (token != null) {
				logger.info(token);
				response.addHeader(headerToken, token);
			}
		} catch (Exception exp) {

		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/*
		 * String token=request.getHeader(headerToken); if(token!=null) {
		 * response.setHeader(headerToken,token); }
		 */
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*
		 * String token=request.getHeader(headerToken); if(token!=null) {
		 * response.setHeader(headerToken,token); }
		 */
	}

	private String getIp(HttpServletRequest request) {
		String strIp = "";
		String forwarded = request.getHeader("x-forwarded-for");
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(forwarded)) {
			strIp += "forward ip:";
			strIp += forwarded;
			strIp += ";";
		}
		String real = request.getHeader("x-real-ip");
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(real)) {
			strIp += "real ip:";
			strIp += real;
			strIp += ";";
		}
		strIp += request.getRemoteAddr();
		return strIp;
	}
}
