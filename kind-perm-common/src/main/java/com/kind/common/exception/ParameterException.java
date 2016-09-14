
package com.kind.common.exception;
/**
 * Function:参数校验异常. <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ParameterException extends RuntimeException {
	private static final long serialVersionUID = 3583566093089790852L;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}

