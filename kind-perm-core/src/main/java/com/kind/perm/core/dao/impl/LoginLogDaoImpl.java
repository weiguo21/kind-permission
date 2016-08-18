/**
 * Project Name:kafa-wheat-core
 * File Name:LogDaoImpl.java
 * Package Name:com.kind.perm.core.dao.impl
 * Date:2016年7月8日上午10:39:39
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.LoginLogDao;
import com.kind.perm.core.domain.LoginLogDO;

/**
 * Function:日志数据持久化实现. <br/>
 * Date: 2016年7月8日 上午10:39:39 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository("loginLogDao")
public class LoginLogDaoImpl extends BaseDaoMyBatisImpl<LoginLogDO, Serializable> implements LoginLogDao {

	@Override
	public void save(LoginLogDO logDO) {
		super.insert(NAMESPACE + "save", logDO);
	}

}
