/**
 * Project Name:kafa-wheat-core
 * File Name:RoleResultForm.java
 * Package Name:com.kind.perm.core.form
 * Date:2016年6月7日下午2:59:17
 *
*/

package com.kind.perm.core.form;

import java.io.Serializable;
import java.util.Date;

import com.kind.perm.core.domain.RoleDO;

/**
 * Function: RoleResultForm. <br/>
 * Date:     2016年6月7日 下午2:59:17 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class RoleResultForm implements Serializable{
	private static final long serialVersionUID = 2487748926405720343L;
	
	public RoleResultForm() {
		super();
	}

	public RoleResultForm(RoleDO roleDO) {
		super();
		this.roleDO = roleDO;
	}

	private RoleDO roleDO;

	public RoleDO getRoleDO() {
		return roleDO;
	}

	public void setRoleDO(RoleDO roleDO) {
		this.roleDO = roleDO;
	}

	public Long getId() {
		return roleDO.getId();
	}

	public void setId(Long id) {
		roleDO.setId(id);
	}

	public String getName() {
		return roleDO.getName();
	}

	public void setName(String name) {
		roleDO.setName(name);
	}

	public String getCode() {
		return roleDO.getCode();
	}

	public void setCode(String code) {
		roleDO.setCode(code);
	}

	public String getDescription() {
		return roleDO.getDescription();
	}

	public void setDescription(String description) {
		roleDO.setDescription(description);
	}

	public Integer getSortNo() {
		return roleDO.getSortNo();
	}

	public void setSortNo(Integer sortNo) {
		roleDO.setSortNo(sortNo);
	}

	@Override
	public int hashCode() {
		return roleDO.hashCode();
	}

	public Integer getStatus() {
		return roleDO.getStatus();
	}

	public void setStatus(Integer status) {
		roleDO.setStatus(status);
	}

	public Date getCreateTime() {
		return roleDO.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		roleDO.setCreateTime(createTime);
	}

	public Date getModifyTime() {
		return roleDO.getModifyTime();
	}

	public void setModifyTime(Date modifyTime) {
		roleDO.setModifyTime(modifyTime);
	}

	@Override
	public String toString() {
		return roleDO.toString();
	}


	
	

}

