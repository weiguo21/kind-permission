/**
 * Project Name:kafa-wheat-core
 * File Name:UserServiceImpl.java
 * Package Name:com.kind.perm.core.service.impl
 * Date:2016年5月17日下午7:58:17
 * Copyright (c) 2016, weiguo.liu@mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kind.common.dto.KindResult;
import com.kind.common.mapper.JSONMapper;
import com.kind.common.persistence.PageView;
import com.kind.common.uitls.DateUtils;
import com.kind.common.uitls.codec.MD5Utils;
import com.kind.perm.core.dao.UserDao;
import com.kind.perm.core.dao.UserRoleDao;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.domain.UserRoleDO;
import com.kind.perm.core.dto.request.PasswordRequest;
import com.kind.perm.core.dto.request.UserQueryRequest;
import com.kind.perm.core.service.UserService;
import com.kind.perm.core.shrio.SessionUtils;

/**
 * 
 * Function:用户管理. <br/>
 * 
 * @date:2016年5月12日 下午2:43:04 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserDao userDao;

	@Resource
	private UserRoleDao userRoleDao;

	@Value("login.username")
	private String username;

	@Override
	public UserDO getUser(String username) {
		return userDao.getUser(username);
	}

	/**
	 * 判断是否超级管理员
	 * 
	 * @param id
	 * @return boolean
	 */
	@SuppressWarnings("unused")
	private boolean isSupervisor(Integer id) {
		return id == 1;
	}

	/**
	 * 设定安全的密码
	 */
	@SuppressWarnings("unused")
	private void entryptPassword(UserDO user) {
		user.setPassword(MD5Utils.getStringMD5(user.getPassword()));
	}

	@Override
	public void saveUser(UserDO userDO) {
		userDO.setPassword(MD5Utils.getStringMD5(userDO.getPassword()));
		userDao.saveUser(userDO);
	}

	@Override
	public KindResult changePassword(PasswordRequest passwordRequest) {
		if (StringUtils.isEmpty(passwordRequest.getOriginPassword())
				|| StringUtils.isEmpty(passwordRequest.getTargetPassword())
				|| StringUtils.isEmpty(passwordRequest.getConfirmPassword())) {
			return KindResult.build(300, "修改密码参数有误");
		}
		Long userId = passwordRequest.getUserId();
		UserDO userDO = userDao.getById(userId);
		if (userDO == null) {
			return KindResult.build(300, "没有该用户");
		}
		if (!checkPassword(userDO, passwordRequest.getOriginPassword())) {
			return KindResult.build(300, "密码有误!");
		}
		userDO.setPassword(MD5Utils.getStringMD5(passwordRequest.getTargetPassword()));
		userDao.changePassword(userDO);
		return KindResult.build(200, "密码修改成功!");

	}

	@Override
	public PageView<UserDO> pageUser(UserQueryRequest request) {
		List<UserDO> list = userDao.page(request);
		int count = userDao.count(request);
		request.setItems(count);
		return new PageView<>(request, list);
	}

	@Override
	public UserDO getById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void changeUser(UserDO userDO) {
		userDao.change(userDO);
	}

	@Override
	public void remove(Long id) {
		userDao.remove(id);
	}

	@Override
	public List<UserRoleDO> getUserRoles(Long userId) {
		return userRoleDao.getUserRolesByUserId(userId);
	}

	@Override
	public void changeUserRole(Long userId, List<Long> originRoleIds, List<Long> targetRoleIds) {

		/**
		 * 是否删除
		 */
		for (Long roleId : originRoleIds) {
			if (!targetRoleIds.contains(roleId)) {
				userRoleDao.remove(userId, roleId);
			}
		}
		/**
		 * 是否添加
		 */
		for (Long roleId : targetRoleIds) {
			if (!originRoleIds.contains(roleId)) {
				UserRoleDO userRole = this.makeUserRole(userId, roleId);
				userRoleDao.save(userRole);
			}
		}
	}

	/**
	 * 构造用户角色 .
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	private UserRoleDO makeUserRole(Long userId, Long roleId) {
		UserRoleDO userRole = new UserRoleDO();
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		userRole.setCreateUser(SessionUtils.getCurrentUserName());
		return userRole;
	}

	@Override
	public void saveLoginTime(UserDO userDO) {
		logger.debug("userDO{}" + JSONMapper.getInstance().toJson(userDO));
		userDO.setVisitCount(this.increaseTimes(userDO));
		userDO.setLastVisitTime(DateUtils.getSysDate());
		userDao.change(userDO);
	}

	/**
	 * 累加登录次数.
	 * 
	 * @param userDO
	 * @return
	 */
	private Integer increaseTimes(UserDO userDO) {
		int times;
		if (null == userDO.getVisitCount()) {
			times = 0;
		} else {
			times = userDO.getVisitCount();
		}
		times++;
		return times;
	}

	/**
	 * 验证原密码是否正确
	 * 
	 * @param user
	 * @param oldPwd
	 * @return
	 */
	public boolean checkPassword(UserDO user, String oldPassword) {
		logger.debug("oldPassword:" + user.getPassword() + " pass:" + MD5Utils.getStringMD5(oldPassword));
		if (user.getPassword().equals(MD5Utils.getStringMD5(oldPassword))) {
			return true;
		}
		return false;
	}

}
