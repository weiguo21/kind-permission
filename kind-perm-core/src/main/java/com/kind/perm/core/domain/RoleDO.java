/**
 * Project Name:kafa-wheat-core
 * File Name:RoleDO.java
 * Package Name:com.kind.perm.core.domain
 * Date:2016年6月6日下午6:07:28
 * Copyright (c) 2016, weiguo21@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.domain;

import java.util.Date;

import com.kind.common.domain.Domain;

/**
 * Function: 角色. <br/>
 * Date:     2016年6月6日 下午6:07:28 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class RoleDO extends Domain{
	private static final long serialVersionUID = 7788213796674395594L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色编码
	 */
	private String code;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sortNo;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 最后修改人
	 */
	private String modifyUser;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}

