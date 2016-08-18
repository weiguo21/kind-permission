/**
 * Project Name:kind-common-base
 * File Name:KindResult.java
 * Package Name:com.kind.common.dto
 * Date:2016年6月27日下午6:01:04
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/
package com.kind.common.dto;

public class BaseResultCode {
	 /**
    * 返回代码
    */
   private String code;

   /**
    * 代码描述
    */
   private String desc;
    public BaseResultCode() {

    }

    public BaseResultCode(String code, String desc) {
        this.setCode(code);
        this.setDesc(desc);
    }

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
    
}
