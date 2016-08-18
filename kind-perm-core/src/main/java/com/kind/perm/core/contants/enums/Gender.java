/**
 * Project Name:kafa-wheat-core
 * File Name:Gender.java
 * Package Name:com.kind.perm.core.contants.enums
 * Date:2016年6月13日下午5:03:03
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.contants.enums;

/**
 * Function:用户性别. <br/>
 * Date:     2016年6月13日 下午5:03:03 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public enum Gender {
	UNKONWN("0","未知"),
	MALE("1","男"),
	FEMALE("2","女");
	private String code;
	private String name;

	private Gender(String code, String name) {
		this.code = code;
		this.name = name;
	}

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
	public static String getName(String code) {
		for (Gender c : Gender.values()) {
			if (c.getCode().equals(code)) {
				return c.name;
			}
		}
		return null;
	}

}

