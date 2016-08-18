/**
 * Project Name:kafa-wheat-core
 * File Name:RolePermissionDaoImpl.java
 * Package Name:com.kind.perm.core.dao.impl
 * Date:2016年6月15日上午10:49:09
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.RolePermissionDao;
import com.kind.perm.core.domain.RolePermissionDO;

/**
 * Function:角色权限数据持久化实现. <br/>
 * Date: 2016年6月15日 上午10:49:09 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository("rolePermissionDao")
public class RolePermissionDaoImpl extends BaseDaoMyBatisImpl<RolePermissionDO, Serializable>
		implements RolePermissionDao {

	@Override
	public RolePermissionDO getyById(Long id) {
		return super.getById(NAMESPACE + "getById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getPermIdsByRoleId(Long roleId) {
		return (List<Long>) super.queryForList(NAMESPACE + "getPermIdsByRoleId", roleId);
	}

	@Override
	public void save(RolePermissionDO rolePermissionDO) {
		super.insert(NAMESPACE + "save", rolePermissionDO);
	}

	@Override
	public void change(RolePermissionDO rolePermissionDO) {
		super.update(NAMESPACE + "change", rolePermissionDO);
	}

	@Override
	public void reomve(Long id) {
		super.delete(NAMESPACE + "removeById", id);
	}

	@Override
	public void remove(Long roleId, Long permissionId) {
		Map<String, Long> paramMap = new HashMap<>();
		paramMap.put("roleId", roleId);
		paramMap.put("permissionId", permissionId);
		super.deleteByMap(NAMESPACE + "removeByParamMap", paramMap);
	}

}
