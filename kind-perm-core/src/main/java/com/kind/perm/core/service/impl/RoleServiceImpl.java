/**
 * Project Name:kafa-wheat-core
 * File Name:RoleServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年6月14日下午5:13:33
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.PageView;
import com.kind.perm.core.dao.RoleDao;
import com.kind.perm.core.domain.RoleDO;
import com.kind.perm.core.service.RoleService;

/**
 * Function:角色服务实现. <br/>
 * Date: 2016年6月14日 下午5:13:33 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;

	@Override
	public PageView<RoleDO> pageRole(PageQuery query) {
		List<RoleDO> list = this.buildPage(query);
		return new PageView<>(query, list);
	}

	private List<RoleDO> buildPage(PageQuery query) {
		List<RoleDO> list = roleDao.page(query);
		int count = roleDao.count(query);
		query.setItems(count);
		return list;
	}

	@Override
	public void saveRole(RoleDO roleDO) {
		roleDao.save(roleDO);
	}

	@Override
	public void changeRole(RoleDO roleDO) {
		roleDao.change(roleDO);
	}

	@Override
	public RoleDO getRoleById(Long roleId) {
		return roleDao.getById(roleId);
	}

	@Override
	public void removeRoleById(Long roleId) {
		roleDao.remove(roleId);
	}

}
