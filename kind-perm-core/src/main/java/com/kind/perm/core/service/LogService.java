/**
 * Project Name:kafa-wheat-core
 * File Name:LogService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/
package com.kind.perm.core.service;

import com.kind.perm.core.domain.LoginLogDO;
import com.kind.perm.core.domain.OpLogDO;

/**
 * 
 * Function:日志管理. <br/>
 * Date: 2016年5月4日 下午8:54:47 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public interface LogService {
	/**
	 * 保存登录日志.
	 * 
	 * @param log
	 */
	public void saveLoginLog(LoginLogDO logDO);

	/**
	 * 保存操作日志.
	 * 
	 * @param opLog
	 */
	public void saveOpLog(OpLogDO opLog);

}
