package com.kind.perm.core.contants;

/**
 * 
 * Function:求职意向相关常量. <br/>
 * Date: 2016年6月13日 下午1:42:56 <br/>
 * 
 * @author weiguo.liu
 * @version 2.0
 * @since JDK 1.7
 * @see
 */
public class SessionConstants {
	/**
	 * 登录用户session key.
	 */
	public static final String SESSION_USER_KEY = "back_session_user";
	/**
	 * shiroUser session key.
	 */
	public static final String SHIRO_USER_KEY = "shiro_session_user";
	/**
	 * session过期时间.
	 */
	public static final long sessionTimeOut = 3600000;
}
