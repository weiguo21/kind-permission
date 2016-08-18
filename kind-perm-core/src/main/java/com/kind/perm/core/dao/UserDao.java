/**
 * Project Name:mcake-sample-core
 * File Name:UserDao.java
 * Package Name:com.kind.permission.core.dao.system
 * Date:2016年5月3日下午6:40:48
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.kind.perm.core.dao;

import java.util.List;

import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.dto.request.UserQueryRequest;

/**
 * 
 * Function:用户数据访问接口. <br/>
 * 
 * @date:2016年5月11日 下午9:04:14 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
public interface UserDao {
	public static String NAMESPACE = "com.kind.perm.core.mapper.UserDOMapper.";


	/**
	 * 获取用户
	 * 
	 * @param userDO
	 * @return
	 */
	public UserDO getUser(String username);

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	public void saveUser(UserDO userDO);

	/**
	 * 修改用户密码
	 * 
	 * @param userDO
	 */
	public void changePassword(UserDO userDO);

	/**
	 * 分页查询用户信息
	 * 
	 * @param request
	 * @return
	 */
	public List<UserDO> page(UserQueryRequest request);

	/**
	 * 加载用户记录数
	 * 
	 * @param request
	 * @return
	 */
	public int count(UserQueryRequest request);

	/**
	 * 根据id加载数据
	 * 
	 * @param id
	 * @return
	 */
	public UserDO getById(Long id);

	/**
	 * 修改用户信息(不包含密码)
	 * 
	 * @param userDO
	 */
	public void change(UserDO userDO);

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 */
	public void remove(Long id);
}
