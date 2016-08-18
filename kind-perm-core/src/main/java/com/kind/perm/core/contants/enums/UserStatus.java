/**
 * Project Name:mcake-console-system
 * File Name:PermissionStatus.java
 * Package Name:com.kind.permission.core.enums
 * Date:2016年5月6日上午10:37:05
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.contants.enums;

/**
 * 
 * Function:用户状态. <br/>
 * Date: 2016年5月6日 下午4:24:57 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public enum UserStatus {
	VALID("1", "有效"), 
	INVALID("0", "无效");
	private String code;

	private String cnName;

	public String getCode() {
		return code;
	}

	public String getCnName() {
		return cnName;
	}

	private UserStatus(String code, String cnName) {
		this.code = code;
		this.cnName = cnName;
	}
}
