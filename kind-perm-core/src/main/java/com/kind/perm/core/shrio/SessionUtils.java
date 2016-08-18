package com.kind.perm.core.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.kind.perm.core.contants.SessionConstants;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.shrio.UserAuthRealm.ShiroUser;

/**
 * function:登录用户相关数据. <br/>
 *
 * @date:2016年5月13日 下午1:40:38 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
public class SessionUtils {
	/**
	 * 获取当前用户对象shiroUser.
	 * 
	 * @return
	 */
	public static ShiroUser getCurrentShiroUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	/**
	 * 获取当前用户session.
	 * 
	 * @return session
	 */
	public static Session getSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户httpSession.
	 * 
	 * @return
	 */
	public static Session getHttpSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户对象.
	 * 
	 * @return user
	 */
	public static UserDO getCurrentUser() {
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			return (UserDO) session.getAttribute(SessionConstants.SESSION_USER_KEY);
		} else {
			return null;
		}
	}

	/**
	 * 获取当前登录用户id.
	 * 
	 * @return
	 */
	public static Long getCurrentUserId() {
		UserDO user = getCurrentUser();
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	/**
	 * 获取当前登录用户名.
	 * 
	 * @return
	 */
	public static String getCurrentUserName() {
		UserDO user = getCurrentUser();
		if (user != null) {
			return user.getUsername();
		}
		return null;
	}
}
