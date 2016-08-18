package com.kind.perm.web.rest;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kind.common.dto.BaseResultCode;
import com.kind.common.dto.BaseResultErrorType;
import com.kind.common.dto.BaseSingleResult;

/**
 * 
 * Function:rest服务控制器. <br/>
 * 
 * @date:2016年5月12日 上午11:19:16 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public abstract class RestController {

	protected static final Logger logger = (Logger) LoggerFactory.getLogger(RestController.class);

	@ExceptionHandler
	@ResponseBody
	public BaseResultCode handleException(Exception ex, HttpServletRequest request) {
		logger.error(request.getRequestURI() + "-base error:", ex);

		if (ex instanceof ConstraintViolationException) {
			BaseResultCode orderReturnCode = new BaseResultCode();
			orderReturnCode.setCode(BaseResultErrorType.CODE_FAIL);
			orderReturnCode.setDesc(this.getConstraintErrorDesc((ConstraintViolationException) ex));
			return orderReturnCode;
		} else if (ex instanceof HttpMessageNotReadableException) {
			return new BaseResultCode(BaseResultErrorType.CODE_PARMS_ERROR, "The input parameter form is not correct.");
		} else {
			return new BaseResultCode(BaseResultErrorType.CODE_SYSTEM_ERROR, ex.getMessage());
		}
	}

	protected String getConstraintErrorDesc(ConstraintViolationException constraintExp) {
		Set<ConstraintViolation<?>> errorSet = constraintExp.getConstraintViolations();
		if (errorSet != null && errorSet.size() > 0) {
			for (ConstraintViolation<?> error : errorSet) {
				return error.getPropertyPath() + ":" + error.getMessage();
			}
		}
		return "";
	}

	/**
	 * 返回失败
	 * 
	 * @param data
	 * @return
	 * @author cary
	 */
	@SuppressWarnings("rawtypes")
	public BaseSingleResult<?> getFail(String desc) {
		BaseSingleResult<?> response = new BaseSingleResult(BaseResultErrorType.CODE_SUCCESS);
		response.setDesc(desc);
		return response;
	}

	/**
	 * 返回成功
	 * 
	 * @param <T>
	 * 
	 * @param data
	 * @param desc
	 * @return
	 */
	public <T> BaseSingleResult<?> getSuccess(String desc, T content) {
		BaseSingleResult<T> response = new BaseSingleResult<T>(BaseResultErrorType.CODE_SUCCESS);
		response.setDesc(desc);
		response.setContent(content);
		return response;
	}
}
