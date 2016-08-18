/**
 * Project Name:mcake-console-system
 * File Name:CommunityDaoImpl.java
 * Package Name:com.kind.permission.core.dao.impl
 * Date:2016年5月6日下午2:25:51
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.datasource.KindDataSourceHolder;
import com.kind.common.datasource.DataSourceKey;
import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.CommunityDao;
import com.kind.perm.core.domain.CommunityDO;

/**
 * 
 * Function:小区数据访问实现类. <br/>
 * 
 * @date:2016年5月11日 下午9:07:01 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Repository
public class CommunityDaoImpl extends BaseDaoMyBatisImpl<CommunityDO, Serializable> implements CommunityDao {

	@Override
	public List<CommunityDO> page(PageQuery query) {
		return super.query(NAMESPCE + "page", query);
	}

	@Override
	public int count(PageQuery query) {

		return super.count(NAMESPCE + "count", query);
	}

	@Override
	public void save(CommunityDO community) {
		KindDataSourceHolder.setDataSourceKey(DataSourceKey.YM_ORDER_DATA_SOURCE);
		if (community.getId() == null) {
			super.insert(NAMESPCE + "insert", community);
		} else {
			super.update(NAMESPCE + "update", community);
		}
	}

	@Override
	public void remove(Long id) {
		delete(NAMESPCE + "delete", id);
	}

	@Override
	public CommunityDO getById(Long id) {
		return super.getById(NAMESPCE + "getById", id);
	}

}
