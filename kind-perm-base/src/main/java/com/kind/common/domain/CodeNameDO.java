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
 * Function:CodeNameDO. <br/>
 * Date: 2016年5月17日 下午7:26:20 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class CodeNameDO implements Serializable {
	private static final long serialVersionUID = -2391785072806972075L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
