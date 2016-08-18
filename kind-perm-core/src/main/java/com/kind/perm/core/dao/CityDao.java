/**
 * Project Name:kafa-wheat-core
 * File Name:YmCityDao.java
 * Package Name:com.kind.permission.core.order.dao
 * Date:2016年5月17日下午7:36:44
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.perm.core.domain.CityDO;

/**
 * Function: 城市基础信息. <br/>
 * Date: 2016年5月17日 下午7:36:44 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository
public interface CityDao {
	public static final String NAMESPACE="com.kind.perm.core.mapper.CityDOMapper.";
	/**
	 * 加载有效城市
	 * 
	 * @return
	 */
	public List<CityDO> getValidCitys();

}
