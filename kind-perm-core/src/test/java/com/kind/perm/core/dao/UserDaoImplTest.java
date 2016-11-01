/**
 * Project Name:kafa-wheat-core
 * File Name:UserDaoImplTest.java
 * Package Name:com.kind.perm.core.dao
 * Date:2016年6月13日下午3:22:56
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.kind.common.mapper.JSONMapper;
import com.kind.perm.core.BaseTestCase;
import com.kind.perm.core.dao.UserDao;
import com.kind.perm.core.dto.request.UserQueryRequest;

/**
 * Function:Unit Test for UserDaoImpl . <br/>
 * Date: 2016年6月13日 下午3:22:56 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserDaoImplTest extends BaseTestCase {
	@Resource
	private UserDao userDao;

	@Test
	public void testPage() {
		UserQueryRequest request = new UserQueryRequest();
		System.out.println("get count:" + userDao.count(request));
		System.out.println("get data:" + JSONMapper.getInstance().toJson(userDao.page(request).get(0)));
	}
}
