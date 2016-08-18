/**
 * Project Name:kafa-wheat-core
 * File Name:BasService.java
 * Package Name:com.kind.perm.core.service
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service;

import java.util.List;

import com.kind.common.dto.KindResult;
import com.kind.common.persistence.PageView;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.domain.UserRoleDO;
import com.kind.perm.core.dto.request.PasswordRequest;
import com.kind.perm.core.dto.request.UserQueryRequest;

/**
 * ClassName:UserService <br/>
 * Date: 2016年5月4日 下午12:53:26 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public interface UserService {
	/**
	 * 按登录名查询用户(配置文件)
	 * 
	 * @param username
	 * @return 用户对象
	 */
	public UserDO getUser(String username);

	/**
	 * 保存用户信息
	 * 
	 * @param userDO
	 */
	public void saveUser(UserDO userDO);

	/**
	 * 修改用户密码
	 * 
	 * @param userDO
	 */
	public KindResult changePassword(PasswordRequest passwordRequest);

	/**
	 * 用户信息分页
	 * 
	 * @param request
	 * @return
	 */
	public PageView<UserDO> pageUser(UserQueryRequest request);

	/**
	 * 根据id加载数据
	 * 
	 * @param id
	 * @return
	 */
	public UserDO getById(Long id);

	/**
	 * 修改用户信息
	 * 
	 * @param userDO
	 */
	public void changeUser(UserDO userDO);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void remove(Long id);

	/**
	 * 获取用户角色.
	 */
	public List<UserRoleDO> getUserRoles(Long userId);

	/**
	 * 修改用户角色.
	 * 
	 * @param userId
	 * @param originRoleIds
	 * @param targetRoleIds
	 */
	public void changeUserRole(Long userId, List<Long> originRoleIds, List<Long> targetRoleIds);

	/**
	 * 记录登录时间.
	 * 
	 * @param userDO
	 */
	public void saveLoginTime(UserDO userDO);

	/**
	 * 验证密码.
	 * 
	 * @param user
	 * @param oldPassword
	 * @return
	 */
	public boolean checkPassword(UserDO user, String oldPassword);

}
