/**
 * Project Name:kafa-wheat-core
 * File Name:RolePermissionResultForm.java
 * Package Name:com.kind.perm.core.form
 * Date:2016年6月8日下午4:30:25
 * Copyright (c) 2016, weiguo21@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.form;

import java.io.Serializable;

import com.kind.perm.core.domain.RolePermissionDO;

/**
 * Function:RolePermissionResultForm. <br/>
 * Date: 2016年6月8日 下午4:30:25 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class RolePermissionResultForm implements Serializable {

	private static final long serialVersionUID = -1369163203923134763L;

	private RolePermissionDO rolePermissionDO;

	public RolePermissionDO getRolePermissionDO() {
		return rolePermissionDO;
	}

	public void setRolePermissionDO(RolePermissionDO rolePermissionDO) {
		this.rolePermissionDO = rolePermissionDO;
	}

}
