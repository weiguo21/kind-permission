/**
 * Project Name:kafa-wheat-core
 * File Name:OpLogDaoImpl.java
 * Package Name:com.kind.perm.core.dao.impl
 * Date:2016年7月22日下午5:42:58
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.kind.common.exception.DaoException;
import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.OpLogDao;
import com.kind.perm.core.domain.OpLogDO;

/**
 * Function:操作日志数据持久化实现. <br/>
 * Date: 2016年7月22日 下午5:42:58 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository("opLogDao")
public class OpLogDaoImpl extends BaseDaoMyBatisImpl<OpLogDO, Serializable> implements OpLogDao {

	@Override
	public void saveOpLog(OpLogDO opLog) throws DaoException {
		super.insert(NAMESPACE + "save", opLog);
	}

}
