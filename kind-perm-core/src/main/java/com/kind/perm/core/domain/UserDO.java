/**
 * Project Name:kafa-wheat-core
 * File Name:UserDO.java
 * Package Name:com.kind.perm.core.domain
 * Date:2016年6月6日下午5:37:27
 * Copyright (c) 2016, weiguo21@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Function: 用户. <br/>
 * Date: 2016年6月6日 下午5:37:27 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 6699967885317239481L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 登录次数
	 */
	private Integer visitCount;
	/**
	 * 最后一次登录时间
	 */
	private Date lastVisitTime;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
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
