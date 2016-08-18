package com.kind.perm.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kind.common.mapper.JSONMapper;
import com.kind.common.uitls.DateUtils;
import com.kind.common.uitls.IPUtils;
import com.kind.perm.core.domain.LoginLogDO;
import com.kind.perm.core.service.LogService;
import com.kind.perm.core.shrio.SessionUtils;

import nl.bitwalker.useragentutils.UserAgent;

/**
 * 
 * Function:日志拦截器. <br/>
 * 
 * @date:2016年5月12日 上午11:16:33 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private LogService logService;

	/**
	 * 1、开始时间
	 */
	private Long beginTime;
	/**
	 * 2、结束时间
	 */
	private Long endTime;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		beginTime = System.currentTimeMillis();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		endTime = System.currentTimeMillis();
		this.saveLog(request);
	}

	/**
	 * 保存日志.
	 * 
	 * @param request
	 */
	private void saveLog(HttpServletRequest request) {
		String requestRri = request.getRequestURI();
		String uriPrefix = request.getContextPath();
		String operCode = StringUtils.substringAfter(requestRri, uriPrefix); // 操作编码
		String requestParam = JSONMapper.getInstance().toJson(request.getParameterMap()); // 请求参数
		/**
		 * 如果是GET请求，请求编码包含get，query,page,list(添加修改页)不记录日志
		 */
		if (request.getMethod().equals("GET")) {
			if (operCode.contains("get") || operCode.contains("query") || operCode.contains("page")
					|| operCode.contains("list")) {
				return;
			}
		}
		String type = request.getMethod();
		Long executeTime = endTime - beginTime;
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		/**
		 * 获取客户端操作系统
		 */
		String os = userAgent.getOperatingSystem().getName();
		/**
		 * 获取客户端浏览器
		 */
		String browser = userAgent.getBrowser().getName();
		LoginLogDO logDO = this.buildLogDO(request, type, operCode, requestParam, executeTime, os, browser);
		logService.saveLoginLog(logDO);
	}

	/**
	 * 构造logDO.
	 * 
	 * @param request
	 * @param operCode
	 * @param requestParam
	 * @param executeTime
	 * @param os
	 * @param browser
	 * @return
	 */
	private LoginLogDO buildLogDO(HttpServletRequest request, String method, String operCode, String requestParam,
			Long executeTime, String os, String browser) {
		LoginLogDO logDO = new LoginLogDO();
		logDO.setType(method);
		logDO.setOs(os);
		logDO.setBrowser(browser);
		String ipAddr = IPUtils.getIpAddr(request);
		logDO.setIpAddr(ipAddr);
		String mac = IPUtils.getMAC(ipAddr);
		logDO.setMac(mac);
		logDO.setOperCode(operCode);
		logDO.setExecuteTime(Integer.valueOf(executeTime.toString()));
		logDO.setCreateUser(SessionUtils.getCurrentUser().getUsername());
		logDO.setCreateTime(DateUtils.getSysDate());
		logDO.setRequestParam(requestParam);
		return logDO;
	}

}
