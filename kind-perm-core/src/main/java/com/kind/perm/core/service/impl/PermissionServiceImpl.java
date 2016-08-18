/**
 * Project Name:kafa-wheat-core
 * File Name:PermissionServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kind.perm.core.dao.PermissionDao;
import com.kind.perm.core.dao.RolePermissionDao;
import com.kind.perm.core.domain.PermissionDO;
import com.kind.perm.core.domain.RolePermissionDO;
import com.kind.perm.core.service.PermissionService;
import com.kind.perm.core.shrio.UserAuthRealm;

/**
 * 
 * Function:权限管理实现. <br/>
 * 
 * @date:2016年5月12日 下午2:44:01 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Service("permissionService")
@Transactional(propagation = Propagation.REQUIRED)
public class PermissionServiceImpl implements PermissionService {
	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	@Resource
	private PermissionDao permissionDao;

	@Resource
	private RolePermissionDao rolePermissionDao;

	@Override
	public List<PermissionDO> getAllMenus() {
		return permissionDao.getAllMenus();
	}

	@Override
	public List<PermissionDO> getAllPermissions() {
		return permissionDao.getAll();
	}

	@Override
	public void save(PermissionDO permissionDO) {
		permissionDao.save(permissionDO);
	}

	@Override
	public void change(PermissionDO permissionDO) {
		permissionDao.change(permissionDO);
	}

	@Override
	public PermissionDO getById(Long id) {
		return permissionDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		permissionDao.remove(id);
	}

	@Override
	public List<Long> getPermIdsByRoleId(Long roleId) {
		return rolePermissionDao.getPermIdsByRoleId(roleId);
	}

	@Override
	public void changeRolePermission(Long roleId, List<Long> originIds, List<Long> targetIds) {
		logger.debug("修改角色权限:roleId{}" + roleId);
		/**
		 * 是否删除
		 */
		for (Long permId : originIds) {
			if (!targetIds.contains(permId)) {
				rolePermissionDao.remove(roleId, permId);
			}
		}
		/**
		 * 是否添加
		 */
		for (Long permId : targetIds) {
			if (!originIds.contains(permId)) {
				rolePermissionDao.save(this.makeRolePermission(roleId, permId));
			}
		}

	}

	private RolePermissionDO makeRolePermission(Long roleId, Long permissionId) {
		RolePermissionDO rolePermission = new RolePermissionDO();
		rolePermission.setRoleId(roleId);
		rolePermission.setPermissionId(permissionId);
		return rolePermission;
	}

	public void clearUserPermCache(PrincipalCollection pc) {
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserAuthRealm userRealm = (UserAuthRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthorizationInfo(pc);
	}

	@Override
	public List<PermissionDO> getMenuOperations(Long parentId) {
		return permissionDao.queryMenuOperation(parentId);
	}

	@Override
	public List<PermissionDO> getPermissionsByUserId(Long userId) {
		return permissionDao.getPermissionsByUserId(userId);
	}

}
