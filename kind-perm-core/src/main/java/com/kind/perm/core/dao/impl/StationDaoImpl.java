/**
 * Project Name:kafa-wheat-core
 * File Name:YmStationDaoImpl.java
 * Package Name:com.kind.permission.core.order.dao.impl
 * Date:2016年5月17日下午7:19:42
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.StationDao;
import com.kind.perm.core.domain.StationDO;

/**
 * Function:配送站点. <br/>
 * Date: 2016年5月17日 下午7:19:42 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository
public class StationDaoImpl extends BaseDaoMyBatisImpl<StationDO, Serializable> implements StationDao {

	@Override
	public List<StationDO> getValidStations() {
		return super.query(NAMESPACE + "queryValidStation", null);
	}

}
