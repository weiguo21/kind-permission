/**
 * Project Name:kafa-wheat-core
 * File Name:CommunityServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/
package com.kind.perm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.PageView;
import com.kind.perm.core.dao.CommunityDao;
import com.kind.perm.core.domain.CommunityDO;
import com.kind.perm.core.service.CommunityService;

/**
 * 
 * Function:小区管理. <br/>
 * @date:2016年5月12日 下午2:43:38 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Service("communityService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommunityServiceImpl implements CommunityService {
	@Resource
	private CommunityDao communityDao;

	@Override
	public PageView<CommunityDO> pageCommunity(PageQuery query) {
		query.setPageSize(query.getPageSize());
		List<CommunityDO> list = communityDao.page(query);
		int count = communityDao.count(query);
		query.setItems(count);
		return new PageView<>(query, list);
	}

	@Override
	public void save(CommunityDO community) {
		communityDao.save(community);
	}

	@Override
	public void remove(Long id) {
		communityDao.remove(id);
	}

	@Override
	public CommunityDO getById(Long id) {
		return communityDao.getById(id);
	}

}
