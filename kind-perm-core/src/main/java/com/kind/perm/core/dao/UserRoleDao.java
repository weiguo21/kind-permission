/**
 * Project Name:kafa-wheat-core
 * File Name:UserRoleDao.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年6月14日下午5:15:06
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.perm.core.domain.UserRoleDO;

/**
 * Function:用户角色数据持久化接口. <br/>
 * Date: 2016年6月14日 下午5:15:06 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface UserRoleDao {
	public static final String NAMESPACE = "com.kind.perm.core.mapper.UserRoleDOMapper.";
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public UserRoleDO getById(Long id);

	/**
	 * 保存
	 * 
	 * @param userRoleDO
	 */
	public void save(UserRoleDO userRoleDO);

	/**
	 * 修改
	 * 
	 * @param userRoleDO
	 */
	public void change(UserRoleDO userRoleDO);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void remove(Long userId, Long roleId);

	/**
	 * 获取用户角色.
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserRoleDO> getUserRolesByUserId(Long userId);

}
