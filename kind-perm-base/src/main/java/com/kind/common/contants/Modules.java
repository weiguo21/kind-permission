/**
 * Project Name:kafa-common-base
 * File Name:Modules.java
 * Package Name:com.kind.common.trace
 * Date:2016年7月22日下午4:55:52
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.common.contants;

/**
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2016年7月22日 下午4:55:52 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public enum Modules {
	ORDER("ORDER","订单"), 
	ORDER_PACKAGE("ORDER_PACKAGE","配送单");
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


	private Modules(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getDesc(String code) {
		for (Modules c : Modules.values()) {
			if (c.getCode().equals(code)) {
				return c.name;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Modules type = Modules.ORDER;
		System.out.println(type.name);
		System.out.println(type.toString());
	}
}
