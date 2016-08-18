/**
 * Project Name:kafa-wheat-core
 * File Name:PermissionService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service;

import java.util.List;

import org.apache.shiro.subject.PrincipalCollection;

import com.kind.perm.core.domain.PermissionDO;

/**
 * 
 * Function:权限服务声明. <br/>
 * Date: 2016年6月15日 下午3:52:36 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface PermissionService {
	/**
	 * 加载菜单数据.
	 * 
	 * @return
	 */
	public List<PermissionDO> getAllMenus();

	/**
	 * 加载全部数据.
	 * 
	 * @return
	 */
	public List<PermissionDO> getAllPermissions();

	/**
	 * 保存权限.
	 * 
	 * @param permissionDO
	 */
	public void save(PermissionDO permissionDO);

	/**
	 * 修改权限.
	 * 
	 * @param permissionDO
	 */
	public void change(PermissionDO permissionDO);

	/**
	 * 根据id查询权限信息.
	 * 
	 * @param id
	 * @return
	 */
	public PermissionDO getById(Long id);

	/**
	 * 根据id删除权限.
	 * 
	 * @param id
	 */
	public void remove(Long id);

	/**
	 * 根据角色id查询权限.
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Long> getPermIdsByRoleId(Long roleId);

	/**
	 * 
	 * @param roleId
	 * @param riginIds
	 * @param targetIds
	 */
	public void changeRolePermission(Long roleId, List<Long> orginIds, List<Long> targetIds);

	/**
	 * 清空该角色用户的权限缓存.
	 * 
	 * @param pc
	 */
	public void clearUserPermCache(PrincipalCollection pc);

	/**
	 * 查询菜单下的操作权限
	 * 
	 * @param parentId
	 * @return
	 */
	public List<PermissionDO> getMenuOperations(Long parentId);

	/**
	 * 获取用户权限.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PermissionDO> getPermissionsByUserId(Long userId);
}
