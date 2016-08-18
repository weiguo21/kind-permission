/**
 * Project Name:kafa-wheat-core
 * File Name:UserInputForm.java
 * Package Name:com.kind.perm.core.form
 * Date:2016年6月14日下午1:50:04
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.form;

import java.io.Serializable;
import java.util.Date;

import com.kind.perm.core.domain.UserDO;

/**
 * Function: 用户输入Form. <br/>
 * Date: 2016年6月14日 下午1:50:04 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserInputForm implements Serializable {
	private static final long serialVersionUID = -529673548058093393L;

	public UserInputForm() {
		super();
	}

	public UserInputForm(UserDO userDO) {
		super();
		this.userDO = userDO;
	}

	private UserDO userDO;

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	public Long getId() {
		return userDO.getId();
	}

	public void setId(Long id) {
		userDO.setId(id);
	}

	public String getUsername() {
		return userDO.getUsername();
	}

	public void setUsername(String username) {
		userDO.setUsername(username);
	}

	public String getPassword() {
		return userDO.getPassword();
	}

	public void setPassword(String password) {
		userDO.setPassword(password);
	}

	public int hashCode() {
		return userDO.hashCode();
	}

	public String getName() {
		return userDO.getName();
	}

	public void setName(String name) {
		userDO.setName(name);
	}

	public Date getBirthday() {
		return userDO.getBirthday();
	}

	public void setBirthday(Date birthday) {
		userDO.setBirthday(birthday);
	}

	public Integer getGender() {
		return userDO.getGender();
	}

	public void setGender(Integer gender) {
		userDO.setGender(gender);
	}

	public String getEmail() {
		return userDO.getEmail();
	}

	public void setEmail(String email) {
		userDO.setEmail(email);
	}

	public String getMobile() {
		return userDO.getMobile();
	}

	public void setMobile(String mobile) {
		userDO.setMobile(mobile);
	}

	public String getDescription() {
		return userDO.getDescription();
	}

	public void setDescription(String description) {
		userDO.setDescription(description);
	}

	public Integer getStatus() {
		return userDO.getStatus();
	}

	public void setStatus(Integer status) {
		userDO.setStatus(status);
	}

	public Integer getVisitCount() {
		return userDO.getVisitCount();
	}

	public void setVisitCount(Integer visitCount) {
		userDO.setVisitCount(visitCount);
	}

	public Date getLastVisitTime() {
		return userDO.getLastVisitTime();
	}

	public void setLastVisitTime(Date lastVisitTime) {
		userDO.setLastVisitTime(lastVisitTime);
	}

	public Date getCreateTime() {
		return userDO.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		userDO.setCreateTime(createTime);
	}

	public Date getModifyTime() {
		return userDO.getModifyTime();
	}

	public void setModifyTime(Date modifyTime) {
		userDO.setModifyTime(modifyTime);
	}

	public boolean equals(Object obj) {
		return userDO.equals(obj);
	}

	public String toString() {
		return userDO.toString();
	}

}
