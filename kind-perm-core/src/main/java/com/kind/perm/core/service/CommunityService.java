/**
 * Project Name:kafa-wheat-core
 * File Name:CommunityService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service;

import com.kind.common.persistence.PageQuery;
import com.kind.common.persistence.PageView;
import com.kind.perm.core.domain.CommunityDO;

/**
 * Date: 2016年5月6日 下午3:07:21 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface CommunityService {
	public PageView<CommunityDO> pageCommunity(PageQuery query);

	public void save(CommunityDO community);

	public void remove(Long id);

	public CommunityDO getById(Long id);

}
