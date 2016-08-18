/**
 * Project Name:mcake-console-system
 * File Name:PermissionDao.java
 * Package Name:com.kind.permission.core.dao
 * Date:2016年5月5日下午4:37:38
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.perm.core.domain.PermissionDO;

/**
 * 
 * Function:权限菜单数据访问接口. <br/>
 * 
 * @date:2016年5月11日 下午9:05:25 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
public interface PermissionDao {
	String NAMESPACE = "com.kind.perm.core.mapper.PermissionDOMapper.";

	/**
	 * 加载菜单数据.
	 * 
	 * @return
	 */
	public List<PermissionDO> getAllMenus();

	/**
	 * 查询全部数据.
	 * 
	 * @return
	 */
	public List<PermissionDO> getAll();

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
	 * 查询菜单下的操作权限.
	 * 
	 * @param parentId
	 * @return
	 */
	public List<PermissionDO> queryMenuOperation(Long parentId);

	/**
	 * 获取用户权限.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PermissionDO> getPermissionsByUserId(Long userId);

}
