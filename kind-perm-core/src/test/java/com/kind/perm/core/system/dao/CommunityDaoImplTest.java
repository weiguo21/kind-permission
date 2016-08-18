
package com.kind.perm.core.system.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.kind.common.mapper.JSONMapper;
import com.kind.common.persistence.PageQuery;
import com.kind.perm.core.BaseTestCase;
import com.kind.perm.core.dao.CommunityDao;

public class CommunityDaoImplTest extends BaseTestCase {
	@Resource
	private CommunityDao communityDao;

	@Test
	public void testPage() {
		PageQuery query = new PageQuery();
		logger.debug("get count:" + communityDao.count(query));
		logger.debug("get data:" + JSONMapper.getInstance().toJson(communityDao.page(query)));
	}

}
