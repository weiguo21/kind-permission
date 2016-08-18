/**
 * Project Name:kafa-wheat-core
 * File Name:UserRoleDaoImpl.java
 * Package Name:com.kind.perm.core.dao.impl
 * Date:2016年6月15日上午10:59:00
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
import com.kind.perm.core.dao.UserRoleDao;
import com.kind.perm.core.domain.UserRoleDO;

/**
 * Function: 用户角色数据持久化实现. <br/>
 * Date: 2016年6月15日 上午10:59:00 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoMyBatisImpl<UserRoleDO, Serializable> implements UserRoleDao {

	@Override
	public UserRoleDO getById(Long id) {
		return super.getById(NAMESPACE + "getById", id);
	}

	@Override
	public void save(UserRoleDO userRoleDO) {
		super.insert(NAMESPACE + "save", userRoleDO);
	}

	@Override
	public void change(UserRoleDO userRoleDO) {
		super.update(NAMESPACE + "change", userRoleDO);
	}

	@Override
	public void remove(Long userId, Long roleId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("roleId", roleId);
		super.deleteByMap(NAMESPACE + "removeById", paramMap);
	}

	@Override
	public List<UserRoleDO> getUserRolesByUserId(Long userId) {
		return super.query(NAMESPACE + "getUserRolesByUserId", userId);
	}

}
