package com.kind.perm.core.domain;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -6988993223211125635L;

	private Long id;

	private Integer status;

	private String username;

	private String password;

	private String salt;

	private String email;

	private Integer roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", status=" + status + ", username=" + username + ", password=" + password
		      + ", salt=" + salt + ", email=" + email + ", roleId=" + roleId + "]";
	}

}