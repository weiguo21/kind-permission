/**
 * Project Name:kafa-wheat-core
 * File Name:RolePermissionDao.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年6月14日下午5:15:23
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.perm.core.domain.RolePermissionDO;

/**
 * Function:角色权限数据持久化接口. <br/>
 * Date: 2016年6月14日 下午5:15:23 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RolePermissionDao {
	public static final String NAMESPACE = "com.kind.perm.core.mapper.RolePermissionDOMapper.";

	/**
	 * 根据id查询.
	 * 
	 * @param id
	 * @return
	 */
	public RolePermissionDO getyById(Long id);

	/**
	 * 根据角色id查询权限.
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Long> getPermIdsByRoleId(Long roleId);

	/**
	 * 保存.
	 * 
	 * @param rolePermissionDO
	 */
	public void save(RolePermissionDO rolePermissionDO);

	/**
	 * 修改.
	 * 
	 * @param rolePermissionDO
	 */
	public void change(RolePermissionDO rolePermissionDO);

	/**
	 * 根据id删除.
	 * 
	 * @param id
	 */
	public void reomve(Long id);

	/**
	 * 根据角色id和permissionId删除.
	 * 
	 * @param roleId
	 * @param permissionId
	 */
	public void remove(Long roleId, Long permissionId);

}
