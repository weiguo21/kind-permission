/**
 * Project Name:kind-common-base
 * File Name:KindResult.java
 * Package Name:com.kind.common.dto
 * Date:2016年6月27日下午6:01:04
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/

package com.kind.common.dto;

import com.kind.common.mapper.JSONMapper;

/**
 * Function:KindResult. <br/>
 * Date: 2016年6月27日 下午6:01:04 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class KindResult {
	/**
	 * 响应业务状态
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 响应中的数据
	 */
	private Object data;

	public static KindResult build(Integer status, String msg, Object data) {
		return new KindResult(status, msg, data);
	}

	public static KindResult ok(Object data) {
		return new KindResult(data);
	}

	public static KindResult ok() {
		return new KindResult(null);
	}

	public KindResult() {

	}

	public static KindResult build(Integer status, String msg) {
		return new KindResult(status, msg, null);
	}

	public KindResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public KindResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Boolean isOK() {
		return this.status == 200;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将JSON结果集转化为TaotaoResult对象
	 * 
	 * @param jsonData
	 * 
	 * @param clazz
	 * 
	 * @return
	 */
	public static KindResult formatToPojo(String json, Class<?> clazz) {
		try {
			if (clazz == null) {
				return JSONMapper.getInstance().getSingleBean(json, KindResult.class);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static KindResult format(String json) {
		try {
			return JSONMapper.getInstance().getSingleBean(json, KindResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData
	 * @param clazz
	 * @return
	 */
	public static KindResult formatToList(String jsonData, Class<?> clazz) {
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
