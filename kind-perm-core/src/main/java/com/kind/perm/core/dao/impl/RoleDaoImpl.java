/**
 * Project Name:kafa-wheat-core
 * File Name:RoleDaoImpl.java
 * Package Name:com.kind.perm.core.dao.impl
 * Date:2016年6月15日上午10:37:00
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.RoleDao;
import com.kind.perm.core.domain.RoleDO;

/**
 * Function:角色数据持久化实现. <br/>
 * Date: 2016年6月15日 上午10:37:00 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoMyBatisImpl<RoleDO, Serializable> implements RoleDao {

	@Override
	public List<RoleDO> page(PageQuery query) {
		return super.query(NAMESPACE + "page", query);
	}

	@Override
	public int count(PageQuery query) {
		return super.count(NAMESPACE + "count", query);
	}

	@Override
	public void save(RoleDO roleDO) {
		super.insert(NAMESPACE + "save", roleDO);
	}

	@Override
	public void change(RoleDO roleDO) {
		super.update(NAMESPACE + "change", roleDO);
	}

	@Override
	public RoleDO getById(Long id) {
		return super.getById(NAMESPACE + "getById", id);
	}

	@Override
	public void remove(Long id) {
		super.delete(NAMESPACE + "removeById", id);
	}

}
