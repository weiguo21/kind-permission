

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
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exception", ex.getMessage());
		/**
		 * 根据不同错误转向不同页面
		 */
		if (ex instanceof ServiceException) {
			return new ModelAndView("error/500", model);
		} else if (ex instanceof ParameterException) {
			return new ModelAndView("error/parameter_err", model);
		} else {
			return new ModelAndView("error/500", model);
		}
	}

}
