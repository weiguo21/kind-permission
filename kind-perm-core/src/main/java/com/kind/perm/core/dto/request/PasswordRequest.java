/**
 * Project Name:kafa-wheat-core
 * File Name:PasswordRequest.java
 * Package Name:com.kafa.wheat.core.system.dto.request
 * Date:2016年8月18日下午1:17:30
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dto.request;

import java.io.Serializable;

/**
 * Function:修改密码参数. <br/>
 * Date: 2016年8月18日 下午1:17:30 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class PasswordRequest implements Serializable {
	private static final long serialVersionUID = -7725593337294109998L;
	private Long userId;
	private String originPassword;
	private String targetPassword;
	private String confirmPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOriginPassword() {
		return originPassword;
	}

	public void setOriginPassword(String originPassword) {
		this.originPassword = originPassword;
	}

	public String getTargetPassword() {
		return targetPassword;
	}

	public void setTargetPassword(String targetPassword) {
		this.targetPassword = targetPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
