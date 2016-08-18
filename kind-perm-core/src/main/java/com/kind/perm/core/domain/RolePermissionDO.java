/**
 * Project Name:kafa-wheat-core
 * File Name:RolePermissionDO.java
 * Package Name:com.kind.perm.core.domain
 * Date:2016年6月7日下午5:40:26
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.domain;

import java.util.Date;

import com.kind.common.domain.Domain;

/**
 * Function:角色权限. <br/>
 * Date: 2016年6月7日 下午5:40:26 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class RolePermissionDO extends Domain {
	private static final long serialVersionUID = 2869401164732841152L;
	/**
	 * 主键.
	 */
	private Long id;
	/**
	 * 角色id.
	 */
	private Long roleId;
	/**
	 * 权限id.
	 */
	private Long permissionId;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 最后修改人
	 */
	private String modifyUser;
	/**
	 * 创建时间.
	 */
	private Date createTime;
	/**
	 * 最后修改时间.
	 */
	private Date modifyTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
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
