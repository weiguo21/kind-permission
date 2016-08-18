package com.kind.perm.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Function:日志. <br/>
 * Date:     2016年6月18日 下午3:06:59 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see
 */
public class LoginLogDO implements Serializable {
	private static final long serialVersionUID = 8397682965174225714L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 操作编码
	 */
	private String operCode;
	/**
	 * 操作类型
	 */
	private String type;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 浏览器
	 */
	private String browser;
	/**
	 * IP地址
	 */
	private String ipAddr;
	/**
	 * MAC地址
	 */
	private String mac;
	/**
	 * 执行时间
	 */
	private Integer executeTime;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 请求参数
	 */
	private String requestParam;
	/**
	 * 创建人
	 */
	private String createUser;
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

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Integer getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Integer executeTime) {
		this.executeTime = executeTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
