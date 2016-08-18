/**
 * Project Name:kafa-wheat-core
 * File Name:LogServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kind.common.mapper.JSONMapper;
import com.kind.perm.core.dao.LoginLogDao;
import com.kind.perm.core.dao.OpLogDao;
import com.kind.perm.core.domain.LoginLogDO;
import com.kind.perm.core.domain.OpLogDO;
import com.kind.perm.core.service.LogService;

/**
 * 
 * Function:日志管理. <br/>
 * 
 * @date:2016年5月12日 下午2:43:21 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Service("logService")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class LogServiceImpl implements LogService {
	private final static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
	@Resource
	private LoginLogDao loginLogDao;
	@Resource
	private OpLogDao opLogDao;

	@Override
	public void saveLoginLog(LoginLogDO logDO) {
		logger.debug("logDO:" + JSONMapper.getInstance().toJson(logDO));
		loginLogDao.save(logDO);
	}

	@Override
	public void saveOpLog(OpLogDO opLog) {
		opLogDao.saveOpLog(opLog);
	}

}
