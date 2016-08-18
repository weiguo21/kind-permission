/**
 * Project Name:kind-common-base
 * File Name:CodeNameDO.java
 * Package Name:com.kind.common.domain
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Function:Domain. <br/>
 * Date: 2016年6月24日 上午10:43:49 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class Domain implements Serializable {
	private static final long serialVersionUID = -5498182919751698368L;

	/**
	 * 创建者.
	 */
	private String createUser;
	/**
	 * 修改者.
	 */
	private String modifyUser;

	/**
	 * 创建时间.
	 */
	private Date createTime;
	/**
	 * 修改者.
	 */
	private Date modifyTime;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
