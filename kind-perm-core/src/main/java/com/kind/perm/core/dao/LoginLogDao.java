/**
 * Project Name:kafa-wheat-core
 * File Name:LogDao.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年7月8日上午10:38:36
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import com.kind.perm.core.domain.LoginLogDO;

/**
 * Function:日志数据持久化接口. <br/>
 * Date: 2016年7月8日 上午10:38:36 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface LoginLogDao {
	public static String NAMESPACE="com.kind.perm.core.mapper.LogDOMapper.";
	/**
	 * 保存日志.
	 * 
	 * @param logDO
	 */
	public void save(LoginLogDO logDO);
}
