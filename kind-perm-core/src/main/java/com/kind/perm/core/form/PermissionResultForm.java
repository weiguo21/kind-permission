/**
 * Project Name:kafa-wheat-core
 * File Name:PermissionResultForm.java
 * Package Name:com.kind.perm.core.form
 * Date:2016年6月8日下午4:30:56
 *
*/

package com.kind.perm.core.form;

import java.io.Serializable;

import com.kind.perm.core.domain.PermissionDO;

/**
 * Function: PermissionResultForm. <br/>
 * Date: 2016年6月8日 下午4:30:56 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class PermissionResultForm implements Serializable {
	private static final long serialVersionUID = 5254179895387850217L;
	

	public PermissionResultForm() {
		super();
	}

	public PermissionResultForm(PermissionDO permissionDO) {
		super();
		this.permissionDO = permissionDO;
	}

	private PermissionDO permissionDO;

	public PermissionDO getPermissionDO() {
		return permissionDO;
	}

	public void setPermissionDO(PermissionDO permissionDO) {
		this.permissionDO = permissionDO;
	}

	public Integer getId() {
		return permissionDO.getId();
	}

	public void setId(Integer id) {
		permissionDO.setId(id);
	}

	public Integer getParentId() {
		return permissionDO.getParentId();
	}

	public void setParentId(Integer parentId) {
		permissionDO.setParentId(parentId);
	}

	public String getName() {
		return permissionDO.getName();
	}

	public void setName(String name) {
		permissionDO.setName(name);
	}

	public String getType() {
		return permissionDO.getType();
	}

	public void setType(String type) {
		permissionDO.setType(type);
	}

	public Integer getSortNo() {
		return permissionDO.getSortNo();
	}

	public void setSortNo(Integer sortNo) {
		permissionDO.setSortNo(sortNo);
	}

	public String getUrl() {
		return permissionDO.getUrl();
	}

	public void setUrl(String url) {
		permissionDO.setUrl(url);
	}

	public String getPermCode() {
		return permissionDO.getPermCode();
	}

	public void setPermCode(String permCode) {
		permissionDO.setPermCode(permCode);
	}

	public String getIcon() {
		return permissionDO.getIcon();
	}

	public void setIcon(String icon) {
		permissionDO.setIcon(icon);
	}

	public String getStatus() {
		return permissionDO.getStatus();
	}

	public void setStatus(String status) {
		permissionDO.setStatus(status);
	}

	@Override
	public int hashCode() {
		return permissionDO.hashCode();
	}

	public String getDescription() {
		return permissionDO.getDescription();
	}

	public void setDescription(String description) {
		permissionDO.setDescription(description);
	}

	@Override
	public boolean equals(Object obj) {
		return permissionDO.equals(obj);
	}

	@Override
	public String toString() {
		return permissionDO.toString();
	}
	

}
