/**
 * Project Name:kafa-wheat-core
 * File Name:BasService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service;

import java.util.List;

import com.kind.perm.core.domain.CityDO;
import com.kind.perm.core.domain.StationDO;

/**
 * Function:基础信息服务. <br/>
 * Date: 2016年5月17日 下午7:58:17 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public interface BasService {
	/**
	 * 加载城市
	 * 
	 * @return
	 */
	public List<CityDO> getCitys();

	/**
	 * 加载配送站点
	 * 
	 * @return
	 */
	public List<StationDO> getStations();

}
