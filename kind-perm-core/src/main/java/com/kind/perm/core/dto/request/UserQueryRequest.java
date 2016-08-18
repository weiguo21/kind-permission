/**
 * Project Name:kafa-wheat-core
 * File Name:UserRequest.java
 * Package Name:com.kind.perm.core.dto.request
 * Date:2016年6月13日下午2:16:10
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dto.request;

import java.util.Date;

import com.kind.common.persistence.PageQuery;

/**
 * Function:用户查询条件. <br/>
 * Date: 2016年6月13日 下午2:16:10 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserQueryRequest extends PageQuery {
	private static final long serialVersionUID = -98120936151141306L;

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 创建时间(开始)
	 */
	private Date createTimeStart;
	/**
	 * 创建时间(结束)
	 */
	private Date createTimeEnd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

}
