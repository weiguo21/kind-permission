/**
 * Project Name:kafa-wheat-core
 * File Name:OpLogDao.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年7月22日下午5:41:47
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import com.kind.common.exception.DaoException;
import com.kind.perm.core.domain.OpLogDO;

/**
 * Function: 操作日志数据持久化. <br/>
 * Date: 2016年7月22日 下午5:41:47 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface OpLogDao {
	public static final String NAMESPACE="com.kind.perm.core.mapper.OpLogDOMapper.";
	/**
	 * 保存操作日志.
	 * 
	 * @param opLog
	 * @throws DaoException
	 */
	public void saveOpLog(OpLogDO opLog) throws DaoException;
}
