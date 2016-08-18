package com.kind.perm.web.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Function:ajax拦截器. <br/>
 * 
 * @date:2016年5月12日 上午11:17:10 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public class AjaxFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(AjaxFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequestt, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequestt;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// String currentURL = request.getRequestURI();//取得根目录所对应的绝对路径:
		// String targetURL = currentURL.substring(currentURL.indexOf("/", 1),
		// currentURL.length()); //截取到当前文件名用于比较

		String ajaxSubmit = request.getHeader("X-Requested-With");
		logger.debug("session:" + request.getSession(false));
		if (ajaxSubmit != null && ajaxSubmit.equals("XMLHttpRequest")) {
			if (request.getSession(false) == null) {
				response.setHeader("sessionstatus", "timeout");
				response.getWriter().print("sessionstatus");
				return;
			}
		}
		chain.doFilter(servletRequestt, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
