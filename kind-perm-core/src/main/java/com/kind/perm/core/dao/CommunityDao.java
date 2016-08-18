/**
 * Project Name:mcake-console-system
 * File Name:CommunityDao.java
 * Package Name:com.kind.permission.core.dto
 * Date:2016年5月6日上午10:46:18
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.common.persistence.PageQuery;
import com.kind.perm.core.domain.CommunityDO;

/**
 * 
 * Function:小区数据访问接口. <br/>
 * @date:2016年5月11日 下午9:05:46 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
public interface CommunityDao {
	final String NAMESPCE = "com.kind.perm.core.mapper.CommunityDOMapper.";

	/**
	 * 
	 * page:分页查询小区信息<br/>
	 *
	 * @param query
	 * @return
	 */
	public List<CommunityDO> page(PageQuery query);

	/**
	 * 查询记录数.
	 * count:. <br/>
	 *
	 * @author weiguo.liu
	 * @param query
	 * @return
	 * @since JDK 1.6
	 */
	public int count(PageQuery query);
	/**
	 * 
	 * save:保存小区信息<br/>
	 * TODO
	 *
	 * @author weiguo.liu
	 * @param community
	 */
	public void save(CommunityDO community);
	/**
	 * 
	 * remove:删除小区信息 <br/>
	 * TODO
	 *
	 * @author weiguo.liu
	 * @param id
	 */
	public void remove(Long id);
	/**
	 * 
	 * getById:根据id加载<br/>
	 * TODO
	 *
	 * @author weiguo.liu
	 * @param id
	 * @return
	 */
	public CommunityDO getById(Long id);
}
