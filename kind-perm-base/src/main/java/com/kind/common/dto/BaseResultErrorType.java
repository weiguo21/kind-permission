/**
 * Project Name:kind-common-base
 * File Name:KindResult.java
 * Package Name:com.kind.common.dto
 * Date:2016年6月27日下午6:01:04
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/
package com.kind.common.dto;

/**
 * 
 * Function:rest错误编码. <br/>
 * Date: 2016年6月24日 上午10:48:37 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class BaseResultErrorType {
	public final static String CODE_SUCCESS = "000";
	public final static String CODE_FAIL = "001";
	public final static String NOT_ORDERDET = "002";
	public final static String CODE_USER_NOT_FOUND = "003";
	public final static String CODE_AGENCY_NOT_FOUND = "004";
	public final static String CODE_SYSTEM_ERROR = "100";
	public final static String CODE_PARMS_ERROR = "101";

	/**
	 * 操作状态码
	 */
	public static final String OPERATE_CODE = "code";
	/**
	 * 操作描述
	 */
	public static final String OPERATE_DESC = "desc";
}
