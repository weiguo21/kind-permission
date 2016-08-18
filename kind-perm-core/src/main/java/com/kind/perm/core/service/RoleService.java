/**
 * Project Name:kafa-wheat-core
 * File Name:RoleService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年6月14日下午5:13:12
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service;

import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.PageView;
import com.kind.perm.core.domain.RoleDO;

/**
 * Function:角色服务接口. <br/>
 * Date: 2016年6月14日 下午5:13:12 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoleService {
	/**
	 * 分页加载所有角色.
	 * 
	 * @param query
	 * @return
	 */
	public PageView<RoleDO> pageRole(PageQuery query);

	/**
	 * 保存角色.
	 * 
	 * @param roleDO
	 */
	public void saveRole(RoleDO roleDO);

	/**
	 * 修改角色.
	 * 
	 * @param roleDO
	 */
	public void changeRole(RoleDO roleDO);

	/**
	 * 根据id获取角色.
	 * 
	 * @param roleId
	 * @return
	 */
	public RoleDO getRoleById(Long roleId);

	/**
	 * 根据roleId删除.
	 * 
	 * @param roleId
	 */
	public void removeRoleById(Long roleId);
}
