/**
 * Project Name:kafa-wheat-core
 * File Name:YmCityDaoImpl.java
 * Package Name:com.kind.permission.core.order.dao.impl
 * Date:2016年5月17日下午7:38:00
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.CityDao;
import com.kind.perm.core.domain.CityDO;

/**
 * Function:城市. <br/>
 * Date: 2016年5月17日 下午7:38:00 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository
public class CityDaoImpl extends BaseDaoMyBatisImpl<CityDO, Serializable> implements CityDao {

	@Override
	public List<CityDO> getValidCitys() {
		return super.query(NAMESPACE + "queryValidCity", null);
	}

}
