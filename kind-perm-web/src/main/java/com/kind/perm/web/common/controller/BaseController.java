package com.kind.perm.web.common.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.kind.common.domain.LogActor;
import com.kind.common.dto.KafaDataGrid;
import com.kind.common.exception.ParameterException;
import com.kind.common.exception.ServiceException;
import com.kind.common.persistence.PageView;
import com.kind.common.uitls.IPUtils;
import com.kind.perm.core.shrio.SessionUtils;
import com.kind.perm.web.common.DateTypeEditor;

/**
 * 
 * Function:BaseController. <br/>
 * 
 * @date:2016年5月13日 下午1:40:38 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
@Controller
public class BaseController {
	/**
	 * 请求后缀
	 */	
	final static String SUFFIX = "";

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 基于@ExceptionHandler异常处理 .
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public String handle(HttpServletRequest request, Exception ex) {
		request.setAttribute("exception", ex.getMessage());
		// 根据不同错误转向不同页面
		if (ex instanceof ServiceException) {
			return "error/500";
		} else if (ex instanceof ParameterException) {
			return "error/parameter_err";
		} else {
			return "error/500";
		}
	}

	/**
	 * 初始化数据绑定 . <br/>
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击.<br/>
	 * 2. 将字段中Date类型转换为String类型.
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		/**
		 * String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击.
		 */
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		/**
		 * date类型转换
		 */
		binder.registerCustomEditor(Date.class, new DateTypeEditor());
	}

	/**
	 * 获取easyUI分页数据.
	 * 
	 * @param page
	 * @return map对象
	 */
	@Deprecated
	public <T> Map<String, Object> buildPageSet(PageView<T> page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", page.getRows());
		map.put("total", page.getTotal());
		return map;
	}

	/**
	 * PageView构建DataGrid.
	 * 
	 * @param page
	 * @return
	 */
	public <T> KafaDataGrid buildDataGrid(PageView<T> page) {
		KafaDataGrid dataGrid = new KafaDataGrid();
		dataGrid.setRows(page.getRows());
		dataGrid.setTotal(page.getTotal());
		return dataGrid;
	}

	/**
	 * 构建DataGrid.
	 * 
	 * @param rows
	 * @param total
	 * @return
	 */
	public <T> KafaDataGrid buildDataGrid(List<T> rows, Integer total) {
		KafaDataGrid dataGrid = new KafaDataGrid();
		dataGrid.setRows(rows);
		dataGrid.setTotal(total);
		return dataGrid;
	}

	/**
	 * 获取登录用户信息.
	 * 
	 * @param request
	 * @return
	 */
	public LogActor getLogActor(HttpServletRequest request) {
		LogActor logActor = new LogActor();
		logActor.setActor(SessionUtils.getCurrentUserName());
		String ipAddr = IPUtils.getIpAddr(request);
		logActor.setIpAddr(ipAddr);
		return logActor;
	}

}
