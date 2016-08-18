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

/**
 * Function:日志操作者. <br/>
 * Date: 2016年7月22日 下午6:01:09 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class LogActor implements Serializable {
	private static final long serialVersionUID = 735010689008147706L;
	private String ipAddr;
	private String actor;

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

}
