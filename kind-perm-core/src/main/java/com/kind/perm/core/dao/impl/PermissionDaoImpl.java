/**
 * Project Name:mcake-console-system
 * File Name:PermissionDaoImpl.java
 * Package Name:com.kind.permission.core.dao.impl
 * Date:2016年5月5日下午4:39:19
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.PermissionDao;
import com.kind.perm.core.domain.PermissionDO;

/**
 * 
 * Function:权限菜单数据访问实现. <br/>
 * 
 * @date:2016年5月11日 下午9:06:31 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Repository("permissionDao")
public class PermissionDaoImpl extends BaseDaoMyBatisImpl<PermissionDO, Serializable> implements PermissionDao {

	@Override
	public List<PermissionDO> getAllMenus() {
		List<PermissionDO> list = super.query(NAMESPACE + "getAllMenus", null);
		return list;
	}

	@Override
	public List<PermissionDO> getAll() {
		return super.query(NAMESPACE + "getAll", null);
	}

	@Override
	public void save(PermissionDO permissionDO) {
		super.insert(NAMESPACE + "save", permissionDO);
	}

	@Override
	public void change(PermissionDO permissionDO) {
		super.update(NAMESPACE + "change", permissionDO);
	}

	@Override
	public PermissionDO getById(Long id) {
		return super.getById(NAMESPACE + "getById", id);
	}

	@Override
	public void remove(Long id) {
		super.delete(NAMESPACE + "removeById", id);
	}

	@Override
	public List<PermissionDO> queryMenuOperation(Long parentId) {
		return super.query(NAMESPACE + "queryMenuOperation", parentId);
	}

	@Override
	public List<PermissionDO> getPermissionsByUserId(Long userId) {
		return super.query(NAMESPACE + "getPermissionsByUserId", userId);
	}

}
