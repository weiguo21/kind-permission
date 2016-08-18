/**
 * Project Name:kafa-wheat-core
 * File Name:OperationLogDO.java
 * Package Name:com.kind.perm.core.domain
 * Date:2016年7月22日下午5:31:43
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.domain;

import java.io.Serializable;
import java.util.Date;

import com.kind.common.domain.LogActor;

/**
 * Function:系统操作日志. <br/>
 * Date: 2016年7月22日 下午5:31:43 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class OpLogDO extends LogActor implements Serializable {
	private static final long serialVersionUID = 279409227848908160L;
	private Long id;
	/**
	 * 子系统
	 */
	private String subSystem;
	/**
	 * 操作模块名称
	 */
	private String module;

	/**
	 * 操作动作的名称
	 */
	private String operation;

	/**
	 * 参数
	 */
	private String content;
	/**
	 * 操作描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
