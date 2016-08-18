/**
 * Project Name:kafa-wheat-core
 * File Name:StationDao.java
 * Package Name:com.kind.permission.core.order.dao
 * Date:2016年5月17日下午7:16:32
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.perm.core.domain.StationDO;

/**
 * Function:站点服务. <br/>
 * Date: 2016年5月17日 下午7:16:32 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository
public interface StationDao {
	public static String NAMESPACE = "com.kind.perm.core.mapper.StationDOMapper.";

	public List<StationDO> getValidStations();

}
