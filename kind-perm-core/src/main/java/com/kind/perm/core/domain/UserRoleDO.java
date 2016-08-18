/**
 * Project Name:kafa-wheat-core
 * File Name:UserRoleDO.java
 * Package Name:com.kind.perm.core.domain
 * Date:2016年6月7日下午5:40:13
 * Copyright (c) 2016, weiguo21@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2016年6月7日 下午5:40:13 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserRoleDO implements Serializable {
	private static final long serialVersionUID = 752120992292119612L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 角色id
	 */
	private Long roleId;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 最后修改人
	 */
	private String modifyUser;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后修改时间
	 */
	private Date modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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
