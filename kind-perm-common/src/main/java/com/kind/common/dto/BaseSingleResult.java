/**
 * Project Name:kind-common-base
 * File Name:KindResult.java
 * Package Name:com.kind.common.dto
 * Date:2016年6月27日下午6:01:04
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/
package com.kind.common.dto;
/**
 * 
 * Function: 接口返回结果. <br/>
 * date: 2016-3-29 下午1:19:59 <br/>
 * @author weiguo21
 * @version @param <T>
 * @since JDK 1.7
 */
public class BaseSingleResult<T> {
	public BaseSingleResult() {

	}

	public BaseSingleResult(String code) {
		this.code = code;
	}

	public BaseSingleResult(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public BaseSingleResult(String code, String desc, T content) {
		this.code = code;
		this.desc = desc;
		this.content = content;
	}

	private String code;

	private String desc;

	private T content;

	public String getCode() {
   	return code;
   }

	public void setCode(String code) {
   	this.code = code;
   }

	public String getDesc() {
   	return desc;
   }

	public void setDesc(String desc) {
   	this.desc = desc;
   }

	public T getContent() {
   	return content;
   }

	public void setContent(T content) {
   	this.content = content;
   }


	

}
