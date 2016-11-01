/**
 * Project Name:kafa-common-base
 * File Name:SubSystem.java
 * Package Name:com.kind.common.trace
 * Date:2016年7月25日下午4:59:10
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.common.contants;

/**
 * Function:子系统. <br/>
 * Date: 2016年7月25日 下午4:59:10 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public enum SubSystem {
	JOYSEED("JOYSEED", "卓溪"),
	WHEAT("WHEAT", "原麦山丘");

	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SubSystem(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getDesc(String code) {
		for (SubSystem c : SubSystem.values()) {
			if (c.getCode().equals(code)) {
				return c.name;
			}
		}
		return null;
	}
}
