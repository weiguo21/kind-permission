/**
 * Project Name:kafa-wheat-core
 * File Name:BasServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年5月17日下午8:00:19
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.kind.perm.core.dao.CityDao;
import com.kind.perm.core.dao.StationDao;
import com.kind.perm.core.domain.CityDO;
import com.kind.perm.core.domain.StationDO;
import com.kind.perm.core.service.BasService;

/**
 * Function: 基础公共服务. <br/>
 * Date: 2016年5月17日 下午8:00:19 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class BasServiceImpl implements BasService {
	@Resource
	private CityDao cityDao;
	@Resource
	private StationDao stationDao;

	@Override
	public List<CityDO> getCitys() {
		return cityDao.getValidCitys();
	}

	@Override
	public List<StationDO> getStations() {
		return stationDao.getValidStations();
	}

}
