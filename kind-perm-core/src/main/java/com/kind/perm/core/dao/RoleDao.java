/**
 * Project Name:kafa-wheat-core
 * File Name:RoleDao.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年6月14日下午5:14:34
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.common.persistence.PageQuery;
import com.kind.perm.core.domain.RoleDO;

/**
 * Function:角色数据持久化接口. <br/>
 * Date: 2016年6月14日 下午5:14:34 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoleDao {
	public static final String NAMESPACE = "com.kind.perm.core.mapper.RoleDOMapper.";

	/**
	 * 分页加载角色信息.
	 * 
	 * @param query
	 * @return
	 */
	public List<RoleDO> page(PageQuery query);

	/**
	 * 获得记录数.
	 * 
	 * @param query
	 * @return
	 */
	public int count(PageQuery query);

	/**
	 * 保存角色.
	 * 
	 * @param roleDO
	 */
	public void save(RoleDO roleDO);

	/**
	 * 修改角色.
	 * 
	 * @param roleDO
	 */
	public void change(RoleDO roleDO);

	/**
	 * 根据id查询角色信息.
	 * 
	 * @param id
	 * @return
	 */
	public RoleDO getById(Long id);

	/**
	 * 根据id删除角色.
	 * 
	 * @param id
	 */
	public void remove(Long id);
}
