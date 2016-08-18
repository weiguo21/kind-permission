/**
 * Project Name:kafa-wheat-core
 * File Name:UserRoleResultForm.java
 * Package Name:com.kind.perm.core.form
 * Date:2016年6月8日下午4:30:04
 * Copyright (c) 2016,http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.form;

import java.io.Serializable;
import java.util.Date;

import com.kind.perm.core.domain.UserRoleDO;

/**
 * Function:用户角色输出Form. <br/>
 * Date: 2016年6月8日 下午4:30:04 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserRoleResultForm implements Serializable {
	private static final long serialVersionUID = 1976709395475519783L;

	public UserRoleResultForm() {
		super();
	}

	public UserRoleResultForm(UserRoleDO userRoleDO) {
		super();
		this.userRoleDO = userRoleDO;
	}

	private UserRoleDO userRoleDO;

	public Long getId() {
		return userRoleDO.getId();
	}

	public void setId(Long id) {
		userRoleDO.setId(id);
	}

	public Long getUserId() {
		return userRoleDO.getUserId();
	}

	public void setUserId(Long userId) {
		userRoleDO.setUserId(userId);
	}

	public Long getRoleId() {
		return userRoleDO.getRoleId();
	}

	public void setRoleId(Long roleId) {
		userRoleDO.setRoleId(roleId);
	}

	public Date getCreateTime() {
		return userRoleDO.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		userRoleDO.setCreateTime(createTime);
	}

	public Date getModifyTime() {
		return userRoleDO.getModifyTime();
	}

	public void setModifyTime(Date modifyTime) {
		userRoleDO.setModifyTime(modifyTime);
	}

	public int hashCode() {
		return userRoleDO.hashCode();
	}

	public boolean equals(Object obj) {
		return userRoleDO.equals(obj);
	}

	public String toString() {
		return userRoleDO.toString();
	}

}
